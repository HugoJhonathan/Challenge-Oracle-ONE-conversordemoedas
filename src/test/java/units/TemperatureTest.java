package units;

import org.junit.Test;

import static units.Tester.test;
import static units.Temperature.*;

public class TemperatureTest {

    @Test
    public void testConversaoCelsius() {
        test(400, CELSIUS).isEquals(400.0, CELSIUS);
        test(400, CELSIUS).isEquals(752.0, FAHRENHEIT);
        test(400, CELSIUS).isEquals(673.15, KELVIN);
        test(400, CELSIUS).isEquals(132, NEWTON);
        test(400, CELSIUS).isEquals(320, REAUMUR);
        test(400, CELSIUS).isEquals(1211.67, RANKINE);
    }

    @Test
    public void testConversaoKelvin() {
        test(400, KELVIN).isEquals(126.85, CELSIUS);
        test(400, KELVIN).isEquals(260.33, FAHRENHEIT);
        test(400, KELVIN).isEquals(400.0, KELVIN);
        test(400, KELVIN).isEquals(41.8605, NEWTON);
        test(400, KELVIN).isEquals(101.48, REAUMUR);
        test(400, KELVIN).isEquals(720, RANKINE);
    }

    @Test
    public void testConversaoFahrenheit() {
        test(400, CELSIUS).isEquals(-450, DELISLE);
        test(400, FAHRENHEIT).isEquals(-156.6666667, DELISLE);
        test(400, KELVIN).isEquals(-40.275, DELISLE);
        test(400, NEWTON).isEquals(-1668.1818182, DELISLE);
        test(400, REAUMUR).isEquals(-600.0, DELISLE);
        test(400, RANKINE).isEquals(226.3916667, DELISLE);
        test(400, DELISLE).isEquals(400.00, DELISLE);
        test(400, DELISLE).isEquals(-166.6666667, CELSIUS);
        test(400, DELISLE).isEquals(-268, FAHRENHEIT);
        test(400, DELISLE).isEquals(106.4833333, KELVIN);
        test(400, DELISLE).isEquals(-55, NEWTON);
        test(400, DELISLE).isEquals(-133.3333333, REAUMUR);
        test(400, DELISLE).isEquals(191.67, RANKINE);
        test(400, DELISLE).isEquals(400, DELISLE);
    }
}
