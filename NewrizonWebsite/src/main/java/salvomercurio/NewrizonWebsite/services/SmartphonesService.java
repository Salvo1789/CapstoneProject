package salvomercurio.NewrizonWebsite.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import salvomercurio.NewrizonWebsite.entities.Smartphone;
import salvomercurio.NewrizonWebsite.entities.SmartphoneColor;
import salvomercurio.NewrizonWebsite.exceptions.BadRequestException;
import salvomercurio.NewrizonWebsite.exceptions.NotFoundException;
import salvomercurio.NewrizonWebsite.payloads.ModifiedSmartphonePayload;
import salvomercurio.NewrizonWebsite.payloads.NewSmartphonePayload;
import salvomercurio.NewrizonWebsite.repositories.SmartphonesRepository;

@Service
public class SmartphonesService {
	@Autowired
	SmartphonesRepository smartphonesRepo;

	public Smartphone findById(UUID id) throws NotFoundException {
		return smartphonesRepo.findById(id).orElseThrow(() -> new NotFoundException("Fattura non trovata!"));

	}

	public Page<Smartphone> find(int page, int size, String sortBy, String display, int ram, int rom, String os,
			SmartphoneColor color, double price1, double price2) {
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
		if (!display.equals("")) {
			return smartphonesRepo.findByDisplay(display, pageable);
		} else if (ram != 0) {
			return smartphonesRepo.findByRAM(ram, pageable);
		} else if (rom != 0) {
			return smartphonesRepo.findByROM(rom, pageable);
		} else if (!os.equals("")) {
			return smartphonesRepo.findByOS(os, pageable);
		} else if (!color.equals(SmartphoneColor.PURE_WHITE)) {
			return smartphonesRepo.findByColor(color, pageable);
		} else if (price1 > 0 && price2 < 1000) {
			return smartphonesRepo.findByPriceBetween(price1, price2, pageable);
		} else {
			return smartphonesRepo.findAll(pageable);
		}
	}

	public Smartphone findByName(String name) {
		return smartphonesRepo.findByName(name).orElseThrow(() -> new NotFoundException("Fattura non trovata!"));
	}

	public Smartphone findByIdAndUpdate(UUID id, ModifiedSmartphonePayload s) {
		Smartphone found = this.findById(id);
		found.setId(id);
		found.setName(found.getName());
		found.setPrice(s.getPrice());
		found.setQty(s.getQty());
		found.setDisplay(found.getDisplay());
		found.setCPU(found.getCPU());
		found.setRAM(found.getRAM());
		found.setROM(found.getROM());
		found.setBattery(found.getBattery());
		found.setRapidRecharge(found.getRapidRecharge());
		found.setCam1(found.getCam1());
		found.setCam2(found.getCam2());
		found.setCam3(found.getCam3());
		found.setCam4(found.getCam4());
		found.setOS(found.getOS());
		found.setColor(found.getColor());
		return smartphonesRepo.save(found);
	}

	public Smartphone create(NewSmartphonePayload s) {

		smartphonesRepo.findByName(s.getName()).ifPresent(smartphone -> {
			throw new BadRequestException("Smartphone " + smartphone.getName() + " already created!");
		});
		Smartphone newSmartphone = new Smartphone(s.getName(), s.getPrice(), s.getQty(), s.getDisplay(), s.getCPU(),
				s.getRAM(), s.getROM(), s.getBattery(), s.getRapidRecharge(), s.getCam1(), s.getCam2(), s.getCam3(),
				s.getCam4(), s.getOS());
		newSmartphone.setColor(s.getColor());
		return smartphonesRepo.save(newSmartphone);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Smartphone found = this.findById(id);
		smartphonesRepo.delete(found);
	}
}
