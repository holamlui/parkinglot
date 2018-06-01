package controller;

import parkinglot.model.Car;

public abstract class ParkingBoy {
	abstract boolean parkCar(Car car);
	abstract Car pickCar(String name);
}