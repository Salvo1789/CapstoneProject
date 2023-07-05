package salvomercurio.NewrizonWebsite.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import salvomercurio.NewrizonWebsite.entities.User;
import salvomercurio.NewrizonWebsite.exceptions.BadRequestException;
import salvomercurio.NewrizonWebsite.exceptions.NotFoundException;
import salvomercurio.NewrizonWebsite.payloads.ModifiedUserPayload;
import salvomercurio.NewrizonWebsite.payloads.UserRegistrationPayload;
import salvomercurio.NewrizonWebsite.repositories.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepo;

	public Page<User> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return usersRepo.findAll(pageable);
	}

	public User findById(UUID id) throws NotFoundException {
		return usersRepo.findById(id).orElseThrow(() -> new NotFoundException("Utente non trovato!"));

	}

	public User findByIdAndUpdate(UUID id, ModifiedUserPayload u) {
		User found = this.findById(id);
		found.setId(id);
		found.setUsername(u.getUsername());
		found.setEmail(found.getEmail());
		found.setPassword(u.getPassword());
		found.setName(u.getName());
		found.setSurname(u.getSurname());
		found.setRole(u.getRole());
		return usersRepo.save(found);

	}

	public User create(UserRegistrationPayload u) {

		usersRepo.findByEmail(u.getEmail()).ifPresent(user -> {
			throw new BadRequestException("Email " + user.getEmail() + " already in use!");
		});
		User newUser = new User(u.getUsername(), u.getEmail(), u.getPassword(), u.getName(), u.getSurname(),
				u.getCreditCard());
		return usersRepo.save(newUser);
	}

	public User findByEmail(String email) throws NotFoundException {
		return usersRepo.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Utente con questa mail: " + email + " non trovato!"));
	}

	public User findByUsername(String username) throws NotFoundException {
		return usersRepo.findByUsername(username)
				.orElseThrow(() -> new NotFoundException("Nessun utente con username: " + username + " trovato"));
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		User found = this.findById(id);
		usersRepo.delete(found);
	}
}
