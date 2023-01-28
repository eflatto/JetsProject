package com.skilldistillery.entities;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AirField {

	private List<Jet> jetsList = new ArrayList<>();

	public AirField() {

	}

	public void ReadFile(String filename) {

		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jets = line.split(",");

				String type = jets[0];
				String model = jets[1];
				double speed = Double.parseDouble(jets[2]);
				int range = Integer.parseInt(jets[3]);
				long price = Long.parseLong(jets[4]);

				if (type.equals("CargoPlane")) {
					Jet cargo = new CargoPlane(model, speed, range, price);
					jetsList.add(cargo);
				} else if (type.equals("JetImpl")) {
					Jet jetImpl = new JetImpl(model, speed, range, price);
					jetsList.add(jetImpl);
				} else if (type.equals("FighterJet")) {
					Jet fighter = new FighterJet(model, speed, range, price);
					jetsList.add(fighter);
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	
	public void listFleet() {
		for (Jet jet : jetsList) {
			System.out.println(jet + "\n");
		}
	}
	
	public void flyAllJets() {
		for (Jet jet : jetsList) {
			jet.fly();
		}
	}
	public Jet viewFastestJet() {
		Jet fastestJet = jetsList.get(0);
		double fastestSpeed = fastestJet.getSpeedInMach();
		for (Jet jet : jetsList) {
			if(jet.getSpeedInMach()>fastestSpeed) {
				fastestJet=jet;
			}	
		}
		
		return fastestJet;
	}
	public Jet viewJetWithLongestRange() {
		 Jet longestRangeJet = jetsList.get(0);
		    for (Jet jet : jetsList) {
		        if (jet.range > longestRangeJet.range) {
		            longestRangeJet = jet;
		        }
		    }
		    return longestRangeJet;
	}
	
}
