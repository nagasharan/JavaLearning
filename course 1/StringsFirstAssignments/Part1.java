
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
  public  String findSimpleGene(String dna){
     int startIndex = dna.indexOf("ATG");
     if (startIndex == -1){
         return "";
        }
     int endIndex = dna.indexOf("TAA",startIndex+3);
     if (endIndex == -1){
         return "";
        }
    
    String geneDna = dna.substring(startIndex,endIndex+3);
    if (geneDna.length() % 3 == 0){
        return geneDna;
    }
    else{
        return "";
    }}
    
    public  void testSimpleGene(){
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        //System.out.println("Expected result: ATGGATAGAAATTAA");
        String gene = findSimpleGene(dna);
        System.out.println("Actual result is: "+gene);
        
        
    }
        
}

