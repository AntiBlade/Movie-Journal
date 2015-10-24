import java.util.Scanner;
import java.util.ArrayList;
import JSONObject.*;
import java.util.Arrays;
/**
 * Take input from User
 * 
 * @authors Harrison, Caleb, Chris
 * @version Beta
 */
public class ParseInput
{
    Journal current;
    ParseInput(Journal cur){
        current = cur;
    }
    
    private Scanner cur;

    public boolean parse(String input, Scanner console){
	cur = console;
	String[] words = input.split(" ");
	boolean done = false;
	String test = words[0].toLowerCase();
	if (test.equals("search")) {
	    search(words);
	} else if (test.equals("add")) {
	    
	} else if (test.equals("view")) {
	    
	} else if (test.equals("remove")) {
       
	} else if (test.equals("quit")) {
            done = true;
    } else if (test.equals("save")) {
        if (words.length == 2)
            JournalEncoder.encodeJournal(current, words[1]);
        else
            System.out.println("You done goofed"); // placeholder
    } else if (test.equals("load")) {
        if (words.length == 2 && new File(System.getProperty("user.dir" + words[1]).exists())
        	current = JournalEncoder.decodeJournal(words[1]);        
        else
            System.out.println("you done goofed"); // placeholder
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
   
    private ArrayList<Entry> searchLoc(String query) {
	ArrayList<Entry> list = current.search(query);
	return list;
    }

    private ArrayList<Entry> searchLoc(String[] query) {
	ArrayList<Entry> list = current.search(query);
	return list;
    }

    private void search(String[] words) {
	String search;
	if(words[1].equals("online")){
	    search = reConcat(words, " ", 2);
	    searchDB(search);
	} else if(words[1].equals("local")){
	    search = reConcat(words, " ", 2);
	} else {
	    search = reConcat(words, " ", 1);
	}
    }

    private ArrayList<Entry> view(String[] words) {
	if (words.length == 1)
	    System.out.println(current);
	else {
	    String[] a = Arrays.copyOfRange(words, 1, words.length);
	    ArrayList<Entry> b = searchLoc(a);
	    for (int i = 0; i < b.size(); ++i) 
		System.out.println(i+1 + ": " + b.get(i) + "\n");
	}
	return a;
    }

    private void remove(String[] words) {
	if (current.getEntries().size() > 0) {
	    result = view(words);
	    System.out.println("Enter the number of the entry you wish to remove, -1 to cancel: ");
	    int input = cur.nextInt();
	    if (input < words.size())
		Journal.removeEntry(result.get(input-1));
	} else {
	    System.out.println("No entries found; nothing to remove!");
	}
    }
}
