package by.htp.equipment.work;

import by.htp.equipment.accessory.Accessory;
import by.htp.equipment.accessory.BagWithTools;
import by.htp.equipment.accessory.Castle;
import by.htp.equipment.accessory.Helmet;
import by.htp.equipment.accessory.Pump;
import by.htp.equipment.entity.Bike;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Scooter;

public class PrintInfo {
	public static void printEquip(Equipment equip){
		String line;
		line="ID:"+equip.getId()+", title: "+equip.getTitle()+ ", type: "+equip.getType();
		switch(equip.getTitle()){
		case "Bike":{
			Bike bike = (Bike) equip;
			line=line+", grade: "+bike.getGrade();
			break;
		}
		case "Scooter":{
			Scooter scooter = (Scooter) equip;
			line=line+", speed: "+scooter.getSpeed();
			break;
		}
		}
		print(line);
	}
	public static void printAcc(Accessory accessory){
		System.out.print("         ");
		String line;
		line="ID:"+accessory.getId()+", title: "+accessory.getTitle();
		switch(accessory.getTitle()){
		case "BagWithTools":{
			BagWithTools access = (BagWithTools) accessory;
			line=line+", number of tools: "+access.getNumberOfTools();
			break;
		}
		case "Castle":{
			Castle access = (Castle) accessory;
			line=line+", cable length: "+access.getCableLength();
			break;
		}case "Helmet":{
			Helmet access = (Helmet) accessory;
			line=line+", color: "+access.getColor();
			break;
		}case "Pump":{
			Pump access = (Pump) accessory;
			line=line+", weigth "+access.getWeight();
			break;
		}
		}
		print(line);
	}
	public static void print(String line){
		System.out.println(line);
	}
}
