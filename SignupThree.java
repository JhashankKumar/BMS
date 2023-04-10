import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton saving, fixed, current, recurring;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3:Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        saving = new JRadioButton("Savings Account");
        saving.setFont(new Font("Raleway", Font.BOLD, 16));
        saving.setBounds(100, 180, 200, 30);
        add(saving);

        fixed = new JRadioButton("Fixed Account");
        fixed.setFont(new Font("Raleway", Font.BOLD, 16));
        fixed.setBounds(100, 220, 200, 30);
        add(fixed);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBounds(400, 180, 200, 30);
        add(current);

        recurring = new JRadioButton("Recurring Account");
        recurring.setFont(new Font("Raleway", Font.BOLD, 16));
        recurring.setBounds(400, 220, 200, 30);
        add(recurring);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(current);
        groupaccount.add(saving);
        groupaccount.add(fixed);
        groupaccount.add(recurring);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 280, 200, 30);
        add(card);

        JLabel cnumber = new JLabel("XXXX-XXXX-XXXX-4184"); // DUMMY CARD NUMBER
        cnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cnumber.setBounds(330, 280, 300, 30);
        add(cnumber);

        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100, 310, 300, 15);
        add(carddetail);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 340, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX"); // DUMMY PIN NUMBER
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 340, 300, 30);
        add(pnumber);

        JLabel pindetail = new JLabel("Your 4 Digit PIN Number");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100, 370, 300, 15);
        add(pindetail);

        JLabel services = new JLabel("SERVICES REQURIED:");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100, 400, 300, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 440, 200, 30);
        add(c1);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(300, 440, 200, 30);
        add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(500, 440, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS ALERTS");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(100,500,200,30);
        add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(300,500,200,30);
        add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(500,500,200,30);
        add(c6);

        c7 = new JCheckBox("I here by declares that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,14));
        c7.setBounds(100,550,800,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.setBounds(400,650,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.setBounds(600,650,100,30);
        cancel.addActionListener(this);
        add(cancel);


        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType = null;
            if(saving.isSelected()){
                accountType = "Savings Account";
            }else if(current.isSelected()){
                accountType = "Current Account";
            }else if(fixed.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(recurring.isSelected()){
                accountType = "Reccuring Account";
            }
            Random random = new Random();
            String cardnumber = ""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pinnumber = ""+Math.abs((random.nextLong()%9000L)+1000L);
            String facility ="";
            if(c1.isSelected()){
                facility = facility+"ATM CARD";
            }else if(c2.isSelected()){
                facility = facility+"Internet Banking";
            }else if(c3.isSelected()){
                facility = facility+"Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility+"EMAIL and SMS Alerts";
            }else if(c5.isSelected()){
                facility = facility+"Cheque Book";
            }else if(c6.isSelected()){
                facility = facility+"E-Statement";
            }
            
            try {
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else{
                    DateBaseConnection con = new DateBaseConnection();
                    String query1 = "insert into SignupThree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert login values ('"+formno+"','"+cardnumber+"', '"+pinnumber+"')";
                    con.s.executeUpdate(query1);
                    con.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number:" + cardnumber + "\n pin:"+pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
