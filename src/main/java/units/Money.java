package units;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

public enum Money implements Unit {
    Real("BRL", 0.1919),
    Dolar("USD", 1.00),
    Euro("EUR", 1.06),
    Libra("GBP", 1.21),
    Peso_Argentino("ARS", 0.005125),
    Peso_Chileno("CLP", 0.00126);

    private String symbol;
    private double dollarEquivalent;

    Money(String symbol, double dollarEquivalent) {
        try {
            Currency.getInstance(symbol);
        } catch (IllegalArgumentException e) {
            System.out.println(Currency.getAvailableCurrencies());
            throw new RuntimeException("Currency symbol " + symbol + " does not exist!");
        }
        this.symbol = symbol;
        this.dollarEquivalent = dollarEquivalent;
    }

    @Override
    public String getFormattedValue(double value) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setCurrency(Currency.getInstance(getSymbol()));
        return nf.format(value);
    }

    @Override
    public double convert(double amount, Unit targetUnit) {
        checkIfTheClassesAreEquals(targetUnit);
        double mult = getFactor() / targetUnit.getFactor();
        return mult * amount;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public double getFactor() {
        return dollarEquivalent;
    }

    public double getDollarEquivalent() {
        return dollarEquivalent;
    }

    public void setDollarEquivalent(double dollarEquivalent) {
        this.dollarEquivalent = dollarEquivalent;
    }

    static public Money getBySymbol(String symbol) {
        for (Money m : Money.values()) {
            if (Objects.equals(m.getSymbol(), symbol)) {
                return m;
            }
        }
        throw new IllegalArgumentException("There is no monetary value with the symbol " + symbol);
    }

    static public List<String> getAllSymbols() {
        List<String> list = new ArrayList<>();
        for (Money m : Money.values()) {
            list.add(m.getSymbol());
        }
        return list;
    }

}