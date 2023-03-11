package units;

import java.util.LinkedList;
import java.util.List;

public class DataStorage extends Unit<DataStorage> {

    private static List<DataStorage> all = new LinkedList<>();

    public static final DataStorage PETABYTE = new DataStorage("Petabyte", "PB", 8.0 * 1024 * 1024 * 1024 * 1024 * 1024);
    public static final DataStorage TERABYTE = new DataStorage("Terabyte", "TB", 8.0 * 1024 * 1024 * 1024 * 1024);
    public static final DataStorage GIGABYTE = new DataStorage("Gigabyte", "GB", 8.0 * 1024 * 1024 * 1024);
    public static final DataStorage MEGABYTE = new DataStorage("Megabyte", "MB", 8.0 * 1024 * 1024);
    public static final DataStorage KILOBYTE = new DataStorage("Kilobyte", "KB", 8.0 * 1024);
    public static final DataStorage BYTE = new DataStorage("Byte", "B", 8);
    public static final DataStorage BIT = new DataStorage("bit", "b", 1);

    private DataStorage(String name, String symbol, double bitsEquivalent) {
        super(name, symbol, bitsEquivalent);
        all.add(this);
    }

    public static DataStorage[] getAll() {
        return all.toArray(new DataStorage[0]);
    }

}
