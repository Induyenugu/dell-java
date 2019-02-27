/**
 *  Truck subclass
 */

/**
 * @author Indu_Yenugu
 *
 */
public class Truck extends Vehicle {

	int bedSize;

	/*
	 * (non-Javadoc) super class method override
	 * 
	 * @see Vehicle#printDescription()
	 */
	@Override
	void printDescription() {
		System.out.println("Vehicle Type: Truck");
		System.out.println("BedSize:" + this.bedSize);
		System.out.println("License#:" + this.licenseNumber);
		System.out.println("Make:" + this.make);
		System.out.println("Model:" + this.model);
		System.out.println("Price $" + this.price + ". ");
	}

	/**
	 * @param bedSize
	 */
	public Truck(int bedSize) {
		this.bedSize = bedSize;
	}

}