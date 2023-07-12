package salvomercurio.NewrizonWebsite2.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import salvomercurio.NewrizonWebsite2.entities.Charger;
import salvomercurio.NewrizonWebsite2.entities.Cover;
import salvomercurio.NewrizonWebsite2.entities.Product;
import salvomercurio.NewrizonWebsite2.entities.Smartphone;
import salvomercurio.NewrizonWebsite2.exceptions.BadRequestException;
import salvomercurio.NewrizonWebsite2.exceptions.NotFoundException;
import salvomercurio.NewrizonWebsite2.payloads.ProductPayload;
import salvomercurio.NewrizonWebsite2.repositories.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	ProductsRepository productsRepo;

	public Product findById(UUID id) throws NotFoundException {
		return productsRepo.findById(id).orElseThrow(() -> new NotFoundException("Product not found!"));

	}

	public Page<Product> find(int page, int size, String sortBy, double price1, double price2) {
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
			return productsRepo.findByPriceBetween(price1, price2, pageable);
		} else {
			return productsRepo.findAll(pageable);
		}
	}

	public Product findByName(String name) {
		return productsRepo.findByName(name).orElseThrow(() -> new NotFoundException("Fattura non trovata!"));
	}

	public Product findByIdAndUpdate(UUID id, ProductPayload p) {
		switch (p.getType()) {

		case "smartphone":
			Smartphone found = (Smartphone) this.findById(id);
			found.setId(id);
			found.setName(p.getName());
			found.setPrice(p.getPrice());
			found.setProductPic(p.getProductPic());
			found.setQty(p.getQty());
			found.setDisplay(p.getDisplay());
			found.setCPU(p.getCPU());
			found.setRAM(p.getRAM());
			found.setROM(p.getROM());
			found.setBattery(p.getBattery());
			found.setRapidRecharge(p.getRapidRecharge());
			found.setCam1(p.getCam1());
			found.setCam2(p.getCam2());
			found.setCam3(p.getCam3());
			found.setCam4(p.getCam4());
			found.setOS(p.getOS());
			found.setColor(p.getColor());
			return (Product) productsRepo.save(found);

		case "Charger":
			Charger chargerFound = (Charger) this.findById(id);
			chargerFound.setId(id);
			chargerFound.setName(p.getName());
			chargerFound.setPrice(p.getPrice());
			chargerFound.setProductPic(p.getProductPic());
			chargerFound.setQty(p.getQty());
			chargerFound.setOutput(p.getOutput());
			chargerFound.setRapidRecharge(p.getRapidRecharge());
			chargerFound.setPower(p.getPower());
			chargerFound.setChargerColor(p.getChargerColor());
			return (Product) productsRepo.save(chargerFound);

		default:
			Cover coverFound = (Cover) this.findById(id);
			coverFound.setId(id);
			coverFound.setName(p.getName());
			coverFound.setPrice(p.getPrice());
			coverFound.setProductPic(p.getProductPic());
			coverFound.setQty(p.getQty());
			coverFound.setMaterial(p.getMaterial());
			coverFound.setWaterproof(p.isWaterproof());
			coverFound.setCoverColor(p.getCoverColor());
			return (Product) productsRepo.save(coverFound);
		}
	}

	public Product create(ProductPayload p) {

		productsRepo.findByName(p.getName()).ifPresent(product -> {
			throw new BadRequestException("Smartphone " + product.getName() + " already created!");
		});

		switch (p.getType()) {

		case "smartphone":
			Smartphone newSmartphone = new Smartphone(p.getName(), p.getPrice(), p.getProductPic(), p.getQty(),
					p.getDisplay(), p.getCPU(), p.getRAM(), p.getROM(), p.getBattery(), p.getRapidRecharge(),
					p.getCam1(), p.getCam2(), p.getCam3(), p.getCam4(), p.getOS());
			newSmartphone.setColor(p.getColor());
			return (Product) productsRepo.save(newSmartphone);

		case "charger":
			Charger newCharger = new Charger(p.getName(), p.getPrice(), p.getProductPic(), p.getQty(), p.getOutput(),
					p.getRapidRecharge(), p.getPower());
			newCharger.setChargerColor(p.getChargerColor());
			return (Product) productsRepo.save(newCharger);

		default:
			Cover newCover = new Cover(p.getName(), p.getPrice(), p.getProductPic(), p.getQty(), p.getMaterial(),
					p.isWaterproof());
			newCover.setCoverColor(p.getCoverColor());
			return (Product) productsRepo.save(newCover);
		}
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Product found = this.findById(id);
		productsRepo.delete(found);
	}
}
