package com.coffee.view.admin;

import com.coffee.view.Main;
import com.coffee.view.OrderedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminView extends JFrame implements WindowListener{

    JLabel label;

    JButton orders;
    JButton coffees;
    JButton users;
    JButton main;

    public AdminView(){
        super("");

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.orange);
        contentPane.setLayout(null);

        JLabel title = new JLabel("<html><span style='color:white;'>ADMIN</span></html>");
        title.setBounds(160, 68, 200, 20);
        contentPane.add(title);

        orders = new JButton("ORDERS");
        orders.setBounds(100, 200, 175, 50);
        orders.addActionListener((ActionEvent e) -> {
            new AdminOrderedList();
            this.dispose();
        });
        contentPane.add(orders);

        coffees = new JButton("COFFEES");
        coffees.setBounds(100, 270, 175, 50);
        coffees.addActionListener((ActionEvent e) -> {
            new AdminCoffeeList();
            this.dispose();
        });
        contentPane.add(coffees);

        users = new JButton("USERS");
        users.setBounds(100, 340, 175, 50);
        users.addActionListener((ActionEvent e) -> {
            new AdminUserList();
            this.dispose();
        });
        contentPane.add(users);

        main = new JButton("MAIN");
        main.setBounds(100, 410, 175, 50);
        main.addActionListener((ActionEvent e) -> {
            new Main();
            this.dispose();
        });
        contentPane.add(main);






        //--------------------------------------------------
        label = new JLabel("---");
        label.setBounds(0,0,100,30);
        add(label);
        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                label.setText("x: "+x+ "  y: "+y);
            }
        });
        //--------------------------------------------------

        setBounds(100, 100, 375, 667);
        setResizable(false);
        setVisible(true);
        addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
