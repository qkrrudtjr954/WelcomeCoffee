package com.coffee.dto;

import com.coffee.delegator.Delegator;

import java.util.Arrays;

public class User {
    private int age;
    private String name;
    private String id;
    private char[] password;

    public User(){

    }

    public User(int age, String name, String id, char[] password) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public static boolean isUser(String id, char[] pwd){
        Delegator delegator = Delegator.getInstance();
        boolean result = delegator.getUsers().stream()
                .anyMatch(user ->
                        user.getId().equals(id) && User.isCorrectPwd(pwd, user.getPassword()));

        return result;
    }

    public static User getUserById(String id){
        Delegator delegator = Delegator.getInstance();
        User user = null;
        for (int i=0; i<delegator.getUsers().size(); i++){
            if(delegator.getUsers().get(i).getId().equals(id)){
                user = delegator.getUsers().get(i);
            }
        }

        return user;
    }


    public static boolean isCorrectPwd(char[] pwd1, char[] pwd2){
        boolean result = true;

        if (pwd1.length != pwd2.length){
            result = false;
        }else{
            for (int i=0; i<pwd1.length; i++){
                if(pwd1[i] != pwd2[i]){
                    result = false;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
