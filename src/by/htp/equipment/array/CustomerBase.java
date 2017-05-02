package by.htp.equipment.array;

import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.client.*;

public class CustomerBase {
	private List<Client> client = new ArrayList<Client>();

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}
	
}
