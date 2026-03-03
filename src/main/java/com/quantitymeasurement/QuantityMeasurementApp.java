package com.quantitymeasurement;

public class QuantityMeasurementApp {

    private static final double EPSILON = 1e-6;

    public enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CENTIMETER(0.393701 / 12.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public static class QuantityLength {
        final double value;
        final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            this.value = value;
            this.unit = unit;
        }

        double toBaseUnit() {
            return value * unit.getConversionFactor();
        }

        public QuantityLength convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
            double converted = this.toBaseUnit() / targetUnit.getConversionFactor();
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
        double resultValue = sumInBase / q1.unit.getConversionFactor();
        return new QuantityLength(resultValue, q1.unit);
    }
    /**
     * Overloaded add: result expressed in explicitly specified targetUnit.
     * @throws IllegalArgumentException for null operands or null targetUnit
     */
    public static QuantityLength add(QuantityLength q1, QuantityLength q2, LengthUnit targetUnit) {
        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Operands cannot be null");
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
        double sumInBase = q1.toBaseUnit() + q2.toBaseUnit();
        double resultValue = sumInBase / targetUnit.getConversionFactor();
        return new QuantityLength(resultValue, targetUnit);
    }


    public static void demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        double result = convert(value, from, to);
        System.out.printf("%.4f %s = %.4f %s%n", value, from, result, to);
    }

    public static void demonstrateLengthConversion(QuantityLength length, LengthUnit to) {
        QuantityLength result = length.convertTo(to);
        System.out.println(length + " = " + result);
    }

    public static void demonstrateLengthEquality(QuantityLength q1, QuantityLength q2) {
        System.out.println(q1 + " == " + q2 + " ? " + q1.equals(q2));
    }

    public static void main(String[] args) {
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCH);
        demonstrateLengthConversion(1.0, LengthUnit.YARD, LengthUnit.INCH);
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETER, LengthUnit.INCH);
        demonstrateLengthConversion(new QuantityLength(3.0, LengthUnit.FEET), LengthUnit.YARD);
        demonstrateLengthEquality(
                new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCH)
        );
        System.out.println(add(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(12.0, LengthUnit.INCH)));
        System.out.println(add(new QuantityLength(1.0, LengthUnit.YARD), new QuantityLength(3.0, LengthUnit.FEET)));
    }
}
