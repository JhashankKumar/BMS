import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{

    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JTextField panTextField, aadharTextField;
    JComboBox<String> religion, category, income, education, occupation;
    String formno;

    SignUpTwo(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel AdditionalDetails= new JLabel("Page 2: Additional Details");
        AdditionalDetails.setFont(new Font("Raleway",Font.BOLD,28));
        AdditionalDetails.setBounds(280,80,600,40);
        add(AdditionalDetails);

        //JLabel display the what information need to be given by user 
        JLabel Religion= new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,20));
        Religion.setBounds(100,140,100,30);
        add(Religion);

        //religion box
        String ValReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(ValReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel Category= new JLabel("Category:");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(100,180,100,30);
        add(Category);

        String valcategory[]= {"General","OBC","SC","ST","Other"};
        category = new JComboBox<>(valcategory);
        category.setBounds(300,180,400,30);
        category.setBackground(Color.WHITE);
        add(category);


        JLabel Income= new JLabel("Income:");
        Income.setFont(new Font("Raleway",Font.BOLD,20));
        Income.setBounds(100,220,100,30);
        add(Income);

        String valIncome[]= {"Null","<1,50,00","<2,50,000","<5,00,000","upto 10,00,000"};
        income = new JComboBox<>(valIncome);
        income.setBounds(300,220,400,30);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel Education= new JLabel("Education:");
        Education.setFont(new Font("Raleway",Font.BOLD,20));
        Education.setBounds(100,260,150,30);
        add(Education);

        String valeducation[]= {"Non-Graduation","Graduation","Post-Graduation","Doctrate","Others"};
        education = new JComboBox<>(valeducation);
        education.setBounds(300,260,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        

        JLabel Occupation= new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway",Font.BOLD,20));
        Occupation.setBounds(100,300,150,30);
        add(Occupation);

        String valoccupation[]= {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox<>(valoccupation);
        occupation.setBounds(300,300,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel Pan= new JLabel("PAN Number:");
        Pan.setFont(new Font("Raleway",Font.BOLD,20));
        Pan.setBounds(100,340,150,30);
        add(Pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,340,400,30);
        add(panTextField);


        JLabel Aadhar= new JLabel("Aadhar Number:");
        Aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        Aadhar.setBounds(100,380,200,30);
        add(Aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,380,400,30);
        add(aadharTextField);


        JLabel seniorcitizen= new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorcitizen.setBounds(100,420,150,30);
        add(seniorcitizen);

        syes = new JRadioButton("YES");
        syes.setBounds(300,420,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(500,420,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorCitizen = new ButtonGroup();
        seniorCitizen.add(syes);
        seniorCitizen.add(sno);


        JLabel Existing= new JLabel("Existing Account:");
        Existing.setFont(new Font("Raleway",Font.BOLD,20));
        Existing.setBounds(100,460,200,30);
        add(Existing);

        eyes = new JRadioButton("YES");
        eyes.setBounds(300,460,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(500,460,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existing = new ButtonGroup();
        existing.add(syes);
        existing.add(sno);


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
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "YES";
        }
        else if(sno.isSelected()){
            seniorcitizen = "NO";
        }
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "YES";
        }
        else{
            existingaccount = "NO";
        }
        //it collects data into DataBase 
        try{
            DateBaseConnection c = new DateBaseConnection();
            //below query is MYSQL query
            String query = "insert into signupTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
            c.s.executeUpdate(query);

            //signup 3 
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
       
    }
    public static void main(String[] args) {
        new SignUpTwo("");

    } 
}
