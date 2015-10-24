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
    private String entryDescription;
    private int[] location = new int[2];
    // TODO: Add more features

    public void setItem(Media newItem) {item = newItem;}
    public Media getItem() {return item;}
    public void setUserRating(double newRating) {userRating = newRating;}
    public double getUserRating() {return userRating;}
    public void setUserReview(String newReview) {userReview = newReview;}
    public String getUserReview() {return userReview;}
    public void setHasSeen(boolean seen) {hasSeen = seen;}
    public boolean getHasSeen() {return hasSeen;}
    public void setEntryDescription(String newDescription) {entryDescription = newDescription;}
    public String getEntryDescription() {return entryDescription;}
    
}
