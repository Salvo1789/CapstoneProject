package salvomercurio.NewrizonWebsite2.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue
	private UUID id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate orderDate;
	private String status;

	@ManyToOne
	@JsonBackReference
	private User user;

	@OneToMany(mappedBy = "pk.order")
	@JsonManagedReference
	@Valid
	private List<OrderProduct> productsList = new ArrayList<>();

	@Transient
	public Double getTotalOrderPrice() {
		double sum = 0D;
		List<OrderProduct> orderProducts = getProductsList();
		for (OrderProduct op : orderProducts) {
			sum += op.getTotalPrice();
		}

		return sum;
	}

	@Transient
	public int getNumberOfProducts() {
		return this.productsList.size();
	}

}
