import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdrawl, back;
    String pinnumber;

    Withdrawl(String pinnumber){

        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text =  new JLabel("Enter the amount of WithDraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(220,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raieway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdrawl = new JButton("WithDrawl");
        withdrawl.setBounds(355,445,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back= new JButton("Back");
        back.setBounds(355,485,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== withdrawl){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals(" ")){
                JOptionPane.showMessageDialog(null, "Enter the Amount");
            }else{
                try {
                    DateBaseConnection conn = new DateBaseConnection();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"RS"+number+"WithDrawl Successfully");
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }
    }    
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
