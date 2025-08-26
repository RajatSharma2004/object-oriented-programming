class Engine {
    private boolean isRunning;

    public Engine() {
        this.isRunning = false;
    }

    public void start() {
        this.isRunning = true;
        System.out.println("Engine is rumbling to life...");
    }

    public void stop() {
        this.isRunning = false;
        System.out.println("Engine shuts down.");
    }
}

/**
 * An interface that defines a contract for anything that can be driven.
 */
interface Drivable {
    void drive();
}

/**
 * A blueprint for all vehicles. It's an abstract class
 * to ensure that all vehicles have a brand and a way to start their engine,
 * but the details are left to the specific car types.
 */
abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void startEngine();
}

/**
 * Our Car class extends Vehicle and implements Drivable.
 * This shows how a Car "is a" Vehicle, and can also be Drivable.
 */
class Car extends Vehicle implements Drivable {
    // The car HAS an engine (composition).
    private Engine engine;
    private int fuelLevel;

    public Car(String brand, int fuelLevel) {
        super(brand);
        this.engine = new Engine();
        this.fuelLevel = fuelLevel;
        System.out.println("New " + brand + " car created. Fuel: " + fuelLevel + " units.");
    }

    // We're overriding the startEngine() method from the abstract Vehicle class.
    @Override
    public void startEngine() {
        if (fuelLevel > 0) {
            engine.start(); // Delegation: we let the Engine object handle the start logic.
            System.out.println(brand + "'s engine is now running.");
        } else {
            System.out.println("No fuel in the " + brand + " car, can't start.");
        }
    }

    // An overloaded method to start the engine with a special password.
    public void startEngine(String password) {
        if ("secret".equals(password)) {
            startEngine(); // Call the original startEngine() method
            System.out.println("Engine started with special key.");
        } else {
            System.out.println("Incorrect password.");
        }
    }

    // This method is final because it's a core part of the system that shouldn't be changed.
    public final void startIgnitionSystem() {
        System.out.println(brand + "'s ignition system is activating.");
    }

    @Override
    public void drive() {
        if (fuelLevel > 0) {
            System.out.println(brand + " is driving.");
            fuelLevel--;
            System.out.println("Remaining fuel: " + fuelLevel);
        } else {
            System.out.println(brand + " is out of fuel.");
        }
    }
}

/**
 * An ElectricCar is also a Car, but with its own way of starting the engine.
 * This demonstrates the Liskov Substitution Principle.
 */
class ElectricCar extends Car {
    private int batteryCharge;

    public ElectricCar(String brand, int charge) {
        super(brand, 0); // An electric car doesn't need fuel.
        this.batteryCharge = charge;
    }

    @Override
    public void startEngine() {
        if (batteryCharge > 0) {
            System.out.println(brand + "'s silent electric motor is running.");
        } else {
            System.out.println("Low battery on the " + brand + ", can't start.");
        }
    }
}

public class MyVehicleApp {
    public static void main(String[] args) {
        // Here's how polymorphism works.
        Vehicle myGasCar = new Car("Honda", 5);
        Vehicle myEV = new ElectricCar("Tesla", 100);

        System.out.println("--- Testing the Gas Car ---");
        myGasCar.startEngine();
        
        System.out.println("\n--- Testing the Electric Car ---");
        myEV.startEngine();
        
        System.out.println("\n--- Final Method Demonstration ---");
        // We have to cast to Car to access the specific final method.
        ((Car) myGasCar).startIgnitionSystem();
    }
}