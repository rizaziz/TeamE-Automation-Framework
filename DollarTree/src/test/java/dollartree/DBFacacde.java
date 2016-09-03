package dollartree;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 9/3/2016.
 */
public class DBFacacde {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String CONNECTION_URL = "jdbc:mysql://localhost/registrationtable";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    String sql = "SELECT zipcode, firstname, lastname, emailadress FROM signupdetails";

    public Connection connect(String connectionString, String userName, String password){
      try {
        Class.forName(JDBC_DRIVER);
        Connection conn= DriverManager.getConnection(connectionString, userName, password);
        System.out.println("Connected database successfully...");
        return  conn;
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
    }
    return  null;
    }

    public ResultSet getResultSet(Connection conn, String sql) {


        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return rs;
    }


    public Map<String,String> getValuesAsList() {
        Map<String, String> record = new HashMap<String, String>();
        // STEP 5: Extract data from result set

        Connection conn = connect(CONNECTION_URL, USER, PASS);
        ResultSet rs = getResultSet(conn, sql);
        try {
            if (rs.next()) {
                // Retrieve by column name
                record.put("zipcode" ,String.valueOf(rs.getInt("zipcode")));
                record.put(" firstname", rs.getString("firstname"));
                record.put("lastname",rs.getString("lastname"));
                record.put("emailadress",rs.getString("emailadress"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;
    }



}
