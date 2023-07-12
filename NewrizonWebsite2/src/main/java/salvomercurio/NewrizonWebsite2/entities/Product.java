package salvomercurio.NewrizonWebsite2.entities;

import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product {
	@Id
	@GeneratedValue
	private UUID id;
	@Basic(optional = false)
	private String name;
	private double price;
	private String productPic;
	private int qty;

	public Product(String name, double price, String productPic, int qty) {
		super();
		this.name = name;
		this.price = price;
		this.productPic = productPic;
		this.qty = qty;
	}

}
