
/**
 * Write a description of AdvancedGene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AdvancedGene {
    
    public int EndIndex(String dna){
        int startIndex = dna.indexOf("ATG");
        int endIndex = 0;
        if (startIndex == -1){
            endIndex = -1;
            
        }
        else{
            int taaIndex = dna.indexOf("TAA",startIndex+3);
            int tgaIndex = dna.indexOf("TGA",startIndex+3);
            int tagIndex = dna.indexOf("TAG",startIndex+3);
            endIndex = Math.min(Math.min(taaIndex,tgaIndex),tagIndex);
            
        
    }
    return endIndex;
}}
