package com.quantitymeasurement;

/**
 * Generic immutable quantity class for any measurement category.
 * Replaces QuantityLength and QuantityWeight with a single, reusable implementation.
 *
 * @param <U> any enum implementing IMeasurable
 */
public class Quantity<U extends IMeasurable> {

    private static final double EPSILON = 1e-4;

    final double value;
    final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double converted = targetUnit.convertFromBaseUnit(this.toBaseUnit());
        return new Quantity<>(converted, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        if (other == null) throw new IllegalArgumentException("Operand cannot be null");
        double sumInBase = this.toBaseUnit() + other.toBaseUnit();
        return new Quantity<>(this.unit.convertFromBaseUnit(sumInBase), this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null) throw new IllegalArgumentException("Operand cannot be null");
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double sumInBase = this.toBaseUnit() + other.toBaseUnit();
        return new Quantity<>(targetUnit.convertFromBaseUnit(sumInBase), targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Quantity<?> other = (Quantity<?>) obj;
        if (this.unit.getClass() != other.unit.getClass()) return false;
        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(Math.round(toBaseUnit() / EPSILON) * EPSILON);
        return (int) (bits ^ (bits >>> 32));
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}
