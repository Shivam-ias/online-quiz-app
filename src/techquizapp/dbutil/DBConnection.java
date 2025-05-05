
package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Ankit
 */
public class DBConnection {
    private static Connection conn=null;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","onlineexam", "student");
            //JOptionPane.showMessageDialog(null,"Connected successfully to the DB");
        }
        catch(ClassNotFoundException cnf){
            JOptionPane.showMessageDialog(null,"Driver can't be loading!" );
            cnf.printStackTrace();
            System.exit(1);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Connection can't be opening!");
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            if(conn!=null)
                conn.close();
         //JOptionPane.showMessageDialog(null,"Disconnected Successfully to the DB" );
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Can not disconnect with the DB" );
            ex.printStackTrace();
        }
    }
    
}
