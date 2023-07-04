package salvomercurio.NewrizonWebsite;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import salvomercurio.NewrizonWebsite.entities.Accessory;
import salvomercurio.NewrizonWebsite.entities.Charger;
import salvomercurio.NewrizonWebsite.entities.ChargerColor;
import salvomercurio.NewrizonWebsite.entities.Cover;
import salvomercurio.NewrizonWebsite.entities.CoverColor;
import salvomercurio.NewrizonWebsite.repositories.AccessoriesRepository;

@Component
public class AccessoriesRunner implements CommandLineRunner {

	@Autowired
	AccessoriesRepository accessoriesRepo;

	@Override
	public void run(String... args) throws Exception {

		List<Accessory> accessoriesListNew = new ArrayList<>();

		// CHARGERS

		Charger mango = new Charger();
		mango.setName("Caricabatteria USB Micro-usb Fast");
		mango.setPrice(19.90);
		mango.setQty(1000);
		mango.setOutput("Micro-usb");
		mango.setRapidRecharge(false);
		mango.setPower("25W");
		mango.setChargerColor(ChargerColor.WHITE);

		Charger dragonfruit = new Charger();
		dragonfruit.setName("Caricabatteria USB Type-C Super Fast");
		dragonfruit.setPrice(39.90);
		dragonfruit.setQty(600);
		dragonfruit.setOutput("Type-C");
		dragonfruit.setRapidRecharge(true);
		dragonfruit.setPower("45W");
		dragonfruit.setChargerColor(ChargerColor.WHITE);

		// COVERS

		Cover beetleBK = new Cover();
		beetleBK.setName("Prime X1 Silicone Lounge case");
		beetleBK.setPrice(19.90);
		beetleBK.setQty(800);
		beetleBK.setMaterial("Silicone");
		beetleBK.setWaterproof(false);
		beetleBK.setCoverColor(CoverColor.DARK_BLACK);

		Cover beetleWH = new Cover();
		beetleWH.setName("Prime X1 Silicone Lounge case");
		beetleWH.setPrice(19.90);
		beetleWH.setQty(800);
		beetleWH.setMaterial("Silicone");
		beetleWH.setWaterproof(false);
		beetleWH.setCoverColor(CoverColor.PURE_WHITE);

		Cover beetleTR = new Cover();
		beetleTR.setName("Prime X1 Silicone Clear case");
		beetleTR.setPrice(19.90);
		beetleTR.setQty(800);
		beetleTR.setMaterial("Silicone");
		beetleTR.setWaterproof(false);
		beetleTR.setCoverColor(CoverColor.TRANSPARENT);

		Cover rhino = new Cover();
		rhino.setName("Prime X1 Rugged Stone case");
		rhino.setPrice(39.90);
		rhino.setQty(500);
		rhino.setMaterial("Silicone/poliuretano termoplastico");
		rhino.setWaterproof(true);
		rhino.setCoverColor(CoverColor.DARK_BLACK);

		Cover butterflyGR = new Cover();
		butterflyGR.setName("Wonder S1 Silicone Bright case");
		butterflyGR.setPrice(17.90);
		butterflyGR.setQty(1200);
		butterflyGR.setMaterial("Silicone");
		butterflyGR.setWaterproof(false);
		butterflyGR.setCoverColor(CoverColor.ASH_GREY);

		Cover butterflyRO = new Cover();
		butterflyRO.setName("Wonder S1 Silicone Bright case");
		butterflyRO.setPrice(17.90);
		butterflyRO.setQty(1200);
		butterflyRO.setMaterial("Silicone");
		butterflyRO.setWaterproof(false);
		butterflyRO.setCoverColor(CoverColor.PETAL_ROSE);

		Cover butterflyTR = new Cover();
		butterflyTR.setName("Wonder S1 Silicone Clear case");
		butterflyTR.setPrice(17.90);
		butterflyTR.setQty(1200);
		butterflyTR.setMaterial("Silicone");
		butterflyTR.setWaterproof(false);
		butterflyTR.setCoverColor(CoverColor.TRANSPARENT);

		Cover tiger = new Cover();
		tiger.setName("Wonder S1 Silicone Style case");
		tiger.setPrice(39.90);
		tiger.setQty(500);
		tiger.setMaterial("Silicone rinforzato antiscivolo");
		tiger.setWaterproof(false);
		tiger.setCoverColor(CoverColor.ASH_GREY);

		accessoriesListNew.add(mango);
		accessoriesListNew.add(dragonfruit);
		accessoriesListNew.add(beetleBK);
		accessoriesListNew.add(beetleWH);
		accessoriesListNew.add(beetleTR);
		accessoriesListNew.add(rhino);
		accessoriesListNew.add(butterflyGR);
		accessoriesListNew.add(butterflyRO);
		accessoriesListNew.add(butterflyTR);
		accessoriesListNew.add(tiger);

		accessoriesRepo.saveAll(accessoriesListNew);

	}

}
