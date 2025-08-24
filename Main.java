
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public ResultSet res;

    public static void main(String[] args) {        
try {
            System.out.println("Bienvenido al sistema de gestión hospitalaria");

    SQLiteConnection dbConnection = new SQLiteConnection("database/prueba.db");
        dbConnection.getConnection();
    ResultSet rs = dbConnection.executeQuery("SELECT id FROM products;");
        dbConnection.getConnection();

     while (rs.next()) {
        System.out.println("hola");
                    int id = rs.getInt("id");
                    System.out.println("ID: " + id);
                }
        dbConnection.closeConnection(); 
} catch (SQLException e) {
    System.out.println("Error: " + e.getMessage());
}

   
        //dbConnection.closeConnection();
        // Aquí se puede iniciar la interacción con el usuario, como mostrar un menú y gestionar las opciones
    }
}