package com.quantitymeasurement;

import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends IMeasurable> {

    private static final double EPSILON = 1e-4;

    final double value;
    final U unit;

    // ===== PRIVATE ENUM: ArithmeticOperation (Lambda approach) =====
    private enum ArithmeticOperation {
        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        DIVIDE((a, b) -> {
            if (b == 0.0) throw new ArithmeticException("Cannot divide by zero");
            return a / b;
        });

        private final DoubleBinaryOperator operator;

        ArithmeticOperation(DoubleBinaryOperator operator) {
            this.operator = operator;
        }

        public double compute(double a, double b) {
            return operator.applyAsDouble(a, b);
        }
    }

    public Quantity(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    // ===== PRIVATE: Centralized Validation =====
    private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean targetUnitRequired) {
        if (other == null) throw new IllegalArgumentException("Operand cannot be null");
        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cannot perform arithmetic on different measurement categories");
        if (!Double.isFinite(this.value) || !Double.isFinite(other.value))
            throw new IllegalArgumentException("Values must be finite");
        if (targetUnitRequired && targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
    }

    // ===== PRIVATE: Centralized Arithmetic =====
    private double performBaseArithmetic(Quantity<U> other, ArithmeticOperation operation) {
        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = other.unit.convertToBaseUnit(other.value);
        return operation.compute(thisBase, otherBase);
    }

    private static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    // ===== PUBLIC: convertTo =====
    public Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double converted = targetUnit.convertFromBaseUnit(this.toBaseUnit());
        return new Quantity<>(converted, targetUnit);
    }

    // ===== PUBLIC: Addition =====
    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);
        double resultBase = performBaseArithmetic(other, ArithmeticOperation.ADD);
        return new Quantity<>(targetUnit.convertFromBaseUnit(resultBase), targetUnit);
    }

    // ===== PUBLIC: Subtraction =====
    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);
        double resultBase = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
        return new Quantity<>(roundToTwoDecimals(targetUnit.convertFromBaseUnit(resultBase)), targetUnit);
    }

    // ===== PUBLIC: Division =====
    public double divide(Quantity<U> other) {
        validateArithmeticOperands(other, null, false);
        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Quantity<?> other = (Quantity<?>) obj;
        if (this.unit.getClass() != other.unit.getClass()) return false;
        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(Math.round(toBaseUnit() / EPSILON) * EPSILON);
        return (int) (bits ^ (bits >>> 32));
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}
