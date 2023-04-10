import java.sql.*;
public class DateBaseConnection {
    Connection c ;
    Statement s;
    //in JDBC Connectivity there will be 5 steps
    // 1 Register the Driver
    // 2 Create Connection
    // 3 Create Statement
    // 4 Create Query
    // 5 Close Connection
    public DateBaseConnection(){
        //exceptional handling is used here due to MySQL which is extrnal entity
        //My SQL gives runtime errors
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Jhashank@190703");
            s = c.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
