import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
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

    public int getNumPoints (Shape s) {
        // Put code here
        int i = 0;
        for (Point p : s.getPoints()) {
            i++;
 }
        return i;
        
    }

    public double getAverageLength(Shape s) {
        // Put code here
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

    public double getLargestSide(Shape s) {
        // Put code here
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

    public double getLargestX(Shape s) {
        // Put code here
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

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double lengthOne = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double lengthTwo = getPerimeter(s);
            if (lengthTwo>lengthOne){
                lengthOne =lengthTwo;
        }
    }
    return lengthOne;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double lengthOne = 0;
        File temp = null;    // replace this code
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double lengthTwo = getPerimeter(s);
            if (lengthTwo>lengthOne){
                temp = f;
                lengthOne=lengthTwo;
        }
        
    }
    return temp.getName();
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
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largeP = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter in multiple files is: " + largeP);
}
    

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fileP = getFileWithLargestPerimeter();
        System.out.println("File with Largest perimeter is: "+ fileP);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
