package geekbrains.java.level3.lesson2.homework2.server;

import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

public class BaseAuthService implements AuthService {

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
    }


    @Override
    public String getNickByLoginPass(String login, String pass) {
        String result = null;
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:java-level3.db");
             Statement stmt = conn.createStatement()) {
            String sqlRead = "SELECT * FROM USERS";
            ResultSet rs = stmt.executeQuery(sqlRead);
            String md5password = DigestUtils.md5Hex(pass);
            while (rs.next()) {
                if (rs.getString("login").equals(login) && rs.getString("password").
                        equals(md5password)) {
                    result = rs.getString("nick");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void changeNick(String newNick, String oldNick) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:java-level3.db");
             Statement stmt = conn.createStatement()) {
            String sqlUpdate = "UPDATE users SET nick = '" + newNick + "' WHERE nick = '" + oldNick + "';";
            stmt.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
