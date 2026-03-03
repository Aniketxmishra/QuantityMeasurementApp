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
        // Length demos (existing + new)
        demonstrateConversion(new Quantity<>(1.0, LengthUnit.FEET), LengthUnit.INCH);
        demonstrateAddition(
                new Quantity<>(1.0, LengthUnit.FEET),
                new Quantity<>(12.0, LengthUnit.INCH),
                LengthUnit.FEET);
        demonstrateSubtraction(
                new Quantity<>(10.0, LengthUnit.FEET),
                new Quantity<>(6.0, LengthUnit.INCH),
                LengthUnit.FEET);
        demonstrateDivision(
                new Quantity<>(24.0, LengthUnit.INCH),
                new Quantity<>(2.0, LengthUnit.FEET));

        // Volume demos (existing + new)
        demonstrateAddition(
                new Quantity<>(1.0, VolumeUnit.LITRE),
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE),
                VolumeUnit.LITRE);
        demonstrateSubtraction(
                new Quantity<>(5.0, VolumeUnit.LITRE),
                new Quantity<>(500.0, VolumeUnit.MILLILITRE),
                VolumeUnit.LITRE);
        demonstrateDivision(
                new Quantity<>(10.0, VolumeUnit.LITRE),
                new Quantity<>(5.0, VolumeUnit.LITRE));

        // Weight demos (existing + new)
        demonstrateAddition(
                new Quantity<>(1.0, WeightUnit.KILOGRAM),
                new Quantity<>(1000.0, WeightUnit.GRAM),
                WeightUnit.KILOGRAM);
        demonstrateSubtraction(
                new Quantity<>(10.0, WeightUnit.KILOGRAM),
                new Quantity<>(5000.0, WeightUnit.GRAM),
                WeightUnit.KILOGRAM);
        demonstrateDivision(
                new Quantity<>(10.0, WeightUnit.KILOGRAM),
                new Quantity<>(5.0, WeightUnit.KILOGRAM));
        // Temperature demos
        demonstrateEquality(
                new Quantity<>(0.0, TemperatureUnit.CELSIUS),
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT));
        demonstrateEquality(
                new Quantity<>(100.0, TemperatureUnit.CELSIUS),
                new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT));
        demonstrateConversion(
                new Quantity<>(100.0, TemperatureUnit.CELSIUS),
                TemperatureUnit.FAHRENHEIT);
        demonstrateConversion(
                new Quantity<>(273.15, TemperatureUnit.KELVIN),
                TemperatureUnit.CELSIUS);
        demonstrateConversion(
                new Quantity<>(0.0, TemperatureUnit.CELSIUS),
                TemperatureUnit.KELVIN);

    }

    public static <U extends IMeasurable> void demonstrateSubtraction(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        System.out.println(q1 + " - " + q2 + " = " + q1.subtract(q2, targetUnit));
    }

    public static <U extends IMeasurable> void demonstrateDivision(Quantity<U> q1, Quantity<U> q2) {
        System.out.println(q1 + " ÷ " + q2 + " = " + q1.divide(q2));
    }

}
