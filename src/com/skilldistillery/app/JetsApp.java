package com.skilldistillery.app;

import java.util.Scanner;

import com.skilldistillery.entities.AirField;
import com.skilldistillery.entities.CargoCarrier;
import com.skilldistillery.entities.CargoPlane;
import com.skilldistillery.entities.CombatReady;
import com.skilldistillery.entities.Jet;

public class JetsApp {
	private AirField airField = new AirField();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JetsApp ja = new JetsApp();

		try {
			ja.airField.ReadFile("jets.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		}

		ja.launch();

	}

	private void launch() {
		displayMenu();
	}

	private void displayMenu() {
		boolean running = true;
		while (running) {
			System.out.println("*************************************");
			System.out.println("*                                   *");
			System.out.println("*           Menu:                   *");
			System.out.println("*                                   *");
			System.out.println("*    1. List fleet                  *");
			System.out.println("*    2. Fly all jets                *");
			System.out.println("*    3. View fastest jet            *");
			System.out.println("*    4. View jet with longest range *");
			System.out.println("*    5. Load all Cargo Jets         *");
			System.out.println("*    6. Dogfight!                   *");
			System.out.println("*    7. Add a jet to Fleet          *");
			System.out.println("*    8. Remove a jet from Fleet     *");
			System.out.println("*    9. Quit                        *");
			System.out.println("*                                   *");
			System.out.println("*************************************");
			System.out.print("Enter number choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				airField.listFleet();
				break;
			case 2:
				airField.flyAllJets();
				break;
			case 3:
				System.out.println(airField.viewFastestJet());
				break;
			case 4:
				System.out.println(airField.viewJetWithLongestRange());
				break;
			case 5:
				for (Jet jet : airField.getJetsList()) {
					if (jet instanceof CargoCarrier) {
						((CargoCarrier) jet).loadAllCargoJets();
					}
				}
				break;
			case 6:
				for (Jet jet : airField.getJetsList()) {
					if (jet instanceof CombatReady) {
						((CombatReady) jet).fight();
					}
				}

				break;
			case 7:
				airField.addJetToFleet();
				break;
			case 8:
                    airField.removeJetFromFleet();
                    break;
			case 9:
				System.out.println("Exiting...");
				running = false;
				break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
