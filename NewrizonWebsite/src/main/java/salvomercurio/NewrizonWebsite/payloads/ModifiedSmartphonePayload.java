package salvomercurio.NewrizonWebsite.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifiedSmartphonePayload {

	@NotNull(message = "Please insert price")
	protected double price;
	@NotNull(message = "Please insert qty")
	protected int qty;

}
