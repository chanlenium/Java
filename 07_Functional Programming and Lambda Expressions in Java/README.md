# Workshop 07 : Functional Programming and Lambda Expressions

## Objectives
* Familiar with Functional Programming (Functional Interface)
* Implement abstract method as data using Lambda Expressions

## Outline
### Define a functional interface
```
@FunctionalInterface
public interface Area {
    double getArea(double x, double y); // abstract method
}
```
### Create an object of the interface
* Implement an abstract method using lambda expression and allocate it to reference variable `area`
```
public class Circle implements Shape{
    private double radius;
    // define "getArea(double x, double y)" method in Area interface as "Math.PI * realRadius * realRadius"
    private Area area = (realRadius, fakeRadius) -> Math.PI * realRadius * realRadius;

    public Area getArea() {
        return area;
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

```

## Screenshot
* Link : https://github.com/chanlenium/Java/blob/main/03_Encapsulation%2C%20Inheritance%2C%20and%20Polymorphism/screenshot.pdf
