package carPark.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import controller.ParkinglotController;
import parkinglot.model.Car;
import parkinglot.model.Parkinglot;
/**
 * Unit test for simple App.
 */
public class parkinglotTest{
	@Test
	public void simpleParkCar(){
	Parkinglot parkingLot = new Parkinglot(10, "parkingLotA");
	Car myCar = new Car("name");
	int parkingSpaceId = parkingLot.parkCar(myCar);
	assertTrue(0 <= parkingSpaceId && parkingSpaceId <= 10);
	}
	@Test
	public void idParkCar(){
	Parkinglot parkingLot = new Parkinglot(10, "parkingLotA");
	Car myCar = new Car("name");
	int parkingSpaceId = parkingLot.parkCar(myCar,5);
	assertEquals(5,parkingSpaceId);
	}
	@Test
	public void smartSelectParkingLot(){
	Parkinglot smallParkingLot = new Parkinglot(3, "parkingLotA");
	Parkinglot largeParkingLot = new Parkinglot(10, "parkingLotB");
	List<Parkinglot> parkinglotList = new ArrayList<Parkinglot>();
	parkinglotList.add(smallParkingLot);
	parkinglotList.add(largeParkingLot);
	ParkinglotController parkinglotController = new ParkinglotController(parkinglotList);
	Car myCar = new Car("name");
	assertTrue(parkinglotController.parkCar(myCar));
	Car myCar2 = parkinglotController.pickCar("name");
	assertEquals("name",myCar2.getName());
	}
}