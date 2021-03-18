package shapes;

import java.text.NumberFormat;

public class Rectangle implements Shape{
    private double width, height;
    // create an object of functional interface using lambda expression
    // define "getArea(double x, double y)" method in Area interface
    // as "width * height"
    // area : reference to objects
    private Area area = (width, height) -> width * height;

    public Rectangle() {
        // no-argument constructor
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Area getArea() {
        return area;
    }

    @Override
    public double perimeter() {
        return (2*getHeight() + 2*getWidth());
    }

    public double rectangleArea(double width, double height, Area rArea){
        return rArea.getArea(width, height);    // call getArea method to calculate rectangular area
    }

    @Override
    public String toString() {
        NumberFormat df = Utils.displayFormat(perimeter());
        return this.getClass().getSimpleName() +
                " {w=" + getWidth() +
                ", h=" + getHeight() +
                "} perimeter = " + df.format(perimeter()) +
                ", area = " + String.format(df.format(rectangleArea(getWidth(), getHeight(), getArea())));
    }
}
