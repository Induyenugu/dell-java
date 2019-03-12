/**
 * Driver class
 */

/**
 * @author Indu_Yenugu
 *
 */
public class CarLotProgram {
	public static void main(String[] args) {
		
		
		CarLot carMax = new CarLot("CarMax"); 
		CarLot carvana = new CarLot("CarVana"); 

		Vehicle nissan = new Truck(6); // new Vehical1 truck
		nissan.licenseNumber = "TXN1234";
		nissan.make = "Nissan";
		nissan.model = "TitanPro";
		nissan.price = "26,998";
		carMax.addVehicle(nissan); // added vehicle to carlot1
		carvana.addVehicle(nissan); // added vehicle to carlot2
		
		Vehicle ford = new Truck(6); // new Vehical2 truck
		ford.licenseNumber = "AUS9876";
		ford.make = "Ford";
		ford.model = "F250";
		ford.price = "44,998";
		carMax.addVehicle(ford); // added vehicle to carlot1
		carvana.addVehicle(ford); // added vehicle to carlot2

		Vehicle mustang = new Car("Coupe", 2); // added Vehical3 car
		mustang.licenseNumber = "HII7690";
		mustang.make = "Ford";
		mustang.model = "Mustang";
		mustang.price = "51,200";
		carMax.addVehicle(mustang); // added vehicle to carlot1
		carvana.addVehicle(mustang); // added vehicle to carlot2

		

		Vehicle tesla = new Car("Sedan", 4); // new Vehical 4 car 
		tesla.licenseNumber = "STP5643";
		tesla.make = "Tesla";
		tesla.model = "model3";
		tesla.price = "64,000";
		carMax.addVehicle(tesla); // added vehicle to carlot1
		carvana.addVehicle(tesla); // added vehicle to carlot2

		Vehicle scion = new Car("Hatchback", 4); // new Vehical5 car
		scion.licenseNumber = "MOV8593";
		scion.make = "Scion";
		scion.model = "TC";
		scion.price = "16,000";
		carvana.addVehicle(scion); // added vehicle to carlot2

		carMax.printInventory(); // print carlot1 inventory
		carvana.printInventory(); // print carlot2 inventory

	}

}