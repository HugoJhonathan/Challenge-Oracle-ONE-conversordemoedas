package units;

public enum DataStorage implements Unit {
    Petabyte("PB", 8.0 * 1024 * 1024 * 1024 * 1024 * 1024),
    Terabyte("TB", 8.0 * 1024 * 1024 * 1024 * 1024),
    Gigabyte("GB", 8.0 * 1024 * 1024 * 1024),
    Megabyte("MB", 8.0 * 1024 * 1024),
    Kilobyte("KB", 8.0 * 1024),
    Byte("B", 8),
    bit("b", 1);

    private String symbol;
    private double factor;

    DataStorage(String symbol, double factor) {
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

}