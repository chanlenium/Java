package PlayWithPoints;

public class Point {
    int x, y;   // variable to store points

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
