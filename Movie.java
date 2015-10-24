import org.json.*;
/**
 * Stores information related to a movie.
 */
public class Movie {

    private String id;
    private JSONObject dBInfo;

    /**
     * 
     */
    public void setInfo(JSONObject newDBInfo) {
	newDBInfo = dBInfo;
    }

    /**
     */
    public String getInfo(String tag) {
	try {
	    return dBInfo.get(tag);
	} catch (JSONException e) {
	    return null;
	}
    }
}
