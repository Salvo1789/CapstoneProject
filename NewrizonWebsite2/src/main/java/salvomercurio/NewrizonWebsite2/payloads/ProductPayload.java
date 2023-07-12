package salvomercurio.NewrizonWebsite2.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import salvomercurio.NewrizonWebsite2.entities.enums.ChargerColor;
import salvomercurio.NewrizonWebsite2.entities.enums.CoverColor;
import salvomercurio.NewrizonWebsite2.entities.enums.SmartphoneColor;

@Getter
@Setter
public class ProductPayload {

	// Common attributes
	@NotNull(message = "Please insert name")
	protected String name;
	@NotNull(message = "Please insert price")
	protected double price;
	@NotNull(message = "Please insert image link")
	protected String productPic;
	@NotNull(message = "Please insert qty")
	protected int qty;
	@NotNull(message = "Please insert type")
	protected String type;

	// Smartphone attributes
	protected String Display;
	protected String CPU;
	protected int RAM;
	protected int ROM;
	protected String Battery;
	protected Boolean RapidRecharge;
	protected String Cam1;
	protected String Cam2;
	protected String Cam3;
	protected String Cam4;
	protected String OS;
	protected SmartphoneColor color;

	// Charger attributes
	protected String output;
	protected boolean rapidRecharge;
	protected String power;
	protected ChargerColor chargerColor;

	// Cover attributes
	protected String material;
	protected boolean waterproof;
	protected CoverColor coverColor;
}
