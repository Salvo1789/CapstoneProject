package salvomercurio.NewrizonWebsite.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationPayload {
	@NotNull(message = "Please insert username")
	@Size(min = 3, max = 30, message = "Min 3, max 30 chars")
	String username;
	@Email(message = "Please insert email")
	String email;
	@NotNull(message = "Please insert password")
	String password;
	@NotNull(message = "Please insert name")
	String name;
	@NotNull(message = "Please insert surname")
	String surname;
}
