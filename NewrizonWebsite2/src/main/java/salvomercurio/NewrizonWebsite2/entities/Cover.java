package salvomercurio.NewrizonWebsite2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import salvomercurio.NewrizonWebsite2.entities.enums.CoverColor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cover extends Product {
	private String material;
	private boolean waterproof;
	@Enumerated(EnumType.STRING)
	private CoverColor coverColor;

	public Cover(String name, double price, String productPic, int qty, String material, boolean waterproof) {
		super(name, price, productPic, qty);
		this.material = material;
		this.waterproof = waterproof;

	}
}
