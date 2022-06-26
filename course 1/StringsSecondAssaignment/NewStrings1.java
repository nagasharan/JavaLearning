
/**
 * Write a description of NewStrings1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewStrings1 {
    public String findGenes (String dna){
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        else{
            int endIndex = dna.indexOf("TAA",startIndex+3);
            if (endIndex == -1){
                return "";
            }
            else{
                while (endIndex != -1){
                if ((endIndex-startIndex)/3 == 0){
                    return dna.substring(startIndex,endIndex+3);
                }
                else{
                    endIndex = dna.indexOf("TAA",endIndex+1);
                }}
            
    }

}
return "";
}
}
