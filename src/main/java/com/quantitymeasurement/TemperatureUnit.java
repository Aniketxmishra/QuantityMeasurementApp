package com.quantitymeasurement;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS(
            celsius -> celsius,
            celsius -> celsius
    ),
    FAHRENHEIT(
            fahrenheit -> (fahrenheit - 32.0) * 5.0 / 9.0,
            celsius -> celsius * 9.0 / 5.0 + 32.0
    ),
    KELVIN(
            kelvin -> kelvin - 273.15,
            celsius -> celsius + 273.15
    );

    private final Function<Double, Double> toBase;
    private final Function<Double, Double> fromBase;

    private static final SupportsArithmetic ARITHMETIC_SUPPORT = () -> false;

    TemperatureUnit(Function<Double, Double> toBase, Function<Double, Double> fromBase) {
        this.toBase = toBase;
        this.fromBase = fromBase;
    }

    @Override
    public double getConversionFactor() { return 1.0; }

    @Override
    public double convertToBaseUnit(double value) { return toBase.apply(value); }

    @Override
    public double convertFromBaseUnit(double baseValue) { return fromBase.apply(baseValue); }

    @Override
    public String getUnitName() { return name(); }

    @Override
    public boolean supportsArithmetic() { return ARITHMETIC_SUPPORT.isSupported(); }

    @Override
    public boolean supportsAddition() { return false; }

    @Override
    public boolean supportsDivision() { return false; }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
                "Temperature does not support " + operation +
                        ". Temperature values represent absolute points on a scale, not relative measurements.");
    }
}
