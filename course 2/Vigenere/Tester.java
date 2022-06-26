import java.util.*;
import edu.duke.*;
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester {
    public static void test1(){
        //CaesarCipher cc = new CaesarCipher(4);
        //FileResource fr = new FileResource();
        //String enc = cc.encrypt(fr.asString());
        //System.out.println(enc);
        //String dec = cc.decrypt(enc);
        //System.out.println(dec);
        //CaesarCracker ck = new CaesarCracker('a');
        //String pout = ck.decrypt(fr.asString());
        //System.out.println(pout);
        VigenereBreaker vb = new VigenereBreaker();
        
        vb.breakVigenere();
        //System.out.println(vb.sliceString("abcdefghijklm",2,3));
        //int[] keys = vb.tryKeyLength(fr.asString(),4,'e');
        //for(int i=0;i<keys.length;i++){
          //  System.out.println(keys[i]);}
        //vb.breakVigenere();
        //System.out.println(Arrays.toString(keys));
        //System.out.println(vb.readDictionary(fr).size());
    }
}
