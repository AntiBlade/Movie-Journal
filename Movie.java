import JSONObject.*;

/**
 * Stores information related to a movie.
 */
public class Movie implements Media{

    private String id;
    private JSONObject dbInfo;

    /**
     * 
     */
    public void setInfo(JSONObject newDBInfo) {
	dbInfo = newDBInfo;
    }

    /**
     */
    public String getInfo(String tag) {
	try {
	    return dbInfo.getString(tag);
	} catch (JSONException e) {
	    return null;
	}
    }
}
