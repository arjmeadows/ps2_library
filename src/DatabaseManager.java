import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

    public class DatabaseManager {
        private static final String URL = "jdbc:sqlite:src/library.db"; // Update path as needed

        // Method to connect to the database
        public Connection connect() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(URL);
                System.out.println("Connection to SQLite has been established.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }

        // Create table if it doesn't exist
        public void createTable() {
            String sql = """
                CREATE TABLE IF NOT EXISTS games (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    genre TEXT,
                    year INTEGER
                );
                """;

            try (Connection conn = this.connect();
                 Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("Table 'games' created (if not exists).");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

