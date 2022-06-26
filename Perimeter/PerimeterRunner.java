import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints = getNumPoints(s);
        System.out.println("number of points = " + numPoints);
        double averageLength = getAverageLength(s);
        System.out.println("Average Length = " + averageLength);
        double largestSide = getLargestSide(s);
        System.out.println("Largest side = "+largestSide);
        double largeX = getLargestX(s);
        System.out.println("Largest X = "+largeX);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
    
    public static int getNumPoints(Shape s){
        int i = 0;
        for (Point p : s.getPoints()) {
            i++;
 }
        return i;
}
public static double getAverageLength(Shape s){
        double totalPerim = 0.0;
        int i=0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
            i++;
        }
        // totalPerim is the answer
        double averageLength = totalPerim/i;
        return averageLength;
        
    }
public static double getLargestSide(Shape s){
    double sideOne = 0;
    double sideTwo = 0;
    Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
             sideTwo = prevPt.distance(currPt);
            
            // Update prevPt to be currPt
            prevPt = currPt;
            if (sideTwo>sideOne){
                sideOne = sideTwo;
            }
            else{
                sideOne = sideOne;
            }
        }
        // totalPerim is the answer
        
        return sideOne;
    
}
public static double getLargestX(Shape s){
   Point prevPoint = s.getLastPoint();
   double largeX = 0;
   for(Point p: s.getPoints()){
       
       double currX = p.getX();
       if (currX>largeX){
           largeX = currX;
        }
    }
    return largeX;
    
    
}
}
