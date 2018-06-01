package controller;

import parkinglot.model.Car;

public interface ParkingBoy {
	public boolean parkCar(Car car);
	public Car pickCar(String name);
}