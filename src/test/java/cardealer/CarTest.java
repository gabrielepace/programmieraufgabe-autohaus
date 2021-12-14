package cardealer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CarTest {

    Car car = new Car();

    @Test
    void getChassisNr() {
        car.setChassisNr("ABC123");
        assertEquals("ABC123", car.getChassisNr());
    }

    @Test
    void getBrand() {
        car.setBrand("Volkswagen");
        assertEquals("Volkswagen", car.getBrand());
    }

    @Test
    void getModel() {
        car.setModel("Golf");
        assertEquals("Golf", car.getModel());
    }

    @Test
    void getYear() {
        car.setYear(2021);
        assertEquals(2021, car.getYear());
    }

    @Test
    void getKm() {
        car.setKm(60000);
        assertEquals(60000, car.getKm());
    }

    @Test
    void getPrice() {
        car.setPrice(35000.0F);
        assertEquals(35000.0F, car.getPrice());
    }
}