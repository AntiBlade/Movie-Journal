/*
 * Entry.java
 * Purpose: Contains a Media and user-entered values
 *      By: Caleb Lucas-Foley, Harrison Keiser, Chris Phifer
 *      On: October 23, 2015
 */

public class Entry {
    private Media item;
    private double userRating;
    private String userReview;
    private boolean hasSeen;
    private int dateSeen;
    private String entryDescription;
    private int[] location = new int[2];
    // TODO: Add more features

    /*
     * setItem
     * Purpose: Sets the item field
     * Parameters: (Media) newItem
     * Returns: Nothing (sets a value)
     */
    public void setItem(Media newItem) {item = newItem;}

    /*
     * getItem
     * Purpose: Gets value in item field
     * Parameters: None
     * Returns: The value in item
     */
    public Media getItem() {return item;}
    
    /*
     * setUserRating
     * Purpose: Set the userRating field
     * Parameters: (double) newRating
     * Returns: Nothing (sets a value)
     */
    public void setUserRating(double newRating) {userRating = newRating;}

    /*
     * getUserRating
     * Purpose: Gets the value in userRating
     * Parameters: None
     * Returns: The value in userRating
     */
    public double getUserRating() {return userRating;}

    /*
     * setUserReview
     * Purpose: Set the userReview field
     * Parameters: (String) newReview
     * Returns: Nothing (sets a value)
     */
    public void setUserReview(String newReview) {userReview = newReview;}

    /*
     * getUserReview
     * Purpose: Gets the value in userReview
     * Parameters: None
     * Returns: The value in userReview
     */
    public String getUserReview() {return userReview;}

    /* 
     * setHasSeen
     * Purpose: Set the hasSeen field
     * Parameters: (boolean) seen
     * Returns: Nothing (sets a value)
     */
    public void setHasSeen(boolean seen) {hasSeen = seen;}

    /*
     * getHasSeen
     * Purpose: Gets the value in hasSeen
     * Parameters: None
     * Returns: The value in hasSeen
     */
    public boolean getHasSeen() {return hasSeen;}

    /*
     * setDateSeen
     * Purpose: Set the dateSeen field
     * Parameters: (int) newDate
     * Returns: Nothing (sets a value) 
     */
    public void setDateSeen(int newDate) {dateSeen = newDate;}

    /*
     * getDateSeen
     * Purpose: Gets the value in dateSeen
     * Parameters: None
     * Returns: The value in dateSeen
     */
    public int getDateSeen() {return dateSeen;}

    /*
     * setEntryDescription
     * Purpose: Set the entryDescription field
     * Parameters: (String) newDescription
     * Returns: Nothing (sets a value)
     */
    public void setEntryDescription(String newDescription) {entryDescription = newDescription;}

    /*
     * getEntryDescription
     * Purpose: Gets the value in entryDescription 
     * Parameters: None
     * Returns: The value in entryDescription
     */
    public String getEntryDescription() {return entryDescription;}

    /*
     * setLocation
     * Purpose: Set the location field
     * Parameters: (int[]) newLocation
     * Returns: Nothing (sets a value)
     */
    public void setLocation(int[] newLocation) {location = newLocation;}

    /*
     * getLocation
     * Purpose: Get the value in location 
     * Parameters: None
     * Returns The value in location
     */
    public int[] getLocation() {return location;}
}
