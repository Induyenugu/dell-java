/**
 * car subclass
 */

/**
 * @author Indu_Yenugu
 *
 */
public class Car extends Vehicle {
	String type;
	int numberofDoors;

	/**
	 * @param type
	 * @param numberofDoors
	 */
	public Car(String type, int numberofDoors) {
		this.type = type;
		this.numberofDoors = numberofDoors;
	}

	// superclass method override
	@Override
	void printDescription() {
		System.out.println("Vehicle Type: " + this.type);
		System.out.println("NumberofDoors:" + this.numberofDoors);
		System.out.println("License#:" + this.licenseNumber);
		System.out.println("Make:" + this.make);
		System.out.println("Model:" + this.model);
		System.out.println("Price $" + this.price + ". ");
	}

}