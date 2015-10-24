import java.util.Scanner;
import java.util.ArrayList;
import JSONObject.*;
import java.util.Arrays;
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
		String[] words = input.split(" ");
		boolean done = false;
		String test = words[0].toLowerCase();
		if (test.equals("search")) {
	    String search;
	    if(words[1].equals("online")){
	        search = reConcat(words, " ", 2);
	        searchDB(search);
	    }else if(words[1].equals("local")){
	        search = reConcat(words, " ", 2);
	    } else{
	        search = reConcat(words, " ", 1);
	    }
            
	    
	} else if (test.equals("add")) {
            
        
	} else if (test.equals("view")) {
        
       
    } else if (test.equals("remove")) {
        
       
	} else if (test.equals("quit")) {
            done = true;
        
    } else if (test.equals("load")) {
            //load new journal from filename words[1]
        
    }
        return done;
    }
    private String reConcat(String[] a, String s, int first){
        String out = "";
        for(int i = first; i < a.length-1; i++){
            out += a[i] + s;
        }
	out += a[a.length - 1];
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
