package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void givenSameFeetValue_WhenCompared_ShouldReturnEqual() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(1.0);
        assertEquals(f1, f2);
    }

    @Test
    public void givenDifferentFeetValue_WhenCompared_ShouldReturnNotEqual() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(2.0);
        assertNotEquals(f1, f2);
    }

    @Test
    public void givenNullValue_WhenCompared_ShouldReturnNotEqual() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        assertNotEquals(null, f1);
    }

    @Test
    public void givenNonNumericInput_WhenCompared_ShouldReturnNotEqual() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        assertNotEquals("someString", f1);
    }

    @Test
    public void givenSameReference_WhenCompared_ShouldReturnEqual() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        assertSame(f1, f1);
    }
    // ========== INCH TESTS ==========

    @Test
    public void givenSameInchValue_WhenCompared_ShouldReturnEqual() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);
        QuantityMeasurementApp.Inch i2 = new QuantityMeasurementApp.Inch(1.0);
        assertEquals(i1, i2);
    }

    @Test
    public void givenDifferentInchValue_WhenCompared_ShouldReturnNotEqual() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);
        QuantityMeasurementApp.Inch i2 = new QuantityMeasurementApp.Inch(2.0);
        assertNotEquals(i1, i2);
    }

    @Test
    public void givenNullInchValue_WhenCompared_ShouldReturnNotEqual() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);
        assertNotEquals(null, i1);
    }

    @Test
    public void givenNonNumericInputForInch_WhenCompared_ShouldReturnNotEqual() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);
        assertNotEquals("someString", i1);
    }

    @Test
    public void givenSameInchReference_WhenCompared_ShouldReturnEqual() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);
        assertSame(i1, i1);
    }

}
