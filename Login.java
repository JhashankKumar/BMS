import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//ActionListener persent in AWT event 
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    //gobally declared for accessing in different classes 
    JButton signIn , signUp , clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    //constructor
    Login(){
        setTitle("ATM");
        setLayout(null);
        //it set image in frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("banklogo.jpg"));//initalize the image
        //image size Image is in awt pakage
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        //image location change
        label.setBounds(70,10,100,100);
        add(label);
        //the main work of JLabel
        //for welcome to ATM
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        //for card number 
        JLabel cardNum = new JLabel("Card Number");
        cardNum.setFont(new Font("Raleway",Font.BOLD,28));
        cardNum.setBounds(120,150,180,30);
        add(cardNum);

        // box where user can enter card number 
        cardTextField = new JTextField();
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        cardTextField.setBounds(300, 150, 250, 30);
        add(cardTextField);

        //for pin number
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,180,30);
        add(pin);

        // box where user can enter pin number 
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        //for buttons
        //SignIn button
        signIn = new JButton("SIGN IN");
        signIn.setBounds(300,300,100,30);
        //button color
        signIn.setBackground(Color.BLACK);
        //text color (which present on button)
        signIn.setForeground(Color.WHITE);
        //it captures the action (button was clicked)
        signIn.addActionListener(this);
        add(signIn);

        //Clear button
        clear = new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        //button color
        clear.setBackground(Color.BLACK);
        //text color (which present on button)
        clear.setForeground(Color.WHITE);
        //it captures the action (button was clicked)
        clear.addActionListener(this);
        add(clear);

        //SignUp button
        signUp = new JButton("SIGN UP");
        signUp.setBounds(300,350,250,30);
        //button color
        signUp.setBackground(Color.BLACK);
        //text color (which present on button)
        signUp.setForeground(Color.WHITE);
        //it captures the action (button was clicked)
        signUp.addActionListener(this);
        add(signUp);


        //sets background color
        getContentPane().setBackground(Color.LIGHT_GRAY);
        //frame size 
        setSize(800,500);
        setVisible(true);
        setLocation(350,200);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(e.getSource()==signIn){
            DateBaseConnection conn = new DateBaseConnection();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"'and pin = '"+pinnumber+"'";
            try{
                ResultSet rs =  conn.s.executeQuery(query);
                if(rs.next()){
                    //here if data entered and data in DB are matched then transaction page must be opened 
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch(Exception er){
                System.out.println(er);
            }
        }else if(e.getSource()==signUp){
            //it opens signup page for new users
            setVisible(false);
            new SignUpOne().setVisible(true);
        }

    }
    public static void main(String[] args) {
        //to make frame
        new Login();
    }
}