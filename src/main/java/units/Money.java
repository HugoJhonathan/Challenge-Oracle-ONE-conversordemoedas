package units;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Money extends Unit<Money> {

    private static List<Money> all = new ArrayList<>();
    private static NumberFormat nf = NumberFormat.getCurrencyInstance();

    public static Money REAL = new Money("Real", "BRL", 0.1919);
    public static Money DOLAR = new Money("Dólar", "USD", 1.00);
    public static Money EURO = new Money("Euro", "EUR", 1.06);
    public static Money LIBRA = new Money("Libra", "GBP", 1.21);
    public static Money PESO_ARGENTINO = new Money("Peso Argentino", "ARS", 0.005125);
    public static Money PESO_CHILENO = new Money("Peso Chileno", "CLP", 0.00126);

    private Money(String symbol, String name, double dolarEquivalent) {
        super(symbol, name, dolarEquivalent);
        Money.all.add(this);
    }

    @Override
    public BigDecimal convert(BigDecimal amount, Money targetUnit) {
        BigDecimal sourceFactorBd = new BigDecimal(String.valueOf(getFactor()));
        BigDecimal targetFactorBd = new BigDecimal(String.valueOf(targetUnit.getFactor()));
        BigDecimal calc1 = sourceFactorBd.divide(targetFactorBd, MathContext.DECIMAL128);
        return calc1.multiply(amount);
    }

    @Override
    public String getFormattedValue(String value) {
        nf.setCurrency(Currency.getInstance(getSymbol()));
        return nf.format(new BigDecimal(value));
    }

    public static Money[] getAll() {
        return all.toArray(new Money[0]);
    }

}