package units;

import org.junit.Test;

import static units.Tester.test;
import static units.Temperature.*;

public class TemperatureTest {

    @Test
    public void testConversaoCelsius() {
        test(400, Celsius).isEquals(400.0, Celsius);
        test(400, Celsius).isEquals(752.0, Fahrenheit);
        test(400, Celsius).isEquals(673.15, Kelvin);
        test(400, Celsius).isEquals(132, Newton);
        test(400, Celsius).isEquals(320, Reaumur);
        test(400, Celsius).isEquals(1211.67, Rankine);
    }

    @Test
    public void testConversaoKelvin() {
        test(400, Kelvin).isEquals(126.85, Celsius);
        test(400, Kelvin).isEquals(260.33, Fahrenheit);
        test(400, Kelvin).isEquals(400.0, Kelvin);
        test(400, Kelvin).isEquals(41.8605, Newton);
        test(400, Kelvin).isEquals(101.48, Reaumur);
        test(400, Kelvin).isEquals(720, Rankine);
    }

    @Test
    public void testConversaoFahrenheit() {
        test(400, Celsius).isEquals(-450, Delisle);
        test(400, Fahrenheit).isEquals(-156.6666667, Delisle);
        test(400, Kelvin).isEquals(-40.275, Delisle);
        test(400, Newton).isEquals(-1668.1818182, Delisle);
        test(400, Reaumur).isEquals(-600.0, Delisle);
        test(400, Rankine).isEquals(226.3916667, Delisle);
        test(400, Delisle).isEquals(400.00, Delisle);
        test(400, Delisle).isEquals(-166.6666667, Celsius);
        test(400, Delisle).isEquals(-268, Fahrenheit);
        test(400, Delisle).isEquals(106.4833333, Kelvin);
        test(400, Delisle).isEquals(-55, Newton);
        test(400, Delisle).isEquals(-133.3333333, Reaumur);
        test(400, Delisle).isEquals(191.67, Rankine);
        test(400, Delisle).isEquals(400, Delisle);
    }
}
