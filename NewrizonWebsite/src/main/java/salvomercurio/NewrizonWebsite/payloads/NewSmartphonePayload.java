package salvomercurio.NewrizonWebsite.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import salvomercurio.NewrizonWebsite.entities.SmartphoneColor;

@Getter
@Setter
public class NewSmartphonePayload {
	@NotNull(message = "Please insert name")
	protected String name;
	@NotNull(message = "Please insert price")
	protected double price;
	@NotNull(message = "Please insert qty")
	protected int qty;
	@NotNull(message = "Please insert display")
	protected String Display;
	@NotNull(message = "Please insert CPU")
	protected String CPU;
	@NotNull(message = "Please insert RAM")
	protected int RAM;
	@NotNull(message = "Please insert ROM")
	protected int ROM;
	@NotNull(message = "Please insert battery")
	protected String Battery;
	@NotNull(message = "Please insert RapidRecharge")
	protected Boolean RapidRecharge;
	@NotNull(message = "Please insert Cam. no.1")
	protected String Cam1;
	@NotNull(message = "Please insert Cam. no.2")
	protected String Cam2;
	protected String Cam3;
	protected String Cam4;
	@NotNull(message = "Please insert OS")
	protected String OS;
	@NotNull(message = "Please insert color")
	protected SmartphoneColor color;
}
