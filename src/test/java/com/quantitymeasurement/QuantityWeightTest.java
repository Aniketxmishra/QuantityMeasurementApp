package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityWeightTest {

    // ========== EQUALITY TESTS ==========

    @Test
    public void givenSameKilogramValue_WhenCompared_ShouldReturnEqual() {
        assertEquals(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityWeight(1.0, WeightUnit.KILOGRAM));
    }

    @Test
    public void givenDifferentKilogramValue_WhenCompared_ShouldReturnNotEqual() {
        assertNotEquals(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityWeight(2.0, WeightUnit.KILOGRAM));
    }

    @Test
    public void givenSameGramValue_WhenCompared_ShouldReturnEqual() {
        assertEquals(new QuantityWeight(500.0, WeightUnit.GRAM), new QuantityWeight(500.0, WeightUnit.GRAM));
    }

    @Test
    public void givenSamePoundValue_WhenCompared_ShouldReturnEqual() {
        assertEquals(new QuantityWeight(2.0, WeightUnit.POUND), new QuantityWeight(2.0, WeightUnit.POUND));
    }

    @Test
    public void givenOneKilogram_WhenComparedToThousandGrams_ShouldReturnEqual() {
        assertEquals(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityWeight(1000.0, WeightUnit.GRAM));
    }

    @Test
    public void givenThousandGrams_WhenComparedToOneKilogram_ShouldReturnEqual() {
        assertEquals(new QuantityWeight(1000.0, WeightUnit.GRAM), new QuantityWeight(1.0, WeightUnit.KILOGRAM));
    }

    @Test
    public void givenOneKilogram_WhenComparedToTwoPointTwoPounds_ShouldReturnEqual() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(2.20462, WeightUnit.POUND);
        assertEquals(w1.toBaseUnit(), w2.toBaseUnit(), 1e-4);
    }


    @Test
    public void givenFourFiveFourGrams_WhenComparedToOnePound_ShouldReturnEqual() {
        QuantityWeight w1 = new QuantityWeight(453.592, WeightUnit.GRAM);
        QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.POUND);
        assertEquals(w1.toBaseUnit(), w2.toBaseUnit(), 1e-4);
    }


    @Test
    public void givenZeroKilogram_WhenComparedToZeroGram_ShouldReturnEqual() {
        assertEquals(new QuantityWeight(0.0, WeightUnit.KILOGRAM), new QuantityWeight(0.0, WeightUnit.GRAM));
    }

    @Test
    public void givenNegativeKilogram_WhenComparedToNegativeGram_ShouldReturnEqual() {
        assertEquals(new QuantityWeight(-1.0, WeightUnit.KILOGRAM), new QuantityWeight(-1000.0, WeightUnit.GRAM));
    }

    @Test
    public void givenLargeGramValue_WhenComparedToKilogram_ShouldReturnEqual() {
        assertEquals(new QuantityWeight(1000000.0, WeightUnit.GRAM), new QuantityWeight(1000.0, WeightUnit.KILOGRAM));
    }

    @Test
    public void givenSmallKilogramValue_WhenComparedToGram_ShouldReturnEqual() {
        assertEquals(new QuantityWeight(0.001, WeightUnit.KILOGRAM), new QuantityWeight(1.0, WeightUnit.GRAM));
    }

    @Test
    public void givenSameReference_WhenCompared_ShouldReturnEqual() {
        QuantityWeight w = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertSame(w, w);
    }

    @Test
    public void givenNullComparison_ShouldReturnNotEqual() {
        assertNotEquals(null, new QuantityWeight(1.0, WeightUnit.KILOGRAM));
    }

    @Test
    public void givenNullUnit_WhenCreated_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new QuantityWeight(1.0, null));
    }

    @Test
    public void givenNaNValue_WhenCreated_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new QuantityWeight(Double.NaN, WeightUnit.KILOGRAM));
    }

    @Test
    public void givenWeightComparedToLength_ShouldReturnNotEqual() {
        QuantityWeight w = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityMeasurementApp.QuantityLength l = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        assertNotEquals(w, l);
    }

    // ========== CONVERSION TESTS ==========

    @Test
    public void givenOneKilogram_WhenConvertedToGram_ShouldReturnThousand() {
        QuantityWeight result = new QuantityWeight(1.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.GRAM);
        assertEquals(new QuantityWeight(1000.0, WeightUnit.GRAM), result);
    }

    @Test
    public void givenTwoPounds_WhenConvertedToKilogram_ShouldReturnPointNine() {
        QuantityWeight result = new QuantityWeight(2.0, WeightUnit.POUND).convertTo(WeightUnit.KILOGRAM);
        assertEquals(0.907184, result.value, 1e-4);
    }

    @Test
    public void givenFiveHundredGrams_WhenConvertedToPound_ShouldReturnApproxOne() {
        QuantityWeight result = new QuantityWeight(500.0, WeightUnit.GRAM).convertTo(WeightUnit.POUND);
        assertEquals(1.10231, result.value, 1e-4);
    }

    @Test
    public void givenOneKilogram_WhenConvertedToPound_ShouldReturnTwoPointTwo() {
        QuantityWeight result = new QuantityWeight(1.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.POUND);
        assertEquals(2.20462, result.value, 1e-4);
    }

    @Test
    public void givenSameUnit_WhenConverted_ShouldReturnSameValue() {
        QuantityWeight result = new QuantityWeight(5.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.KILOGRAM);
        assertEquals(new QuantityWeight(5.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void givenZeroKilogram_WhenConvertedToGram_ShouldReturnZero() {
        QuantityWeight result = new QuantityWeight(0.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.GRAM);
        assertEquals(new QuantityWeight(0.0, WeightUnit.GRAM), result);
    }

    @Test
    public void givenNegativeKilogram_WhenConvertedToGram_ShouldReturnNegative() {
        QuantityWeight result = new QuantityWeight(-1.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.GRAM);
        assertEquals(new QuantityWeight(-1000.0, WeightUnit.GRAM), result);
    }

    @Test
    public void givenRoundTripConversion_ShouldPreserveValue() {
        QuantityWeight result = new QuantityWeight(1.5, WeightUnit.KILOGRAM)
                .convertTo(WeightUnit.GRAM)
                .convertTo(WeightUnit.KILOGRAM);
        assertEquals(1.5, result.value, 1e-6);
    }

    // ========== ADDITION TESTS ==========

    @Test
    public void givenOneKgPlusTwoKg_WhenAdded_ShouldReturnThreeKg() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(2.0, WeightUnit.KILOGRAM));
        assertEquals(new QuantityWeight(3.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void givenOneKgPlusThousandGrams_WhenAdded_ShouldReturnTwoKg() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1000.0, WeightUnit.GRAM));
        assertEquals(new QuantityWeight(2.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void givenFiveHundredGramsPlusHalfKg_WhenAdded_ShouldReturnThousandGrams() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(500.0, WeightUnit.GRAM),
                new QuantityWeight(0.5, WeightUnit.KILOGRAM));
        assertEquals(new QuantityWeight(1000.0, WeightUnit.GRAM), result);
    }

    @Test
    public void givenFiveKgPlusZeroGrams_WhenAdded_ShouldReturnFiveKg() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(5.0, WeightUnit.KILOGRAM),
                new QuantityWeight(0.0, WeightUnit.GRAM));
        assertEquals(new QuantityWeight(5.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void givenFiveKgPlusNegativeTwoKg_WhenAdded_ShouldReturnThreeKg() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(5.0, WeightUnit.KILOGRAM),
                new QuantityWeight(-2.0, WeightUnit.KILOGRAM));
        assertEquals(new QuantityWeight(3.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void givenLargeValues_WhenAdded_ShouldReturnCorrectSum() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(1e6, WeightUnit.KILOGRAM),
                new QuantityWeight(1e6, WeightUnit.KILOGRAM));
        assertEquals(new QuantityWeight(2e6, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void givenNullOperand_WhenAdded_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityWeight.add(new QuantityWeight(1.0, WeightUnit.KILOGRAM), null));
    }

    // ========== ADDITION WITH TARGET UNIT ==========

    @Test
    public void givenOneKgPlusThousandGrams_WhenAddedWithTargetGram_ShouldReturnTwoThousandGrams() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1000.0, WeightUnit.GRAM),
                WeightUnit.GRAM);
        assertEquals(new QuantityWeight(2000.0, WeightUnit.GRAM), result);
    }

    @Test
    public void givenTwoKgPlusFourPounds_WhenAddedWithTargetKg_ShouldReturnCorrect() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(2.0, WeightUnit.KILOGRAM),
                new QuantityWeight(4.0, WeightUnit.POUND),
                WeightUnit.KILOGRAM);
        assertEquals(2.0 + 4.0 * 0.453592, result.value, 1e-4);
    }

    @Test
    public void givenAdditionWithTargetUnit_ShouldBeCommutative() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight r1 = QuantityWeight.add(q1, q2, WeightUnit.GRAM);
        QuantityWeight r2 = QuantityWeight.add(q2, q1, WeightUnit.GRAM);
        assertEquals(r1, r2);
    }

    @Test
    public void givenNullTargetUnit_WhenAdded_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityWeight.add(
                        new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                        new QuantityWeight(1000.0, WeightUnit.GRAM),
                        null));
    }

    // ========== WeightUnit ENUM TESTS ==========

    @Test
    public void testWeightUnit_KilogramConversionFactor() {
        assertEquals(1.0, WeightUnit.KILOGRAM.getConversionFactor(), 1e-6);
    }

    @Test
    public void testWeightUnit_GramConversionFactor() {
        assertEquals(0.001, WeightUnit.GRAM.getConversionFactor(), 1e-6);
    }

    @Test
    public void testWeightUnit_PoundConversionFactor() {
        assertEquals(0.453592, WeightUnit.POUND.getConversionFactor(), 1e-6);
    }

    @Test
    public void testConvertToBaseUnit_GramToKilogram() {
        assertEquals(1.0, WeightUnit.GRAM.convertToBaseUnit(1000.0), 1e-6);
    }

    @Test
    public void testConvertFromBaseUnit_KilogramToGram() {
        assertEquals(1000.0, WeightUnit.GRAM.convertFromBaseUnit(1.0), 1e-6);
    }

    @Test
    public void testConvertFromBaseUnit_KilogramToPound() {
        assertEquals(2.20462, WeightUnit.POUND.convertFromBaseUnit(1.0), 1e-4);
    }
}
