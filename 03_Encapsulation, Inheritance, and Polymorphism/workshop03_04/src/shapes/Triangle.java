package shapes;

import java.text.NumberFormat;

public class Triangle implements Shape{
    private double side1, side2, side3;
    private boolean isMinPerimeter;
    // Declare and initialize static variable to share among objects with Triangle class type
    // to calculate the total perimeter of all triangles
    private static double totalPerimeterOfTriangles = 0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getTotalPerimeterOfTriangles() {
        return totalPerimeterOfTriangles;
    }

    public void setTotalPerimeterOfTriangles(double totalPerimeterOfTriangles) {
        Triangle.totalPerimeterOfTriangles = totalPerimeterOfTriangles;
    }

    @Override
    public double perimeter() {
        return (getSide1() + getSide2() + getSide3());
    }

    @Override
    public String toString() {
        NumberFormat df = Utils.displayFormat(perimeter());
        return this.getClass().getSimpleName() +
                " {s1=" + getSide1() +
                ", s2=" + getSide2() +
                ", s3=" + getSide3() +
                "} perimeter = " + String.format(df.format(perimeter()));
    }
}
