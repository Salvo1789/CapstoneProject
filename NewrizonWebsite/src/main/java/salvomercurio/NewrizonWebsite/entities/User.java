package salvomercurio.NewrizonWebsite.entities;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
@JsonIgnoreProperties({ "password", "creditCard", "isAccountNonLocked", "isEnabled", "isCredentialsNonExpired",
		"authorities" })
public class User implements UserDetails {
	@Id
	@GeneratedValue
	private UUID id;
	private String username;
	private String email;
	private String password;
	private String name;
	private String surname;
	@Enumerated(EnumType.STRING)
	private Role role;

	@Convert(converter = CreditCardConverter.class)
	private String creditCard;

	private boolean isEnabled;
	private boolean isCredentialsNonExpired;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;

	public User(String username, String email, String password, String name, String surname, String creditCard) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.creditCard = creditCard;
		this.isEnabled = true;
		this.isAccountNonExpired = true;
		this.isCredentialsNonExpired = true;
		this.isAccountNonLocked = true;
		this.role = Role.USER;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getPassword() {

		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return this.isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {

		return this.isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return this.isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {

		return this.isEnabled;
	}

}
