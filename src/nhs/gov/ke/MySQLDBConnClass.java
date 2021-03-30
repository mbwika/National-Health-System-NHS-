package nhs.gov.ke;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Collins Mbwika <androidapps.collinsmbwika.me>
 */
public class MySQLDBConnClass {
    
    public static void DBConnector() throws SQLException{
        try {
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLDBConnClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
