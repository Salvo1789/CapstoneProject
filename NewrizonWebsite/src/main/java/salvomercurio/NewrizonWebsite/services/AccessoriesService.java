package salvomercurio.NewrizonWebsite.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import salvomercurio.NewrizonWebsite.entities.Accessory;
import salvomercurio.NewrizonWebsite.entities.Charger;
import salvomercurio.NewrizonWebsite.entities.Cover;
import salvomercurio.NewrizonWebsite.exceptions.BadRequestException;
import salvomercurio.NewrizonWebsite.exceptions.NotFoundException;
import salvomercurio.NewrizonWebsite.payloads.NewAccessoryPayload;
import salvomercurio.NewrizonWebsite.repositories.AccessoriesRepository;

@Service
public class AccessoriesService {

	@Autowired
	AccessoriesRepository accessoriesRepo;

	public Accessory create(NewAccessoryPayload a) {

		accessoriesRepo.findByName(a.getName()).ifPresent(accessory -> {
			throw new BadRequestException("Accessory " + accessory.getName() + " already created!");
		});

		if (a.getType().equals("cover")) {
			Cover newCover = new Cover(a.getName(), a.getPrice(), a.getQty(), a.getMaterial(), a.isWaterproof());
			newCover.setCoverColor(a.getCoverColor());
			return (Accessory) accessoriesRepo.save(newCover);
		} else {
			Charger newCharger = new Charger(a.getName(), a.getPrice(), a.getQty(), a.getOutput(), a.isRapidRecharge(),
					a.getPower());
			newCharger.setChargerColor(a.getChargerColor());
			return (Accessory) accessoriesRepo.save(newCharger);
		}
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

	public Accessory findById(UUID id) throws NotFoundException {
		return accessoriesRepo.findById(id).orElseThrow(() -> new NotFoundException("Accessory not found!"));

	}

	public Accessory findByIdAndUpdate(UUID id, ModifiedAccessoryPayload s) {
		if (s.getType().equals("cover")) {
			Cover found = (Cover) this.findById(id);
			found.setId(id);
			found.setName(found.getName());
			found.setPrice(s.getPrice());
			found.setQty(s.getQty());
			found.setMaterial(s.getMaterial());
			found.setWaterproof(s.isWaterproof());
			found.setCoverColor(s.getCoverColor());
			return (Accessory) accessoriesRepo.save(found);
		} else {
			Charger found = (Charger) this.findById(id);
			found.setId(id);
			found.setName(found.getName());
			found.setPrice(s.getPrice());
			found.setQty(s.getQty());
			found.setOutput(s.getOutput());
			found.setRapidRecharge(s.isRapidRecharge());
			found.setPower(s.getPower());
			found.setChargerColor(s.getChargerColor());
			return (Accessory) accessoriesRepo.save(found);
		}
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Accessory found = this.findById(id);
		accessoriesRepo.delete(found);
	}

}
