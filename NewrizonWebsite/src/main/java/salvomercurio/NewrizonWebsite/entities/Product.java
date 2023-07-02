package salvomercurio.NewrizonWebsite.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product {
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private double price;
	private int qty;

	public Product(String name, double price, int qty) {
		super();
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

}