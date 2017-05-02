package by.htp.equipment.launch;

import by.htp.equipment.work.ManagDOMxml;
import by.htp.equipment.work.ManagSAXxml;
import by.htp.equipment.work.Management;
//import by.htp.equipment.work.Manager;

public class Main {

	public static void main(String[] args) {
		control();
	}

	private static void control() {
		Management manag = new ManagSAXxml();
		manag.initialization();
		manag.printStock();
		manag.addClient();
		manag.printClient();
	}
}
