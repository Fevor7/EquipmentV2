package by.htp.equipment.work;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import by.htp.equipment.accessory.Accessory;
import by.htp.equipment.accessory.BagWithTools;
import by.htp.equipment.accessory.Castle;
import by.htp.equipment.accessory.Helmet;
import by.htp.equipment.accessory.Pump;
import by.htp.equipment.array.CustomerBase;
import by.htp.equipment.array.RenUnit;
import by.htp.equipment.array.RentStation;
import by.htp.equipment.array.Stock;
import by.htp.equipment.client.Client;
import by.htp.equipment.entity.Bike;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Scooter;

public class ManagDOMxml implements Management {
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
		Node node = null;
		Node node2 = null;
		Document doc = null;
		String nameAtr = null;
		try {
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			f.setValidating(false);
			DocumentBuilder builder = f.newDocumentBuilder();
			doc = builder.parse(new File("/home/viktor/workspace/EquipmentV2/xmlfile/stock.xml"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		node = doc.getChildNodes().item(0);
		NodeList lst = node.getChildNodes();
		for (int i = 0; i < lst.getLength(); i++) {
			node2 = lst.item(i);
			String s = node2.getNodeName();

			if (!("#text").equals(s)) {
				NamedNodeMap attributes = node2.getAttributes();
				Node nameAttrib = attributes.getNamedItem("title");
				nameAtr = nameAttrib.getNodeValue();
				NodeList lst2 = node2.getChildNodes();
				parse2(nameAtr, lst2);
			}
		}
	}

	private void parse2(String title, NodeList lst2) {
		String s4;
		Node node4;
		String nameAtr = null;
		String[] paramLine = new String[3];
		int iterator = 0;
		int iterAccess = 0;
		for (int j = 0; j < lst2.getLength(); j++) {
			Node node3 = lst2.item(j);
			String s2 = lst2.item(j).getNodeName();
			s4 = lst2.item(j).getTextContent();
			if ((!("#text").equals(s2)) && ((!("ecceessory").equals(s2)))) {
				paramLine[iterator] = s4.trim();
				iterator++;
			}
			if (("ecceessory").equals(s2)) {
				if (iterAccess == 0) {
					newEquip(title, paramLine);
				}
				iterAccess++;
				NamedNodeMap attributes = node3.getAttributes();
				Node nameAttrib = attributes.getNamedItem("title");
				nameAtr = nameAttrib.getNodeValue();
				NodeList lst3 = node3.getChildNodes();
				parse3(nameAtr, lst3);
			}
		}
	}

	private void parse3(String title, NodeList lst3) {
		Node node4 = null;
		int iterator = 0;
		String[] paramLine = new String[2];
		for (int k = 0; k < lst3.getLength(); k++) {
			node4 = lst3.item(k);
			String s3 = lst3.item(k).getNodeName();
			String s4 = lst3.item(k).getTextContent();
			if (!("#text").equals(s3)) {
				paramLine[iterator] = s4.trim();
				iterator++;
			}
		}
		newAccess(title, paramLine);
	}

	private void newEquip(String title, String[] paramLine) {
		addEquipment(title, paramLine[1], paramLine[2]);
	}

	private void newAccess(String title, String[] paramLine) {
		addAccess(title, paramLine[1]);
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
}