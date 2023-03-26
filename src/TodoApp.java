import java.sql.Connection;

public class TodoApp {
    public static void main(String[] args) throws Exception {
        Connection c = ConnectionFactory.getConnection();

        ConnectionFactory.closeConnection(c);
    }
}
