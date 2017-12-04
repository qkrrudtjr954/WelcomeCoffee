package com.coffee.file;


import com.coffee.delegator.Delegator;
import com.coffee.dto.Coffee;
import com.coffee.dto.Ordered;
import com.coffee.dto.User;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FileClass {
    private static File userFile;
    private static File coffeeFile;
    private static File orderFile;


    public FileClass() {
        userFile = new File("/Users/kyungseok_park/Desktop/Users.txt");
        coffeeFile = new File("/Users/kyungseok_park/Desktop/Coffees.txt");
        orderFile = new File("/Users/kyungseok_park/Desktop/Orders.txt");

        try {
            if (userFile.createNewFile() && coffeeFile.createNewFile() && orderFile.createNewFile()) {
                System.out.println("FILE created");
            }else {
                System.out.println("FILE exist");
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
                    pw.println(user.getId()+"-"+new String(user.getPassword())+"-"+user.getName()+"-"+user.getAge());
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
                    pw.println(order.getCoffee().getName()+"-"+order.getSize()+"-"+order.getUser().getId()+"-"+order.getEtc().get("hazelnut")+"-"+order.getEtc().get("caramel")+"-"+order.getEtc().get("vanilla")+"-"+order.getEtc().get("whipping")+"-"+order.getEtc().get("shot")+"-"+order.getCount());
                });
                pw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadOrderedFromFile(){
        if(orderFile != null){
            try{
                BufferedReader br = new BufferedReader(new FileReader(orderFile));
                String str;
                String temp[];

                Ordered ordered;

                Coffee coffee = null;
                User user = null;
                HashMap<String, Boolean> etc;

                Delegator delegator = Delegator.getInstance();

                while((str = br.readLine()) != null){
                    temp = str.split("-");
                    ordered = new Ordered();

                    for (int i = 0; i < delegator.getCoffees().size(); i++){
                        if(delegator.getCoffees().get(i).getName().equals(temp[0])){
                            coffee = delegator.getCoffees().get(i);
                            break;
                        }
                            
                    }
                    ordered.setCoffee(coffee);


                    ordered.setSize(temp[1]);


                    for (int i =0; i<delegator.getUsers().size(); i++){
                        if(delegator.getUsers().get(i).getId().equals(temp[2])){
                            user = delegator.getUsers().get(i);
                            break;
                        }
                    }
                    ordered.setUser(user);


                    etc = new HashMap<>();
                    etc.put("hazelnut", Boolean.parseBoolean(temp[3]));
                    etc.put("caramel", Boolean.parseBoolean(temp[4]));
                    etc.put("vanilla", Boolean.parseBoolean(temp[5]));

                    etc.put("whipping", Boolean.parseBoolean(temp[6]));
                    etc.put("shot", Boolean.parseBoolean(temp[7]));
                    ordered.setEtc(etc);


                    ordered.setCount(Integer.parseInt(temp[8]));

                    delegator.getOrders().add(ordered);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void loadUserFromFile(){

        if(userFile!=null){
            try {
                BufferedReader br = new BufferedReader(new FileReader(userFile));
                String temp[] = null;
                String str;
                User tempUser = null;
                char[] password;

                while((str = br.readLine()) != null){
                    temp = str.split("-");

                    tempUser = new User();
                    tempUser.setId(temp[0]);

                    password = new char[temp[1].length()];
                    for (int i=0; i<temp[1].length(); i++){
                        password[i] = temp[1].charAt(i);
                    }
                    tempUser.setPassword(password);
                    tempUser.setName(temp[2]);
                    tempUser.setAge(Integer.parseInt(temp[3]));

                    Delegator.getInstance().getUsers().add(tempUser);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
