package salvomercurio.NewrizonWebsite2.dto;

import lombok.Getter;
import lombok.Setter;
import salvomercurio.NewrizonWebsite2.entities.Product;

@Getter
@Setter
public class OrderProductDto {

	private Product product;
	private Integer quantity;

}
