package application;

import application.Conversor;

import static units.Distance.Centimetro;
import static units.Distance.Metro;
import static units.Temperature.*;

public class Main {

    public static void main(String[] args) {

        Conversor.convert(1.0, Centimetro, Metro).printInConsole();
        double result = Celsius.convert(10, Fahrenheit);
        System.out.println(result);

    }

}