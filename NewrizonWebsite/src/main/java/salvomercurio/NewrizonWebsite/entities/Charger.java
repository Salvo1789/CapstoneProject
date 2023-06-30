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
@DiscriminatorValue("charger")
public class Charger extends Accessory {
	private String output;
	private boolean rapidRecharge;
	private String power;

	public Charger(String name, double price, int qty, String output, boolean rapidRecharge, String power) {
		super(name, price, qty);
		this.output = output;
		this.rapidRecharge = rapidRecharge;
		this.power = power;
	}

}
