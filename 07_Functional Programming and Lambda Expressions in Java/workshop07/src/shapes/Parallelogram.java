package shapes;

public class Parallelogram extends Rectangle{
    // Declare and initialize static variable to share among objects with Parallelogram class type
    // to calculate the total perimeter of all parallelograms
    private static double totalPerimeterOfParallelograms = 0;

    public Parallelogram() {
        // super();
        // no-argument constructor
        // When executing no-arg constructor of subClass, no-arg constructor of superClass is automatically called
        // So, there should be no-argument constructor in the super class(Rectangular class)
    }

    public Parallelogram(double height, double width) {
        super(height, width);
    }

    public double getTotalParallelograms() {
        return totalPerimeterOfParallelograms;
    }

    public void setTotalParallelograms(double totalParallelograms) {
        Parallelogram.totalPerimeterOfParallelograms = totalParallelograms;
    }
}
