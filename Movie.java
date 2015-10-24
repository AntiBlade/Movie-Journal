import JSONObject.*;

/**
 * Stores information related to a movie.
 */
public class Movie implements Media{

    private String id;
    private JSONObject dbInfo;

    public Movie(JSONObject initialDbInfo) {
	id = initialDbInfo.getString("imdbID");
	dbInfo = initialDbInfo;
    }

    public void setData(JSONObject newDBInfo) {
	dbInfo = newDBInfo;
    }

    public String getDatum(String tag) {
	try {
	    return dbInfo.getString(tag);
	} catch (JSONException e) {
	    return null;
	}
    }

    public String getId() {
        return id;
    }

    public String toString() {
        String s = "";
        s += getDatum("Title");
        s += "\n\t" + getDatum("Released");
        s += "\n\t" + getDatum("Plot").substring(0, 45) + "....";
        return s;
    }

}
