package shapes;

import java.text.NumberFormat;

public class Square extends Rectangle{
    public Square(double side) {
        super(side, side);
    }

    @Override
    public String toString() {
        NumberFormat df = Utils.displayFormat(perimeter());
        return this.getClass().getSimpleName() +
                " {s=" + getHeight() +
                "} perimeter = " + df.format(perimeter()) +
                ", area = " + String.format(df.format(rectangleArea(getWidth(), getHeight(), getArea())));
    }
}
