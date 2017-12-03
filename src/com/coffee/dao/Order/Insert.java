package com.coffee.dao.Order;

import com.coffee.delegator.Delegator;
import com.coffee.dto.Coffee;
import com.coffee.dto.Ordered;
import com.coffee.dto.User;

import java.util.HashMap;

public class Insert {

    public boolean insert(Coffee coffee, String size, int count, HashMap<String, Boolean> etc){
        User current = Delegator.getInstance().getCurrent_user();

        Ordered ordered = new Ordered(current, coffee, etc, size, count);
        Delegator delegator= Delegator.getInstance();

        if(delegator.getOrders().add(ordered)){
            return true;
        }else{
            return false;
        }
    }

}
