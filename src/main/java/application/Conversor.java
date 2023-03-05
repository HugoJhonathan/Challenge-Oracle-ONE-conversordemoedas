package application;

import units.Unit;

import java.math.BigDecimal;

public abstract class Conversor {

    static public <T extends Unit<T>> Result convert(BigDecimal amount, T source, T target) {
        BigDecimal result = source.convert(amount, target);
        return new Result(source, target, amount, result);
    }

}