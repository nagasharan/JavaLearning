import edu.duke.*;
public class Perimeter_assaignment {
    
    public static int getNumPoints(Shape s){
        
        
    }

    public static double getAverageLength(Shape s){
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
        double averageLength = totalPerim/4;
        return averageLength;
        
    }
    
    public static void testPerimeter(Shape s){
    }
}
