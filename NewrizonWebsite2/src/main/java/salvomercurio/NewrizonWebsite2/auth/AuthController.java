package salvomercurio.NewrizonWebsite2.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import salvomercurio.NewrizonWebsite2.entities.User;
import salvomercurio.NewrizonWebsite2.exceptions.NotFoundException;
import salvomercurio.NewrizonWebsite2.exceptions.UnauthorizedException;
import salvomercurio.NewrizonWebsite2.payloads.AuthenticationSuccessfullPayload;
import salvomercurio.NewrizonWebsite2.payloads.UserLoginPayload;
import salvomercurio.NewrizonWebsite2.payloads.UserRegistrationPayload;
import salvomercurio.NewrizonWebsite2.services.UsersService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UsersService usersService;

	@Autowired
	private PasswordEncoder bcrypt;

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody @Validated UserRegistrationPayload body) {
		body.setPassword(bcrypt.encode(body.getPassword()));
		User createdUser = usersService.create(body);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationSuccessfullPayload> login(@RequestBody UserLoginPayload body)
			throws NotFoundException {

		User user = usersService.findByEmail(body.getEmail());

		String plainPW = body.getPassword();
		String hashedPW = user.getPassword();

		if (!bcrypt.matches(plainPW, hashedPW))
			throw new UnauthorizedException("Credenziali non valide!");

		String token = JWTTools.createToken(user);

		return new ResponseEntity<>(new AuthenticationSuccessfullPayload(token), HttpStatus.OK);
	}

}
