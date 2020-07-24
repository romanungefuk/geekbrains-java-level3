package geekbrains.java.level3.lesson2.homework2.server;

public interface AuthService {
    void start();

    String getNickByLoginPass(String login, String pass);

    void changeNick(String newNick, String oldNick);

    void stop();
}
