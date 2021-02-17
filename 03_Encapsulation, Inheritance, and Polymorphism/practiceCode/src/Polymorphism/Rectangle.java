package Polymorphism;

public class Rectangle implements Shape{
    private double width;
    private double length;

//    public Rectangle() {
//    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
        System.out.println("Rectangle constructor was called");
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double area() {
        return getLength() * getWidth();
    }

    @Override
    public String toString() {
        return String.format("This is a %s", this.getClass().getName());
    }
}
