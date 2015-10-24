/*
 * Media.java
 * Purpose: Interface for the basic types of media
 *      By: Caleb Foley, Harrison Keiser, Chris Phifer
 *      On: October 23, 2015
 */
import org.json.*;

interface Media {
    /**
     * Sets the information in this implementation of 
     * Media. 
     * @param JSONObject newDBInfo - the JSONObject from the online database
     * @return N/A
     */
    void setInfo(JSONObect newDBInfo);

    /**
     * Gets the info corresponding to a given tag
     * @param String tag - the particular property requested 
     * @return String - the value corresponding to the property 
     */
    String getInfo(String tag);
}
