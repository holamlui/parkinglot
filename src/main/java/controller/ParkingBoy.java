package controller;

import java.util.List;

import parkinglot.model.Car;
import parkinglot.model.Parkinglot;

public class ParkingBoy {
	Parkinglot parkinglot;
	
	public ParkingBoy(Parkinglot parkinglot){
		this.parkinglot=parkinglot;			
	}
	public int parkCar(Car car) {
		return parkinglot.parkCar(car);
	}
	public int parkCar(Car car, int position) {
		return parkinglot.parkCar(car, position);
	}
	public Car pickCar(String name) {
		return parkinglot.pickCar(name);
	}
	public Car pickCar(int position) {
		return parkinglot.pickCar(position);
	}
}