package salvomercurio.NewrizonWebsite.payloads;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import salvomercurio.NewrizonWebsite.entities.Role;

@Getter
@Setter
public class ModifiedUserPayload {
	@NotNull(message = "Please insert username")
	@Size(min = 3, max = 30, message = "Min 3, max 30 chars")
	String username;

	@NotNull(message = "Please insert password")
	String password;
	@NotNull(message = "Please insert name")
	String name;
	@NotNull(message = "Please insert surname")
	String surname;

	@NotNull(message = "Please insert role")
	Role role;
}
