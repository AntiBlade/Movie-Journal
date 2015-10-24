import java.net.*;
import java.io.*;
import org.json.*;

public static class Database {

    private static final String DBURL = "http://www.ombdapi.com/?";
    private static final String DBPARAMS = "&plot=short&r=json&tomatoes=true";

    /**
     * Search the database for a title with the given IMDb ID
     * @param String id - the IMDb ID of the title
     * @return JSONObject - the information associated with the given id
     */
    public JSONOBJECT searchId(String id) {
	JSONObject json = lookupURL(new URL(DBURL + "i=" + id + BDPARAMS));
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
    public JSONOBJECT searchName(String name) {
	JSONObject json = lookupURL(new URL(DBURL + "t=" + name + BDPARAMS));
	if (json.getString("Response").equals("False"))
	    return null;
	return json;
    }

    /**
     * Get the JSON data from the given URL
     * @param URL dBentry - the url to get JSON from
     * @return JSONObject - the JSON data from the URL as a JSONObject
     */
    private JSONObject lookupURL(URL dBentry) {
	URLConnection dbConnect = dbEntry.openConnection();
	BufferedReader in = new BufferedReader(
					       new InputStreamReader(
					       dbConnect.getInputStream()));
	return new JSONObject(in.readLine());
    }
}
