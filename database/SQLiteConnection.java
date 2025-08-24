public class SQLiteConnection {
    private Connection connection;

    public SQLiteConnection(String dbFilePath) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing the connection: " + e.getMessage());
            }
        }
    }

    public void executeUpdate(String sql) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error executing update: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
            Statement stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return resultSet;
    }
}