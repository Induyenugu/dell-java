import java.util.ArrayList;
import java.util.List;



/**
 * @author Indu_Yenugu
 *
 */
public class CarLot {
	private String name;
	private List<Vehicle> listofVehicles;

	/**
	 * @param name
	 * @param listofVehicles
	 */
	public CarLot(String name) {
		this.name = name;
		this.listofVehicles = new ArrayList<Vehicle>();
	}

	// add vehicle to lot
	public void addVehicle(Vehicle vehicle) {
		if (vehicle == null)
			throw new NullPointerException();
		listofVehicles.add(vehicle);
	}

	// print carlot inventory
	public void printInventory() {
		if (listofVehicles.size() <= 0) {
			System.out.println("Add Vehicles to see Inventory");
			return;
		}

		System.out.println("CarLot Name:" + this.name);
		System.out.println("Total Number of Vehicles:" + listofVehicles.size());
		System.out.println("\n");
		for (Vehicle v : listofVehicles) {
			v.printDescription();
			System.out.println("\n");
		}
		System.out.println("------------------------------------------------------------------------------------");

	}

}