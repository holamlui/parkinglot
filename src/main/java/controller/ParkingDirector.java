package controller;

import java.util.List;

import parkinglot.model.Car;
import parkinglot.model.Parkinglot;

public class ParkingDirector {
	List<Parkinglot> parkinglotList;	
	
	public ParkingDirector(List<Parkinglot> parkinglotList) {
		this.parkinglotList=parkinglotList;
	}
	public void showReport() {
		System.out.println("===Printing Parking Report===");
		for(int i=0;i<parkinglotList.size();i++) {
			parkinglotList.get(i).printCars();
		}
	}
}