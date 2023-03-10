package service;

import units.Money;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MoneyService {

    public static void updateDollarEquivalenceOfCoins() throws Exception {
        String joinedWithUSD = Money.getAllSymbols()
                .stream()
                .filter(e -> !Objects.equals(e, "USD"))
                .map(e -> e + "-USD")
                .collect(Collectors.joining(","));

        Map<String, Coin> m = Api.findAllCurrenciesDollarEquivalent(joinedWithUSD);
        m.forEach((key, value) -> {
            String code = value.getCode();
            double dollarEquivalent = value.getBid();
            Money.getBySymbol(code).setDollarEquivalent(dollarEquivalent);
        });
    }
}
