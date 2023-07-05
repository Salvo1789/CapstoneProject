package salvomercurio.NewrizonWebsite.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Smartphones")
@Getter
@Setter
@NoArgsConstructor
public class Smartphone extends Product {

	private String Display;
	private String CPU;
	private int RAM;
	private int ROM;
	private String Battery;
	private Boolean RapidRecharge;
	private String Cam1;
	private String Cam2;
	private String Cam3;
	private String Cam4;
	private String OS;
	@Enumerated(EnumType.STRING)
	private SmartphoneColor color;

	public Smartphone(String name, double price, int qty, String display, String cPU, int rAM, int rOM, String battery,
			Boolean rapidRecharge, String cam1, String cam2, String cam3, String cam4, String oS) {
		super(name, price, qty);
		Display = display;
		CPU = cPU;
		RAM = rAM;
		ROM = rOM;
		Battery = battery;
		RapidRecharge = rapidRecharge;
		Cam1 = cam1;
		Cam2 = cam2;
		Cam3 = cam3;
		Cam4 = cam4;
		OS = oS;
		color = SmartphoneColor.PURE_WHITE;

	}

	public Smartphone(String name, double price, int qty, String display, String cPU, int rAM, int rOM, String battery,
			Boolean rapidRecharge, String cam1, String cam2, String cam3, String oS) {
		super(name, price, qty);
		Display = display;
		CPU = cPU;
		RAM = rAM;
		ROM = rOM;
		Battery = battery;
		RapidRecharge = rapidRecharge;
		Cam1 = cam1;
		Cam2 = cam2;
		Cam3 = cam3;
		Cam4 = "N/A";
		OS = oS;
		color = SmartphoneColor.PURE_WHITE;
	}

	public Smartphone(String name, double price, int qty, String display, String cPU, int rAM, int rOM, String battery,
			Boolean rapidRecharge, String cam1, String cam2, String oS) {
		super(name, price, qty);
		Display = display;
		CPU = cPU;
		RAM = rAM;
		ROM = rOM;
		Battery = battery;
		RapidRecharge = rapidRecharge;
		Cam1 = cam1;
		Cam2 = cam2;
		Cam3 = "N/A";
		Cam4 = "N/A";
		OS = oS;
		color = SmartphoneColor.PURE_WHITE;
	}

}
