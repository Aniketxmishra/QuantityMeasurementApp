package com.quantitymeasurement;

/**
 * Standalone enum representing weight units with full conversion responsibility.
 * Base unit = KILOGRAM.
 */
public enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    /** Converts value in this unit → base unit (kilograms) */
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    /** Converts value from base unit (kilograms) → this unit */
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}
