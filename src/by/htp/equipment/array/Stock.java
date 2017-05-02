package by.htp.equipment.array;

import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.entity.Bike;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Scooter;

public class Stock {

	private List<Equipment> equip = new ArrayList<Equipment>();
	RentStation rentStat = new RentStation();
	private int idNumber=10001;
	private Class<?>[] cl = {
			Bike.class, Scooter.class
	};

	
	public RentStation getRentStat() {
		return rentStat;
	}

	public void setRentStat(RentStation rentStat) {
		this.rentStat = rentStat;
	}

	public List<Equipment> getEquip() {
		return equip;
	}

	public void setEquip(List<Equipment> equip) {
		this.equip = equip;
	}


	public int getIdnumber() {
		return idNumber;
	}

	public void setIdnumber(int idnumber) {
		this.idNumber = idnumber;
	}

	public Class<?>[] getCl() {
		return cl;
	}

	public void setCl(Class<?>[] cl) {
		this.cl = cl;
	}
}
