package com.skilldistillery.entities;

import java.util.Objects;

public abstract class Jet {
	protected String model;
	protected double speed;
	protected int range;
	protected long price;
	protected String type;
	protected Pilot pilot;
	
	
	

	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	

	public Jet(String model, double speed, int range, long price, String type, Pilot pilot) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.type = type;
		this.pilot = pilot;
	}



	public Pilot getPilot() {
		return pilot;
	}



	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}



	public abstract void fly();
	
	public abstract double getSpeedInMach();

	@Override
	public String toString() {
		return "Model: " + model + ", Speed: " + speed + " MPH, Range: " + range + " miles, Price: $" + price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Jet))
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model) && price == other.price && range == other.range
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed)
				&& Objects.equals(type, other.type);
	}

	
}
