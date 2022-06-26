
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public  String findSimpleGene(String dna, String startCodon, String stopCodon){
     String upDna = dna.toUpperCase();
     int startIndex = upDna.indexOf(startCodon);
     if (startIndex == -1){
         return "";
        }
     int endIndex = upDna.indexOf(stopCodon,startIndex+3);
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
        String dna = "gatgctataat";
        //System.out.println("Expected result: ATGGATAGAAATTAA");
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Actual result is: "+gene);
        
        
    }

}
