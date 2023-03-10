package units;

import java.util.LinkedList;
import java.util.List;

public class Mass extends Unit<Mass> {

    private static List<Mass> all = new LinkedList<>();

    public static Mass KILOGRAMA = new Mass("Quilograma", "Kg", 1000.0);
    public static Mass HECTOGRAMA = new Mass("Hectograma", "hg", 100.0);
    public static Mass DECAGRAMA = new Mass("Decagrama", "dag", 10.0);
    public static Mass GRAMA = new Mass("Grama", "g", 1.0);
    public static Mass DECOGRAMA = new Mass("Decograma", "dg", 0.1);
    public static Mass CENTIGRAMA = new Mass("Centigrama", "cg", 0.01);
    public static Mass MILIGRAMA = new Mass("Miligrama", "mg", 0.001);

    private Mass(String name, String symbol, double gramsEquivalent) {
        super(name, symbol, gramsEquivalent);
        all.add(this);
    }

    public static Mass[] getAll() {
        return all.toArray(new Mass[0]);
    }

}
