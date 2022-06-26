import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of CSNMin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CSNMin {
    public static CSVRecord coldestHourInFile(CSVParser parser){
        
        CSVRecord coldestSofar = null;
        for(CSVRecord currentRow : parser){
            coldestSofar = smallestOfTwo(currentRow,coldestSofar);
        }
        return coldestSofar;
    }
    
    public static CSVRecord smallestOfTwo(CSVRecord currentRow, CSVRecord coldestSofar){
        if (coldestSofar == null){
        coldestSofar = currentRow;
        }
        double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
        double largestTemp = Double.parseDouble(coldestSofar.get("TemperatureF"));
        if (currentTemp<largestTemp){
            coldestSofar = currentRow;
        }
        return coldestSofar;
    }
    
    public static String fileWithColdestTemperature(){
        CSVRecord coldestSofar = null;
        String filename = "";
	DirectoryResource dr = new DirectoryResource();
		// iterate over files
	for (File f : dr.selectedFiles()) {
	    FileResource fr = new FileResource(f);
	
            for(CSVRecord currentRow : fr.getCSVParser()){
                if (coldestSofar == null){
                    coldestSofar = currentRow;
                    filename = f.getAbsolutePath();
                }
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(coldestSofar.get("TemperatureF"));
                if (currentTemp<largestTemp){
                    coldestSofar = currentRow;
                    filename = f.getAbsolutePath();
                }
            }
		}
		//The largestSoFar is the answer
	return filename;
        
        
        
    }
    
    
    public static CSVRecord lowestHumidityInFile(){
        CSVRecord lowestHumidity = null;
        double currentHum = 0;
	double coldestHum = 0;
	DirectoryResource dr = new DirectoryResource();
	for (File f : dr.selectedFiles()) {
	    FileResource fr = new FileResource(f);
	for(CSVRecord currentRow : fr.getCSVParser()){
                if (lowestHumidity == null){
                    lowestHumidity = currentRow;
                    
                }
                if (currentRow.get("Humidity").contains("N/A")==false){
                     currentHum = Double.parseDouble(currentRow.get("Humidity"));
                     coldestHum = Double.parseDouble(lowestHumidity.get("Humidity"));
                    }
                if (currentHum<coldestHum){
                    lowestHumidity = currentRow;
                    
                }
            
		}
}
        return lowestHumidity;
    }
    
    
    public static double averageTemperatureInFile(CSVParser parser){
        
        double currentTemp = 0;
	double total = 0;
	int count = 0;
	for(CSVRecord currentRow : parser){
            
                     currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                     total = total+currentTemp;
                     count++;
            }
                
        return total/count;
    }
    
    
    
    public static double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        
        double currentTemp = 0;
	double total = 0;
	int count = 0;
	for(CSVRecord currentRow : parser){
            double currentHum = Double.parseDouble(currentRow.get("Humidity"));
            currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
	    if(currentHum>=value){
            total = total+currentTemp;
            count++;
        }
            }
                
        return total/count;
        
        
        
        
    }
    
    
    public static void testColdestHourInFile(){
         FileResource fr = new FileResource("data/2014/weather-2014-05-01.csv");
         CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
         System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
				   " at " + coldest.get("DateUTC"));
        
    }
    
    public static void testFileWithColdestTemperature(){
    
            String filename = fileWithColdestTemperature();
            FileResource fr = new FileResource(filename);
            System.out.println("Coldest temperature found in file "+ filename);
            CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
            System.out.println("Coldest temperature is " + coldest.get("TemperatureF"));
            System.out.println("All the temperature of that day were: ");
            for(CSVRecord record : fr.getCSVParser()){
                System.out.print(record.get("TimeEST"));
                System.out.println(" "+ record.get("TemperatureF")+ " ");
                
            }
     }
     
     
    public static void testLowestHumidityInFile() {
        
        
        CSVRecord csv = lowestHumidityInFile();
        
        System.out.println("Lowest humidity was "+ csv.get("Humidity")+ " at "+csv.get("DateUTC"));
        
        
    }
    
    
    public static void testaverageTemperatureInFile(){
    
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double temp = averageTemperatureInFile(parser);
        System.out.println("Average temperature is "+temp);
    }
    
    public static void testaverageTemperatureWithHighHumidityInFile(){
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double temp = averageTemperatureWithHighHumidityInFile(parser,80);
        if(Double.isNaN(temp)){
        System.out.println("No temperatures with that humidity");
        }
        else{
        System.out.println("Average temperature is "+temp);}
        
        
        
    }
}
