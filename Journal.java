import JSONObject.*;
import java.util.ArrayList;
public class Journal
{
    ArrayList<Entry> entries = new ArrayList<Entry>();
    
    public boolean addEntry(Entry a){
        return entries.add(a);
    }
    
  
}
