package salvomercurio.NewrizonWebsite.services;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import salvomercurio.NewrizonWebsite.entities.ChargerColor;
import salvomercurio.NewrizonWebsite.entities.CoverColor;

@Getter
@Setter
public class ModifiedAccessoryPayload {
	@NotNull(message = "Please insert price")
	protected double price;
	@NotNull(message = "Please insert qty")
	protected int qty;
	protected String output;
	protected boolean rapidRecharge;
	protected String power;
	protected ChargerColor chargerColor;
	protected String material;
	protected boolean waterproof;
	protected CoverColor coverColor;
	protected String type;
}
