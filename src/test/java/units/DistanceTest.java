package units;

import org.junit.Test;

import static units.Tester.test;
import static units.Distance.*;

public class DistanceTest {

    @Test
    public void milimetro() {
        test(100, Milimetro).isEquals(100, Milimetro);
        test(100, Milimetro).isEquals(10, Centimetro);
        test(100, Milimetro).isEquals(1, Decimetro);
        test(100, Milimetro).isEquals(0.1, Metro);
        test(100, Milimetro).isEquals(0.01, Decametro);
        test(100, Milimetro).isEquals(0.001, Hectometro);
        test(100, Milimetro).isEquals(0.0001, Quilometro);
    }

}
