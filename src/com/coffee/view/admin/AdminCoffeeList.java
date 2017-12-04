package com.coffee.view.admin;

import com.coffee.delegator.Delegator;
import com.coffee.dto.Coffee;
import com.coffee.dto.User;
import com.coffee.view.Main;
import com.coffee.view.coffee.CoffeeAdd;
import com.coffee.view.coffee.CoffeeDetail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdminCoffeeList extends JFrame implements WindowListener, ActionListener{


    JLabel label;

    JTable table;
    JScrollPane jScrollPane;

    Object rowData[][];
    String columnNames[] = {"Coffee", "Short", "Tall", "Grande", "Price Gap"};

    JButton adminView;
    JButton main;
    JButton add;

    public AdminCoffeeList(){
        super("List");

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.orange);
        contentPane.setLayout(null);

        JLabel title = new JLabel("<html><span style='color:white;'>COFFEE LIST</span></html>");
        title.setBounds(150, 68, 200, 20);
        contentPane.add(title);

        Delegator delegator = Delegator.getInstance();
        ArrayList<Coffee> tempCoffee = delegator.getCoffees();

        rowData = new Object[tempCoffee.size()][columnNames.length];

        for (int i = 0; i < tempCoffee.size(); i++){
            rowData[i][0] = tempCoffee.get(i).getName();
            rowData[i][1] = tempCoffee.get(i).getPrice();
            rowData[i][2] = tempCoffee.get(i).getTall();
            rowData[i][3] = tempCoffee.get(i).getGrande();
            rowData[i][4] = tempCoffee.get(i).getPriceGap();
        }

        table = new JTable(rowData, columnNames);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = table.getSelectedRow();
                new CoffeeDetail(index);
            }
        });
        jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 95, 375, 300);
        contentPane.add(jScrollPane);








        JPanel panel = new JPanel();
        panel.setSize(150, 100);
        panel.setLayout(new GridLayout(2,1));
        panel.setLocation(100, 450);


        add = new JButton("ADD");
        add.setSize(150, 50);
        add.addActionListener(this);
        panel.add(add);


        JPanel btnPanel = new JPanel();
        btnPanel.setSize(150, 50);
        btnPanel.setLocation(115, 450);
        btnPanel.setLayout(new GridLayout(1, 2));


        adminView = new JButton("ADMIN");
        adminView.setSize(75, 50);
        adminView.addActionListener(this);
        btnPanel.add(adminView);


        main = new JButton("MAIN");
        main.setSize(75, 50);
        main.addActionListener(this);
        btnPanel.add(main);

        panel.add(btnPanel);

        contentPane.add(panel);




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
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if(obj == adminView){
            new AdminView();
        }else if(obj == main){
            new Main();
        }else{
            new CoffeeAdd();
        }
        this.dispose();
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
