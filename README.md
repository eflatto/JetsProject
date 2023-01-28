# JetsProject

## Description
This is a Java program that simulates a fleet of jets. The program includes classes for different types of jets, including FighterJet, CargoPlane, and JetImpl.
JetImpl is a class that can make any type of Jet. The program also includes interfaces for CombatReady and CargoCarrier. In addition the program has an option to add pilots to certain Jets.


### Classes
0. The JetApp class includes the main method and prompts the user to enter a choice from the menu options

1. The Jet class is the superclass for all jet types in the program. It includes basic information about the jet, such as its model, speed, range, and price. The class includes a fly() method that calculates how long the jet can fly for based on its range and speed. The class also includes a method to get the speed of the jet in mach units.

2. The FighterJet class extends the Jet class and also implements the CombatReady interface. In addition to the basic information from the Jet class, the FighterJet class includes a fight() method that simulates a dogfight.

3. The CargoPlane class extends the Jet class and also implements the CargoCarrier interface. In addition to the basic information from the Jet class, the CargoPlane class includes a loadAllCargoJets() method that simulates loading cargo onto the plane.

4. The JetImpl class extends the Jet class and is a more general implementation of a jet. It does not have any additional methods or behavior beyond the basic information and fly() method from the Jet class.

5. The Pilot class is the blueprint for making a Pilot object to fly the Jets.

### Interfaces
The CombatReady interface includes a single method, fight(), that simulates a dogfight. Any class that implements the CombatReady interface must include a fight() method.

The CargoCarrier interface includes a single method, loadAllCargoJets(), that simulates loading cargo onto a plane. Any class that implements the CargoCarrier interface must include a loadAllCargoJets() method.

### .txt File

The program reads in the jet information from a .txt file, where each line contains the following information: jetType, model, speed, range, price. This information is then used to create new jet objects and add them to an ArrayList of jets.

## Technologies Used

Java and Eclipse 

## Lessons Learned
The importance of clear and organized code structure. By separating the logic and behavior of the Jets and Pilots into their own classes and interfaces, it made it easier to understand and maintain the code

The power of polymorphism in Java. By utilizing interfaces and abstract classes, I was able to create more reusable code.

I was able to get more practice with I/O and and also Iterating through the ArrayList 
The project provided an opportunity to practice reading from files using the try-withresources and AutoCLoseable interface

Also getting practice Iterating through ArrayLists: Instead of using the traditional for-each loop, I utilized Iterator to iterate through the list of jets and pilots.
