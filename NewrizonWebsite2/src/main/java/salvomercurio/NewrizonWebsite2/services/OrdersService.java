package salvomercurio.NewrizonWebsite2.services;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import salvomercurio.NewrizonWebsite2.entities.Order;
import salvomercurio.NewrizonWebsite2.exceptions.NotFoundException;
import salvomercurio.NewrizonWebsite2.repositories.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	OrdersRepository ordersRepo;

	public Order findById(UUID id) throws NotFoundException {
		return ordersRepo.findById(id).orElseThrow(() -> new NotFoundException("Product not found!"));

	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Order found = this.findById(id);
		ordersRepo.delete(found);
	}

	public Page<Order> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;

		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return ordersRepo.findAll(pageable);
	}

	public Order create(Order order) {
		order.setOrderDate(LocalDate.now());

		return ordersRepo.save(order);
	}

	public void update(Order order) {
		ordersRepo.save(order);
	}
}
