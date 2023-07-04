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
@DiscriminatorValue("charger")
public class Charger extends Accessory {
	private String output;
	private boolean rapidRecharge;
	private String power;
	@Enumerated(EnumType.STRING)
	private ChargerColor chargerColor;

	public Charger(String name, double price, int qty, String output, boolean rapidRecharge, String power) {
		super(name, price, qty);
		this.output = output;
		this.rapidRecharge = rapidRecharge;
		this.power = power;
		this.chargerColor = null;
	}

}
