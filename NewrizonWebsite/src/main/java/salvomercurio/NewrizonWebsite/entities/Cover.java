package salvomercurio.NewrizonWebsite.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("cover")
public class Cover extends Accessory {
	private String material;
	private boolean waterproof;
	@Enumerated(EnumType.STRING)
	private CoverColor coverColor;

	public Cover(String name, double price, int qty, String material, boolean waterproof) {
		super(name, price, qty);
		this.material = material;
		this.waterproof = waterproof;
		this.coverColor = null;

	}
}
