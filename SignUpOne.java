import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignUpOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField, fnameTextField, mnameTextField, emailTextField, addressTextField, stateTextField, pincodeTextField, cityTextField ;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser datechooser;

    SignUpOne(){
        setLayout(null);
        //random number for form number 
        Random ran = new Random();
        Long random = Math.abs(ran.nextLong()%9000L+1000L);
        //form number 
        JLabel formno = new JLabel("APPLICATION FORM NUMBER:"+random);
        formno.setFont(new Font("Raleway",Font.BOLD,34));
        formno.setBounds(125,20,600,40);
        add(formno);

        JLabel personDetails= new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,28));
        personDetails.setBounds(280,80,600,40);
        add(personDetails);

        //JLabel display the what information need to be given by user 
        JLabel name= new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        //JTextFeild takes the input from the user
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        

        JLabel fname= new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,180,150,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,180,400,30);
        add(fnameTextField);

        JLabel mname= new JLabel("Mother's Name:");
        mname.setFont(new Font("Raleway",Font.BOLD,20));
        mname.setBounds(100,220,150,30);
        add(mname);

        mnameTextField = new JTextField();
        mnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        mnameTextField.setBounds(300,220,400,30);
        add(mnameTextField);

        JLabel dob= new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,260,150,30);
        add(dob);

        datechooser = new JDateChooser();
        datechooser.setBounds(300,260,400,30);
        datechooser.setForeground(new Color(105, 105, 105));
        add(datechooser);


        JLabel gender= new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,300,150,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 300, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 300, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);


        //gender group selects either male or female only one option
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        JLabel email= new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,150,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel marital= new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,380,150,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 380, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 380, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(500, 380, 100, 30);
        other.setBackground(Color.WHITE);
        add( other);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        JLabel address= new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,420,150,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,420,400,30);
        add(addressTextField);

        JLabel city= new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,460,150,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,460,400,30);
        add(cityTextField);

        JLabel state= new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,500,150,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,500,400,30);
        add(stateTextField);

        JLabel pincode= new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,540,150,30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(300,540,400,30);
        add(pincodeTextField);

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        //SIGN UP frame 
        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random; //long
        String name = nameTextField.getText();//set Text
        String fname = fnameTextField.getText();
        String mname = mnameTextField.getText();
        String dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";
        }else if(other.isSelected()){
            marital = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        
        //taking validation for all blocks of form
        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required" );
            }
            else{
                DateBaseConnection c = new DateBaseConnection();
                //below query is MYSQL query
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+mname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(query);

                //here we are passing application number to next page [additional details page]
                setVisible(false);
                //signup two
                new SignUpTwo(formno).setVisible(true);
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignUpOne();
    }
    
}
