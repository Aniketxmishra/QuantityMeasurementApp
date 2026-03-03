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
    // ========== YARD TESTS ==========

    @Test
    public void givenSameYardValue_WhenCompared_ShouldReturnEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertEquals(q1, q2);
    }

    @Test
    public void givenDifferentYardValue_WhenCompared_ShouldReturnNotEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertNotEquals(q1, q2);
    }

    @Test
    public void givenOneYard_WhenComparedToThreeFeet_ShouldReturnEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertEquals(q1, q2);
    }

    @Test
    public void givenThreeFeet_WhenComparedToOneYard_ShouldReturnEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertEquals(q1, q2);
    }

    @Test
    public void givenOneYard_WhenComparedToThirtySixInches_ShouldReturnEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(q1, q2);
    }

    @Test
    public void givenOneYard_WhenComparedToTwoFeet_ShouldReturnNotEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertNotEquals(q1, q2);
    }

// ========== CENTIMETER TESTS ==========

    @Test
    public void givenSameCentimeterValue_WhenCompared_ShouldReturnEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        assertEquals(q1, q2);
    }

    @Test
    public void givenOneCentimeter_WhenComparedToPointThreeInches_ShouldReturnEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(0.393701, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(q1, q2);
    }

    @Test
    public void givenOneCentimeter_WhenComparedToOneFoot_ShouldReturnNotEqual() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertNotEquals(q1, q2);
    }

    @Test
    public void givenOneYard_TwoFeet_ThirtySixInches_TransitiveProperty_ShouldAllBeEqual() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches);
    }
    // ========== CONVERSION TESTS ==========

    @Test
    public void givenOneFeet_WhenConvertedToInches_ShouldReturnTwelve() {
        assertEquals(12.0, QuantityMeasurementApp.convert(1.0, QuantityMeasurementApp.LengthUnit.FEET, QuantityMeasurementApp.LengthUnit.INCH), 1e-6);
    }

    @Test
    public void givenTwentyFourInches_WhenConvertedToFeet_ShouldReturnTwo() {
        assertEquals(2.0, QuantityMeasurementApp.convert(24.0, QuantityMeasurementApp.LengthUnit.INCH, QuantityMeasurementApp.LengthUnit.FEET), 1e-6);
    }

    @Test
    public void givenOneYard_WhenConvertedToInches_ShouldReturnThirtySix() {
        assertEquals(36.0, QuantityMeasurementApp.convert(1.0, QuantityMeasurementApp.LengthUnit.YARD, QuantityMeasurementApp.LengthUnit.INCH), 1e-6);
    }

    @Test
    public void givenSeventyTwoInches_WhenConvertedToYards_ShouldReturnTwo() {
        assertEquals(2.0, QuantityMeasurementApp.convert(72.0, QuantityMeasurementApp.LengthUnit.INCH, QuantityMeasurementApp.LengthUnit.YARD), 1e-6);
    }

    @Test
    public void givenSixFeet_WhenConvertedToYards_ShouldReturnTwo() {
        assertEquals(2.0, QuantityMeasurementApp.convert(6.0, QuantityMeasurementApp.LengthUnit.FEET, QuantityMeasurementApp.LengthUnit.YARD), 1e-6);
    }

    @Test
    public void givenPointTwoFiveFourCentimeters_WhenConvertedToInches_ShouldReturnApproxOne() {
        assertEquals(1.0, QuantityMeasurementApp.convert(2.54, QuantityMeasurementApp.LengthUnit.CENTIMETER, QuantityMeasurementApp.LengthUnit.INCH), 1e-4);
    }

    @Test
    public void givenZeroFeet_WhenConverted_ShouldReturnZero() {
        assertEquals(0.0, QuantityMeasurementApp.convert(0.0, QuantityMeasurementApp.LengthUnit.FEET, QuantityMeasurementApp.LengthUnit.INCH), 1e-6);
    }

    @Test
    public void givenNegativeOneFeet_WhenConvertedToInches_ShouldReturnNegativeTwelve() {
        assertEquals(-12.0, QuantityMeasurementApp.convert(-1.0, QuantityMeasurementApp.LengthUnit.FEET, QuantityMeasurementApp.LengthUnit.INCH), 1e-6);
    }

    @Test
    public void givenSameUnit_WhenConverted_ShouldReturnSameValue() {
        assertEquals(5.0, QuantityMeasurementApp.convert(5.0, QuantityMeasurementApp.LengthUnit.FEET, QuantityMeasurementApp.LengthUnit.FEET), 1e-6);
    }

    @Test
    public void givenRoundTrip_WhenConverted_ShouldPreserveOriginalValue() {
        double original = 3.0;
        double converted = QuantityMeasurementApp.convert(original, QuantityMeasurementApp.LengthUnit.FEET, QuantityMeasurementApp.LengthUnit.INCH);
        double back = QuantityMeasurementApp.convert(converted, QuantityMeasurementApp.LengthUnit.INCH, QuantityMeasurementApp.LengthUnit.FEET);
        assertEquals(original, back, 1e-6);
    }

    @Test
    public void givenNullUnit_WhenConverting_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(1.0, null, QuantityMeasurementApp.LengthUnit.INCH));
    }

    @Test
    public void givenNaNValue_WhenConverting_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(Double.NaN, QuantityMeasurementApp.LengthUnit.FEET, QuantityMeasurementApp.LengthUnit.INCH));
    }


}
