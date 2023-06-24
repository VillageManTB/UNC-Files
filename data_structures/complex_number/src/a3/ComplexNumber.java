package a3;

public interface ComplexNumber {
    double getReal();
    double getImaginary();
    double getAbsValue();
    ComplexNumber multiply(ComplexNumber other);
    ComplexNumber add(ComplexNumber other);
    boolean equals(ComplexNumber other);

    final static double EQUALS_EPSILON = 2 * Double.MIN_VALUE;
    final static ComplexNumber I = new ComplexNumberImpl(0.0, 1.0);
}
