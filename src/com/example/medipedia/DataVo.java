package com.example.medipedia;

import java.util.ArrayList;

public class DataVo
{
	
	private String name,quantity,time,type;
	
	ArrayList<String> medicines;

	public ArrayList<String> getMedicines() {
		return medicines;
	}

	public void setMedicines(ArrayList<String> medicines) {
		this.medicines = medicines;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	
	
	

}
