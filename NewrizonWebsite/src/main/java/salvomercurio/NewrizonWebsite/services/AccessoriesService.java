package salvomercurio.NewrizonWebsite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import salvomercurio.NewrizonWebsite.entities.Accessory;
import salvomercurio.NewrizonWebsite.repositories.AccessoriesRepository;

@Service
public class AccessoriesService {

	@Autowired
	AccessoriesRepository accessoriesRepo;

	public List<Accessory> saveAccessories(List<Accessory> accList) {
		List<Accessory> accessoriesResponse = (List<Accessory>) accessoriesRepo.saveAll(accList);
		return accessoriesResponse;
	};

	public Page<Accessory> find(int page, int size, String sortBy, double price1, double price2) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;

		if (price1 < 0)
			price1 = 0;
		if (price1 > 1000)
			price1 = 1000;
		if (price2 > 1000)
			price2 = 1000;
		if (price2 < 10)
			price2 = 1000;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		if (price1 > 0 && price2 < 1000) {
			return accessoriesRepo.findByPriceBetween(price1, price2, pageable);
		} else {
			return accessoriesRepo.findAll(pageable);
		}
	}

}
