package PlayWithPoints;

public class PlayWithThings<T> {
    public T[] things;

    public void forEach(Action<T> action){
        for(T t : things)
            action.change(t);
    }

    @Override
    public String toString() {
        String result = "";
        for(T t : things)
            result += t.getClass().getName() + ": " + t.toString() + "\n";
        return result;
    }

    public static void main(String[] args) {
        PlayWithThings<Point> playWithThings = new PlayWithThings<>();
        // initialize array reference 'things' by constructing two PlayWithPoints.Point components
        playWithThings.things = new Point[]{new Point(0,0), new Point(1,1)};

        // forEach takes as arguments PlayWithPoints.Action<T> object
        // PlayWithPoints.Action<T> is an interface; you can create an object of type PlayWithPoints.Action<T>
        // if there is a class that implements PlayWithPoints.Action<T> OR
        // if you build an instance of this class as an anonymous class OR
        // if you use lambda expressions
        // here are the possible implementations:

//        // Implementation 1 : class that implements PlayWithPoints.Action<T>
//        class MoveAction<T extends PlayWithPoints.Point> implements PlayWithPoints.Action<T>{
//            @Override
//            public void change(T t) {
//                t.move(10, 10);
//            }
//        }
//        // MoveAction<PlayWithPoints.Point> innerClassImp = new MoveAction<>();
//        // innerClassImp.forEach(innerClassImp);
//
//        // Implementation 2 : build an instance of this class as an anonymous class
//        playWithThings.forEach(new PlayWithPoints.Action<PlayWithPoints.Point>() {
//            @Override
//            public void change(PlayWithPoints.Point point) {
//                point.move(10, 10);
//            }
//        });

        // Implementation 3 : lambda expressions
        playWithThings.forEach((Point point) -> {   // pass PlayWithPoints.Point as a generic T
            point.move(10, 10);});

        System.out.println(playWithThings);
    }
}
