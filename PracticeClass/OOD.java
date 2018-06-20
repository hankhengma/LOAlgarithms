public abstract class Vehicle {
	private final int size;
	public abstract int getSize();
}

public enum VehicleType {
	Truck, Car;
}

public class Truck extends Vehicle {
	@Override
	public VehicleType getSize() {
		return VehicleType.Truck;
	}
}

public class Car extends Vehicle {
	@Override
	public VehicleType getSize() {
		return VehicleType.Car;
	} 
}

class ParkingSpot {
	private final VehicleSize size;
	private Vehicle currentVehicle;

		
}