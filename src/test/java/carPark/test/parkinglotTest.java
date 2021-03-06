package carPark.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import controller.NormalParkingBoy;
import controller.ParkingBoy;
import controller.ParkingDirector;
import controller.ParkingManager;
import controller.SmartParkingBoy;
import controller.SuperParkingBoy;
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
	int parkingSpaceId = parkingLot.parkCar(myCar, "Test");
	assertTrue(0 <= parkingSpaceId && parkingSpaceId <= 10);
	}
	@Test
	public void idParkCar(){
	Parkinglot parkingLot = new Parkinglot(10, "parkingLotA");
	Car myCar = new Car("name");
	int parkingSpaceId = parkingLot.parkCar(myCar, "test", 5);
	assertEquals(5,parkingSpaceId);
	}
	@Test
	public void smartSelectParkingLot(){
		Parkinglot smallParkingLot = new Parkinglot(3, "parkingLotA");
		Parkinglot largeParkingLot = new Parkinglot(10, "parkingLotB");
		List<Parkinglot> parkinglotList = new ArrayList<Parkinglot>();
		parkinglotList.add(smallParkingLot);
		parkinglotList.add(largeParkingLot);
		SmartParkingBoy parkinglotController = new SmartParkingBoy(parkinglotList);
		Car myCar = new Car("name");
		assertTrue(parkinglotController.parkCar(myCar));
		Car myCar2 = parkinglotController.pickCar("name");
		assertEquals("name",myCar2.getName());
	}
	@Test
	public void superParkingBoyTest(){
	Parkinglot smallParkingLot = new Parkinglot(2, "parkingLotA");
	Parkinglot largeParkingLot = new Parkinglot(10, "parkingLotB");
	List<Parkinglot> parkinglotList = new ArrayList<Parkinglot>();
	parkinglotList.add(smallParkingLot);
	parkinglotList.add(largeParkingLot);
	SuperParkingBoy parkingBoy = new SuperParkingBoy(parkinglotList);
	parkingBoy.parkCar(new Car("car1"));
	parkingBoy.parkCar(new Car("car2"));
	parkingBoy.parkCar(new Car("car3"));
	assertEquals(1,parkingBoy.getParkinglotList().get(0).getVacancy());
	assertEquals(8,parkingBoy.getParkinglotList().get(1).getVacancy());
	}
	@Test
	public void managerParkCar(){
	Parkinglot smallParkingLot = new Parkinglot(2, "parkingLotA");
	Parkinglot largeParkingLot = new Parkinglot(10, "parkingLotB");
	List<Parkinglot> parkinglotList = new ArrayList<Parkinglot>();
	parkinglotList.add(smallParkingLot);
	parkinglotList.add(largeParkingLot);
	List<ParkingBoy> parkingBoyList = new ArrayList<ParkingBoy>();
	parkingBoyList.add(new SuperParkingBoy(parkinglotList));
	parkingBoyList.add(new SmartParkingBoy(parkinglotList));
	parkingBoyList.add(new NormalParkingBoy(parkinglotList));
	ParkingManager parkingManager = new ParkingManager(parkingBoyList,parkinglotList);
	assertTrue(parkingManager.parkCar(new Car("car1")));
	assertTrue(parkingManager.parkCar(new Car("car2")));
	assertTrue(parkingManager.parkCar(new Car("car3")));
	assertTrue(parkingManager.parkCar(new Car("car4")));
	}
	
	@Test
	public void parkingDirectorPrint(){
		Parkinglot smallParkingLot = new Parkinglot(2, "parkingLotA");
		Parkinglot largeParkingLot = new Parkinglot(10, "parkingLotB");
		List<Parkinglot> parkinglotList = new ArrayList<Parkinglot>();
		parkinglotList.add(smallParkingLot);
		parkinglotList.add(largeParkingLot);
		List<ParkingBoy> parkingBoyList = new ArrayList<ParkingBoy>();
		parkingBoyList.add(new SuperParkingBoy(parkinglotList));
		parkingBoyList.add(new SmartParkingBoy(parkinglotList));
		parkingBoyList.add(new NormalParkingBoy(parkinglotList));
		ParkingManager parkingManager = new ParkingManager(parkingBoyList,parkinglotList);
		assertTrue(parkingManager.parkCar(new Car("car1")));
		assertTrue(parkingManager.parkCar(new Car("car2")));
		assertTrue(parkingManager.parkCar(new Car("car3")));
		assertTrue(parkingManager.parkCar(new Car("car4")));
	
		ParkingDirector parkingDirector = new ParkingDirector(parkinglotList);
		parkingDirector.showReport();
		
	}
}