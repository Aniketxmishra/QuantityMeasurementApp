package com.quantitymeasurement;

/**
 * Interface defining the contract for all measurement units.
 * Any unit enum (LengthUnit, WeightUnit, etc.) must implement this.
 */
public interface IMeasurable {
    double getConversionFactor();
    double convertToBaseUnit(double value);
    double convertFromBaseUnit(double baseValue);
    String getUnitName();
}
