package salvomercurio.NewrizonWebsite.model;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product {
	@Id
	@GeneratedValue
	protected UUID id;
	protected String name;
	protected double price;
	protected int qty;

	public Product(String name, double price, int qty) {
		super();
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
}
