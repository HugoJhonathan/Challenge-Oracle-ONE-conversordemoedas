package units;

import org.junit.Test;

import static units.DataStorage.*;
import static units.Tester.test;


public class DataStorageTest {

    @Test
    public void dataStorage() {
        test(1, BIT).isEquals(0.125, BYTE);
        test(1, BYTE).isEquals(1, BYTE);
        test(1, KILOBYTE).isEquals(1024, BYTE);
        test(1, MEGABYTE).isEquals(1048576, BYTE);
        test(1, GIGABYTE).isEquals(1073741824.0, BYTE);
        test(1, TERABYTE).isEquals(1099511627776.0, BYTE);
        test(1, PETABYTE).isEquals(1125899906842624.0, BYTE);
    }

}
