import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        vehicle = new Vehicle();
    }

    @AfterEach
    void tearDown() {
        if (vehicle.totalVehicle() != 0) {
            vehicle.finalize();
        }
    }

    @Test
    void testFinalize() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        vehicle.finalize();
        assertEquals(0, vehicle.totalVehicle());
        assertEquals("finalize has been called\r\n", stream.toString());
    }

    @Test
    void setSpeed() {
        vehicle.setSpeed(12);
        assertEquals(12, vehicle.getSpeed());
    }

    @Test
    void setDir() {
        vehicle.setDir("east");
        assertEquals("east", vehicle.getDir());
    }

    @Test
    void getSpeed() {
        assertEquals(0, vehicle.getSpeed());
    }

    @Test
    void getDir() {
        assertEquals("north", vehicle.getDir());
    }

    @Test
    void totalVehicle() {
        assertEquals(1, vehicle.totalVehicle());
    }
}