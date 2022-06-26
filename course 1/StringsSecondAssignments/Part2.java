
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  class Part2 {
    public static int howMany(String inta, String intb){
        int count = 0;
        int temp = intb.indexOf(inta);
        while(true){
            if (temp == -1){
                break;
            }
            count = count+1;
            temp = intb.indexOf(inta,temp+inta.length());
        }
        return count;
    }
    
    public static void testHowMany(){
       String a = "AA";
       String b = "jhsdfyeksdjh";
       System.out.println(howMany(a,b));
    }
}
