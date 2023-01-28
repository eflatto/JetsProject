package com.skilldistillery.entities;

import java.util.Objects;

public abstract class Jet {
	protected String model;
	protected double speed;
	protected int range;
	protected long price;
	
	
	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	public abstract void fly();
	
	public abstract double getSpeedInMach();

	@Override
	public String toString() {
		return "Model: " + model + ", Speed: " + speed + " MPH, Range: " + range + " miles, Price: $" + price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model) && price == other.price && range == other.range
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}
	
}
