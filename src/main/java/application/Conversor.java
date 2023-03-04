package application;

import units.Unit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Conversor {

    static public Result convert(double amount, Unit source, Unit target) {
        double result = source.convert(amount, target);
        result = new BigDecimal(result).setScale(7, RoundingMode.HALF_UP).doubleValue();
        return new Result(source, target, amount, result);
    }

}