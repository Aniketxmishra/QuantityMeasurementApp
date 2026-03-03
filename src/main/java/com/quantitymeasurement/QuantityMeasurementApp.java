package com.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet feet = (Feet) obj;
            return Double.compare(this.value, feet.value) == 0;
        }
    }

    public static class Inch {
        private final double value;

        public Inch(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Inch inch = (Inch) obj;
            return Double.compare(this.value, inch.value) == 0;
        }
    }

    public static boolean compareFeet(double a, double b) {
        return new Feet(a).equals(new Feet(b));
    }

    public static boolean compareInch(double a, double b) {
        return new Inch(a).equals(new Inch(b));
    }

    public static void main(String[] args) {
        System.out.println("Feet equal? " + compareFeet(1.0, 1.0));
        System.out.println("Inch equal? " + compareInch(1.0, 1.0));
    }
}
