package com.coffee.view;

import com.coffee.delegator.Delegator;
import com.coffee.dto.User;
import com.coffee.view.admin.AdminView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class SignIn extends JFrame implements WindowListener, ActionListener {

    JTextField id;
    JPasswordField password;

    JButton signIn;
    JButton signUp;
    JButton main;

    JLabel label;

    public SignIn(){
        super("");

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.orange);
        contentPane.setLayout(null);

        JLabel title = new JLabel("<html><span style='color:white;'>SIGN IN</span></html>");
        title.setBounds(150, 68, 200, 20);
        contentPane.add(title);


        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(100, 170, 50, 20);
        contentPane.add(idLabel);

        id = new JTextField();
        id.setBounds(100, 210, 150, 20);
        contentPane.add(id);

        JLabel pwdLabel = new JLabel("PASSWORD");
        pwdLabel.setBounds(100, 248, 150, 20);
        contentPane.add(pwdLabel);

        password = new JPasswordField();
        password.setBounds(100, 288, 150, 20);
        contentPane.add(password);





        JPanel panel = new JPanel();
        panel.setSize(150, 100);
        panel.setLayout(new GridLayout(2,1));
        panel.setLocation(100, 450);

        signIn = new JButton("SIGN IN");
        signIn.setSize(150, 50);
        signIn.addActionListener(this);
        panel.add(signIn);


        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1, 2));

        signUp = new JButton("SIGN UP");
        signUp.setSize(75, 50);
        signUp.addActionListener(this);
        btnPanel.add(signUp);


        main = new JButton("MAIN");
        main.setSize(75, 50);
        main.addActionListener(this);
        btnPanel.add(main);

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

        if(obj == signIn){
            String id = this.id.getText();
            char[] password = this.password.getPassword();

            if(User.isUser(id, password)){
                Delegator.getInstance().setCurrent_user(User.getUserById(id));
                if(id.equals("admin")){
                    new AdminView();
                }else{
                    new Order();
                }
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Wrong ID or PASSWORD");
            }

        }else if(obj == signUp){
            new SignUp();
            this.dispose();
        }else{
            new Main();
            this.dispose();
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
