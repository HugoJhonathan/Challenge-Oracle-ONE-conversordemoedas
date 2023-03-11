package units;

import java.util.LinkedList;
import java.util.List;

public class Length extends Unit<Length> {

    private static List<Length> all = new LinkedList<>();

    public static final Length MEGA_METRO = new Length("Megametro", "Mm", 1000000.0);
    public static final Length QUILOMETRO = new Length("Quilômetro", "km", 1000.0);
    public static final Length HECTOMETRO = new Length("Hectômetro", "Hm", 100.0);
    public static final Length DECAMETRO = new Length("Decâmetro", "dam", 10.0);
    public static final Length METRO = new Length("Metro", "m", 1.0);
    public static final Length DECIMETRO = new Length("Decímetro", "dm", 0.1);
    public static final Length CENTIMETRO = new Length("Centímetro", "cm", 0.01);
    public static final Length MILIMETRO = new Length("Milímetro", "mm", 0.001);

    private Length(String name, String symbol, double mettersEquivalent) {
        super(name, symbol, mettersEquivalent);
        all.add(this);
    }

    public static Length[] getAll() {
        return all.toArray(new Length[0]);
    }

}
