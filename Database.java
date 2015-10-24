
import java.net.*;
import java.io.*;
import JSONObject.*;
import java.util.ArrayList;


public class Database {

    private static final String DBURL = "http://www.ombdapi.com/?";
    private static final String DBPARAMS = "&plot=short&r=json&tomatoes=true";

    /**
     * Search the database for a title with the given IMDb ID
     * @param String id - the IMDb ID of the title
     * @return JSONObject - the information associated with the given id
     */
    public static JSONObject getById(String id) {
        URL s;
        try{
            s = new URL(DBURL + "i=" + id + DBPARAMS);
        }
        catch(MalformedURLException a){throw new IllegalArgumentException();}
        JSONObject json = lookupURL(s);
        if (json.getString("Response").equals("False"))
            return null;
        return json;
    }

    /**
     * Search the database for a title using the given keywords
     * @param String name - keywords in the name of the title, separated by
     *                      plus signs
     * @return JSONObject - the information most closely associated with the
     *                      given name
     */
    public static JSONObject getByName(String name) {
        name.replace(' ', '+');
        URL s;
        try{
            s = new URL(DBURL + "t=" + name + DBPARAMS);
        }
        catch(MalformedURLException a){throw new IllegalArgumentException();}
        JSONObject json = lookupURL(s);
        if (json.getString("Response").equals("False"))
            return null;
        return json;
    }

    /**
     * Search the database for titles using the given keywords
     * @param String name - keywords in the name of the title, separated by
     *                      plus signs
     * @return ArrayList<JSONObject> - the JSONObjects most closely associated
     *                                 with the given name
     */
    public static ArrayList<JSONObject> searchByQuery(String query) {
		name.replace(' ', '+');
		URL s;
		try{
		    s = new URL(DBURL + "s=" + query + DBPARAMS);
		}
		catch(MalformedURLException a){throw new IllegalArgumentException();}
		JSONObject json = lookupURL(s);
		if (json.getString("Response").equals("False"))
		    return null;

		JSONArray jsonArray = json.getJSONArray("Search");
		ArrayList<JSONObject> jsonArrList = new ArrayList<JSONObject>();
		for (int i = 0; i < jsonArray.length(); i++) {
		    jsonArrList.add(jsonArray.getJSONObject(i));
		}
		return jsonArrList;
    }

    // overloads to search by type

    /**
     * Search the database for a title using the given keywords
     * @param String name - keywords in the name of the title, separated by
     *                      plus signs
     * @param String type - the type of the title. can be movie, series, etc.
     * @return JSONObject - the information most closely associated with the
     *                      given name
     */
    public static JSONObject getByName(String name, String type) {
        name.replace(' ', '+');
		URL s;
        try{
            s = new URL(DBURL + "t=" + name + DBPARAMS + "&type=" + type);
        }
        catch(MalformedURLException a){throw new IllegalArgumentException();}
        JSONObject json = lookupURL(s);
        if (json.getString("Response").equals("False"))
            return null;
        return json;
    }

    /**
     * Search the database for titles using the given keywords
     * @param String name - keywords in the name of the title, separated by
     *                      plus signs
     * @param String type - the type of the title. can be movie, series, etc.
     * @return ArrayList<JSONObject> - the JSONObjects most closely associated
     *                                 with the given name
     */
    public static ArrayList<JSONObject> searchByQuery(String query, String type) {
		name.replace(' ', '+');
		URL s;
		try{
		    s = new URL(DBURL + "s=" + query + DBPARAMS + "&type=" + type);
		}
		catch(MalformedURLException a){throw new IllegalArgumentException();}
		JSONObject json = lookupURL(s);
		if (json.getString("Response").equals("False"))
		    return null;

		JSONArray jsonArray = json.getJSONArray("Search");
		ArrayList<JSONObject> jsonArrList = new ArrayList<JSONObject>();
		for (int i = 0; i < jsonArray.length(); i++) {
		    jsonArrList.add(jsonArray.getJSONObject(i));
		}
		return jsonArrList;
    }

    /**
     * Get the JSON data from the given URL
     * @param URL dBentry - the url to get JSON from
     * @return JSONObject - the JSON data from the URL as a JSONObject
     */
    private static JSONObject lookupURL(URL dbEntry) {
        try{
            URLConnection dbConnect = dbEntry.openConnection();
	    	BufferedReader in;
            in = new BufferedReader(
                           new InputStreamReader(
                           dbConnect.getInputStream()));
			return new JSONObject(in.readLine());
        } catch(IOException a) {throw new IllegalArgumentException();}
    }
}
