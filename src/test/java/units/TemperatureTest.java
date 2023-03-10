package units;

import org.junit.Test;

import static units.Temperature.*;
import static units.Tester.test;

public class TemperatureTest {

    @Test
    public void testConversaoCelsius() {
        test(400, CELSIUS).isEquals(400.0, CELSIUS);
        test(400, CELSIUS).isEquals(752.0, FAHRENHEIT);
        test(400, CELSIUS).isEquals(673.15, KELVIN);
        test(400, CELSIUS).isEquals(132, NEWTON);
        test(400, CELSIUS).isEquals(320, REAUMUR);
        test(400, CELSIUS).isEquals(1211.67, RANKINE);
        //test(400, CELSIUS).isEquals(-450, DELISLE);
    }

    @Test
    public void testConversaoKelvin() {
        test(400, KELVIN).isEquals(126.85, CELSIUS);
        test(400, KELVIN).isEquals(260.33, FAHRENHEIT);
        test(400, KELVIN).isEquals(400.0, KELVIN);
        test(400, KELVIN).isEquals(41.8605, NEWTON);
        test(400, KELVIN).isEquals(101.48, REAUMUR);
        test(400, KELVIN).isEquals(720, RANKINE);
        //test(400, KELVIN).isEquals(-40.275, DELISLE);
    }

    @Test
    public void testConversaoFahrenheit() {
        test(400, FAHRENHEIT).isEquals(204.4444, CELSIUS);
        test(400, FAHRENHEIT).isEquals(400, FAHRENHEIT);
        test(400, FAHRENHEIT).isEquals(477.5944, KELVIN);
        test(400, FAHRENHEIT).isEquals(67.4667, NEWTON);
        test(400, FAHRENHEIT).isEquals(163.5556, REAUMUR);
        test(400, FAHRENHEIT).isEquals(859.67, RANKINE);
        //test(400, FAHRENHEIT).isEquals(-156.6667, DELISLE);
    }

    @Test
    public void testConversaoNewton() {
        test(400, NEWTON).isEquals(1212.1212, CELSIUS);
        test(400, NEWTON).isEquals(2213.8182, FAHRENHEIT);
        test(400, NEWTON).isEquals(1485.2712, KELVIN);
        test(400, NEWTON).isEquals(400, NEWTON);
        test(400, NEWTON).isEquals(969.6970, REAUMUR);
        test(400, NEWTON).isEquals(2673.4882, RANKINE);
        //test(400, NEWTON).isEquals(-1668.1818, DELISLE);
    }

    @Test
    public void testConversaoReaumur() {
        test(400, REAUMUR).isEquals(500.0, CELSIUS);
        test(400, REAUMUR).isEquals(932, FAHRENHEIT);
        test(400, REAUMUR).isEquals(773.15, KELVIN);
        test(400, REAUMUR).isEquals(165, NEWTON);
        test(400, REAUMUR).isEquals(400.0, REAUMUR);
        test(400, REAUMUR).isEquals(1391.67, RANKINE);
        //test(400, REAUMUR).isEquals(-600, DELISLE);
    }

    @Test
    public void testConversaoRankine() {
        test(400, RANKINE).isEquals(-50.9278, CELSIUS);
        test(400, RANKINE).isEquals(-59.67, FAHRENHEIT);
        test(400, RANKINE).isEquals(222.2222, KELVIN);
        test(400, RANKINE).isEquals(-16.8062, NEWTON);
        test(400, RANKINE).isEquals(-40.7422, REAUMUR);
        test(400, RANKINE).isEquals(400, RANKINE);
        //test(400, RANKINE).isEquals(226.3917, DELISLE);
    }

//    @Test
//    public void testConversaoDelisle() {
//        test(400, DELISLE).isEquals(-166.6667, CELSIUS);
//        test(400, DELISLE).isEquals(-268, FAHRENHEIT);
//        test(400, DELISLE).isEquals(106.4833, KELVIN);
//        test(400, DELISLE).isEquals(-55, NEWTON);
//        test(400, DELISLE).isEquals(-133.3333, REAUMUR);
//        test(400, DELISLE).isEquals(191.67, RANKINE);
//        test(400, DELISLE).isEquals(400, DELISLE);
//    }
}
