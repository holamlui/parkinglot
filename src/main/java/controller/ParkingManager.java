package controller;

import java.util.List;

import parkinglot.model.Car;
import parkinglot.model.Parkinglot;

public class ParkingManager {
	List<ParkingBoy> parkingBoyList;
	List<Parkinglot> parkinglotList;
	
	public ParkingManager(List<ParkingBoy> parkingBoyList,List<Parkinglot> parkinglotList) {
		this.parkingBoyList = parkingBoyList;
	}
	public boolean parkCarByMyself(Car car) {
		int parkResult=-1;
		for(int i=0;i<parkinglotList.size();i++) {
			
			parkResult = parkinglotList.get(i).parkCar(car);
			if(parkResult!=-1){
				break;
			}
		}
		return parkResult!=-1;
	}
	public boolean parkCar(Car car) {
		int assignParkJob = (int)(Math.random()*parkingBoyList.size());
		if(assignParkJob==parkingBoyList.size()) {
			return parkCarByMyself(car);
		}else {
			return parkingBoyList.get(assignParkJob).parkCar(car);
		}
	}
}