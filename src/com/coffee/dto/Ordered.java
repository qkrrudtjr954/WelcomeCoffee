package com.coffee.dto;

import com.coffee.delegator.Delegator;

import java.util.HashMap;

public class Ordered {
    // Coffee coffee,
    // String size,
    // int count,
    // HashMap<String, Boolean> etc

    Coffee coffee;
    User user;
    HashMap<String, Boolean> etc;
    String size;
    int count;
    String orderStr;

    public Ordered(){

    }

    public Ordered(User user, Coffee coffee, HashMap<String, Boolean> etc, String size, int count) {
        this.coffee = coffee;
        this.user = user;
        this.etc = etc;
        this.size = size;
        this.count = count;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HashMap<String, Boolean> getEtc() {
        return etc;
    }

    public void setEtc(HashMap<String, Boolean> etc) {
        this.etc = etc;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSyrup(){
        StringBuilder str = new StringBuilder();

        if(this.etc.get("hazelnut")){
            str.append("HazelNut");
        }

        if(this.etc.get("caramel")){
            str.append(" Caramel ");
        }

        if(this.etc.get("vanilla")){
            str.append(" Vanilla");
        }

        if(str.equals("")){
            str.append("no");
        }

        System.out.println(str.toString());

        return str.toString();
    }

    public String getOrderStr(){
        StringBuilder str = new StringBuilder("");

        str.append(this.coffee);
        str.append(" ");
        str.append(this.size);

        str.append(" ( ");
        if(this.etc.get("hazelnut")){
            str.append("HazelNut");
        }
        if(this.etc.get("caramel")){
            str.append(" Caramel ");
        }
        if(this.etc.get("vanilla")){
            str.append(" Vanilla");
        }
        str.append(" ), ");

        if(this.etc.get("whipping")){
            str.append(" Whipping Cream, ");
        }
        if(this.etc.get("shot")){
            str.append(" add Shot,  ");
        }

        str.append(this.count);
        str.append("잔");

        return str.toString();
    }

    public int getTotalPrice(){
        Delegator delegator = Delegator.getInstance();

        Coffee coffee = null;

        for (int i=0; i < delegator.getCoffees().size(); i++){
            if(delegator.getCoffees().get(i).equals(this.coffee)){
                coffee = delegator.getCoffees().get(i);
                break;
            }
        }

        int total = 0;

        if(this.size.equals("Short")){
            total += coffee.getPrice();
        }else if(this.size.equals("Tall")){
            total += coffee.getTall();
        }else if(this.size.equals("Grande")){
            total += coffee.getGrande();
        }


        if(this.etc.get("hazelnut")){
            total += 500;
        }
        if(this.etc.get("caramel")){
            total += 500;
        }
        if(this.etc.get("vanilla")){
            total += 500;
        }


        if(this.etc.get("whipping")){
            total += 500;
        }
        if(this.etc.get("shot")){
            total += 500;
        }

        total = total * this.count;

        return total;
    }

    @Override
    public String toString() {
        return "Ordered{" +
                "coffee=" + coffee +
                ", user=" + user +
                ", etc=" + etc +
                ", size='" + size + '\'' +
                ", count=" + count +
                '}';
    }
}
