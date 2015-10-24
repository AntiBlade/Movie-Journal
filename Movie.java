import org.json.*;
/**
 * Stores information related to a movie.
 */
public class Movie implements Media{

    private String id;
    private JSONObject dBInfo;

    /**
     * 
     */
    public void setInfo(JSONObject newDBInfo) {
	newDBInfo = dbInfo;
    }

    /**
     */
    public String getInfo(String tag) {
	try {
	    return dbInfo.get(tag);
	} catch (JSONException e) {
	    return null;
	}
    }
}
