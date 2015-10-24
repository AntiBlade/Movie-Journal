
/**
 * Take input from User
 * 
 * @author Harrison
 * @version Beta
 */
public class ParseInput
{
   public static boolean parse(String input){
       String[] words = input.split(" ");
       switch(words[0].toLowerCase()){
        case "search":
            if(words[1].equals("online")){
                //Search the database
                //Call ReConccate
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
    }
    return true;//Correct Just for compiler
   }
   private static String reConcat(String[] a, String s){
       String out = "";
       for(String d:a){
           out += d + s;
       }
       return out;
   }
      private static String reConcat(String[] a){
       return reConcat(a, " ");
   }
}
