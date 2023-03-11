package service;

import units.Money;

import java.util.Map;
import java.util.stream.Collectors;

public class MoneyService {

    private static String joinedWithUSD = Money.getAllSymbols()
            .stream()
            .filter(e -> !e.equals("USD"))
            .map(e -> e + "-USD")
            .collect(Collectors.joining(","));

    public static void updateDollarEquivalenceOfCoins() throws Exception {
        Map<String, Coin> m = Api.findAllCurrenciesDollarEquivalent(joinedWithUSD);
        m.forEach((key, value) -> {
            String code = value.getCode();
            double dollarEquivalent = value.getBid();
            Money.getBySymbol(code).setDollarEquivalent(dollarEquivalent);
        });
    }
}
