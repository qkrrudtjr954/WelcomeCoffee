package com.coffee.dao.Coffee;

import com.coffee.delegator.Delegator;
import com.coffee.dto.Coffee;
import com.coffee.view.admin.AdminCoffeeList;

import javax.swing.*;

public class Insert {
    public boolean insert(String coffeeName, int price, int priceGap){

        Delegator delegator = Delegator.getInstance();

        boolean bool = delegator.getCoffees().stream().anyMatch(coffee -> coffee.getName().equals(coffeeName));
        if(bool){
            return false;
        }else{
            Coffee coffee = new Coffee(coffeeName, price, priceGap);
            if(delegator.getCoffees().add(coffee)){
                return true;
            }else{
                return false;
            }
        }
    }
}
