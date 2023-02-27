package application;

import static units.Length.CENTIMETRO;
import static units.Length.METRO;
import static units.Temperature.*;

public class Main {

    public static void main(String[] args) {

        Conversor.convert(1.0, CENTIMETRO, METRO).printInConsole();
        double result = CELSIUS.convert(10, FAHRENHEIT);
        System.out.println(result);

    }

}