package shapes;

import java.text.NumberFormat;

public class Circle implements Shape{
    private double radius;
    // create an object and functional interface using lambda expression
    // define "getArea(double x, double y)" method in Area interface
    // as "Math.PI * realRadius * fakeRadius"
    private Area area = (realRadius, fakeRadius) -> Math.PI * realRadius * realRadius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }   // constructor

    public double getRadius() {
        return radius;
    }

    public Area getArea() {
        return area;
    }

    @Override
    public double perimeter() {
        return (2 * Math.PI * getRadius());
    }

    public double circleArea(double radius, Area cArea){
        return cArea.getArea(radius, radius);   // call getArea method to calculate circle area
    }

    @Override
    public String toString() {
        NumberFormat df = Utils.displayFormat(perimeter());
        return this.getClass().getSimpleName() +
                " {r=" + getRadius() +
                "} perimeter = " + String.format(df.format(perimeter())) +
                ", area = " + String.format(df.format(circleArea(getRadius(), getArea())));
    }
}
