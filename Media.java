/*
 * Media.java
 * Purpose: Interface for the basic types of media
 *      By: Caleb Foley, Harrison Keiser, Chris Phifer
 *      On: October 23, 2015
 */
import org.json.*;

interface Media {
    void setInfo(JSONObect newDBInfo);
    String getInfo(String tag);
}
