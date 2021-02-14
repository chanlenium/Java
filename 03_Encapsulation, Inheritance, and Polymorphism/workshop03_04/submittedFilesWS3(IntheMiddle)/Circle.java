package shapes;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Circle implements Shape{
    //public static final double PI = 3.14;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return (2 * Math.PI * getRadius());
    }

    @Override
    public String toString() {
        NumberFormat df = Utils.displayFormat(perimeter());
        return this.getClass().getSimpleName() +
                " {r=" + getRadius() +
                "} perimeter = " + String.format(df.format(perimeter()));
    }
}
