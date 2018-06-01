package parkinglot.model;

public class Car {
	String name;
	String parkingBoyName;
	public Car(String name){
		this.name=name;
		this.parkingBoyName=null;
	}
	public String getName() {
		return name;
	}
	public String getParkingBoyName() {
		return parkingBoyName;
	}
	public void setParkingBoyName(String parkingBoyName) {
		this.parkingBoyName = parkingBoyName;
	}
}
