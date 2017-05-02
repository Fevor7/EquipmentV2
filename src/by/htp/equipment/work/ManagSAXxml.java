package by.htp.equipment.work;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.equipment.accessory.*;
import by.htp.equipment.array.*;
import by.htp.equipment.client.Client;
import by.htp.equipment.entity.*;

public class ManagSAXxml implements Management {
	private Stock stock = new Stock();
	private CustomerBase customer = new CustomerBase();
	private RentStation rentStat = new RentStation();
	private List<Equipment> equipment;
	private Equipment equip;
	private List<Accessory> access;
	private Accessory accessory;
	private List<Client> clientArr;
	private Client client;
	private RenUnit renUnit;

	public void initialization() {
		readXML();
	}

	private void readXML() {
		Handler defaultHandler = new Handler();
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			saxParser.parse("/home/viktor/workspace/EquipmentV2/xmlfile/stock.xml", defaultHandler);
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			ex.printStackTrace();
		}
	}

	public void addClient() {
		newClient("Masha");
		addEquiClient("Masha", 10007, 10004, 10007);
		newClient("Viktor");
		addEquiClient("Viktor", 10010, 10001);
	}

	public void addEquipment(String title, String type, String specialMark) {
		equipment = stock.getEquip();
		int id = stock.getIdnumber();
		rentStat = stock.getRentStat();
		List<Equipment> equip2 = rentStat.getEquip();
		switch (title) {
		case "Bike": {
			equip = new Bike(id, title, type, specialMark);
			break;
		}
		case "Scooter": {
			equip = new Scooter(id, title, type, specialMark);
			break;
		}
		}
		if (equip != null) {
			id++;
			stock.setIdnumber(id);
			equip2.add(equip);
			equipment.add(equip);
			testMeth(equip);
		}
	}

	private void addAccess(String title, String specialMark) {
		equipment = stock.getEquip();
		int index = equipment.size();
		equip = equipment.get(index - 1);
		access = equip.getAccessory();
		int id = stock.getIdnumber();
		rentStat = stock.getRentStat();
		List<Accessory> access2 = rentStat.getAccess();
		switch (title) {
		case "BagWithTools": {
			int number = Integer.parseInt(specialMark);
			accessory = new BagWithTools(id, number);
			break;
		}
		case "Castle": {
			int langth = Integer.parseInt(specialMark);
			accessory = new Castle(id, langth);
			break;
		}
		case "Helmet": {
			accessory = new Helmet(id, specialMark);
			break;
		}
		case "Pump": {
			double weight = Double.parseDouble(specialMark);
			accessory = new Pump(id, weight);
			break;
		}
		}

		access.add(accessory);
		id++;
		access2.add(accessory);
		stock.setIdnumber(id);
	}

	public void printStock() {
		List<Equipment> list = stock.getEquip();
		int size = list.size();
		Equipment equip;
		List<Accessory> access = null;
		PrintInfo.print("Whole inventory: ");
		for (int i = 0; i < size; i++) {
			equip = list.get(i);
			PrintInfo.printEquip(equip);
			access = equip.getAccessory();
			printAccess(access);
		}
	}

	public void prntRenUnit(List<Equipment> list) {
		int size = list.size();
		Equipment equip;
		for (int i = 0; i < size; i++) {
			equip = list.get(i);
			PrintInfo.printEquip(equip);
			access = equip.getAccessory();
			printUnitAcc(access);
		}
	}

	public void printAccess(List<Accessory> access) {
		int size = access.size();
		accessory = null;
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				accessory = access.get(i);
				PrintInfo.printAcc(accessory);
			}
		}
	}

	public void printUnitAcc(List<Accessory> access) {
		int size = access.size();
		accessory = null;
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				accessory = access.get(i);
				if (!accessory.isAvailabilityInStock()) {
					PrintInfo.printAcc(accessory);
				}
			}
		}
	}

	public void newClient(String name) {
		clientArr = customer.getClient();
		client = new Client(name);
		clientArr.add(client);
		RenUnit renUnit = new RenUnit();
		client.setRenUnit(renUnit);
	}

	public void addEquiClient(String name, int id1) {
		Equipment equip2;
		clientArr = customer.getClient();
		for (int i = 0; i < clientArr.size(); i++) {
			client = clientArr.get(i);
			if ((client.getName()).equals(name)) {
				equip2 = findEqStation(id1);
				addEquiId(equip2);
			}
		}
	}

	public void addEquiClient(String name, int id1, int id2) {
		Equipment equip2;
		clientArr = customer.getClient();
		for (int i = 0; i < clientArr.size(); i++) {
			client = clientArr.get(i);
			if ((client.getName()).equals(name)) {
				equip2 = findEqStation(id1);
				addEquiId(equip2);
				equip2 = findEqStation(id2);
				addEquiId(equip2);
			}
		}
	}

	public void addEquiClient(String name, int id1, int id2, int id3) {
		Equipment equip2;
		clientArr = customer.getClient();
		for (int i = 0; i < clientArr.size(); i++) {
			client = clientArr.get(i);
			if ((client.getName()).equals(name)) {
				equip2 = findEqStation(id1);
				addEquiId(equip2);
				equip2 = findEqStation(id2);
				addEquiId(equip2);
				equip2 = findEqStation(id3);
				addEquiId(equip2);
			}
		}
	}

	public void testMeth(Equipment equip2) {
		try {
			testMethod(equip2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	public void testMethod(Equipment equip2)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		String ss = "by.htp.equipment.entity.Bike";
		String s2 = equip2.getClass().getName();
		for (int i = 0; i < stock.getCl().length; i++) {
			if ((equip2.getClass() == (stock.getCl())[i]) && (ss.equals(s2))) {
				Class<?> c = Class.forName(s2);
				Constructor<?>[] con = c.getConstructors();
				Object obj = con[1].newInstance(3, "dfg0", "dfg", "dfgdfg");
				// Field[] f = c.getDeclaredFields(); //
				// c.getDeclaredField("grade");
				// for (int j=0; j<f.length; j++){
				// f[j].setAccessible(true);
				// f[j].set(obj, "ffdfaf");
				// System.out.println(j);
				// }
				Equipment test = (Equipment) obj;
			}
		}
	}

	public void addEquiId(Equipment equip2) {

		if (equip2 != null) {
			renUnit = client.getRenUnit();
			equipment = renUnit.getEquip();
			equipment.add(equip2);
			rentStat = stock.getRentStat();
			equipment = rentStat.getEquip();
			equipment.remove(equip2);
		}
	}

	public Equipment findEquip(int id) {
		equipment = stock.getEquip();
		for (int i = 0; i < equipment.size(); i++) {
			equip = equipment.get(i);
			if (equip.getId() == id) {
				return equip;
			}

		}
		return null;
	}

	public Equipment findEqStation(int id) {
		rentStat = stock.getRentStat();
		equipment = rentStat.getEquip();
		for (int i = 0; i < equipment.size(); i++) {
			equip = equipment.get(i);
			if (equip.getId() == id) {
				return equip;
			}

		}
		return null;
	}

	public void printClient() {
		clientArr = customer.getClient();
		int size = clientArr.size();
		if (size != 0) {
			PrintInfo.print("List of clients: ");
		}
		for (int i = 0; i < size; i++) {
			client = clientArr.get(i);
			PrintInfo.print(client.getName());
			renUnit = client.getRenUnit();
			equipment = renUnit.getEquip();
			prntRenUnit(equipment);
		}

	}

	private class Handler extends DefaultHandler {
		private boolean equip = false;
		private boolean access = false;
		String title = "";
		String line = "";
		private List<String> data = new ArrayList<String>();

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if (("equipment").equals(qName)) {
				equip = true;
				title = attributes.getValue(0);
			}
			if (("ecceessory").equals(qName) && (equip == true)) {
				access = true;
				equip = false;
				newEquip(title, data);
				data.clear();
				title = attributes.getValue(0);
			}
			if (("ecceessory").equals(qName) && (equip == false)) {
				access = true;
				data.clear();
				title = attributes.getValue(0);
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if ((equip == true) || (access == true)) {
				if (("ecceessory").equals(qName)) {
					access = false;
					newAccess(title, data);
					data.clear();
				} else {
					data.add(line.trim());
				}
			}
		}

		// @Override
		public void characters(char ch[], int start, int stop) throws SAXException {
			if ((equip == true) || (access == true)) {
				line = new String(ch, start, stop);
			}
		}

	}

	private void newEquip(String title, List<String> paramLine) {
		addEquipment(title, paramLine.get(1), paramLine.get(2));
	}

	private void newAccess(String title, List<String> paramLine) {
		addAccess(title, paramLine.get(1));
	}
}