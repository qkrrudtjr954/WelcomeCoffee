package com.coffee.view.coffee;

import com.coffee.dao.Coffee.Insert;
import com.coffee.delegator.Delegator;
import com.coffee.dto.Coffee;
import com.coffee.file.FileClass;
import com.coffee.view.admin.AdminCoffeeList;
import com.coffee.view.admin.AdminView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CoffeeAdd extends JFrame implements WindowListener, ActionListener {

    JButton admin;
    JButton add;
    JButton list;

    JTextField price;
    JTextField priceGap;
    JTextField name;


    public CoffeeAdd(){
        super("");


        Container contentPane = getContentPane();
        contentPane.setBackground(Color.orange);
        contentPane.setLayout(null);

        JLabel title = new JLabel("<html><span style='color:white;'>ADD COFFEE</span></html>");
        title.setBounds(150, 68, 200, 20);
        contentPane.add(title);


        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(100, 100, 50, 20);
        contentPane.add(nameLabel);

        name = new JTextField();
        name.setBounds(100, 130, 150, 20);
        contentPane.add(name);



        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(100, 170, 50, 20);
        contentPane.add(priceLabel);

        price = new JTextField();
        price.setBounds(100, 200, 150, 20);
        contentPane.add(price);



        JLabel priceGapLabel = new JLabel("Price Gap");
        priceGapLabel.setBounds(100, 240, 150, 20);
        contentPane.add(priceGapLabel);

        priceGap = new JTextField();
        priceGap.setBounds(100, 270, 150, 20);
        contentPane.add(priceGap);






        JPanel panel = new JPanel();
        panel.setSize(150, 100);
        panel.setLayout(new GridLayout(2,1));
        panel.setLocation(100, 450);

        admin = new JButton("ADMIN");
        admin.setSize(150, 50);
        admin.addActionListener(this);
        panel.add(admin);


        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1, 2));

        add = new JButton("ADD");
        add.setSize(75, 50);
        add.addActionListener(this);
        btnPanel.add(add);


        list = new JButton("LIST");
        list.setSize(75, 50);
        list.addActionListener(this);
        btnPanel.add(list);

        panel.add(btnPanel);

        contentPane.add(panel);




        setBounds(100, 100, 375, 667);
        setResizable(false);
        setVisible(true);
        addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if(obj == admin){
            new AdminView();
            this.dispose();
        }else if(obj == list){
            new AdminCoffeeList();
            this.dispose();
        }else{
            String coffeeName = this.name.getText();
            int price = Integer.parseInt(this.price.getText());
            int priceGap = Integer.parseInt(this.priceGap.getText());
            Insert coffeeInsert = new Insert();
            boolean result = coffeeInsert.insert(coffeeName, price, priceGap);

            if(result){
                FileClass fileClass = new FileClass();
                fileClass.writeCoffeeToFile();

                JOptionPane.showMessageDialog(new AdminCoffeeList(), "Add Successfully");
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Coffee already exist");
            }


        }


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
