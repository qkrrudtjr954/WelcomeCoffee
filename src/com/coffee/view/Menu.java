package com.coffee.view;

import com.coffee.delegator.Delegator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements WindowListener {
    JLabel label;


    Object rowData[][];
    String columnNames[] = {"Coffee Name", "Short", "Tall", "Grande"};

    JTable table;
    JScrollPane jScrollPane;

    public Menu(){
        super("");
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.orange);
        contentPane.setLayout(null);

        JLabel title = new JLabel("<html><span style='color:white;'>MENU</span></html>");
        title.setBounds(165, 30, 100, 20);
        contentPane.add(title);

        Delegator delegator = Delegator.getInstance();
        rowData = new Object[delegator.getCoffees().size()][columnNames.length];

        for (int i=0; i<delegator.getCoffees().size(); i++){
            rowData[i][0] = delegator.getCoffees().get(i).getName();
            rowData[i][1] = delegator.getCoffees().get(i).getPrice();
            rowData[i][2] = delegator.getCoffees().get(i).getTall();
            rowData[i][3] = delegator.getCoffees().get(i).getGrande();
        }

        table = new JTable(rowData, columnNames);
        jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 70, 375, 300);
        contentPane.add(jScrollPane);

        JButton close = new JButton("CLOSE");
        close.setBounds(129, 380, 100, 20);
        close.setBackground(Color.WHITE);
        close.setBorder(new LineBorder(Color.black, 2));

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.super.dispose();
            }
        });

        contentPane.add(close);




        setBounds(475, 100, 375, 450);
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
