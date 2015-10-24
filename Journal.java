import JSONObject.*;
import java.util.ArrayList;
public class Journal
{
    ArrayList<Entry> entries = new ArrayList<Entry>();
    
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
