
public class GarageManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create four instances of cars		
		Car car1= new Car("white","License1","Toyota","Rav4");
		Car car2= new Car("white","License2","Toyota","Rav4");
		Car car3= new Car("red","License3","Toyota","Rav4");
		Car car4= new Car("blue","License3","Toyota","Rav4");
		
		//Create 2 instance of parking garages
		ParkingGarage parkinggarage1= new ParkingGarage(4, "Downtown Garage");
		ParkingGarage parkinggarage2= new ParkingGarage(3, "Library Garage");
		
		//Park and vacate cars in garage1 and print inventory
		parkinggarage1.Park(car1,0);
		parkinggarage1.Park(car2,2);
		parkinggarage1.Park(car3,1);		
		parkinggarage1.VacateCar(1);
		parkinggarage1.VacateCar(4);
		parkinggarage1.Park(car4,2);
		parkinggarage1.PrintInventory();
		parkinggarage2.PrintInventory();
		
		//Park and vacate cars in garage2 and print inventory
		parkinggarage1.Park(car1,1);
		parkinggarage2.Park(car2,0);
		parkinggarage1.Park(car1,1);
		parkinggarage1.VacateCar(1);
		parkinggarage1.PrintInventory();
		parkinggarage2.PrintInventory();
		
	}
}
	
	
	
	

