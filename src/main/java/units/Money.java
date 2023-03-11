package units;

import service.MoneyService;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Money extends Unit<Money> {

    private static List<Money> all = new LinkedList<>();
    private static NumberFormat nf = NumberFormat.getCurrencyInstance();

    public static final Money REAL = new Money("Real", "BRL", 0);
    public static final Money DOLAR = new Money("Dólar", "USD", 1.0);
    public static final Money EURO = new Money("Euro", "EUR", 0);
    public static final Money LIBRA = new Money("Libra", "GBP", 0);
    public static final Money PESO_ARGENTINO = new Money("Peso Argentino", "ARS", 0);
    public static final Money PESO_CHILENO = new Money("Peso Chileno", "CLP", 0);

    private Money(String symbol, String name, double dollarEquivalent) {
        super(symbol, name, dollarEquivalent);
        all.add(this);
    }

    public BigDecimal updateAndConvert(BigDecimal amount, Money targetUnit) throws Exception {
        MoneyService.updateDollarEquivalenceOfCoins();
        return super.convert(amount, targetUnit);
    }

    @Override
    public String getFormattedValue(String value) {
        nf.setCurrency(Currency.getInstance(getSymbol()));
        return nf.format(new BigDecimal(value));
    }

    public static Money[] getAll() {
        return all.toArray(new Money[0]);
    }

    public void setDollarEquivalent(double dollarEquivalent) {
        this.factor = dollarEquivalent;
    }

    static public List<String> getAllSymbols() {
        return Arrays.stream(getAll())
                .map(coin -> coin.getSymbol())
                .collect(Collectors.toList());
    }

    static public Money getBySymbol(String symbol) {
        return Arrays.stream(getAll())
                .filter(coin -> coin.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no monetary value with the symbol " + symbol));
    }

}