package parkinglot.model;

public class Parkinglot {
	static int NO_PARKING = -1;
	int size;
	int vacancy;
	Car[] parkingSpace;
	
	
	
	public Parkinglot(int size) {
		super();
		this.size = size;
		this.vacancy = size;
		parkingSpace = new Car[size];
	}

	public Car pickCar(int position) {
		Car car = null;
		if (parkingSpace[position] != null) {
			car = parkingSpace[position];
			vacancy++;
		}
		return car;
	}
	
	public int parkCar(Car car, int position) {
		int result = NO_PARKING;
		if (parkingSpace[position] == null) {
			parkingSpace[position] = car;
			vacancy--;
			result = position;
		}
		return result;
	}
	
	public int parkCar(Car car) {
		int result = NO_PARKING;
		int position = getAvailablePosition();
		if (position != NO_PARKING) {
			parkingSpace[position] = car;
			vacancy--;
			result = position;
		}
		return result;
	}
	
	private int getAvailablePosition() {
		int result = NO_PARKING;
		for (int i = 0; i < size; i++) {
			if (parkingSpace[i] == null) {
				result = i;
				break;
			}
		}
		return result;
	}
	
}