package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ========== SAME UNIT TESTS ==========

    @Test
    public void givenSameFeetValue_WhenCompared_ShouldReturnEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertEquals(q1, q2);
    }

    @Test
    public void givenDifferentFeetValue_WhenCompared_ShouldReturnNotEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertNotEquals(q1, q2);
    }

    @Test
    public void givenSameInchValue_WhenCompared_ShouldReturnEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(q1, q2);
    }

    @Test
    public void givenDifferentInchValue_WhenCompared_ShouldReturnNotEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertNotEquals(q1, q2);
    }

    // ========== CROSS-UNIT TESTS ==========

    @Test
    public void givenOneFeet_WhenComparedToTwelveInches_ShouldReturnEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(q1, q2);
    }

    @Test
    public void givenTwelveInches_WhenComparedToOneFeet_ShouldReturnEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertEquals(q1, q2);
    }

    // ========== EDGE CASE TESTS ==========

    @Test
    public void givenNullValue_WhenCompared_ShouldReturnNotEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertNotEquals(null, q1);
    }

    @Test
    public void givenNullUnit_WhenCreated_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new QuantityMeasurementApp.QuantityLength(1.0, null));
    }

    @Test
    public void givenSameReference_WhenCompared_ShouldReturnEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertSame(q1, q1);
    }

    @Test
    public void givenQuantity_WhenComparedToNonQuantity_ShouldReturnNotEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertNotEquals("someString", q1);
    }
}
