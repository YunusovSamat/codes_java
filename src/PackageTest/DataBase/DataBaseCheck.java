package PackageTest.DataBase;

import java.sql.*;

public class DataBaseCheck {
    public static void main(String[] args) {
        Connection con = DataBaseCheck.connect("test");
        System.out.println("Подключение успешно выполнено");
        try {
            if (con != null) con.close();
        } catch (SQLException e) { }
    }

    public static Connection connect(String db) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + db +
                            "?characterEncoding=utf8", "root", "");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Драйвер не найден");
            System.exit(1);
        }
        catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.exit(1);
        }
        return con;
    }
}

