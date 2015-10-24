import java.util.Scanner;
import java.util.ArrayList;
import JSONObject.*;
import java.util.Arrays;
import java.io.*;
/**
 * Take input from User
 * 
 * @authors Harrison, Caleb, Chris
 * @version Beta
 */
public class ParseInput
{
    Journal current;
    Scanner console;

    ParseInput(Scanner console){
        System.out.println("Whose journal is this?");
        this.console = console;
        current = new Journal(UserInput.getInput(console, "Name"));
    }
    
    private Scanner cur;
    
    public boolean parse(String input){
	String[] words = input.split(" ");
	boolean done = false;
	String test = words[0].toLowerCase();
	if (test.equals("search")) {
	    search(words);
	} else if (test.equals("add")) {
	    add(words);
	} else if (test.equals("view")) {
	    view(words);
	} else if (test.equals("remove")) {
	    remove(words);
	} else if (test.equals("quit")) {
            done = true;
	} else if (test.equals("save")) {
	    if (words.length == 2)
		JournalEncoder.encodeJournal(current, words[1]);
	    else
		System.out.println("You done goofed"); // placeholder
	} else if (test.equals("load")) {
	    if (words.length == 2 && new File(words[1]).exists())
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

    private ArrayList<Entry> searchDB_return(String query) {
	ArrayList<JSONObject> list = Database.searchByQuery(query);
	ArrayList<Entry> result = new ArrayList<Entry>();
	for (JSONObject a : list)
	    result.add(new Entry(a));
	return result;
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
	    search = reConcat(words, "+", 2);
	    searchDB(search);
	} else if(words[1].equals("local")){
	    search = reConcat(words, " ", 2);
	} else {
	    search = reConcat(words, " ", 1);
	}
    }
    
    private ArrayList<Entry> view(String[] words) {
	if (words.length == 1) {
	    System.out.println(current);
	    return current.getEntries();
	} else {
	    String[] a = Arrays.copyOfRange(words, 1, words.length);
	    ArrayList<Entry> b = searchLoc(a);
	    for (int i = 0; i < b.size(); ++i) 
		System.out.println(i+1 + ": " + b.get(i) + "\n");
	    return b;
	}
    }
    
    private void remove(String[] words) {
	if (current.getEntries().size() > 0) {
	    ArrayList<Entry> result = searchLoc(reConcat(words, " ", 1));
	    for (int i = 0; i < result.size(); ++i)
		System.out.println(i+1 + ": " + result.get(i));
	    System.out.println("Enter the number of the entry you wish to remove, -1 to cancel: ");
	    int input = Integer.parseInt(UserInput.getInput(console, "Entry#"));
	    if (input-1 < result.size()) {
		current.removeEntry(result.get(input-1).getId());
	    } else {
		System.out.println("No entries found; nothing to remove!");
	    }
	}
    }
    private void add(String[] words) {
	
	ArrayList<Entry> result = searchDB_return(reConcat(words, "+", 1));
	for (int i = 0; i < result.size(); ++i)
	    System.out.println(i+1 + ": " + result.get(i));
	System.out.println("Enter the number of the entry you wish to add, -1 to cancel: ");
	int input = Integer.parseInt(UserInput.getInput(console, "Entry#"));
	if (input-1 < result.size()) 
	    current.addEntry(result.get(input-1));
	else {
	    System.out.println("No entries found; nothing to add!");
	}
	
    } 
}
