package controller;

import java.util.List;

import parkinglot.model.Car;
import parkinglot.model.Parkinglot;

public class SuperParkingBoy extends ParkingBoy{
	String NAME = "SuperParkingBoy";
	List<Parkinglot> parkinglotList;
	
	
	public SuperParkingBoy(List<Parkinglot> parkinglotList){
		this.parkinglotList=parkinglotList;			
	}
	
	public boolean parkCar(Car car) {		
		Parkinglot selected=parkinglotList.get(0);
		for(int i=0;i<parkinglotList.size();i++) {
			if(parkinglotList.get(i).getVacancyRate()>selected.getVacancyRate()) {
				selected=parkinglotList.get(i);
			}					
		}		
		return selected.parkCar(car, NAME)!=-1;		
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
	public List<Parkinglot> getParkinglotList(){
		return parkinglotList;
	}
}