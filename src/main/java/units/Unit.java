package units;

public interface Unit {

    String getSymbol();

    double getFactor();

    String getName();

    Unit[] getAllUnits();

    default String getFormattedValue(double value) {
        return value + " " + getSymbol();
    }

    default void checkIfTheClassesAreEquals(Unit targetUnit) {
        if (this.getClass() != targetUnit.getClass()) {
            throw new RuntimeException("Unable to convert " + this.getClass().getSimpleName()
                    + " to " + targetUnit.getClass().getSimpleName());
        }
    }

    default double convert(double amount, Unit targetUnit) {
        checkIfTheClassesAreEquals(targetUnit);
        return amount * getFactor() / targetUnit.getFactor();
    }

}