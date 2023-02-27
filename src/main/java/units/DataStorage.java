package units;

public enum DataStorage implements Unit {
    PETABYTE("Petabyte", "PB", 8.0 * 1024 * 1024 * 1024 * 1024 * 1024),
    TERABYTE("Terabyte", "TB", 8.0 * 1024 * 1024 * 1024 * 1024),
    GIGABYTE("Gigabyte", "GB", 8.0 * 1024 * 1024 * 1024),
    MEGABYTE("Megabyte", "MB", 8.0 * 1024 * 1024),
    KILOBYTE("Kilobyte", "KB", 8.0 * 1024),
    BYTE("Byte", "B", 8),
    BIT("bit", "b", 1);

    private final String symbol;
    private final double factor;
    private final String name;

    DataStorage(String name, String symbol, double factor) {
        this.name = name;
        this.symbol = symbol;
        this.factor = factor;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public double getFactor() {
        return factor;
    }

    @Override
    public String getName() {
        return name;
    }

}