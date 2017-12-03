package com.coffee.file;


import com.coffee.delegator.Delegator;
import com.coffee.dto.Coffee;
import com.coffee.dto.Ordered;
import com.coffee.dto.User;

import java.io.*;
import java.util.ArrayList;

public class FileClass {
    private static File userFile;
    private static File coffeeFile;
    private static File orderFile;


    private FileClass(String filename) {
        userFile = new File("/Users/kyungseok_park/Desktop/Users.txt");
        coffeeFile = new File("/Users/kyungseok_park/Desktop/Coffees.txt");
        orderFile = new File("/Users/kyungseok_park/Desktop/Orders.txt");

        try {
            if (userFile.createNewFile() && coffeeFile.createNewFile() && orderFile.createNewFile()) {
                System.out.println("FILE created");
            }else {
                System.out.println("ERROR");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeUserToFile(){
        Delegator delegator = Delegator.getInstance();

        ArrayList<User> users = delegator.getUsers();

        if(userFile != null ){
            try {
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(userFile)));

                users.stream().forEach(user -> {
                    pw.println(user.getId()+"-"+user.getPassword()+"-"+user.getName()+"-"+user.getAge());
                });
                pw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void writeCoffeeToFile(){
        Delegator delegator = Delegator.getInstance();

        ArrayList<Coffee> coffees = delegator.getCoffees();

        if(coffeeFile != null){
            try {
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(coffeeFile)));

                coffees.stream().forEach(coffee -> {
                    pw.println(coffee.getName()+"-"+coffee.getPrice()+"-"+coffee.getTall()+"-"+coffee.getGrande()+"-"+coffee.getPriceGap());
                });
                pw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeOrderedToFile(){
        Delegator delegator = Delegator.getInstance();

        ArrayList<Ordered> ordereds = delegator.getOrders();

        if(orderFile != null){
            try {
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(orderFile)));

                ordereds.stream().forEach(order -> {
                    pw.println();
                });
                pw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadFile(){

        if(file!=null){
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String temp[];
                String str = br.readLine();
                User tempUser = null;

                while((str != null)){
                    temp = str.split("-");

                    tempUser = new User();
                    tempUser.setNumber(Integer.parseInt(temp[0]));
                    tempUser.setName(temp[1]);
                    tempUser.setAge(Integer.parseInt(temp[2]));

                    Delegator.getInstance().getUsers().add(tempUser);
                    str = br.readLine();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
