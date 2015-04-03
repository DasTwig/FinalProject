package com.example.twig.finalproject;

import com.example.twig.dataObjects.Friend;
import com.example.twig.dataObjects.User;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddFriendTest {

    @Before
    public void setUp() throws Exception {
        //All setup done in method.
    }

    @Test
    public void testAddFriend() {
        User user1 = new User("Bob", "testemailB", "passwordBob");
        User user2 = new User("Gary", "testemailG", "passwordGary");
        User user3 = new User("Dave", "testemailD", "passwordDave");
        user1.addFriend(user2);
        user1.addFriend(user3);

        List<Friend> list = user1.getFriendList();
        assertEquals(list.get(0), user1);
        assertEquals(list.get(1), user2);
        assertEquals(list.get(0), user1);
        assertEquals(list.get(1), user2);
    }
}