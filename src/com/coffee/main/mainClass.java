package com.coffee.main;

import com.coffee.delegator.Delegator;
import com.coffee.dto.Coffee;
import com.coffee.dto.User;
import com.coffee.view.Main;
import com.coffee.view.Menu;
import com.coffee.view.Order;
import com.coffee.view.SignUp;

public class mainClass {
    public static void main(String[] args) {
        Coffee coffee = new Coffee("test", 4800, 500);

        char[] pwd = {'1', '2', '1', '6'};
        User user = new User(25, "park", "qkrrudtjr954", pwd );

        Delegator.getInstance().getUsers().add(user);
        Delegator.getInstance().getCoffees().add(coffee);

        new Main();
    }

}
