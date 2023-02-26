package units;

import org.junit.Test;

import static units.DataStorage.*;
import static units.Tester.test;


public class DataStorageTest {

    @Test
    public void dataStorage() {
        test(1, bit).isEquals(0.125, Byte);
        test(1, Byte).isEquals(1, Byte);
        test(1, Kilobyte).isEquals(1024, Byte);
        test(1, Megabyte).isEquals(1048576, Byte);
        test(1, Gigabyte).isEquals(1073741824.0, Byte);
        test(1, Terabyte).isEquals(1099511627776.0, Byte);
        test(1, Petabyte).isEquals(1125899906842624.0, Byte);
    }

}
