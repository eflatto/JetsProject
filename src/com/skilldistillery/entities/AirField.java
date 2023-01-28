package com.skilldistillery.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AirField {

	private Scanner sc = new Scanner(System.in);

	private List<Jet> jetsList = new ArrayList<>();
	private List<Pilot> pilotList = new ArrayList<>();

	public AirField() {

	}

	public List<Jet> getJetsList() {
		return jetsList;
	}
//	public void WriteToFIle(String filename) {
//		 
//		  try {
//		    FileWriter fw = new FileWriter(filename);
//		    PrintWriter pw = new PrintWriter(fw);
//		    
//		      pw.println();
//		      Jet impl = new Jet(pw.)
//		    
//		    pw.close();
//		  }
//		  catch (IOException e) {
//		    e.printStackTrace();
//		  }
//		}
//	}

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

	public void addJetToFleet() {
		String model1;
		double speed1;
		int range1;
		long price1;

		System.out.println("Adding Jet to Fleet");
		System.out.println("Please type in model of your jet");
		sc.next();
		model1 = sc.nextLine();
		System.out.println("Please type in the max speed of the jet");
		speed1 = sc.nextDouble();
		System.out.println("Please type in range of the jet");
		range1 = sc.nextInt();
		System.out.println("Please type in price of the jet");
		price1 = sc.nextLong();
		Jet fighter = new JetImpl(model1, speed1, range1, price1);
		jetsList.add(fighter);
	}

	public void removeJetFromFleet() {
		String model2;
		boolean jetFound = false;

		System.out.println("Removing Jet from Fleet");
		System.out.println("Please type in model of jet you want to remove");
		for (Jet jet : jetsList) {
			System.out.println(jet.model);
		}

		model2 = sc.nextLine();
		Iterator<Jet> jets = jetsList.iterator();
		while (jets.hasNext()) {
			Jet jet = jets.next();
			if (jet.model.equalsIgnoreCase(model2)) {
				jets.remove();
				jetFound = true;
				break;
			}
		}

		if (jetFound) {
			System.out.println("Jet removed successfully.");
		} else {
			System.out.println("No jet found with the model " + model2 + ".");
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
			if (jet.getSpeedInMach() > fastestSpeed) {
				fastestJet = jet;
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

	public void addAPilot() {
		String model;
		boolean jetFound1 = false;
		System.out.print("What is your name ");
		String name = sc.next();
		System.out.print("what is your callsign ");
		String callSign = sc.next();

		for (Jet jet : jetsList) {
			System.out.println(jet.model);
		}
		System.out.print("What model plane do you want fly? ");
		model = sc.next();

		Pilot pilot = new Pilot(name, callSign, null);
		Iterator<Jet> jetIterator = jetsList.iterator();
		while (jetIterator.hasNext()) {
			Jet jet = jetIterator.next();
			if (jet.model.trim().equalsIgnoreCase(model)) {
				jet.setPilot(pilot);
				pilot.setModel(model);
				jetFound1 = true;
				pilotList.add(pilot);
				break;

			}

		}
		if (jetFound1) {
			System.out.println(pilot);
		} else {
			System.out.println("No jet found with the model " + model + ".");

		}

	}

	public void listPilots() {
		if (getPilotList().isEmpty()) {
			System.out.println("There are no pilots in the hangar!");
		} 

		for (Pilot pilot : getPilotList()) {
				System.out.println(pilot + "\n");
		}
	}

	public List<Pilot> getPilotList() {
		return pilotList;
	}

}
