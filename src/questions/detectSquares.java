package questions;

import java.util.*;

public class detectSquares {

    class solveDetectSquares{
        class Point{
            int x;
            int y;
            public Point(int x, int y){
                this.x = x;
                this.y = y;
            }
        }

        HashMap<Integer, List<Point>> xPoints = new HashMap<>();
        HashMap<Integer, List<Point>> yPoints = new HashMap<>();

        Set<String> uniquePoint = new HashSet<>();

        public solveDetectSquares() {

        }

        public void add(int[] point) {
            Point p = new Point(point[0], point[1]);
            List<Point> x = xPoints.getOrDefault(point[0], new LinkedList<>());
            x.add(p);
            xPoints.put(p.x,x);
            List<Point> y = yPoints.getOrDefault(point[1], new LinkedList<>());
            y.add(p);
            yPoints.put(p.y,y);
            uniquePoint.add(p.x+","+p.y);
        }

        public int count(int[] point) {
            List<Point> x = xPoints.getOrDefault(point[0], new LinkedList<>());
            List<Point> y = yPoints.getOrDefault(point[1], new LinkedList<>());
            int count = 0;
            for(Point xp : x){
                for(Point yp: y){
                    if(uniquePoint.contains(yp.x+","+xp.y) && (Math.abs(xp.y-point[0]) == Math.abs(yp.x-point[1]))){
                        count++;
                    }
                }
            }
//            System.out.println(count);
            return count;
        }

    }


    public detectSquares(){
        solveDetectSquares detectSquares = new solveDetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        detectSquares.count(new int[]{11, 10}); // return 1. You can choose:
        //   - The first, second, and third points
        detectSquares.count(new int[]{14, 8});  // return 0. The query point cannot form a square with any points in the data structure.
        detectSquares.add(new int[]{11, 2});    // Adding duplicate points is allowed.
        detectSquares.count(new int[]{11, 10}); // return 2. You can choose:
        //   - The first, second, and third points
        //   - The first, third, and fourth points
    }
}
