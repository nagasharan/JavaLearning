import java.util.*;
import edu.duke.*;
/**
 * Write a description of codonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class codonCount {
    private HashMap<String,Integer> codons;
    
    public codonCount(){
        codons = new HashMap<String,Integer>();
    }
    
    public void buildCodonMap(int start, String dna){
        dna = dna.toUpperCase();
        codons.clear();
        String cod = "";
        System.out.println("reading from "+ start +" to "+ dna.length() +" :");
        for(int i=start;i+3<dna.length();i=i+3){
            cod = dna.substring(i,i+3);
            if (codons.containsKey(cod)){
                codons.put(cod,codons.get(cod)+1);
                
            }
            else{
                codons.put(cod,1);
            }
        }
    }
    
    public void getMostCommonCodon(){
        int maxVal=0;
        String maxStr = "";
        for (String s : codons.keySet()) {
            int curVal = codons.get(s);
            if(curVal>maxVal){
                maxVal = curVal;
                maxStr = s;
                
            }
        }
        
        System.out.println("The codon "+maxStr+"occures "+maxVal);
    }
    
    public void printCodonCounts(int start, int end){
        System.out.println("Counts of codons between "+ start +" and "+ end+ " inclusive are:");
        for (String s : codons.keySet()) {
        System.out.println(s+"\t"+codons.get(s));    
        }
        
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        buildCodonMap(0,dna);
        getMostCommonCodon();
        printCodonCounts(1,5);
        buildCodonMap(1,dna);
        getMostCommonCodon();
        printCodonCounts(1,5);
        buildCodonMap(2,dna);
        getMostCommonCodon();
        printCodonCounts(1,5);
    }
}
