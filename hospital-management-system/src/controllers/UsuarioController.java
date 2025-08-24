import java.sql.*;
import models.Usuario;
import utils.Rol;
import database.SQLiteConnection;

public class UsuarioController {
    private SQLiteConnection dbConnection;

    public UsuarioController(String dbFilePath) {
        dbConnection = new SQLiteConnection(dbFilePath);
    }

    public void registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, rol) VALUES (?, ?)";
        try (PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getRol().toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario iniciarSesion(String nombre) {
        String sql = "SELECT * FROM usuarios WHERE nombre = ?";
        Usuario usuario = null;
        try (PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), Rol.valueOf(rs.getString("rol")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public void gestionarRol(Usuario usuario, Rol nuevoRol) {
        String sql = "UPDATE usuarios SET rol = ? WHERE id = ?";
        try (PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, nuevoRol.toString());
            pstmt.setInt(2, usuario.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}