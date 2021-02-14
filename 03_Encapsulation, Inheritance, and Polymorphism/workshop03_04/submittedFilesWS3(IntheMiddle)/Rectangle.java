package shapes;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Rectangle implements Shape{
    private double width, height;

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

    @Override
    public double perimeter() {
        return (2*getHeight() + 2*getWidth());
    }

    @Override
    public String toString() {
        NumberFormat df = Utils.displayFormat(perimeter());
        return this.getClass().getSimpleName() +
                " {w=" + getWidth() +
                ", h=" + getHeight() +
                "} perimeter = " + df.format(perimeter());
    }
}
