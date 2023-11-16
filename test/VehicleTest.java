import DZ2.Car;
import DZ2.Motorcycle;
import DZ2.Vehicle;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("Mercedes-Benz", "EQS_580", 2019);
        motorcycle = new Motorcycle("Honda", "S500", 2021);
    }

    @Test
    void testClassCar() {
        assertThat(car instanceof Vehicle).isEqualTo(true);
    }

    @Test
    void testCountWheelsCar() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void testCountWheelsMotorcycle() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void testTestDriveCar() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void testTestDriveMotorcycle() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void testParkDriveCar() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void testParkDriveMotorcycle() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}