package units;

import java.util.LinkedList;
import java.util.List;

public class DataStorage extends Unit<DataStorage> {

    private static List<DataStorage> all = new LinkedList<>();

    public static DataStorage PETABYTE = new DataStorage("Petabyte", "PB", 8.0 * 1024 * 1024 * 1024 * 1024 * 1024);
    public static DataStorage TERABYTE = new DataStorage("Terabyte", "TB", 8.0 * 1024 * 1024 * 1024 * 1024);
    public static DataStorage GIGABYTE = new DataStorage("Gigabyte", "GB", 8.0 * 1024 * 1024 * 1024);
    public static DataStorage MEGABYTE = new DataStorage("Megabyte", "MB", 8.0 * 1024 * 1024);
    public static DataStorage KILOBYTE = new DataStorage("Kilobyte", "KB", 8.0 * 1024);
    public static DataStorage BYTE = new DataStorage("Byte", "B", 8);
    public static DataStorage BIT = new DataStorage("bit", "b", 1);

    public DataStorage(String name, String symbol, double factor) {
        super(name, symbol, factor);
        all.add(this);
    }

    public static DataStorage[] getAll() {
        return all.toArray(new DataStorage[0]);
    }

}
