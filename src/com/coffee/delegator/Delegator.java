package com.coffee.delegator;

import com.coffee.dto.Coffee;
import com.coffee.dto.Ordered;
import com.coffee.dto.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Delegator {
    private static Delegator instance;
    private User current_user;
    private ArrayList<User> users;
    private ArrayList<Coffee> coffees;
    private ArrayList<Ordered> orders;

    private Delegator(){
        users = new ArrayList<>();
        coffees = new ArrayList<>();
        orders = new ArrayList<>();
        current_user = null;

    }

    public static Delegator getInstance() {
        if(instance == null){
            instance = new Delegator();
        }

        return instance;
    }

    public User getCurrent_user() {
        return current_user;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setCurrent_user(User current_user) {
        this.current_user = current_user;
    }

    public ArrayList<Coffee> getCoffees() {

        return coffees;
    }

    public ArrayList<Ordered> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Ordered> orders) {
        this.orders = orders;
    }
}
