package com.example.twig.finalproject;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.twig.dataObjects.Friend;
import com.example.twig.dataObjects.User;

import java.util.ArrayList;

/**
 * Created by Piyakorn on 4/2/2015.
 */
public class DeleteFriendTest extends ApplicationTestCase<Application> {

    public DeleteFriendTest() {
        super(Application.class);

        User user1 = new User("User1", "u1@gmail.com", "u1");
        User user2 = new User("User2", "u2@gmail.com", "u2");
        User user3 = new User("User3", "u3@gmail.com", "u3");
        User user4 = new User("User4", "u4@gmail.com", "u4");
        User user5 = new User("User5", "u5@gmail.com", "u5");

        //Empty friendlist
        assertEquals(user1.getFriendList().size(), 0);

        // add friends to user1
        user1.addFriend(user2);
        user1.addFriend(user3);
        user1.addFriend(user4);

        //check current number of friends - 3
        assertEquals(user1.getFriendList().size(), 3);

        //delete user2 from friendlist
        user1.removeFriend(user2);


        //checks that user2 and user5 are not on friendlist, but everyone else is still there
        assertFalse(friendList(user1.getFriendList(), user2));
        assertFalse(friendList(user1.getFriendList(), user5));
        assertTrue(friendList(user1.getFriendList(), user3));
        assertTrue(friendList(user1.getFriendList(), user4));

        // deleting user not in friendlist
        user1.removeFriend(user5);

        // should still have 2 friends
        assertEquals(user1.getFriendList().size(), 2);

        assertFalse(friendList(user1.getFriendList(), user2));
        assertFalse(friendList(user1.getFriendList(), user5));
        assertTrue(friendList(user1.getFriendList(), user3));
        assertTrue(friendList(user1.getFriendList(), user4));

        //empty friend list - check to see if you can remove everyone and re-add
        user1.removeFriend(user3);
        user1.removeFriend(user4);

        assertEquals(user1.getFriendList().size(), 0);

        //re-add user2 - friend count: 1
        user1.addFriend(user2);
        assertEquals(user1.getFriendList().size(), 1);
        assertTrue(friendList(user1.getFriendList(), user2));
        assertFalse(friendList(user1.getFriendList(), user3));
        assertFalse(friendList(user1.getFriendList(), user4));
        assertFalse(friendList(user1.getFriendList(), user5));

        //check to make sure user2's friendlist contains user1
        assertEquals(user2.getFriendList().size(), 1);
        assertTrue(friendList(user2.getFriendList(), user1));

        // user2 removes user1 - check to make sure they don't still have each other in friendlist
        user2.removeFriend(user1);

        assertEquals(user1.getFriendList().size(), 0);
        assertFalse(friendList(user1.getFriendList(), user2));

        assertEquals(user2.getFriendList().size(), 0);
        assertFalse(friendList(user2.getFriendList(), user1));

    }

    /**
     * Method that traverse through the list of friends and check if they're there
     * @param friends
     * @param user
     * @return
     */
    private boolean friendList(ArrayList<Friend> friends, User user) {
        for(Friend f: friends) {
            if (f.getUser().equals(user))
                return true;
        }
        return false;
    }
}
