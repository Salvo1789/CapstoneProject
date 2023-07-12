package salvomercurio.NewrizonWebsite2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salvomercurio.NewrizonWebsite2.entities.OrderProduct;
import salvomercurio.NewrizonWebsite2.repositories.OrderProductsRepository;

@Service
public class OrderProductsService {

	@Autowired
	OrderProductsRepository orderProductsRepo;

	public OrderProduct create(OrderProduct orderProduct) {
		return orderProductsRepo.save(orderProduct);
	}
}
