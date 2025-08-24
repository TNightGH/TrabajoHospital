public class MedicoController {
    private SQLiteConnection dbConnection;

    public MedicoController() {
        dbConnection = new SQLiteConnection();
    }

    public void registrarMedico(Medico medico) {
        String sql = "INSERT INTO Medicos (nombre, especialidad) VALUES (?, ?)";
        try {
            dbConnection.open();
            PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql);
            pstmt.setString(1, medico.getNombre());
            pstmt.setString(2, medico.getEspecialidad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }
    }

    public Medico consultarMedico(int id) {
        Medico medico = null;
        String sql = "SELECT * FROM Medicos WHERE id = ?";
        try {
            dbConnection.open();
            PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                medico = new Medico(rs.getInt("id"), rs.getString("nombre"), rs.getString("especialidad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }
        return medico;
    }

    public void actualizarMedico(Medico medico) {
        String sql = "UPDATE Medicos SET nombre = ?, especialidad = ? WHERE id = ?";
        try {
            dbConnection.open();
            PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql);
            pstmt.setString(1, medico.getNombre());
            pstmt.setString(2, medico.getEspecialidad());
            pstmt.setInt(3, medico.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }
    }

    public void eliminarMedico(int id) {
        String sql = "DELETE FROM Medicos WHERE id = ?";
        try {
            dbConnection.open();
            PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }
    }
}