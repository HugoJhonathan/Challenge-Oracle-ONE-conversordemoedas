package application;

import java.math.BigDecimal;

import static units.Length.CENTIMETRO;
import static units.Length.METRO;

public class Main {

    public static void main(String[] args) {
        Result r = Conversor.convert(new BigDecimal("10"), CENTIMETRO, METRO);
        System.out.println(r);
        BigDecimal s = CENTIMETRO.convert(new BigDecimal("10"), METRO);
        System.out.println(s);
    }

}