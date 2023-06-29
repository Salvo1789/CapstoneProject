package salvomercurio.NewrizonWebsite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import salvomercurio.NewrizonWebsite.entities.Smartphone;
import salvomercurio.NewrizonWebsite.repositories.SmartphonesRepository;

@Component
public class SmartphonesRunner implements CommandLineRunner {

	@Autowired
	SmartphonesRepository smartphonesRepo;

	@Override
	public void run(String... args) throws Exception {

		List<Smartphone> smartphonesDB = smartphonesRepo.findAll();

		if (smartphonesDB.size() == 0) {
			try {
				String name = "Prime X1";
				double price = 899.99;
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

				Smartphone alpha = new Smartphone(name, price, qty, display, CPU, RAM, ROM, battery, RapidRecharge,
						cam1, cam2, cam3, cam4, OS);
				smartphonesRepo.save(alpha);

				name = "Wonder S1";
				price = 599.99;
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

				Smartphone beta = new Smartphone(name, price, qty, display, CPU, RAM, ROM, battery, RapidRecharge, cam1,
						cam2, cam3, OS);
				smartphonesRepo.save(beta);

				name = "Joyful M1";
				price = 299.99;
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

				Smartphone gamma = new Smartphone(name, price, qty, display, CPU, RAM, ROM, battery, RapidRecharge,
						cam1, cam2, OS);
				smartphonesRepo.save(gamma);

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
