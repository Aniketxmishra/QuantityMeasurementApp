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

    // ========== ADDITION TESTS ==========

    @Test
    public void givenOneFeetPlusTwoFeet_WhenAdded_ShouldReturnThreeFeet() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2);
        assertEquals(new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET), result);
    }

    @Test
    public void givenSixInchesPlusSixInches_WhenAdded_ShouldReturnTwelveInches() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(6.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(6.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2);
        assertEquals(new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH), result);
    }

    @Test
    public void givenOneFeetPlusTwelveInches_WhenAdded_ShouldReturnTwoFeet() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2);
        assertEquals(new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.FEET), result);
    }

    @Test
    public void givenTwelveInchesPlusOneFeet_WhenAdded_ShouldReturnTwentyFourInches() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2);
        assertEquals(new QuantityMeasurementApp.QuantityLength(24.0, QuantityMeasurementApp.LengthUnit.INCH), result);
    }

    @Test
    public void givenOneYardPlusThreeFeet_WhenAdded_ShouldReturnTwoYards() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2);
        assertEquals(new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.YARD), result);
    }

    @Test
    public void givenTwoPointFiveFourCmPlusOneInch_WhenAdded_ShouldReturnFivePointZeroEightCm() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(2.54, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2);
        assertEquals(5.08, result.value, 1e-4);
    }


    @Test
    public void givenFiveFeetPlusZeroInches_WhenAdded_ShouldReturnFiveFeet() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(0.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2);
        assertEquals(new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET), result);
    }

    @Test
    public void givenFiveFeetPlusNegativeTwoFeet_WhenAdded_ShouldReturnThreeFeet() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(-2.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2);
        assertEquals(new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET), result);
    }

    @Test
    public void givenNullSecondOperand_WhenAdded_ShouldThrowException() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> QuantityMeasurementApp.add(q1, null));
    }

    @Test
    public void givenLargeValues_WhenAdded_ShouldReturnCorrectSum() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1e6, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(1e6, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2);
        assertEquals(new QuantityMeasurementApp.QuantityLength(2e6, QuantityMeasurementApp.LengthUnit.FEET), result);
    }
    // ========== UC7: ADDITION WITH TARGET UNIT ==========

    @Test
    public void givenFeetAndInches_WhenAddedWithTargetFeet_ShouldReturnTwoFeet() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2, QuantityMeasurementApp.LengthUnit.FEET);
        assertEquals(new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.FEET), result);
    }

    @Test
    public void givenFeetAndInches_WhenAddedWithTargetInches_ShouldReturnTwentyFourInches() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(new QuantityMeasurementApp.QuantityLength(24.0, QuantityMeasurementApp.LengthUnit.INCH), result);
    }

    @Test
    public void givenFeetAndInches_WhenAddedWithTargetYards_ShouldReturnPointSixSixSeven() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2, QuantityMeasurementApp.LengthUnit.YARD);
        assertEquals(2.0 / 3.0, result.value, 1e-4);
    }

    @Test
    public void givenTwoInchPlusOneInch_WhenAddedWithTargetCentimeters_ShouldReturnFivePointZeroEight() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        assertEquals(5.08, result.value, 1e-2);
    }

    @Test
    public void givenTwoYardsPlusThreeFeet_WhenAddedWithTargetYards_ShouldReturnThreeYards() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2, QuantityMeasurementApp.LengthUnit.YARD);
        assertEquals(new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.YARD), result);
    }

    @Test
    public void givenTwoYardsPlusThreeFeet_WhenAddedWithTargetFeet_ShouldReturnNineFeet() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2, QuantityMeasurementApp.LengthUnit.FEET);
        assertEquals(new QuantityMeasurementApp.QuantityLength(9.0, QuantityMeasurementApp.LengthUnit.FEET), result);
    }

    @Test
    public void givenAddition_WhenTargetUnitSpecified_ShouldBeCommutative() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength r1 = QuantityMeasurementApp.add(q1, q2, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength r2 = QuantityMeasurementApp.add(q2, q1, QuantityMeasurementApp.LengthUnit.YARD);
        assertEquals(r1, r2);
    }

    @Test
    public void givenFiveFeetPlusZeroInches_WhenAddedWithTargetYards_ShouldReturnOnePointSixSeven() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(0.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2, QuantityMeasurementApp.LengthUnit.YARD);
        assertEquals(5.0 / 3.0, result.value, 1e-4);
    }

    @Test
    public void givenFiveFeetPlusNegativeTwoFeet_WhenAddedWithTargetInches_ShouldReturnThirtySixInches() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(-2.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH), result);
    }

    @Test
    public void givenNullTargetUnit_WhenAdded_ShouldThrowException() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertThrows(IllegalArgumentException.class, () -> QuantityMeasurementApp.add(q1, q2, null));
    }

    @Test
    public void givenLargeToSmallScale_WhenAddedWithTargetInches_ShouldReturnCorrect() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1000.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(500.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(new QuantityMeasurementApp.QuantityLength(18000.0, QuantityMeasurementApp.LengthUnit.INCH), result);
    }

    @Test
    public void givenTwelveInchesPlusTwelveInches_WhenAddedWithTargetYards_ShouldReturnPointSixSeven() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = QuantityMeasurementApp.add(q1, q2, QuantityMeasurementApp.LengthUnit.YARD);
        assertEquals(2.0 / 3.0, result.value, 1e-4);
    }




}
