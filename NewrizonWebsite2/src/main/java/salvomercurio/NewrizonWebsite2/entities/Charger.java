package salvomercurio.NewrizonWebsite2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import salvomercurio.NewrizonWebsite2.entities.enums.ChargerColor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Charger extends Product {
	private String output;
	private boolean rapidRecharge;
	private String power;
	@Enumerated(EnumType.STRING)
	private ChargerColor chargerColor;

	public Charger(String name, double price, String productPic, int qty, String output, boolean rapidRecharge,
			String power) {
		super(name, price, productPic, qty);
		this.output = output;
		this.rapidRecharge = rapidRecharge;
		this.power = power;

	}

}
