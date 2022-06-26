import java.util.*;
import edu.duke.*;

public class t {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder output = new StringBuilder();
        for(int i = whichSlice;i<message.length();i=i+totalSlices){
           
           output = output.append(message.substring(i,i+1));
        }
        return output.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] keys = new int[klength];
        //WRITE YOUR CODE HERE
        for (int i=0; i<klength;i++){
            String slice = sliceString(encrypted,i,klength);
            CaesarCracker cc = new CaesarCracker(mostCommon);
            //System.out.println(cc.getKey(slice));
            //System.out.println(Arrays.toString(cc.countLetters(encrypted)));
            keys[i]=cc.getKey(slice);
        }
        return keys;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource file = new FileResource();
        
        HashMap<String,HashSet<String>> languages = new HashMap<String,HashSet<String>>();
        FileResource en = new FileResource("dictionaries/English");
        FileResource fr = new FileResource("dictionaries/French");
        FileResource da = new FileResource("dictionaries/Danish");
        FileResource du = new FileResource("dictionaries/Dutch");
        FileResource ge = new FileResource("dictionaries/German");
        FileResource it = new FileResource("dictionaries/Italian");
        FileResource po = new FileResource("dictionaries/Portugese");
        FileResource sp = new FileResource("dictionaries/Spanish");
        languages.put("English",readDictionary(en));
        languages.put("French",readDictionary(fr));
        languages.put("Danish",readDictionary(da));
        languages.put("Dutch",readDictionary(du));
        languages.put("German",readDictionary(ge));
        languages.put("Italian",readDictionary(it));
        languages.put("Portugese",readDictionary(po));
        languages.put("Spanish",readDictionary(sp));
        
        //int[] keys = tryKeyLength(fr.asString(),4,'e');
        //VigenereCipher vb = new VigenereCipher(keys);
        //String out = vb.decrypt(fr.asString());
        //System.out.println(out.substring(0,100));
        //System.out.println(Arrays.toString(keys));
        breakForAllLanguage(file.asString(),languages);
        
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dict = new HashSet();
        for(String sr:fr.lines()){
           dict.add(sr.toLowerCase()); 
        }
        return dict;
    }
    
    public int countWords(String message,HashSet<String> dict){
       int cnt=0;
       HashSet<String> valid = new HashSet();
       String[] output = message.split("\\W");
       for(int i=0;i<output.length;i++){
           if(dict.contains(output[i].toLowerCase())){
              cnt = cnt+1 ;
            }
           
        }
       return cnt; 
    }
    
    public String breakForLanguage(String encrypted,HashSet<String> dict){
        int maxCount = 0;
        int keyLength = 0;
        char c = mostCommonCharIn(dict);
        for(int i=1;i<100;i++){
             int[] keys = tryKeyLength(encrypted,i,c);
             VigenereCipher vb = new VigenereCipher(keys);
             String out = vb.decrypt(encrypted);
             int tempCount  = countWords(out,dict);
             if(tempCount>maxCount){
                 maxCount=tempCount;
                 keyLength = i;
                }
        }
        int[] keys = tryKeyLength(encrypted,keyLength,c);
        VigenereCipher vb = new VigenereCipher(keys);
        System.out.println(maxCount);
        System.out.println(keyLength);
        
        return vb.decrypt(encrypted);
    }
    
    public char mostCommonCharIn(HashSet<String> dict){
      HashMap<String, Integer> map = new HashMap<String, Integer>(); 
      
      for(String val: dict){
            for(int i = 0;i<val.length();i++){
                if(map.containsKey(val.substring(i,i+1))){
                    String key = val.substring(i,i+1);
                    map.put(key, map.get(key)+1);
                }
                else{
                    map.put(val.substring(i,i+1),1);
                }
            }
        }
      int maxCount = 0;
      String cha = ""; 
      for(String s : map.keySet()){
            int cnt = map.get(s);
            if(cnt>maxCount){
               maxCount = cnt;
               cha = s;
            }
        }
      char output = cha.charAt(0);
      return output;
    }
    
    public void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>> languages){
        
        for(String lang: languages.keySet()){
            String decrypted = breakForLanguage(encrypted,languages.get(lang));
            int count = countWords(encrypted,languages.get(lang));
            System.out.println(lang);
            System.out.println(count);
            System.out.println(decrypted.substring(0,200));
        }
        
    }
}
