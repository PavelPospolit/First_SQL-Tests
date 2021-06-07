import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Driver {
    public void SQL_starten() {


    }

    public static void main(String[] args) {
        String email = "p%";
        String PW = "%1";

        // Create datasource.
        String connectionUrl = "jdbc:sqlserver://BE1BD320:1433;instance=SQLEXPRESS;databaseName=Reservierungssystem;user=Test;password=Test";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {


            String SQL = "SELECT TOP 10 * FROM dbo.Employees where Emailadress like '"+email+"' AND Employee_Password like '"+
                    PW + "'";
            ResultSet rs = stmt.executeQuery(SQL);
            if(rs.next())
            // Iterate through the data in the result set and display it.
            while (rs.next()) {

                System.out.println(rs.getString("EmployeeID") + " " + rs.getString("Emailadress")
                        + " " + rs.getString("Employee_Password"));
                if(rs.getString("Employee_Password").equals("Password1")){
                    System.out.println("YES GO GO");
                }
                else System.out.println("no no");
            }
            if(!rs.next()){
                System.out.println("2323");
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}