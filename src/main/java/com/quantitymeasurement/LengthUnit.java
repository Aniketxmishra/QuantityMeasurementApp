package com.quantitymeasurement;

/**
 * Standalone enum representing length units with full conversion responsibility.
 * Conversion factor is defined as feet-per-unit (base unit = FEET).
 */
public enum LengthUnit {
    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CENTIMETER(1.0 / 30.48);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    /** Converts a value in this unit to the base unit (feet). */
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    /** Converts a value from the base unit (feet) to this unit. */
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}
