package controller;

import parkinglot.model.Car;
import parkinglot.model.Parkinglot;

public class NormalParkingBoy extends ParkingBoy {
	Parkinglot parkinglot;
	
	public NormalParkingBoy(Parkinglot parkinglot){
		this.parkinglot=parkinglot;			
	}
	public boolean parkCar(Car car) {
		return parkinglot.parkCar(car)!=-1;
	}
	public boolean parkCar(Car car, int position) {
		return parkinglot.parkCar(car, position)!=-1;
	}
	public Car pickCar(String name) {
		return parkinglot.pickCar(name);
	}
	public Car pickCar(int position) {
		return parkinglot.pickCar(position);
	}
}