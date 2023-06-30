package salvomercurio.NewrizonWebsite.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("cover")
public class Cover extends Accessory {
	private String material;
	public boolean waterproof;

	public Cover(String name, double price, int qty, String material, boolean waterproof) {
		super(name, price, qty);
		this.material = material;
		this.waterproof = waterproof;

	}
}
