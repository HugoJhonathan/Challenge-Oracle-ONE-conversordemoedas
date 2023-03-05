package units;

import org.junit.Test;

import static units.Length.*;
import static units.Tester.test;

public class DistanceTest {

    @Test
    public void milimetro() {
        test(100, MILIMETRO).isEquals(100, MILIMETRO);
        test(100, MILIMETRO).isEquals(10, CENTIMETRO);
        test(100, MILIMETRO).isEquals(1, DECIMETRO);
        test(100, MILIMETRO).isEquals(0.1, METRO);
        test(100, MILIMETRO).isEquals(0.01, DECAMETRO);
        test(100, MILIMETRO).isEquals(0.001, HECTOMETRO);
        test(100, MILIMETRO).isEquals(0.0001, QUILOMETRO);
    }

}
