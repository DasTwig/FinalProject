package com.example.twig.finalproject;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.twig.dataObjects.User;
import com.example.twig.dataObjects.Sale;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Thad on 3/28/2015.
 */
public class AddSaleTest extends ApplicationTestCase<Application> {

    public AddSaleTest() {
        super(Application.class);

        User u1 = new User("User1", "one@email.com", "Pass1");
        LatLng x = new LatLng(1.5, 1.8);
        Sale s1 = new Sale("Fish", 15.0, 1.5, 1.8);
        Sale s2 = new Sale("Dog", 10, 1.0, 2.0);

        //Sale list starts out empty
        assertEquals(u1.getSaleList().size(), 0);

        //Add sale
        u1.addSale("Fish", 15.0, x);
        //Sale list should now be 1
        assertEquals(u1.getSaleList().size(), 1);

        //saleList contains the sale that was added
        assertTrue(saleInList(u1.getSaleList(), s1));

        //saleList doesn't contain the sale that wasn't added (sanity check)
        assertFalse(saleInList(u1.getSaleList(), s2));


        /*********attempt adding a duplicate sales********/
        u1.addSale("Fish", 15.0, x);


        //size should go up since duplicates are allowed
        assertEquals(u1.getSaleList().size(), 2);

        //sale should be in the list
        assertTrue(saleInList(u1.getSaleList(), s1));

        //list should contain 2 occurrences of s1
        assertEquals(countInstancesOfSale(u1.getSaleList(), s1), 2);
    }

    /**
     * Helper method to find if a Sale list contains a specific Sale.
     */
    private boolean saleInList(ArrayList<Sale> sales, Sale s) {
        for(Sale f: sales) {
            if (f.getName().equals(s.getName()))
                return true;
        }

        return false;
    }

    /**
     * Counts the instances of a given Sale in a list of sales.
     *
     */
    private int countInstancesOfSale(ArrayList<Sale> sales, Sale s) {
        int count = 0;

        for(Sale f: sales) {
            if (f.getName().equals(s.getName()))
                count++;
        }

        return count;
    }
}