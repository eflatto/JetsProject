package com.skilldistillery.entities;

public class FighterJet extends Jet implements CombatReady{

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		double time = range/speed;
		System.out.println("Model: " + model
				+ ", Speed: " + speed
				+ " MPH, Range: " + range 
				+ " miles");
		System.out.println("This jet will fly for "+ Math.round(time) + " hours");
		System.out.println();
	}


	@Override
	public double getSpeedInMach() {
		// TODO Auto-generated method stub
		double mach;
		mach = speed / 767.269;
		return mach;
	}

	
	  public void fight() {
		// TODO Auto-generated method stub
		System.out.println("the " +this.model+" is in a dog fight! Pew pew pew!");
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof FighterJet))
			return false;
		return true;
	}
	
	

}
