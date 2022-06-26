import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of CSVjava here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CSVjava {
    public static String countryInfo(CSVParser parser, String country){
        country = country.toUpperCase();
        for (CSVRecord record : parser){
            String ctry = record.get("Country");
            ctry = ctry.toUpperCase();
            
            if(ctry.contains(country)){
               String exports = record.get("Exports");
               String value = record.get("Value (dollars)");
               return ctry+":"+exports+":"+value;
               
            }
        }
        
    return "Not found";    
    }
    
    public static void listExportersTwoProducts(CSVParser parser,
    String exportItem1, String exportItem2){
      for (CSVRecord record : parser){
            
            String exports = record.get("Exports");
            
            if(exports.contains(exportItem1) && exports.contains(exportItem2)){
               String ctry = record.get("Country");
               System.out.println(ctry);
               
            }
        }  
        
    }
    
    
    public static int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record : parser){
            
            String exports = record.get("Exports");
            
            if(exports.contains(exportItem)){
               count = count+1;
               
            }
        }
        return count;
    }
    
    
    public static void bigExporters(CSVParser parser, String amount){
      
        for(CSVRecord record : parser){
            String value = record.get("Value (dollars)");
            String ctry = record.get("Country");
            int len_rec = value.length();
            int len_given = amount.length();
            if (len_rec>len_given){
                System.out.println(ctry+" "+value);
            }
        }
    }
    
    
    
    public static void tester(){
      FileResource fr = new FileResource();
      CSVParser parser = fr.getCSVParser();
      String data = countryInfo(parser,"Nauru");
      System.out.println(data);
    }
    
    public static void tester2(){
      FileResource fr = new FileResource();
      CSVParser parser = fr.getCSVParser();
      //listExportersTwoProducts(parser,"cotton","flowers");
      //System.out.println(numberOfExporters(parser,"cocoa"));
      bigExporters(parser, "$999,999,999,999");
    }
}
