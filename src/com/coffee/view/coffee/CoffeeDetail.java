package com.coffee.view.coffee;

import com.coffee.delegator.Delegator;
import com.coffee.dto.Coffee;
import com.coffee.view.Menu;
import com.coffee.view.admin.AdminCoffeeList;
import com.coffee.view.admin.AdminView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CoffeeDetail extends JFrame implements WindowListener, ActionListener {

    JButton admin;
    JButton add;
    JButton delete;

    Coffee coffee;
    int index;

    public CoffeeDetail(int index){
        super("");


        this.index = index;


        Container contentPane = getContentPane();
        contentPane.setBackground(Color.orange);
        contentPane.setLayout(null);

        Delegator delegator = Delegator.getInstance();
        coffee = delegator.getCoffees().get(index);

        JLabel title = new JLabel("<html><span style='color:white;'>"+coffee.getName()+"</span></html>");
        title.setBounds(150, 68, 200, 20);
        contentPane.add(title);


        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(100, 100, 50, 20);
        contentPane.add(priceLabel);

        JLabel price = new JLabel(""+coffee.getPrice());
        price.setBounds(120, 130, 150, 20);
        contentPane.add(price);



        JLabel tallLabel = new JLabel("Tall Price");
        tallLabel.setBounds(100, 170, 150, 20);
        contentPane.add(tallLabel);

        JLabel tall = new JLabel(""+coffee.getTall());
        tall.setBounds(120, 200, 150, 20);
        contentPane.add(tall);



        JLabel grandeLabel = new JLabel("Grande Price");
        grandeLabel.setBounds(100, 240, 150, 20);
        contentPane.add(grandeLabel);

        JLabel grande = new JLabel(""+coffee.getGrande());
        grande.setBounds(120, 270, 150, 20);
        contentPane.add(grande);



        JLabel priceGapLabel = new JLabel("Price Gap");
        priceGapLabel.setBounds(100, 310, 150, 20);
        contentPane.add(priceGapLabel);

        JLabel priceGap = new JLabel(""+coffee.getPriceGap());
        priceGap.setBounds(120, 340, 150, 20);
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


        delete = new JButton("DELETE");
        delete.setSize(75, 50);
        delete.addActionListener(this);
        btnPanel.add(delete);

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
        }else if(obj == delete){
            int i = JOptionPane.showConfirmDialog(null, "Are You Sure?");
            if(i==0){
                Delegator.getInstance().getCoffees().remove(this.index);
                new AdminCoffeeList();
                this.dispose();
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
