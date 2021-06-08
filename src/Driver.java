import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Driver {

    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://BE1BD320:1433;instance=SQLEXPRESS;databaseName=Reservierungssystem;user=Test;password=Test";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {

            /*PreparedStatement st = con.prepareStatement("alter table Reservations nocheck constraint all delete from Employees WHERE Emailaddress like 'jan%' alter table Reservations check constraint all");
            st.executeUpdate();*/

            String insert = "insert into Employees values(?,?,?)";
            PreparedStatement insertstmt = con.prepareStatement(insert);
            insertstmt.setInt(1, 145156);
            insertstmt.setString(2, "janik.sigmund@telekom.de");
            insertstmt.setString(3, "Password");
            insertstmt.execute();


            String SQL = "SELECT TOP 10 * FROM dbo.Employees";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println(rs.getString("EmployeeID") + " " + rs.getString("Emailaddress")
                        + " " + rs.getString("Employee_Password"));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /*public static void DeleteRow (String Name){
        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://BE1BD320:1433;instance=SQLEXPRESS;databaseName=Reservierungssystem;user=Test;password=Test");

            PreparedStatement
        }
        catch (Exception e){
            System.out.println(e);;
        }
    }*/
}