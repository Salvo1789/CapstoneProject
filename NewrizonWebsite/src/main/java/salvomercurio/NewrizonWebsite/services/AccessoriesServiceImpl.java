package salvomercurio.NewrizonWebsite.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salvomercurio.NewrizonWebsite.entities.Accessory;
import salvomercurio.NewrizonWebsite.entities.Charger;
import salvomercurio.NewrizonWebsite.entities.Cover;
import salvomercurio.NewrizonWebsite.repositories.AccessoriesRepository;

@Service("accessoriesServiceImpl")
public class AccessoriesServiceImpl implements AccessoriesService {

	@Autowired
	private AccessoriesRepository accessoriesRepo;

	@Override
	public List<Accessory> saveAccessories(List<Accessory> accList) {

		List<Accessory> accessoriesListNew = new ArrayList<>(accList.size());

		Charger mango = new Charger();
		mango.setName("Caricabatteria USB Micro-usb Fast");
		mango.setPrice(19.90);
		mango.setQty(1000);
		mango.setOutput("Micro-usb");
		mango.setRapidRecharge(false);
		mango.setPower("25W");

		Charger dragonfruit = new Charger();
		dragonfruit.setName("Caricabatteria USB Type-C Super Fast");
		dragonfruit.setPrice(39.90);
		dragonfruit.setQty(600);
		dragonfruit.setOutput("Type-C");
		dragonfruit.setRapidRecharge(true);
		dragonfruit.setPower("45W");

		Cover beetle = new Cover();
		beetle.setName("Prime X1 Silicone Clear case");
		beetle.setPrice(19.90);
		beetle.setQty(800);
		beetle.setMaterial("Silicone");
		beetle.setWaterproof(false);

		Cover rhino = new Cover();
		rhino.setName("Prime X1 Rugged Stone case");
		rhino.setPrice(39.90);
		rhino.setQty(500);
		rhino.setMaterial("Silicone/poliuretano termoplastico");
		rhino.setWaterproof(true);

		Cover butterfly = new Cover();
		butterfly.setName("Wonder S1 Silicone Clear case");
		butterfly.setPrice(17.90);
		butterfly.setQty(1200);
		butterfly.setMaterial("Silicone");
		butterfly.setWaterproof(false);

		Cover tiger = new Cover();
		tiger.setName("Wonder S1 Silicone Style case");
		tiger.setPrice(39.90);
		tiger.setQty(500);
		tiger.setMaterial("Silicone rinforzato antiscivolo");
		tiger.setWaterproof(false);

		accessoriesListNew.add(mango);
		accessoriesListNew.add(dragonfruit);
		accessoriesListNew.add(beetle);
		accessoriesListNew.add(rhino);
		accessoriesListNew.add(butterfly);
		accessoriesListNew.add(tiger);

		List<Accessory> accessoriesResponse = (List<Accessory>) accessoriesRepo.saveAll(accessoriesListNew);
		return accessoriesResponse;
	}

}
