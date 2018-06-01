package carPark.test;

import static org.junit.Assert.*;

import org.junit.*;

import parkinglot.model.Car;
import parkinglot.model.Parkinglot;
/**
 * Unit test for simple App.
 */
public class parkinglotTest{
	@Test
	public void simpleParkCar(){
	Parkinglot parkingLot = new Parkinglot(10);
	Car myCar = new Car("name");
	int parkingSpaceId = parkingLot.parkCar(myCar);
	assertTrue(0 <= parkingSpaceId && parkingSpaceId <= 10);
	}
	@Test
	public void idParkCar(){
	Parkinglot parkingLot = new Parkinglot(10);
	Car myCar = new Car("name");
	int parkingSpaceId = parkingLot.parkCar(myCar,5);
	assertEquals(5,parkingSpaceId);
	}
}