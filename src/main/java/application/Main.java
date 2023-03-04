package application;

import java.math.BigDecimal;
import java.math.MathContext;

import static units.Length.*;
import static units.Temperature.*;

public class Main {

    public static void main(String[] args) {

        Conversor.convert(1.0, CENTIMETRO, METRO).printInConsole();
        double result = CELSIUS.convert(10, FAHRENHEIT);
        System.out.println(result);

    }

}