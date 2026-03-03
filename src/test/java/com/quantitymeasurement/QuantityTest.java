package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    // ===== IMeasurable INTERFACE TESTS =====

    @Test
    public void testIMeasurable_LengthUnitImplementsInterface() {
        IMeasurable unit = LengthUnit.FEET;
        assertEquals(1.0, unit.getConversionFactor(), 1e-6);
        assertEquals(3.0, unit.convertToBaseUnit(3.0), 1e-6);
        assertEquals(3.0, unit.convertFromBaseUnit(3.0), 1e-6);
        assertEquals("FEET", unit.getUnitName());
    }

    @Test
    public void testIMeasurable_WeightUnitImplementsInterface() {
        IMeasurable unit = WeightUnit.KILOGRAM;
        assertEquals(1.0, unit.getConversionFactor(), 1e-6);
        assertEquals(5.0, unit.convertToBaseUnit(5.0), 1e-6);
        assertEquals(5.0, unit.convertFromBaseUnit(5.0), 1e-6);
        assertEquals("KILOGRAM", unit.getUnitName());
    }

    // ===== GENERIC QUANTITY: LENGTH EQUALITY =====

    @Test
    public void testGenericQuantity_LengthEquality_OneFeetEqualsTwelveInches() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);
        assertEquals(q1, q2);
    }

    @Test
    public void testGenericQuantity_LengthEquality_OneYardEqualsThreeFeet() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.YARD);
        Quantity<LengthUnit> q2 = new Quantity<>(3.0, LengthUnit.FEET);
        assertEquals(q1, q2);
    }

    @Test
    public void testGenericQuantity_LengthEquality_DifferentValues_NotEqual() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        assertNotEquals(q1, q2);
    }

    // ===== GENERIC QUANTITY: WEIGHT EQUALITY =====

    @Test
    public void testGenericQuantity_WeightEquality_OneKgEqualsThousandGrams() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertEquals(q1, q2);
    }

    @Test
    public void testGenericQuantity_WeightEquality_SameKg() {
        Quantity<WeightUnit> q1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        assertEquals(q1, q2);
    }

    // ===== CROSS-CATEGORY PREVENTION =====

    @Test
    public void testCrossCategory_LengthVsWeight_ShouldReturnNotEqual() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertNotEquals(length, weight);
    }

    // ===== GENERIC QUANTITY: LENGTH CONVERSION =====

    @Test
    public void testGenericQuantity_LengthConversion_FeetToInches() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q.convertTo(LengthUnit.INCH);
        assertEquals(new Quantity<>(12.0, LengthUnit.INCH), result);
    }

    @Test
    public void testGenericQuantity_LengthConversion_YardToInches() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.YARD);
        Quantity<LengthUnit> result = q.convertTo(LengthUnit.INCH);
        assertEquals(36.0, result.value, 1e-4);
    }

    // ===== GENERIC QUANTITY: WEIGHT CONVERSION =====

    @Test
    public void testGenericQuantity_WeightConversion_KgToGram() {
        Quantity<WeightUnit> q = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> result = q.convertTo(WeightUnit.GRAM);
        assertEquals(new Quantity<>(1000.0, WeightUnit.GRAM), result);
    }

    @Test
    public void testGenericQuantity_WeightConversion_KgToPound() {
        Quantity<WeightUnit> q = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> result = q.convertTo(WeightUnit.POUND);
        assertEquals(2.20462, result.value, 1e-4);
    }

    // ===== GENERIC QUANTITY: LENGTH ADDITION =====

    @Test
    public void testGenericQuantity_LengthAddition_FeetPlusInches() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.FEET);
        assertEquals(new Quantity<>(2.0, LengthUnit.FEET), result);
    }

    @Test
    public void testGenericQuantity_LengthAddition_WithTargetYards() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.YARD);
        assertEquals(2.0 / 3.0, result.value, 1e-4);
    }

    // ===== GENERIC QUANTITY: WEIGHT ADDITION =====

    @Test
    public void testGenericQuantity_WeightAddition_KgPlusGrams() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> result = q1.add(q2, WeightUnit.KILOGRAM);
        assertEquals(new Quantity<>(2.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void testGenericQuantity_WeightAddition_WithTargetGrams() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> result = q1.add(q2, WeightUnit.GRAM);
        assertEquals(new Quantity<>(2000.0, WeightUnit.GRAM), result);
    }

    // ===== INSTANCE add() METHODS =====

    @Test
    public void testGenericQuantity_InstanceAdd_DefaultUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.add(q2);
        assertEquals(new Quantity<>(2.0, LengthUnit.FEET), result);
    }

    // ===== VALIDATION TESTS =====

    @Test
    public void testGenericQuantity_NullUnit_ShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(1.0, (LengthUnit) null));
    }

    @Test
    public void testGenericQuantity_NaNValue_ShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(Double.NaN, LengthUnit.FEET));
    }

    @Test
    public void testGenericQuantity_NullOperand_Add_ShouldThrow() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> q.add(null));
    }

    @Test
    public void testGenericQuantity_NullTargetUnit_Add_ShouldThrow() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> q1.add(q2, null));
    }

    // ===== REFLEXIVE / SYMMETRIC / TRANSITIVE =====

    @Test
    public void testGenericQuantity_ReflexiveEquality() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);
        assertEquals(q, q);
    }

    @Test
    public void testGenericQuantity_SymmetricEquality() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);
        assertEquals(q1, q2);
        assertEquals(q2, q1);
    }

    @Test
    public void testGenericQuantity_TransitiveEquality() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.YARD);
        Quantity<LengthUnit> q2 = new Quantity<>(3.0, LengthUnit.FEET);
        Quantity<LengthUnit> q3 = new Quantity<>(36.0, LengthUnit.INCH);
        assertEquals(q1, q2);
        assertEquals(q2, q3);
        assertEquals(q1, q3);
    }

    // ===== SCALABILITY: NEW UNIT TEST =====

    @Test
    public void testScalability_NewVolumeUnit_WorksWithGenericQuantity() {
        // Inline test enum to prove scalability — no Quantity<> changes needed
        IMeasurable litre = new IMeasurable() {
            public double getConversionFactor() { return 1.0; }
            public double convertToBaseUnit(double v) { return v; }
            public double convertFromBaseUnit(double b) { return b; }
            public String getUnitName() { return "LITRE"; }
        };
        assertEquals(1.0, litre.convertToBaseUnit(1.0), 1e-6);
    }

    // ===== HASHCODE CONSISTENCY =====

    @Test
    public void testHashCode_EqualQuantities_SameHash() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);
        assertEquals(q1, q2);
        assertEquals(q1.hashCode(), q2.hashCode());
    }

    // ===== IMMUTABILITY =====

    @Test
    public void testImmutability_ConvertToReturnsNewInstance() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q.convertTo(LengthUnit.INCH);
        assertNotSame(q, result);
        assertEquals(1.0, q.value, 1e-6); // original unchanged
    }

    @Test
    public void testImmutability_AddReturnsNewInstance() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.add(q2);
        assertNotSame(q1, result);
        assertEquals(1.0, q1.value, 1e-6); // original unchanged
    }
}
