package by.htp.equipment.work;

import java.util.List;

import by.htp.equipment.accessory.Accessory;
import by.htp.equipment.entity.Equipment;

public interface Management {
	void initialization();
	void addEquipment(String title, String type, String specialMark);
	void printStock();
	void prntRenUnit(List<Equipment> list);
	void printAccess(List<Accessory> access);
	void addClient();
	void printUnitAcc(List<Accessory> access);
	void newClient(String name);
	void addEquiClient(String name, int id1);
	void addEquiClient(String name, int id1, int id2);
	void addEquiClient(String name, int id1, int id2, int id3);
	void addEquiId(Equipment equip2);
	Equipment findEqStation(int id);
	void printClient();
}
