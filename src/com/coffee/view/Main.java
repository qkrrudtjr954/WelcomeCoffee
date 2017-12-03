package com.coffee.view;

import com.coffee.delegator.Delegator;
import com.coffee.file.FileClass;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements WindowListener {
    JLabel label;
    public Main(){
        super("Main");
        FileClass fileClass = new FileClass();

        fileClass.loadUserFromFile();
        fileClass.loadOrderedFromFile();

        Delegator.getInstance().getUsers().stream().forEach(System.out::println);
        Delegator.getInstance().getOrders().stream().forEach(System.out::println);


        Container contentPane = getContentPane();
        contentPane.setBackground(Color.orange);
        contentPane.setLayout(null);

        JLabel title = new JLabel("<html><span style='color:white;'>WELCOME COFFEE</span></html>");
        title.setBounds(129, 68, 300, 20);
        contentPane.add(title);

        JButton start = new JButton("START");
        start.setBounds(129, 400, 100, 20);
        start.setBackground(Color.WHITE);
        start.setBorder(new LineBorder(Color.black, 2));

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delegator delegator = Delegator.getInstance();

                if(delegator.getCurrent_user()!=null){
                    new Order();
                }else{
                    new SignIn();
                    JOptionPane.showMessageDialog(null, "Need to Sign In");
                }
                Main.super.dispose();
            }
        });

        contentPane.add(start);



        //--------------------------------------------------
        label = new JLabel("---");
        label.setBounds(0,0,60,30);
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
