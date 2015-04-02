package com.example.twig.dataObjects;

import java.io.Serializable;

/**
 * Wrapper for a user, that also includes, their
 * rating as a friend.
 *
 * Created by Piyakorn on 2/12/2015.
 */
public class Friend implements Serializable {
    private final User user;
    private int rating;


    /**
     * Constructor for a Friend object.
     *
     * @param u - the user friend
     */
    public Friend(User u) {
        user = u;
        rating = 0; //-1 means no rating has been given
    }

    /**
     * Getter for name.
     * @return the name
     */
    public User getUser() {
        return user;
    }

    /**
     * Getter for the friend's rating.
     *
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Setter to change the user's rating.
     *
     * @param rate - the new rating
     */
    public void setRating(int rate) {
        rating = rate;
        UserList.saveUserList();
    }

// --Commented out by Inspection START (4/2/2015 2:20 PM):
//    /**
//     * Increments sales reported for the friend.
//     */
//    public void incrementSalesReported() {
//        salesReported++;
//    }
// --Commented out by Inspection STOP (4/2/2015 2:20 PM)

// --Commented out by Inspection START (4/2/2015 2:20 PM):
//    /**
//     * Getter for sales reported.
//     *
//     * @return number of sales reported.
//     */
//    public int getSalesReported() {
//        return salesReported;
//    }
// --Commented out by Inspection STOP (4/2/2015 2:20 PM)

    /**
     * Returns the friend's name.
     *
     * @return friend's name.
     */
    public String toString() {
        return user.getName();
    }
}