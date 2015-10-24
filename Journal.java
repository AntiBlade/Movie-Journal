import JSONObject.*;
import java.util.ArrayList;
import java.util.HashSet;
public class Journal
{
    ArrayList<Entry> entries = new ArrayList<Entry>();
    private String owner = "";

    public Journal(String owner) {
        this.owner = owner;
    }

    /**
     * Gets the owner of this journal
     * @return the owner of this journal
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner of this journal
     * @param the new owner of this journal
     */
    public void setOwner(String newName) {
        owner = newName;
    }

    public String toString() {
        String s = "";
        s += owner + "'s Movie Journal";
        for (Entry e : entries) {
            s += "\n\n" + e; 
        }
        return s;
    }
    
    /*
     * addEntry
     * Purpose: Adds an entry to the entries ArrayList
     * Parameters: (Entry) a
     * Returns: True if added successfully 
     */
    public boolean addEntry(Entry a){
        return entries.add(a);
    }

    /*
     * indexOf
     * Purpose: Returns index of entry based on entry's id
     * Parameters: (String) id
     * Returns: The index of the entry
     */
    private int indexOf(String id) {
	for(int i = 0; i < entries.size(); ++i) {
	    if (entries.get(i).getItem().getId() == id)
		return i;
	}
    return -1;
    }

    /*
     * indexOf
     * Purpose: Returs index of entry based on entry as a whole
     * Parameters: (Entry) entry
     * Returns: The index of the entry
     */
    private int indexOf(Entry entry) {
	for (int i = 0; i < entries.size(); ++i) {
	    if (entries.get(i) == entry)
		return i;
	}
    return -1;
    }

    /* 
     * search
     * Purpose: Searches for entries by title
     * Parameters: (String) query
     * Returns: ArrayList of entries having the query in their title
     */
    public ArrayList<Entry> search(String query) {
	String[] words = query.split("\\S");
	if (words.length > 1) {
	    return search(words);
	} else {
	    ArrayList<Entry> found = new ArrayList<Entry>();
	    for (int i = 0; i < entries.size(); ++i) {
		Entry current = entries.get(i);
		if (current.getItem().getDatum("Title").indexOf(query) == -1)
		    continue;
		else
		    found.add(current);
	    }
	return found;
	}
    }

    /*
     * search
     * Purpose: Searches for entries by keyword
     * Parameters: (String[]) words
     * Returns: ArrayList of Entries having keywords in title
     */
    public ArrayList<Entry> search(String[] words) {
	ArrayList<Entry> results = new ArrayList<Entry>();
	for (String s : words)
	    results.addAll(search(s));
	results = makeUnique(results);
	return results;
    }
    
    /*
     * makeUnique
     * Purpose: Remove duplicates from an ArrayList
     * Parameters: (ArrayList<Entry>) list
     * Returns: New unique ArrayList
     */
    private ArrayList<Entry> makeUnique(ArrayList<Entry> list) {
	ArrayList<Entry> result = new ArrayList<Entry>();
	HashSet<Entry> set = new HashSet<Entry>();

	for (Entry e : list) {
	    if (!set.contains(e)) {
		result.add(e);
		set.add(e);
	    }
	}
	return result;
    }

    /* 
     * removeEntry
     * Purpose: Removes an entry from entries
     * Parameters: (String) id
     * Returns: The Entry that was removed
     */
    public Entry removeEntry(String id) {
	return entries.remove(indexOf(id));
    }

    /* 
     * getEntry
     * Purpose: Gives an Entry if it's unique, otherwise null
     * Parameters: (String) name
     * Returns: The Entry if it's unique, null otherwise
     */
    public Entry getEntry(String name) {
	ArrayList<Entry> results = search(name);
	if (results.size() == 1)
	    return results.get(0);
	else
	    return null;
    }
}
