import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class transactions extends JFrame implements ActionListener{
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiery, exit;
    String pinnumber;

    transactions(String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,16));
        image.add(text);


        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl= new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash= new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiery = new JButton("Balance Enquiery");
        balanceenquiery.setBounds(355,485,150,30);
        balanceenquiery.addActionListener(this);
        image.add(balanceenquiery);

        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


        //frame making 
        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == exit){
        System.exit(0);
       }
       else if(ae.getSource()==deposit){
        setVisible(true);
        new Deposit(pinnumber).setVisible(true);
       }
       else if(ae.getSource()==withdrawl){
        setVisible(false);
        new Withdrawl(pinnumber).setVisible(true);
       }
       else if(ae.getSource()==fastcash){
        setVisible(false);
        new Fastcash(pinnumber).setVisible(true);
       }
       else if(ae.getSource()==pinchange){
        setVisible(false);
        new Pinchange(pinnumber).setVisible(true);
       }
       else if(ae.getSource()==balanceenquiery){
        setVisible(false);
        new Balanceenquiry(pinnumber).setVisible(true);
       }

    }
    public static void main(String[] args) {
        new transactions("");
    }
    
}
