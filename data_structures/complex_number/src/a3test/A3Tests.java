package a3test;

import a3.ComplexNumber;
import a3.ComplexNumberImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class A3Tests {

    // Test axiom:
    // real(create(A,B)) =
    @Test
    public void testReal() {
        assertEquals(5.25, new ComplexNumberImpl(5.25,3.45).getReal());
    }

    // Test axiom:
    // imag(create(A,B)) = ????
    @Test
    public void testImag() {
        assertEquals(3.45, new ComplexNumberImpl(5.25,3.45).getImaginary());
    }

    // Test axiom:
    // absolute(create(A,B)) = ????
    @Test
    public void testAbsolute() {
        double a = 4.35;
        double b = 7.15;
        assertEquals((Math.sqrt(Math.pow(4.35,2) + Math.pow(7.15,2))),
                new ComplexNumberImpl(4.35,7.15).getAbsValue());
    }

    // Test axiom:
    // add(create(A,B), C) = create(A+real(C), B+imag(C))
    @Test
    public void testAdd1() {
        double a = 1.24;
        double b = 2.45;
        ComplexNumber c = new ComplexNumberImpl(3.56,4.67);
        ComplexNumber lhs = new ComplexNumberImpl(a,b).add(c);
        ComplexNumber rhs = new ComplexNumberImpl(a+c.getReal(),b+c.getImaginary());

        assertEquals(lhs.getReal(),rhs.getReal());
        assertEquals(lhs.getImaginary(),rhs.getImaginary());
    }

    // Test axiom:
    // add(C, create(A,B)) = add(create(A,B), C)
    @Test
    public void testAdd2() {
        double a = 1.24;
        double b = 2.45;
        ComplexNumber c = new ComplexNumberImpl(3.56,4.67);
        ComplexNumber lhs = c.add(new ComplexNumberImpl(a,b));
        ComplexNumber rhs = new ComplexNumberImpl(a,b).add(c);

        assertEquals(lhs.getReal(),rhs.getReal());
        assertEquals(lhs.getImaginary(),rhs.getImaginary());
    }

    // Test axiom:
    // multiply(create(A,B), C) = create((A*real(C)) - (B*imag(C)), (A*imag(C)) - (B*real(C)))
    @Test
    public void testMultiply1() {
        double a = 1.24;
        double b = 2.45;
        ComplexNumber c = new ComplexNumberImpl(3.56,4.67);
        ComplexNumber lhs = new ComplexNumberImpl(a,b).multiply(c);
        ComplexNumber rhs = new ComplexNumberImpl((a*c.getReal()) - (b*c.getImaginary()),
                (a*c.getImaginary()) + b*c.getReal());

        assertEquals(lhs.getReal(),rhs.getReal());
        assertEquals(lhs.getImaginary(),rhs.getImaginary());
    }

    // Test axiom:
    // multiply(C, create(A,B)) = multiply(create(A,B), C)
    @Test
    public void testMultiply2() {
        double a = 14.67;
        double b = 0.45;
        ComplexNumber c = new ComplexNumberImpl(1.86,10.09);
        ComplexNumber lhs = c.multiply(new ComplexNumberImpl(a,b));
        ComplexNumber rhs = new ComplexNumberImpl(a, b).multiply(c);

        assertEquals(lhs.getReal(),rhs.getReal());
        assertEquals(lhs.getImaginary(),rhs.getImaginary());
    }

    // Test axiom:
    // equals(create(A,B), C) = create(abs(a-real(c)) < epsilon)
    @Test
    public void testEquals1() {
        double a = 1.24;
        double b = 2.45;
        ComplexNumber c = new ComplexNumberImpl(3.56,4.67);
        boolean a_close_enough = (Math.abs(a - c.getReal()) < ComplexNumber.EQUALS_EPSILON);
        boolean b_close_enough = (Math.abs(b - c.getImaginary()) < ComplexNumber.EQUALS_EPSILON);
        boolean lhs = new ComplexNumberImpl(a,b).equals(c);
        boolean rhs = a_close_enough && b_close_enough;

        assertEquals(lhs,rhs);
    }

    // Test axiom:
    // equals(C, create(A,B)) = ????
    @Test
    public void testEquals2() {
        double a = 1.24;
        double b = 2.45;
        ComplexNumber c = new ComplexNumberImpl(3.56,4.67);
        boolean lhs = c.equals(new ComplexNumberImpl(a,b));
        boolean rhs = new ComplexNumberImpl(a,b).equals(c);

        assertEquals(lhs, rhs);
    }
}
