import java.sql.*;

public class SQL_start {
    public static void SQL_starten() {
        String connectionUrl = "jdbc:sqlserver://BE1BD320:1433;instance=SQLEXPRESS;databaseName=Reservierungssystem;user=Test;password=Test";
        ResultSet rs;
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM dbo.Employees";
            rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}