import java.util.Scanner;
import java.util.ArrayList;
import JSONObject.*;
/**
 * Take input from User
 * 
 * @author Harrison
 * @version Beta
 */
public class ParseInput
{
   Journal current;
   ParseInput(Journal cur){
       current = cur;
   }
    public boolean parse(String input, Scanner console){
       String[] words = input.split("\\S");
       boolean ret = true;
       switch(words[0].toLowerCase()){
        case "search":
           String search;
            if(words[1].equals("online")){
                search = reConcat(words, " ", 2);
                searchDB(search);
            }else if(words[1].equals("local")){
                search = reConcat(words, " ", 2);
            } else{
                 search = reConcat(words, " ", 1);
            }
            
        break;
        case "add":
            
        break;
        case "view":
        
        break;
        case "remove":
        
        break;
       case "quit":
           ret = false;
       break;
       case "load":
           //load new journal from filename words[1]
       break;
    }
    return ret;
   }
   private String reConcat(String[] a, String s, int first){
       String out = "";
       for(int i = first; i < a.length; i++){
           out += a[i] + s;
       }
       return out;
   }
      private String reConcat(String[] a){
       return reConcat(a, " ", 0);
   }

   private void searchDB(String query) {
        ArrayList<JSONObject> list = Database.searchByQuery(query);
        for(JSONObject a : list){
            System.out.println(new Entry(a) + "\n");
        }
   }
   
}
