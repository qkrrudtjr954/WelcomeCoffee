package com.coffee.dao.User;

import com.coffee.delegator.Delegator;
import com.coffee.dto.User;

public class Insert {
    public boolean insert(String id, char[] pwd, String name, String age){

        char temp;
        for (int i =0; i<age.length(); i++){
            temp = age.charAt(i);
            if( (int)temp < 48 || (int)temp > 58){
                return false;
            }
        }

        int intAge = Integer.parseInt(age);

        User user = new User(intAge, name, id, pwd);
        Delegator delegator = Delegator.getInstance();

        if(delegator.getUsers().add(user)){
            delegator.getUsers().stream().forEach(System.out::println);
            return true;
        }else{
            return false;
        }

    }
}
