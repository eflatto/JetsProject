package com.skilldistillery.entities;
import com.skilldistillery.entities.AirField;
import java.util.Iterator;
import java.util.Scanner;

public class Pilot {
	private String fname;
	private String callSign;
	private String model;
	
	private AirField af = new AirField();
	


	public Pilot(String fname, String callSign) {
		super();
		this.fname = fname;
		this.callSign = callSign;
		
	}
	public Pilot(String fname, String callSign, String model) {
		super();
		this.fname = fname;
		this.callSign = callSign;
		this.model = model;
	}
	


	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Pilot() {
		super();
	}

	
	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getCallSign() {
		return callSign;
	}


	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	@Override
	public String toString() {
		return "Pilot " + fname + ", callSign=" + callSign + ", Flying the " + model + "]";
	}

}
