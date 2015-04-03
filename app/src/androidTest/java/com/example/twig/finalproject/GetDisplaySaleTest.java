package com.example.twig.finalproject;

import com.example.twig.controllers.SaleController;
import com.example.twig.dataObjects.CurrentUser;
import com.example.twig.dataObjects.Sale;
import com.example.twig.dataObjects.User;
import com.google.android.gms.maps.model.LatLng;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.ArrayList;

public class GetDisplaySaleTest extends ApplicationTestCase<Application> {


    public GetDisplaySaleTest() {
        super(Application.class);

        User user = new User("User", "user@user.com", "userpass");
        User friend = new User("Friend", "friend@friend.com", "friendpass");

        Sale milk = new Sale("Milk", 2.00, 10.0, 10.0);
        Sale eggs = new Sale("Eggs", 3.00, 20.0, 20.0);
        Sale bread = new Sale("Bread", 50.00, 30.0, 30.0);

        friend.addSale("Milk", 2.00, new LatLng(10.0, 10.0));
        friend.addSale("Eggs", 3.00, new LatLng(20.0, 20.0));
        friend.addSale("Bread", 50.00, new LatLng(30.0, 30.0));

        user.addInterest("Milk", 5.00);
        user.addInterest("Eggs", 5.00);
        user.addInterest("Bread", 5.00);

        user.addFriend(friend);
        CurrentUser.setCurrentUser(user);

        ArrayList<Sale> tester = SaleController.getSaleController().getDisplaySale();
        assertTrue(saleListContains(tester, milk));
        assertTrue(saleListContains(tester, eggs));
        assertFalse(saleListContains(tester, bread));

    }

    /**
     * Helper method to determine whether a sale list contains the given sale
     * @param list the list that is being searched
     * @param sale the sale being searched for
     * @return whether the list contains the sale
     */
    public boolean saleListContains(ArrayList<Sale> list, Sale sale) {
        for (Sale s: list) {
            if(s.getName() == sale.getName() && s.getPrice() == sale.getPrice()) {
                return true;
            }
        }

        return false;
    }
}