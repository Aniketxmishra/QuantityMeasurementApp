package com.quantitymeasurement;

/**
 * UC10: Simplified QuantityMeasurementApp using generic Quantity<U>.
 * All category-specific methods replaced with single generic methods.
 * QuantityLength and QuantityWeight kept as type aliases for backward compatibility.
 */
public class QuantityMeasurementApp {

    private static final double EPSILON = 1e-6;

    // ===== BACKWARD COMPATIBILITY: QuantityLength as inner class wrapping Quantity<LengthUnit> =====
    public static class QuantityLength {
        final double value;
        final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            this.value = value;
            this.unit = unit;
        }

        double toBaseUnit() {
            return unit.convertToBaseUnit(value);
        }

        public QuantityLength convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
            double converted = targetUnit.convertFromBaseUnit(this.toBaseUnit());
            return new QuantityLength(converted, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            QuantityLength other = (QuantityLength) obj;
            return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
        }

        @Override
        public String toString() {
            return value + " " + unit.name();
        }
    }

    // ===== LEGACY STATIC METHODS for UC1-UC9 backward compatibility =====
    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (sourceUnit == null || targetUnit == null)
            throw new IllegalArgumentException("Units cannot be null");
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");
        return new QuantityLength(value, sourceUnit).convertTo(targetUnit).value;
    }

    public static QuantityLength add(QuantityLength q1, QuantityLength q2) {
        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Operands cannot be null");
        double sumInBase = q1.toBaseUnit() + q2.toBaseUnit();
        return new QuantityLength(q1.unit.convertFromBaseUnit(sumInBase), q1.unit);
    }

    public static QuantityLength add(QuantityLength q1, QuantityLength q2, LengthUnit targetUnit) {
        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Operands cannot be null");
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
        double sumInBase = q1.toBaseUnit() + q2.toBaseUnit();
        return new QuantityLength(targetUnit.convertFromBaseUnit(sumInBase), targetUnit);
    }

    // ===== UC10: GENERIC DEMONSTRATION METHODS =====
    public static <U extends IMeasurable> void demonstrateEquality(Quantity<U> q1, Quantity<U> q2) {
        System.out.println(q1 + " == " + q2 + " ? " + q1.equals(q2));
    }

    public static <U extends IMeasurable> void demonstrateConversion(Quantity<U> q, U targetUnit) {
        System.out.println(q + " → " + q.convertTo(targetUnit));
    }

    public static <U extends IMeasurable> void demonstrateAddition(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        System.out.println(q1 + " + " + q2 + " = " + q1.add(q2, targetUnit));
    }

    public static void main(String[] args) {
        // Length demos using generic Quantity<LengthUnit>
        demonstrateConversion(new Quantity<>(1.0, LengthUnit.FEET), LengthUnit.INCH);
        demonstrateConversion(new Quantity<>(1.0, LengthUnit.YARD), LengthUnit.INCH);
        demonstrateEquality(
                new Quantity<>(1.0, LengthUnit.FEET),
                new Quantity<>(12.0, LengthUnit.INCH));
        demonstrateAddition(
                new Quantity<>(1.0, LengthUnit.FEET),
                new Quantity<>(12.0, LengthUnit.INCH),
                LengthUnit.FEET);

        // Weight demos using generic Quantity<WeightUnit>
        demonstrateEquality(
                new Quantity<>(1.0, WeightUnit.KILOGRAM),
                new Quantity<>(1000.0, WeightUnit.GRAM));
        demonstrateConversion(new Quantity<>(1.0, WeightUnit.KILOGRAM), WeightUnit.GRAM);
        demonstrateAddition(
                new Quantity<>(1.0, WeightUnit.KILOGRAM),
                new Quantity<>(1000.0, WeightUnit.GRAM),
                WeightUnit.KILOGRAM);
    }
}
