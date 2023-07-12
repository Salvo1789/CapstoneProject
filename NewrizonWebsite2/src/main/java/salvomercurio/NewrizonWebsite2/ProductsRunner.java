package salvomercurio.NewrizonWebsite2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import salvomercurio.NewrizonWebsite2.entities.Charger;
import salvomercurio.NewrizonWebsite2.entities.Cover;
import salvomercurio.NewrizonWebsite2.entities.Product;
import salvomercurio.NewrizonWebsite2.entities.Smartphone;
import salvomercurio.NewrizonWebsite2.entities.enums.ChargerColor;
import salvomercurio.NewrizonWebsite2.entities.enums.CoverColor;
import salvomercurio.NewrizonWebsite2.entities.enums.SmartphoneColor;
import salvomercurio.NewrizonWebsite2.repositories.ProductsRepository;

@Component
public class ProductsRunner implements CommandLineRunner {

	@Autowired
	ProductsRepository productsRepo;

	@Override
	public void run(String... args) throws Exception {

		List<Product> productsDB = productsRepo.findAll();

		if (productsDB.size() == 0) {
			try {

				// SMARTPHONES

				String name = "Prime X1";
				double price = 899.99;
				String productPic = "https://m.media-amazon.com/images/I/71NAtIVDCKL._AC_SL1500_.jpg";
				int qty = 300;
				String display = "QHD OLED 6,5 inch";
				String CPU = "Snapdragon 8+ Gen 2";
				int RAM = 12;
				int ROM = 256;
				String battery = "6.300 mAh";
				Boolean RapidRecharge = true;
				String cam1 = "50 mpx grandangolare";
				String cam2 = "20 mpx ultragrandangolare";
				String cam3 = "10 mpx teleobiettivo con zoom 10x";
				String cam4 = "30 mpx con effetto bianco/nero";
				String OS = "Android 13";

				Smartphone alpha = new Smartphone(name, price, productPic, qty, display, CPU, RAM, ROM, battery,
						RapidRecharge, cam1, cam2, cam3, cam4, OS);
				alpha.setColor(SmartphoneColor.DARK_BLACK);
				productsRepo.save(alpha);

				name = "Prime X1";
				price = 899.99;
				qty = 300;
				productPic = "https://files.refurbed.com/ii/oppo-find-x5-pro-1657003310.jpg";
				display = "QHD OLED 6,5 inch";
				CPU = "Snapdragon 8+ Gen 2";
				RAM = 12;
				ROM = 256;
				battery = "6.300 mAh";
				RapidRecharge = true;
				cam1 = "50 mpx grandangolare";
				cam2 = "20 mpx ultragrandangolare";
				cam3 = "10 mpx teleobiettivo con zoom 10x";
				cam4 = "30 mpx con effetto bianco/nero";
				OS = "Android 13";

				alpha = new Smartphone(name, price, productPic, qty, display, CPU, RAM, ROM, battery, RapidRecharge,
						cam1, cam2, cam3, cam4, OS);
				alpha.setColor(SmartphoneColor.PURE_WHITE);
				productsRepo.save(alpha);

				name = "Wonder S1";
				price = 599.99;
				productPic = "https://www.backmarket.it/cdn-cgi/image/format%3Dauto%2Cquality%3D75%2Cwidth%3D1920/https://d1eh9yux7w8iql.cloudfront.net/product_images/738617_01453b18-9b0d-4a18-8359-2e67dfc2d598.jpg";
				qty = 500;
				display = "FHD OLED 6,7 inch";
				CPU = "Snapdragon 7+ Gen 2";
				RAM = 8;
				ROM = 256;
				battery = "6.500 mAh";
				RapidRecharge = true;
				cam1 = "32 mpx grandangolare";
				cam2 = "10 mpx ultragrandangolare";
				cam3 = "20 mpx effetto bianco/nero";
				OS = "Android 13";

				Smartphone beta = new Smartphone(name, price, productPic, qty, display, CPU, RAM, ROM, battery,
						RapidRecharge, cam1, cam2, cam3, OS);
				beta.setColor(SmartphoneColor.ASH_GREY);
				productsRepo.save(beta);

				name = "Wonder S1";
				price = 599.99;
				productPic = "https://www.backmarket.it/cdn-cgi/image/format%3Dauto%2Cquality%3D75%2Cwidth%3D1920/https://d1eh9yux7w8iql.cloudfront.net/product_images/738617_01453b18-9b0d-4a18-8359-2e67dfc2d598.jpg";
				qty = 500;
				display = "FHD OLED 6,7 inch";
				CPU = "Snapdragon 7+ Gen 2";
				RAM = 8;
				ROM = 256;
				battery = "6.500 mAh";
				RapidRecharge = true;
				cam1 = "32 mpx grandangolare";
				cam2 = "10 mpx ultragrandangolare";
				cam3 = "20 mpx effetto bianco/nero";
				OS = "Android 13";

				beta = new Smartphone(name, price, productPic, qty, display, CPU, RAM, ROM, battery, RapidRecharge,
						cam1, cam2, cam3, OS);
				beta.setColor(SmartphoneColor.PETAL_ROSE);
				productsRepo.save(beta);

				name = "Joyful M1";
				price = 299.99;
				productPic = "https://m.media-amazon.com/images/I/610hh2P5wNL._AC_SL1500_.jpg";
				qty = 700;
				display = "FHD LCD 6,7 inch";
				CPU = "Snapdragon 778";
				RAM = 6;
				ROM = 128;
				battery = "7.000 mAh";
				RapidRecharge = false;
				cam1 = "40 mpx";
				cam2 = "10 mpx ultragrandangolare";
				OS = "Android 12";

				Smartphone gamma = new Smartphone(name, price, productPic, qty, display, CPU, RAM, ROM, battery,
						RapidRecharge, cam1, cam2, OS);
				gamma.setColor(SmartphoneColor.INTENSE_BLUE);
				productsRepo.save(gamma);

				name = "Joyful M1";
				price = 299.99;
				productPic = "https://images.eprice.it/nobrand/0/Lightbox/368/307105368/DAM307105368-0-ea559453-6be5-4caf-8a4d-376af003acf2.jpg";
				qty = 700;
				display = "FHD LCD 6,7 inch";
				CPU = "Snapdragon 778";
				RAM = 6;
				ROM = 128;
				battery = "7.000 mAh";
				RapidRecharge = false;
				cam1 = "40 mpx";
				cam2 = "10 mpx ultragrandangolare";
				OS = "Android 12";

				gamma = new Smartphone(name, price, productPic, qty, display, CPU, RAM, ROM, battery, RapidRecharge,
						cam1, cam2, OS);
				gamma.setColor(SmartphoneColor.SUNNY_YELLOW);
				productsRepo.save(gamma);

				// CHARGERS

				Charger mango = new Charger();
				mango.setName("Caricabatteria USB Micro-usb Fast");
				mango.setPrice(19.90);
				mango.setProductPic(
						"https://www.euronics.it/dw/image/v2/BFPN_PRD/on/demandware.static/-/Sites-catalog_euronics_master/default/dw4651a817/hi-res/212001910.jpg?sw=1000&q=90&strip=false");
				mango.setQty(1000);
				mango.setOutput("Micro-usb");
				mango.setRapidRecharge(false);
				mango.setPower("25W");
				mango.setChargerColor(ChargerColor.WHITE);
				productsRepo.save(mango);

				Charger dragonfruit = new Charger();
				dragonfruit.setName("Caricabatteria USB Type-C Super Fast");
				dragonfruit.setPrice(39.90);
				dragonfruit.setProductPic("https://m.media-amazon.com/images/I/61RPHUgtZSL._AC_SL1500_.jpg");
				dragonfruit.setQty(600);
				dragonfruit.setOutput("Type-C");
				dragonfruit.setRapidRecharge(true);
				dragonfruit.setPower("45W");
				dragonfruit.setChargerColor(ChargerColor.WHITE);
				productsRepo.save(dragonfruit);

				// COVERS

				Cover beetleBK = new Cover();
				beetleBK.setName("Prime X1 Silicone Lounge case");
				beetleBK.setPrice(19.90);
				beetleBK.setProductPic("https://m.media-amazon.com/images/I/71elhEsn9QL._AC_UF1000,1000_QL80_.jpg");
				beetleBK.setQty(800);
				beetleBK.setMaterial("Silicone");
				beetleBK.setWaterproof(false);
				beetleBK.setCoverColor(CoverColor.DARK_BLACK);
				productsRepo.save(beetleBK);

				Cover beetleWH = new Cover();
				beetleWH.setName("Prime X1 Silicone Lounge case");
				beetleWH.setPrice(19.90);
				beetleWH.setProductPic("https://img.fruugo.com/product/5/32/411974325_max.jpg");
				beetleWH.setQty(800);
				beetleWH.setMaterial("Silicone");
				beetleWH.setWaterproof(false);
				beetleWH.setCoverColor(CoverColor.PURE_WHITE);
				productsRepo.save(beetleWH);

				Cover beetleTR = new Cover();
				beetleTR.setName("Prime X1 Silicone Clear case");
				beetleTR.setPrice(19.90);
				beetleTR.setProductPic("https://m.media-amazon.com/images/I/61rYI04Pz5L._AC_SL1500_.jpg");
				beetleTR.setQty(800);
				beetleTR.setMaterial("Silicone");
				beetleTR.setWaterproof(false);
				beetleTR.setCoverColor(CoverColor.TRANSPARENT);
				productsRepo.save(beetleTR);

				Cover rhino = new Cover();
				rhino.setName("Prime X1 Rugged Stone case");
				rhino.setPrice(39.90);
				rhino.setProductPic("https://m.media-amazon.com/images/I/71PdWczn8XL._AC_SL1200_.jpg");
				rhino.setQty(500);
				rhino.setMaterial("Silicone/poliuretano termoplastico");
				rhino.setWaterproof(true);
				rhino.setCoverColor(CoverColor.DARK_BLACK);
				productsRepo.save(rhino);

				Cover butterflyGR = new Cover();
				butterflyGR.setName("Wonder S1 Silicone Bright case");
				butterflyGR.setPrice(17.90);
				butterflyGR.setProductPic("https://m.media-amazon.com/images/I/71Zh01PY3QL._AC_SL1500_.jpg");
				butterflyGR.setQty(1200);
				butterflyGR.setMaterial("Silicone");
				butterflyGR.setWaterproof(false);
				butterflyGR.setCoverColor(CoverColor.ASH_GREY);
				productsRepo.save(butterflyGR);

				Cover butterflyRO = new Cover();
				butterflyRO.setName("Wonder S1 Silicone Bright case");
				butterflyRO.setPrice(17.90);
				butterflyRO.setProductPic("https://m.media-amazon.com/images/I/71lVjFGCqoL._AC_SL1500_.jpg");
				butterflyRO.setQty(1200);
				butterflyRO.setMaterial("Silicone");
				butterflyRO.setWaterproof(false);
				butterflyRO.setCoverColor(CoverColor.PETAL_ROSE);
				productsRepo.save(butterflyRO);

				Cover butterflyTR = new Cover();
				butterflyTR.setName("Wonder S1 Silicone Clear case");
				butterflyTR.setPrice(17.90);
				butterflyTR.setProductPic(
						"https://static1.unieuro.it/medias/sys_master/root/h19/h52/33829428428830/-api-rest-00ed29448a7522f610cac04d7b9ea7e0-assets-3b56ce9a399b4a370f8b754ba5faf373-preview-sgmConversionBaseFormat.jpg");
				butterflyTR.setQty(1200);
				butterflyTR.setMaterial("Silicone");
				butterflyTR.setWaterproof(false);
				butterflyTR.setCoverColor(CoverColor.TRANSPARENT);
				productsRepo.save(butterflyTR);

				Cover tiger = new Cover();
				tiger.setName("Wonder S1 Silicone Style case");
				tiger.setPrice(39.90);
				tiger.setProductPic(
						"https://alcanside.com/cdn/shop/products/samsung-galaxy-s22-alcantara-back-cover-space-grey-alcantara-back-cover-alcanside-342460.jpg?v=1684064611&width=1800");
				tiger.setQty(500);
				tiger.setMaterial("Silicone rinforzato antiscivolo");
				tiger.setWaterproof(false);
				tiger.setCoverColor(CoverColor.ASH_GREY);
				productsRepo.save(tiger);

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
