import org.json.*;

public class Movie {

    private String id;
    private JSONObject dBInfo;

    public void setInfo() {
	dBInfo = Database.idSearch(id);
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
