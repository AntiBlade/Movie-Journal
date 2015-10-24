import java.util.Scanner;
/**
 * Take input from User
 * 
 * @author Harrison
 * @version Beta
 */
public class ParseInput
{
    public static boolean parse(String input, Scanner console){
       String[] words = input.split("\\S");
       switch(words[0].toLowerCase()){
        case "search":
            if(words[1].equals("online")){
                //Search the database
                String search = reConcat(words, " ", 2);
            }else if(words[1].equals("local")){
                
            } else{
            
            }
            
        break;
        case "add":
            
        break;
        case "view":
        
        break;
        case "remove":
        
        break;
       case "quit":
           return false;
           break;
       case "load":
           //load new journal from filename words[1]
           break;
    }
    return true;//Correct Just for compiler
   }
   private static String reConcat(String[] a, String s, int first){
       String out = "";
       for(int i = first; i < a.length; i++){
           out += a[i] + s;
       }
       return out;
   }
      private static String reConcat(String[] a){
       return reConcat(a, " ", 0);
   }

    private static void searchDB(String query) {
        // search db
    }
}
