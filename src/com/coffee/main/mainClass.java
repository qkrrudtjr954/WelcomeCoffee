package com.coffee.main;

import com.coffee.delegator.Delegator;
import com.coffee.dto.Coffee;
import com.coffee.dto.User;
import com.coffee.file.FileClass;
import com.coffee.view.Main;
import com.coffee.view.Menu;
import com.coffee.view.Order;
import com.coffee.view.SignUp;
import com.coffee.view.admin.AdminView;

public class mainClass {
    public static void main(String[] args) {
        Coffee coffee1 = new Coffee("Cafe Latte", 4800, 500);
        Coffee coffee2 = new Coffee("Americano", 3000, 700);
        Coffee coffee3 = new Coffee("Caramel Makiato", 4300, 300);
        Coffee coffee4 = new Coffee("Hazel Nut", 4000, 500);

        char[] pwd = {'a','d','m','i','n'};
        User user = new User(25, "admin", "admin", pwd );

        Delegator.getInstance().getUsers().add(user);

        Delegator.getInstance().getCoffees().add(coffee1);
        Delegator.getInstance().getCoffees().add(coffee2);
        Delegator.getInstance().getCoffees().add(coffee3);
        Delegator.getInstance().getCoffees().add(coffee4);


        FileClass fileClass = new FileClass();

        fileClass.loadUserFromFile();
        fileClass.loadOrderedFromFile();


        new Main();
    }

}
