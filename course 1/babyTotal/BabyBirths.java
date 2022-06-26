/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int girlNames = 0;
        int boyNames = 0;
        int totalNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            totalNames+=1;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                boyNames+=1;
            }
            else {
                totalGirls += numBorn;
                girlNames+=1;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
        System.out.println("total names = " + totalNames);
        System.out.println("female girls names = " + girlNames);
        System.out.println("male boys names = " + boyNames);
    }
    
    
    public int getRank(int year, String name, String gender){
        String file = "data/yob"+year+".csv";
        FileResource fr = new FileResource(file);
        int rank = 1;
        for(CSVRecord data : fr.getCSVParser(false)){
            if(data.get(1).equals(gender) && data.get(0).equals(name)){
                return rank;
            }
            if(data.get(1).equals(gender)){
            rank+=1;
        }
        }
        
        return -1;
    }
    
    public String getName(int year, int rank, String gender){
        String file = "data/yob"+year+".csv";
        FileResource fr = new FileResource(file);
        int int_rank = 1;
        
        for(CSVRecord data : fr.getCSVParser(false)){
            if(int_rank==rank){
               return data.get(0);  
            }
            if(data.get(1).equals(gender)){
                int_rank+=1;
            }
        }
        
        return "NO NAME";
        
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year,name,gender);
        String newName = getName(newYear,rank,gender);
        System.out.println(name+" born in "+year+" would be "+newName+"  if she was born in "+newYear);
    }
    
    
    public int yearOfHighestRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int rankYear = -1;
        int temp_rank = -1;
        int year = -1;
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            String filename = f.getName();
            year = Integer.parseInt(filename.substring(3,7));
            int rank = getRank(year,name,gender);
            
            if (temp_rank == -1 && rank!=-1){
                temp_rank = rank;
                rankYear = year;
            }
            if (rank<temp_rank){
                temp_rank = rank;
                rankYear = year;
            }
            
            
        }
        return rankYear;
        
    }
    
    
    public double getAverageRank(String name, String gender){
        
        DirectoryResource dr = new DirectoryResource();
        int count = 0;
        double TotalRank = 0;
        int year = -1;
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            String filename = f.getName();
            year = Integer.parseInt(filename.substring(3,7));
            int rank = getRank(year,name,gender);
            if (rank != -1){
                TotalRank+=rank;
                count = count+1;
            }
            
        
    }
    if(TotalRank==0){
        return -1.0;
    }
    return TotalRank/count;
}


public int getTotalBirthsRankedHigher(int year, String name, String gender){
    int totalBirths = 0;
    int rank = getRank(year,name,gender);
    String file = "data/yob"+year+".csv";
    FileResource fr = new FileResource(file);
    for(CSVRecord data: fr.getCSVParser()){
        if(data.get(1).equals(gender) && data.get(0).equals(name)){
                return totalBirths;
            }
            if(data.get(1).equals(gender)){
            totalBirths = totalBirths+Integer.parseInt(data.get(2));
        }
        
        
    }
    return totalBirths;
    
}



    
    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        //FileResource fr = new FileResource("data/yob1905.csv");
        //totalBirths(fr);
        //String rank = getName(1980,350,"F");
        //System.out.println(rank);
        //whatIsNameInYear("Owen",1974,2014,"M");
        //int year = yearOfHighestRank("Mich","M");
        //double year = getAverageRank("Robert","M");
        double year = getTotalBirthsRankedHigher(1990,"Drew","M");
        System.out.println(year);
    }
}
