package units;

import java.util.LinkedList;
import java.util.List;

public class Mass extends Unit<Mass> {

    private static List<Mass> all = new LinkedList<>();

    public static final Mass KILOGRAMA = new Mass("Quilograma", "Kg", 1000.0);
    public static final Mass HECTOGRAMA = new Mass("Hectograma", "hg", 100.0);
    public static final Mass DECAGRAMA = new Mass("Decagrama", "dag", 10.0);
    public static final Mass GRAMA = new Mass("Grama", "g", 1.0);
    public static final Mass DECOGRAMA = new Mass("Decograma", "dg", 0.1);
    public static final Mass CENTIGRAMA = new Mass("Centigrama", "cg", 0.01);
    public static final Mass MILIGRAMA = new Mass("Miligrama", "mg", 0.001);

    private Mass(String name, String symbol, double gramsEquivalent) {
        super(name, symbol, gramsEquivalent);
        all.add(this);
    }

    public static Mass[] getAll() {
        return all.toArray(new Mass[0]);
    }

}
