package com.coffee.view;

import com.coffee.delegator.Delegator;
import com.coffee.file.FileClass;
import com.coffee.view.admin.AdminView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements WindowListener {
    JLabel label;
    public Main(){
        super("Main");

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

        start.addActionListener((ActionEvent e) -> {
            Delegator delegator = Delegator.getInstance();

            if(delegator.getCurrent_user()!=null){
                if(delegator.getCurrent_user().getId().equals("admin")){
                    new AdminView();
                }else{
                    new Order();
                }
            }else{
                JOptionPane.showMessageDialog(new SignIn(), "Need to Sign In");
            }
            Main.super.dispose();
        });

        if (Delegator.getInstance().getCurrent_user()!=null){
            JButton signOut = new JButton("SIGN OUT");
            signOut.setBounds(129, 430, 100, 20);
            signOut.setBackground(Color.WHITE);
            signOut.setBorder(new LineBorder(Color.black, 2));

            signOut.addActionListener((ActionEvent e) -> {
                Delegator delegator = Delegator.getInstance();
                delegator.setCurrent_user(null);

                JOptionPane.showMessageDialog(new Main(), "Sign Out Successfully");
            });
            contentPane.add(signOut);
        }


        contentPane.add(start);
//
//
//
//        //--------------------------------------------------
//        label = new JLabel("---");
//        label.setBounds(0,0,60,30);
//        add(label);
//        contentPane.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int x = e.getX();
//                int y = e.getY();
//                label.setText("x: "+x+ "  y: "+y);
//            }
//        });
//        //--------------------------------------------------
//
//
//
//


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
