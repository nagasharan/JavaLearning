import edu.duke.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public static int findStopCodon(String dna, int startIndex, String stopCodon){
       int stopIndex = dna.indexOf(stopCodon , startIndex+3);
       
       while(stopIndex != -1){
           if ((stopIndex-startIndex)%3 == 0){
               return stopIndex;
            }
            else{
                stopIndex = dna.indexOf(stopCodon, stopIndex+1);
            }
        }
        return dna.length();
    }
    public static void testFindStopCodon(){
        String dna = "abcATGlkjdaa";
        int startIndex = dna.indexOf("ATG");
        System.out.println(findStopCodon(dna,startIndex,"TAA"));
        
    }
    
    public static String findGene(String dna, int startIndex){
       
       if (startIndex == -1){
           return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        if (taaIndex == dna.length() && tgaIndex == dna.length() 
        && tagIndex == dna.length()){
            return "";
        }
        int stopIndex = Math.min(Math.min(taaIndex,tgaIndex),tagIndex);
        return dna.substring(startIndex,stopIndex+3);
         
    }
    public static void testFindGene(){
       String dna = "aATGjTAAdkdsTGAlTAgGashdkuhaTGA";
       int startIndex = dna.indexOf("ATG");
       String gene = findGene(dna,startIndex);
       System.out.println(gene); 
        
    }
    
    public static StorageResource getAllGenes(String dna){
        dna = dna.toUpperCase();
        StorageResource geneList = new StorageResource();
        int startIndex = dna.indexOf("ATG");
        while(true){
            if (startIndex == -1){
                break;
            }
            String gene = findGene(dna,startIndex);
            geneList.add(gene);
            if (gene == ""){
                break;
            }
            startIndex = dna.indexOf("ATG",startIndex+gene.length());
        }
        return geneList;    
        
        
        
    }
    
    public static void testSR(){
       String dna = "ATGlsjasdTAAhghATGTAAjhgjATGifdTAGjhjhATGkfjhssskjTGAkj"; 
       StorageResource sr = getAllGenes(dna);
       for (String gene : sr.data()){
           System.out.println(gene);
           
        }
    }
    public static float cgRatio(String dna){
        dna = dna.toUpperCase();
        int c_count = 0;
        int g_count = 0;
        int cIndex = dna.indexOf("C");
        int gIndex = dna.indexOf("G");
        while(cIndex!=-1){
            c_count = c_count+1;
            cIndex = dna.indexOf("C",cIndex+1);
        }
        while(gIndex!=-1){
            g_count = g_count+1;
            gIndex = dna.indexOf("G",gIndex+1);
        }
        float cg_ratio = (float)(c_count+g_count)/dna.length();
        return cg_ratio;
        
    }
    public static void testcgRatio(){
      String dna = "ATGCCATAG";
      cgRatio(dna);
    }
    public static void countCTG(StorageResource sr){
        int count = 0;
        for (String dna : sr.data()){
        
        int temp = dna.indexOf("CTG");
        while(temp!=-1){
           count = count+1;
           temp = dna.indexOf("C",temp+3);
        }}
        System.out.println(count);
    }
    public static void processGenes(StorageResource sr){
        float cgratio = 0;
        int count1 = 0;
        int count = 0;
        int long_length = 0;
        for (String data : sr.data()){
            if (data.length()>long_length){
                long_length = data.length();
            }
           if (data.length()>60){
               count = count+1;
               System.out.println(data);
               System.out.println("The genes with length greter than 9 = "+data);
            }
           cgratio = cgRatio(data);
           if (cgratio>0.35){
               System.out.println("more cg = "+data);
               count1 = count1+1;
            }
        }
        System.out.println("count of genes more than p length is "+count);
        System.out.println("count of genes more cg is "+count1);
        System.out.println(long_length);
    }
    public static void testsr(){
       FileResource fr = new FileResource("GRch38dnapart.fa");
       String dna = fr.asString(); 
       StorageResource sr = getAllGenes(dna);
       //System.out.println(sr.size());
       processGenes(sr);
       //countCTG(sr);
    }
}
