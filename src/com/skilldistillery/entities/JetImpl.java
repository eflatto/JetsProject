package com.skilldistillery.entities;

public class JetImpl extends Jet {

	public JetImpl(String model, double speed, int range, long price) {
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
		if (!(obj instanceof JetImpl))
			return false;
		return true;
	}

}
