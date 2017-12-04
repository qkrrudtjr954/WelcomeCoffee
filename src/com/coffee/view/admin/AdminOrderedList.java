package com.coffee.view.admin;

import com.coffee.delegator.Delegator;
import com.coffee.dto.Ordered;
import com.coffee.view.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdminOrderedList extends JFrame implements WindowListener, ActionListener{


    JLabel label;

    JTable table;
    JScrollPane jScrollPane;

    Object rowData[][];
    String columnNames[] = {"Coffee", "Syrup", "Size", "Whipping", "Shot", "Count", "Total"};

    JButton adminView;
    JButton main;

    public AdminOrderedList(){
        super("List");

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.orange);
        contentPane.setLayout(null);

        JLabel title = new JLabel("<html><span style='color:white;'>ORDER LIST</span></html>");
        title.setBounds(150, 68, 200, 20);
        contentPane.add(title);

        Delegator delegator = Delegator.getInstance();
        ArrayList<Ordered> tempOrder = delegator.getOrders();

        rowData = new Object[tempOrder.size()][columnNames.length];

        for (int i = 0; i < tempOrder.size(); i++){
            rowData[i][0] = tempOrder.get(i).getCoffee().getName();
            rowData[i][1] = tempOrder.get(i).getSyrup();
            rowData[i][2] = tempOrder.get(i).getSize();
            if(tempOrder.get(i).getEtc().get("whipping")){
                rowData[i][3] = "add";
            }else{
                rowData[i][3] = "no";
            }

            if(tempOrder.get(i).getEtc().get("shot")){
                rowData[i][4] = "add";
            }else{
                rowData[i][4] = "no";
            }

            rowData[i][5] = tempOrder.get(i).getCount();
            rowData[i][6] = tempOrder.get(i).getTotalPrice();
        }

        table = new JTable(rowData, columnNames);
        jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 95, 375, 300);
        contentPane.add(jScrollPane);


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

        contentPane.add(btnPanel);



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
        }else{
            new Main();
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
