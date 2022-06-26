
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    
    
    public static int countGenes(String dna){
        int startIndex = dna.indexOf("ATG");
        int count = 0;
        while(true){
            if (startIndex == -1){
                break;
            }
            String gene = findGene(dna,startIndex);
            System.out.println(gene);
            if (gene == ""){
                break;
            }
            count = count+1;
            startIndex = dna.indexOf("ATG",startIndex+gene.length());
        }
        return count;
            
        
        
        
    }
    
    
    public static void testCount(){
       String dna = "AATGCTAACTAGCTGACTAAT"; 
       System.out.println(countGenes(dna)); 
    }
}
