package PackageTest.DataBase;

import java.sql.*;

public class TestCreatedb {
    public static void main(String[] args) {
        Connection con = DataBaseCheck.connect("catalog");
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE `qwerty` ("
                    + "`id_user` mediumint(9) auto_increment, "
                    + "`email` char(50), "
                    + "`passw` char(32), "
                    + "PRIMARY KEY (`id_user`), "
                    + "UNIQUE KEY (`email`) "
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8");
            stmt.executeUpdate("CREATE TABLE `rub` ("
                    + "`id_rubr` mediumint(6) auto_increment, "
                    + "`name_rubr` char(150), "
                    + "PRIMARY KEY (`id_rubr`) "
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8");
            stmt.executeUpdate("CREATE TABLE `sit` ("
                    + "`id_site` mediumint(9) auto_increment, "
                    + "`id_user` mediumint(9), "
                    + "`id_rubr` mediumint(6), "
                    + "`url` char(255), "
                    + "`title` char(80), "
                    + "`msg` text, "
                    + "`iq` tinyint, "
                    + "PRIMARY KEY (`id_site`), "
                    + "KEY (`id_rubr`) "
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8");
            System.out.println("Таблицы созданы");
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        finally {
            try { if (stmt != null) stmt.close(); }
            catch (SQLException e) {}
            try { if (con != null)  con.close(); }
            catch (SQLException e) {}
            stmt = null; con = null;
        }

    }
}