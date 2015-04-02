package com.example.twig.dataObjects;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Wrapper class for the currently logged in user.
 *
 * Created by Andrew on 2/18/2015.
 */
public class CurrentUser implements Serializable {
    private static User current;
    private static String filename;

    /**
     * Don't allow anyone to construct a CurrentUser
     */
    private CurrentUser() {
    }

    /**
     * Sets the current user.
     *
     * @param u - the user to set the current user to
     */
    public static void setCurrentUser(User u) {
        current = u;
        saveCurrentUser();
    }

    /**
     * Gets the current user.
     *
     * @return the current user.
     */
    public static User getCurrentUser() {
        return current;
    }

    /**
     * Convenience method for logging out, instead
     * of calling setCurrentUser(null)
     */
    public static void logOut() {
        setCurrentUser(null);
    }

// --Commented out by Inspection START (4/2/2015 2:19 PM):
//    /**
//     * Loads the current user from file.
//     */
//    public static void loadCurrentUser() {
//        try {
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
//            current = (User)in.readObject();
//            in.close();
//        } catch(Exception e) {
//            System.out.println("Error reading in data: " + e.getMessage());
//        }
//    }
// --Commented out by Inspection STOP (4/2/2015 2:19 PM)

    /**
     * Saves the current user to file.
     */
    private static void saveCurrentUser() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(current);
            out.close();
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

// --Commented out by Inspection START (4/2/2015 2:19 PM):
//    /**
//     * Set the name of the file that this class should save to/load from.
//     * Should be set during app initialisation.
//     *
//     * @param str - the filename to save to
//     */
//    public static void setSaveFilename(String str) {
//        filename = str;
//    }
// --Commented out by Inspection STOP (4/2/2015 2:19 PM)

// --Commented out by Inspection START (4/2/2015 2:19 PM):
//    /**
//     * Get the name of the file that this class saves to/loads from.
//     */
//    public static String getSaveFilename() {
//        return filename;
//    }
// --Commented out by Inspection STOP (4/2/2015 2:19 PM)
}
