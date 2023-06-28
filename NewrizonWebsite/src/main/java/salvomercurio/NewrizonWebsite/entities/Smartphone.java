package salvomercurio.NewrizonWebsite.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import salvomercurio.NewrizonWebsite.model.Product;

@Entity
@Table(name = "Smartphones")
@Getter
@Setter
public class Smartphone extends Product {
	protected String Display;
	protected String CPU;
	protected int RAM;
	protected int ROM;
	protected String Battery;
	protected Boolean RapidRecharge;
	protected String Cam1;
	protected String Cam2;
	protected String Cam3;
	protected String Cam4;
	protected String OS;

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
	}

}
