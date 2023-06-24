package a3;

public class ComplexNumberImpl implements ComplexNumber {

    // Fields go here.
    private double _real;
    private double _imag;

    // Constructor
    public ComplexNumberImpl(double real,double imag) {
        this._real = real;
        this._imag = imag;
    }

    @Override
    public double getReal() {
        return _real;
    }

    @Override
    public double getImaginary() {
        return _imag;
    }

    @Override
    public double getAbsValue() {
        return Math.sqrt(Math.pow(_real,2) + Math.pow(_imag,2));
    }

    @Override
    public boolean equals(ComplexNumber other) {
        boolean real_close_enough = (Math.abs(getReal() - other.getReal()) < EQUALS_EPSILON);
        boolean imag_close_enough = (Math.abs(getImaginary() - other.getImaginary()) < EQUALS_EPSILON);

        return (real_close_enough && imag_close_enough);
    }

    @Override
    public ComplexNumber add(ComplexNumber other) {
        double real = getReal()+other.getReal();
        double imag = getImaginary()+other.getImaginary();
        return new ComplexNumberImpl(real, imag);
    }

    @Override
    public ComplexNumber multiply(ComplexNumber other) {
        double real = (getReal()*other.getReal()) - (getImaginary()*other.getImaginary());
        double imag = (getReal()*other.getImaginary()) + (getImaginary()*other.getReal());
        return new ComplexNumberImpl(real, imag);
    }

    // Instance methods go here.
}
