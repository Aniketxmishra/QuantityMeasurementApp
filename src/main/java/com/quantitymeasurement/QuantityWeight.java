package com.quantitymeasurement;

/**
 * Immutable weight measurement. Delegates all conversion to WeightUnit.
 */
public class QuantityWeight {

    private static final double EPSILON = 1e-6;

    final double value;
    final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    double toBaseUnit() {          // ✅ package-private — accessible from test
        return unit.convertToBaseUnit(value);
    }


    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double converted = targetUnit.convertFromBaseUnit(this.toBaseUnit());
        return new QuantityWeight(converted, targetUnit);
    }

    public static QuantityWeight add(QuantityWeight q1, QuantityWeight q2) {
        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Operands cannot be null");
        double sumInBase = q1.toBaseUnit() + q2.toBaseUnit();
        return new QuantityWeight(q1.unit.convertFromBaseUnit(sumInBase), q1.unit);
    }

    public static QuantityWeight add(QuantityWeight q1, QuantityWeight q2, WeightUnit targetUnit) {
        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Operands cannot be null");
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
        double sumInBase = q1.toBaseUnit() + q2.toBaseUnit();
        return new QuantityWeight(targetUnit.convertFromBaseUnit(sumInBase), targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityWeight other = (QuantityWeight) obj;
        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(Math.round(toBaseUnit() / EPSILON) * EPSILON);
        return (int) (bits ^ (bits >>> 32));
    }

    @Override
    public String toString() {
        return value + " " + unit.name();
    }
}
