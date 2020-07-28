package geekbrains.java.level3.lesson2.lesson2;


import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.Arrays;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
        UUID uuid = UUID.randomUUID();
        String faleName = uuid + ".txt";
//        System.out.println(faleName);
        String login = "login2";
        String pass = "pass2";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:java-level3.db");
             Statement stmt = conn.createStatement();) {
            String sqlRead = "SELECT * FROM USERS";
            ResultSet rs = stmt.executeQuery(sqlRead);
            String md5password = DigestUtils.md5Hex(pass);
            String result = null;
            while (rs.next()) {
                if (rs.getString("login").equals(login) && rs.getString("password").
                        equals(md5password)) {
                    result = rs.getString("fileName");
                    System.out.println(result);
                    if (result == null) {
                        String sqlUpdate = "UPDATE users SET fileName = '" + faleName + "' WHERE login = '" + rs.getString("login") + "';";
                        stmt.executeUpdate(sqlUpdate);
                        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(faleName,true))) {
                            out.write("Hello\n".getBytes(Charset.forName("UTF-8")));

                        }
                    } else {
                        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(result,true))) {
                            out.write("Hello\n".getBytes(Charset.forName("UTF-8")));

                        }
                    }
                }
            }
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Connection conn2 = null;
//        Statement stmt2 = null;
//        PreparedStatement ps2 = null;
//        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:java-level3.db");
//             Statement stmt = conn.createStatement();
//             PreparedStatement ps = conn.prepareStatement("INSERT INTO Students (ID, Name, Score, 'Group') VALUES (?,?,?,?)");) {
//            Class.forName("org.sqlite.JDBC");
//
//            stmt.execute("DELETE FROM Students");
//
//            conn.setAutoCommit(false);
//
//            // ps = conn.prepareStatement("INSERT INTO Students (ID, Name, Score, 'Group') VALUES (?,?,?,?)");
//            ps.setInt(1, 1);
//            ps.setString(2, "John3");
//            ps.setInt(3, 10);
//            ps.setInt(4, 2);
//            ps.executeUpdate();
//
//            ps.clearBatch();
//
//            ps.setInt(1, 2);
//            ps.setString(2, "Paul1");
//            ps.setInt(3, 12);
//            ps.setInt(4, 2);
//            ps.addBatch();
//
//            ps.setInt(1, 3);
//            ps.setString(2, "Ringo1");
//            ps.setInt(3, 6);
//            ps.setInt(4, 2);
//            ps.addBatch();
//
//            ps.setInt(1, 4);
//            ps.setString(2, "Jimmy7");
//            ps.setInt(3, 11);
//            ps.setInt(4, 3);
//            ps.addBatch();
//
//            int[] w = ps.executeBatch();
//            System.out.println(Arrays.toString(w));
//            conn.commit();
//
//            String sqlRead = "SELECT * FROM Students";
//            ResultSet rs = stmt.executeQuery(sqlRead);
//
//            while (rs.next()) {
//                System.out.println(rs.getString("Name") + " | " + rs.getInt("Score"));
//            }
//
//            conn2 = conn;
//            stmt2 = stmt;
//            ps2 = ps;
//            System.out.println(stmt.isClosed());
//            System.out.println(ps.isClosed());
//            System.out.println(conn.isClosed());
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(stmt2.isClosed());
//        System.out.println(ps2.isClosed());
//        System.out.println(conn2.isClosed());
    }
}
