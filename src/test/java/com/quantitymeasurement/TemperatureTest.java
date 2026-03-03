package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureTest {

    private static final double EPSILON = 1e-2;

    // ===== EQUALITY =====
    @Test void testTemperatureEquality_CelsiusToCelsius_SameValue() {
        assertEquals(new Quantity<>(0.0, TemperatureUnit.CELSIUS), new Quantity<>(0.0, TemperatureUnit.CELSIUS));
    }
    @Test void testTemperatureEquality_FahrenheitToFahrenheit_SameValue() {
        assertEquals(new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT), new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT));
    }
    @Test void testTemperatureEquality_KelvinToKelvin_SameValue() {
        assertEquals(new Quantity<>(273.15, TemperatureUnit.KELVIN), new Quantity<>(273.15, TemperatureUnit.KELVIN));
    }
    @Test void testTemperatureEquality_0Celsius_32Fahrenheit() {
        assertEquals(new Quantity<>(0.0, TemperatureUnit.CELSIUS), new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT));
    }
    @Test void testTemperatureEquality_100Celsius_212Fahrenheit() {
        assertEquals(new Quantity<>(100.0, TemperatureUnit.CELSIUS), new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT));
    }
    @Test void testTemperatureEquality_Minus40_EqualPoint() {
        assertEquals(new Quantity<>(-40.0, TemperatureUnit.CELSIUS), new Quantity<>(-40.0, TemperatureUnit.FAHRENHEIT));
    }
    @Test void testTemperatureEquality_0Celsius_273_15Kelvin() {
        assertEquals(new Quantity<>(0.0, TemperatureUnit.CELSIUS), new Quantity<>(273.15, TemperatureUnit.KELVIN));
    }
    @Test void testTemperatureEquality_100Celsius_373_15Kelvin() {
        assertEquals(new Quantity<>(100.0, TemperatureUnit.CELSIUS), new Quantity<>(373.15, TemperatureUnit.KELVIN));
    }
    @Test void testTemperatureEquality_212Fahrenheit_373_15Kelvin() {
        assertEquals(new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT), new Quantity<>(373.15, TemperatureUnit.KELVIN));
    }
    @Test void testTemperatureEquality_SymmetricProperty() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> fahrenheit = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        assertEquals(celsius, fahrenheit);
        assertEquals(fahrenheit, celsius);
    }
    @Test void testTemperatureEquality_ReflexiveProperty() {
        Quantity<TemperatureUnit> q = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertEquals(q, q);
    }
    @Test void testTemperatureEquality_DifferentValues_NotEqual() {
        assertNotEquals(new Quantity<>(50.0, TemperatureUnit.CELSIUS), new Quantity<>(100.0, TemperatureUnit.CELSIUS));
    }
    @Test void testTemperatureEquality_NullComparison() {
        assertNotEquals(new Quantity<>(0.0, TemperatureUnit.CELSIUS), null);
    }

    // ===== CONVERSION =====
    @Test void testTemperatureConversion_CelsiusToFahrenheit_0() {
        assertEquals(new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT),
                new Quantity<>(0.0, TemperatureUnit.CELSIUS).convertTo(TemperatureUnit.FAHRENHEIT));
    }
    @Test void testTemperatureConversion_CelsiusToFahrenheit_100() {
        assertEquals(new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT),
                new Quantity<>(100.0, TemperatureUnit.CELSIUS).convertTo(TemperatureUnit.FAHRENHEIT));
    }
    @Test void testTemperatureConversion_CelsiusToFahrenheit_Minus40() {
        assertEquals(new Quantity<>(-40.0, TemperatureUnit.FAHRENHEIT),
                new Quantity<>(-40.0, TemperatureUnit.CELSIUS).convertTo(TemperatureUnit.FAHRENHEIT));
    }
    @Test void testTemperatureConversion_FahrenheitToCelsius_32() {
        assertEquals(new Quantity<>(0.0, TemperatureUnit.CELSIUS),
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT).convertTo(TemperatureUnit.CELSIUS));
    }
    @Test void testTemperatureConversion_FahrenheitToCelsius_212() {
        assertEquals(new Quantity<>(100.0, TemperatureUnit.CELSIUS),
                new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT).convertTo(TemperatureUnit.CELSIUS));
    }
    @Test void testTemperatureConversion_CelsiusToKelvin_0() {
        assertEquals(new Quantity<>(273.15, TemperatureUnit.KELVIN),
                new Quantity<>(0.0, TemperatureUnit.CELSIUS).convertTo(TemperatureUnit.KELVIN));
    }
    @Test void testTemperatureConversion_KelvinToCelsius_273_15() {
        assertEquals(new Quantity<>(0.0, TemperatureUnit.CELSIUS),
                new Quantity<>(273.15, TemperatureUnit.KELVIN).convertTo(TemperatureUnit.CELSIUS));
    }
    @Test void testTemperatureConversion_SameUnit_NoChange() {
        assertEquals(new Quantity<>(100.0, TemperatureUnit.CELSIUS),
                new Quantity<>(100.0, TemperatureUnit.CELSIUS).convertTo(TemperatureUnit.CELSIUS));
    }
    @Test void testTemperatureConversion_RoundTrip_CelsiusToFahrenheitBack() {
        assertEquals(new Quantity<>(37.0, TemperatureUnit.CELSIUS),
                new Quantity<>(37.0, TemperatureUnit.CELSIUS)
                        .convertTo(TemperatureUnit.FAHRENHEIT)
                        .convertTo(TemperatureUnit.CELSIUS));
    }
    @Test void testTemperatureConversion_RoundTrip_CelsiusToKelvinBack() {
        assertEquals(new Quantity<>(100.0, TemperatureUnit.CELSIUS),
                new Quantity<>(100.0, TemperatureUnit.CELSIUS)
                        .convertTo(TemperatureUnit.KELVIN)
                        .convertTo(TemperatureUnit.CELSIUS));
    }
    @Test void testTemperatureConversion_NegativeValue() {
        assertEquals(new Quantity<>(-4.0, TemperatureUnit.FAHRENHEIT),
                new Quantity<>(-20.0, TemperatureUnit.CELSIUS).convertTo(TemperatureUnit.FAHRENHEIT));
    }
    @Test void testTemperatureConversion_AbsoluteZero_CelsiusToFahrenheit() {
        assertEquals(new Quantity<>(-459.67, TemperatureUnit.FAHRENHEIT),
                new Quantity<>(-273.15, TemperatureUnit.CELSIUS).convertTo(TemperatureUnit.FAHRENHEIT));
    }
    @Test void testTemperatureConversion_LargeValue() {
        assertEquals(new Quantity<>(1832.0, TemperatureUnit.FAHRENHEIT),
                new Quantity<>(1000.0, TemperatureUnit.CELSIUS).convertTo(TemperatureUnit.FAHRENHEIT));
    }

    // ===== UNSUPPORTED OPERATIONS =====
    @Test void testTemperatureUnsupportedOperation_Add() {
        assertThrows(UnsupportedOperationException.class,
                () -> new Quantity<>(100.0, TemperatureUnit.CELSIUS)
                        .add(new Quantity<>(50.0, TemperatureUnit.CELSIUS)));
    }
    @Test void testTemperatureUnsupportedOperation_Subtract() {
        assertThrows(UnsupportedOperationException.class,
                () -> new Quantity<>(100.0, TemperatureUnit.CELSIUS)
                        .subtract(new Quantity<>(50.0, TemperatureUnit.CELSIUS)));
    }
    @Test void testTemperatureUnsupportedOperation_Divide() {
        assertThrows(UnsupportedOperationException.class,
                () -> new Quantity<>(100.0, TemperatureUnit.CELSIUS)
                        .divide(new Quantity<>(50.0, TemperatureUnit.CELSIUS)));
    }
    @Test void testTemperatureUnsupportedOperation_ErrorMessageContainsOperation() {
        UnsupportedOperationException ex = assertThrows(UnsupportedOperationException.class,
                () -> new Quantity<>(100.0, TemperatureUnit.CELSIUS)
                        .add(new Quantity<>(50.0, TemperatureUnit.CELSIUS)));
        assertTrue(ex.getMessage().contains("Temperature"));
    }
    @Test void testTemperatureValidateOperationSupport_DirectCall() {
        assertThrows(UnsupportedOperationException.class,
                () -> TemperatureUnit.CELSIUS.validateOperationSupport("addition"));
    }

    // ===== OPERATION SUPPORT METHODS =====
    @Test void testOperationSupportMethods_TemperatureUnit_supportsArithmetic_False() {
        assertFalse(TemperatureUnit.CELSIUS.supportsArithmetic());
        assertFalse(TemperatureUnit.FAHRENHEIT.supportsArithmetic());
        assertFalse(TemperatureUnit.KELVIN.supportsArithmetic());
    }
    @Test void testOperationSupportMethods_TemperatureUnitAddition() {
        assertFalse(TemperatureUnit.CELSIUS.supportsAddition());
    }
    @Test void testOperationSupportMethods_TemperatureUnitDivision() {
        assertFalse(TemperatureUnit.FAHRENHEIT.supportsDivision());
    }
    @Test void testOperationSupportMethods_LengthUnitAddition() {
        assertTrue(LengthUnit.FEET.supportsAddition());
    }
    @Test void testOperationSupportMethods_WeightUnitDivision() {
        assertTrue(WeightUnit.KILOGRAM.supportsDivision());
    }
    @Test void testOperationSupportMethods_VolumeUnitArithmetic() {
        assertTrue(VolumeUnit.LITRE.supportsArithmetic());
    }

    // ===== CROSS-CATEGORY TYPE SAFETY =====
    @Test void testTemperatureVsLengthIncompatibility() {
        assertNotEquals(new Quantity<>(100.0, TemperatureUnit.CELSIUS), new Quantity<>(100.0, LengthUnit.FEET));
    }
    @Test void testTemperatureVsWeightIncompatibility() {
        assertNotEquals(new Quantity<>(50.0, TemperatureUnit.CELSIUS), new Quantity<>(50.0, WeightUnit.KILOGRAM));
    }
    @Test void testTemperatureVsVolumeIncompatibility() {
        assertNotEquals(new Quantity<>(25.0, TemperatureUnit.CELSIUS), new Quantity<>(25.0, VolumeUnit.LITRE));
    }

    // ===== ENUM STRUCTURE =====
    @Test void testTemperatureUnit_AllConstantsAccessible() {
        assertNotNull(TemperatureUnit.CELSIUS);
        assertNotNull(TemperatureUnit.FAHRENHEIT);
        assertNotNull(TemperatureUnit.KELVIN);
    }
    @Test void testTemperatureUnit_GetUnitName() {
        assertEquals("CELSIUS", TemperatureUnit.CELSIUS.getUnitName());
        assertEquals("FAHRENHEIT", TemperatureUnit.FAHRENHEIT.getUnitName());
        assertEquals("KELVIN", TemperatureUnit.KELVIN.getUnitName());
    }
    @Test void testTemperatureNullUnitValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(100.0, null));
    }

    // ===== IMeasurable BACKWARD COMPATIBILITY =====
    @Test void testIMeasurableInterface_LengthUnit_BackwardCompatible() {
        assertEquals(new Quantity<>(2.0, LengthUnit.FEET),
                new Quantity<>(1.0, LengthUnit.FEET).add(new Quantity<>(1.0, LengthUnit.FEET)));
    }
    @Test void testIMeasurableInterface_WeightUnit_BackwardCompatible() {
        assertEquals(new Quantity<>(2.0, WeightUnit.KILOGRAM),
                new Quantity<>(1.0, WeightUnit.KILOGRAM).add(new Quantity<>(1.0, WeightUnit.KILOGRAM)));
    }
    @Test void testIMeasurableInterface_VolumeUnit_BackwardCompatible() {
        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE),
                new Quantity<>(1.0, VolumeUnit.LITRE).add(new Quantity<>(1.0, VolumeUnit.LITRE)));
    }
}
