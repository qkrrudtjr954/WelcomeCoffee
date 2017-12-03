package com.coffee.view;

import com.coffee.dao.Order.Insert;
import com.coffee.delegator.Delegator;
import com.coffee.dto.Coffee;
import com.coffee.file.FileClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class Order extends JFrame implements WindowListener, ActionListener, ItemListener {
    JLabel label;
    Coffee coffees[];

    JButton order;
    JButton main;
    JButton menu;

    JComboBox<Coffee> coffeeList;

    JCheckBox vanilla;
    JCheckBox caramel;
    JCheckBox hazelnut;

    ButtonGroup sizeGroup;
    JRadioButton _short;
    JRadioButton tall;
    JRadioButton grande;

    JCheckBox whipping;
    JCheckBox shot;

    JComboBox<String> count;

    public Order(){
        super("");

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.orange);
        contentPane.setLayout(null);

        JLabel title = new JLabel("<html><span style='color:white;'>ORDER</span></html>");
        title.setBounds(160, 30, 200, 20);
        contentPane.add(title);

        menu = new JButton("Menu");
        menu.setBounds(300, 0, 75, 30);
        menu.addActionListener(this);
        contentPane.add(menu);


        JLabel coffee = new JLabel("Coffee");
        coffee.setBounds(35, 90, 200, 20);
        contentPane.add(coffee);


        Delegator delegator = Delegator.getInstance();
        coffees = new Coffee[delegator.getCoffees().size()];

        for (int i=0; i<delegator.getCoffees().size(); i++){
            coffees[i] = delegator.getCoffees().get(i);
        }

        coffeeList = new JComboBox<>(coffees);
        coffeeList.setBounds(35, 110, 300, 40);
        contentPane.add(coffeeList);

        JLabel syrupLabel = new JLabel("Syrup");
        syrupLabel.setBounds(35, 170, 200, 20);
        contentPane.add(syrupLabel);

        JPanel syrupPanel = new JPanel();
        syrupPanel.setBounds(35, 200, 300, 40);
        vanilla = new JCheckBox("Vanilla");
        caramel = new JCheckBox("Caramel");
        hazelnut = new JCheckBox("Hazel Nut");
        syrupPanel.add(vanilla);
        syrupPanel.add(caramel);
        syrupPanel.add(hazelnut);
        contentPane.add(syrupPanel);

        JLabel sizeLabel = new JLabel("Size");
        sizeLabel.setBounds(35, 250, 200, 20);
        contentPane.add(sizeLabel);

        JPanel sizePanel = new JPanel();
        sizePanel.setBounds(35, 280, 300, 40);

        sizeGroup = new ButtonGroup();
        _short = new JRadioButton("Short");
        _short.setSelected(true);
        tall = new JRadioButton("Tall");
        grande = new JRadioButton("Grande");

        sizeGroup.add(_short);
        sizeGroup.add(tall);
        sizeGroup.add(grande);


        _short.addItemListener(this);
        tall.addItemListener(this);
        grande.addItemListener(this);

        sizePanel.add(_short);
        sizePanel.add(tall);
        sizePanel.add(grande);

        contentPane.add(sizePanel);

        JLabel etcLabel = new JLabel("ETC");
        etcLabel.setBounds(35, 330, 200, 20);
        contentPane.add(etcLabel);

        JPanel etcPanel = new JPanel();
        etcPanel.setBounds(35, 360, 300, 40);
        whipping = new JCheckBox("Whipping");
        shot = new JCheckBox("Shot");
        etcPanel.add(whipping);
        etcPanel.add(shot);
        contentPane.add(etcPanel);

        JLabel countLabel = new JLabel("ORDER COUNT");
        countLabel.setBounds(35, 410, 200, 20);
        contentPane.add(countLabel);

        count = new JComboBox<>();
        for (int i = 1; i<=20; i++){
            count.addItem(""+i);
        }
        count.setBounds(35, 440, 300, 30);
        contentPane.add(count);


        JPanel btnPanel = new JPanel();
        btnPanel.setBounds(110, 500, 150, 50);
        btnPanel.setLayout(new GridLayout(1, 2));

        order = new JButton("ORDER");
        order.setSize(75, 50);
        order.addActionListener(this);
        btnPanel.add(order);


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
        setVisible(true);
        addWindowListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if(obj == order){
            Insert insertOrder = new Insert();

            Coffee coffee = (Coffee) coffeeList.getSelectedItem();


            String size;
            if(_short.isSelected()){
                size = _short.getText();
            }else if(tall.isSelected()){
                size = tall.getText();
            }else{
                size = grande.getText();
            }

            HashMap<String, Boolean> etc = new HashMap<>();
            etc.put("vanilla", this.vanilla.isSelected());
            etc.put("hazelnut", this.vanilla.isSelected());
            etc.put("caramel", this.vanilla.isSelected());

            etc.put("whipping", this.whipping.isSelected());
            etc.put("shot", this.shot.isSelected());

            int count = this.count.getSelectedIndex()+1;


            if(insertOrder.insert(coffee, size, count, etc)){
                JOptionPane.showMessageDialog(null, "Order Complete");
                FileClass fileClass = new FileClass();
                fileClass.writeOrderedToFile();

                new OrderedList();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        }else if(obj == main){
            new Main();
            this.dispose();
        }else{
            new Menu();
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
