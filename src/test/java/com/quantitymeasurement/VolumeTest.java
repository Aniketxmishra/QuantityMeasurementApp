package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VolumeTest {

    private static final double EPSILON = 1e-4;

    // ===== EQUALITY =====
    @Test void testEquality_LitreToLitre_SameValue() {
        assertEquals(new Quantity<>(1.0, VolumeUnit.LITRE), new Quantity<>(1.0, VolumeUnit.LITRE));
    }
    @Test void testEquality_LitreToLitre_DifferentValue() {
        assertNotEquals(new Quantity<>(1.0, VolumeUnit.LITRE), new Quantity<>(2.0, VolumeUnit.LITRE));
    }
    @Test void testEquality_MillilitreToMillilitre_SameValue() {
        assertEquals(new Quantity<>(500.0, VolumeUnit.MILLILITRE), new Quantity<>(500.0, VolumeUnit.MILLILITRE));
    }
    @Test void testEquality_GallonToGallon_SameValue() {
        assertEquals(new Quantity<>(2.0, VolumeUnit.GALLON), new Quantity<>(2.0, VolumeUnit.GALLON));
    }
    @Test void testEquality_LitreToMillilitre_Equivalent() {
        assertEquals(new Quantity<>(1.0, VolumeUnit.LITRE), new Quantity<>(1000.0, VolumeUnit.MILLILITRE));
    }
    @Test void testEquality_MillilitreToLitre_Equivalent() {
        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), new Quantity<>(1.0, VolumeUnit.LITRE));
    }
    @Test void testEquality_GallonToLitre_Equivalent() {
        assertEquals(new Quantity<>(1.0, VolumeUnit.GALLON), new Quantity<>(3.78541, VolumeUnit.LITRE));
    }
    @Test void testEquality_LitreToGallon_Equivalent() {
        assertEquals(new Quantity<>(3.78541, VolumeUnit.LITRE), new Quantity<>(1.0, VolumeUnit.GALLON));
    }
    @Test void testEquality_ZeroValue() {
        assertEquals(new Quantity<>(0.0, VolumeUnit.LITRE), new Quantity<>(0.0, VolumeUnit.MILLILITRE));
    }
    @Test void testEquality_NegativeVolume() {
        assertEquals(new Quantity<>(-1.0, VolumeUnit.LITRE), new Quantity<>(-1000.0, VolumeUnit.MILLILITRE));
    }
    @Test void testEquality_LargeVolumeValue() {
        assertEquals(new Quantity<>(1000000.0, VolumeUnit.MILLILITRE), new Quantity<>(1000.0, VolumeUnit.LITRE));
    }
    @Test void testEquality_SmallVolumeValue() {
        assertEquals(new Quantity<>(0.001, VolumeUnit.LITRE), new Quantity<>(1.0, VolumeUnit.MILLILITRE));
    }
    @Test void testEquality_SameReference() {
        Quantity<VolumeUnit> q = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertEquals(q, q);
    }
    @Test void testEquality_NullComparison() {
        assertNotEquals(new Quantity<>(1.0, VolumeUnit.LITRE), null);
    }
    @Test void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(1.0, null));
    }
    @Test void testEquality_VolumeVsLength_Incompatible() {
        assertNotEquals(new Quantity<>(1.0, VolumeUnit.LITRE), new Quantity<>(1.0, LengthUnit.FEET));
    }
    @Test void testEquality_VolumeVsWeight_Incompatible() {
        assertNotEquals(new Quantity<>(1.0, VolumeUnit.LITRE), new Quantity<>(1.0, WeightUnit.KILOGRAM));
    }

    // ===== CONVERSION =====
    @Test void testConversion_LitreToMillilitre() {
        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE),
                new Quantity<>(1.0, VolumeUnit.LITRE).convertTo(VolumeUnit.MILLILITRE));
    }
    @Test void testConversion_MillilitreToLitre() {
        assertEquals(new Quantity<>(1.0, VolumeUnit.LITRE),
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE).convertTo(VolumeUnit.LITRE));
    }
    @Test void testConversion_GallonToLitre() {
        assertEquals(new Quantity<>(3.78541, VolumeUnit.LITRE),
                new Quantity<>(1.0, VolumeUnit.GALLON).convertTo(VolumeUnit.LITRE));
    }
    @Test void testConversion_LitreToGallon() {
        assertEquals(new Quantity<>(1.0, VolumeUnit.GALLON),
                new Quantity<>(3.78541, VolumeUnit.LITRE).convertTo(VolumeUnit.GALLON));
    }
    @Test void testConversion_MillilitreToGallon() {
        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE).convertTo(VolumeUnit.GALLON),
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE).convertTo(VolumeUnit.GALLON));
    }
    @Test void testConversion_SameUnit() {
        assertEquals(new Quantity<>(5.0, VolumeUnit.LITRE),
                new Quantity<>(5.0, VolumeUnit.LITRE).convertTo(VolumeUnit.LITRE));
    }
    @Test void testConversion_ZeroValue() {
        assertEquals(new Quantity<>(0.0, VolumeUnit.MILLILITRE),
                new Quantity<>(0.0, VolumeUnit.LITRE).convertTo(VolumeUnit.MILLILITRE));
    }
    @Test void testConversion_NegativeValue() {
        assertEquals(new Quantity<>(-1000.0, VolumeUnit.MILLILITRE),
                new Quantity<>(-1.0, VolumeUnit.LITRE).convertTo(VolumeUnit.MILLILITRE));
    }
    @Test void testConversion_RoundTrip() {
        assertEquals(new Quantity<>(1.5, VolumeUnit.LITRE),
                new Quantity<>(1.5, VolumeUnit.LITRE).convertTo(VolumeUnit.MILLILITRE).convertTo(VolumeUnit.LITRE));
    }

    // ===== ADDITION =====
    @Test void testAddition_SameUnit_LitrePlusLitre() {
        assertEquals(new Quantity<>(3.0, VolumeUnit.LITRE),
                new Quantity<>(1.0, VolumeUnit.LITRE).add(new Quantity<>(2.0, VolumeUnit.LITRE)));
    }
    @Test void testAddition_SameUnit_MillilitrePlusMillilitre() {
        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE),
                new Quantity<>(500.0, VolumeUnit.MILLILITRE).add(new Quantity<>(500.0, VolumeUnit.MILLILITRE)));
    }
    @Test void testAddition_CrossUnit_LitrePlusMillilitre() {
        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE),
                new Quantity<>(1.0, VolumeUnit.LITRE).add(new Quantity<>(1000.0, VolumeUnit.MILLILITRE)));
    }
    @Test void testAddition_CrossUnit_MillilitrePlusLitre() {
        assertEquals(new Quantity<>(2000.0, VolumeUnit.MILLILITRE),
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE).add(new Quantity<>(1.0, VolumeUnit.LITRE)));
    }
    @Test void testAddition_CrossUnit_GallonPlusLitre() {
        assertEquals(new Quantity<>(2.0, VolumeUnit.GALLON),
                new Quantity<>(1.0, VolumeUnit.GALLON).add(new Quantity<>(3.78541, VolumeUnit.LITRE)));
    }
    @Test void testAddition_ExplicitTargetUnit_Millilitre() {
        assertEquals(new Quantity<>(2000.0, VolumeUnit.MILLILITRE),
                new Quantity<>(1.0, VolumeUnit.LITRE).add(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), VolumeUnit.MILLILITRE));
    }
    @Test void testAddition_ExplicitTargetUnit_Gallon() {
        assertEquals(new Quantity<>(2.0, VolumeUnit.GALLON),
                new Quantity<>(3.78541, VolumeUnit.LITRE).add(new Quantity<>(3.78541, VolumeUnit.LITRE), VolumeUnit.GALLON));
    }
    @Test void testAddition_WithZero() {
        assertEquals(new Quantity<>(5.0, VolumeUnit.LITRE),
                new Quantity<>(5.0, VolumeUnit.LITRE).add(new Quantity<>(0.0, VolumeUnit.MILLILITRE)));
    }
    @Test void testAddition_NegativeValues() {
        assertEquals(new Quantity<>(3.0, VolumeUnit.LITRE),
                new Quantity<>(5.0, VolumeUnit.LITRE).add(new Quantity<>(-2000.0, VolumeUnit.MILLILITRE)));
    }
    @Test void testAddition_LargeValues() {
        assertEquals(new Quantity<>(2e6, VolumeUnit.LITRE),
                new Quantity<>(1e6, VolumeUnit.LITRE).add(new Quantity<>(1e6, VolumeUnit.LITRE)));
    }

    // ===== ENUM METHODS =====
    @Test void testVolumeUnit_LitreConversionFactor() {
        assertEquals(1.0, VolumeUnit.LITRE.getConversionFactor());
    }
    @Test void testVolumeUnit_MillilitreConversionFactor() {
        assertEquals(0.001, VolumeUnit.MILLILITRE.getConversionFactor());
    }
    @Test void testVolumeUnit_GallonConversionFactor() {
        assertEquals(3.78541, VolumeUnit.GALLON.getConversionFactor(), EPSILON);
    }
    @Test void testConvertToBaseUnit_MillilitreToLitre() {
        assertEquals(1.0, VolumeUnit.MILLILITRE.convertToBaseUnit(1000.0), EPSILON);
    }
    @Test void testConvertToBaseUnit_GallonToLitre() {
        assertEquals(3.78541, VolumeUnit.GALLON.convertToBaseUnit(1.0), EPSILON);
    }
    @Test void testConvertFromBaseUnit_LitreToMillilitre() {
        assertEquals(1000.0, VolumeUnit.MILLILITRE.convertFromBaseUnit(1.0), EPSILON);
    }
    @Test void testConvertFromBaseUnit_LitreToGallon() {
        assertEquals(1.0, VolumeUnit.GALLON.convertFromBaseUnit(3.78541), EPSILON);
    }
}
