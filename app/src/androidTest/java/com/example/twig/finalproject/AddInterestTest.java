package com.example.twig.finalproject;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.twig.dataObjects.Interest;
import com.example.twig.dataObjects.User;

import java.util.ArrayList;

/**
 * Created by Porter Rivers on 3/29/2015.
 */
public class AddInterestTest extends ApplicationTestCase<Application> {

    public AddInterestTest() {
        super(Application.class);

        String testName = "item1";
        double price1 = 50;
        double price2 = 40;
        User testUser = new User("name", "email", "password");

        //First test tests the branch where the item to be added is not in the interest list.
        testUser.addInterest("item1", price1);
        ArrayList<Interest> testList = testUser.getInterestList();
        Interest testInterest = testList.get(0);

        assertEquals(1, testList.size());
        assertEquals(testName, testInterest.getName());
        assertEquals(price1, testInterest.getPrice());

        //Second test tests the branch where the item to be added is in the interest list.
        testUser.addInterest("item1", price2);
        testList = testUser.getInterestList();

        assertEquals(testList.size(), 1);
        assertEquals(testName, testInterest.getName());
        assertEquals(price2, testInterest.getPrice());
    }
}
