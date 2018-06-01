package controller;

import java.util.List;

import parkinglot.model.Car;
import parkinglot.model.Parkinglot;

public class NormalParkingBoy extends ParkingBoy {
	String NAME = "NormalParkingBoy";
	List<Parkinglot> parkinglotList;
	
	public NormalParkingBoy(List<Parkinglot> parkinglotList){
		this.parkinglotList=parkinglotList;	
	}
	public boolean parkCar(Car car) {
		int parkResult=-1;
		for(int i=0;i<parkinglotList.size();i++) {
			
			parkResult = parkinglotList.get(i).parkCar(car, NAME);
			if(parkResult!=-1){
				break;
			}
		}
		return parkResult!=-1;
	}
	
	public Car pickCar(String name) {
		Car car=null;
		for(int i=0;i<parkinglotList.size();i++) {	
			car = parkinglotList.get(i).pickCar(name);
			if(car!=null) {
				break;		
			}							
		}
		return car;
	}
}