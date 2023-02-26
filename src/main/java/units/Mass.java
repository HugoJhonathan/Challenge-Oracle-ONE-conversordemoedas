package units;

public enum Mass implements Unit {
    Kilograma("Kg", 1000.0),
    Hectograma("hg", 100.0),
    Decagrama("dag", 10.0),
    Grama("g", 1.0),
    Decograma("dg", 0.1),
    Centigrama("cg", 0.01),
    Miligrama("mg", 0.001);

    private String symbol;
    private double factor;

    Mass(String symbol, double factor) {
        this.symbol = symbol;
        this.factor = factor;
    }

    @Override
    public double getFactor() {
        return factor;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

}