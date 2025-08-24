public class PacienteController {
    private SQLiteConnection dbConnection;

    public PacienteController() {
        dbConnection = new SQLiteConnection();
    }

    public void registrarPaciente(Paciente paciente) {
        String sql = "INSERT INTO pacientes (nombre, dni, diagnostico) VALUES (?, ?, ?)";
        try {
            dbConnection.open();
            PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql);
            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getDni());
            pstmt.setString(3, paciente.getDiagnostico());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }
    }

    public Paciente consultarPaciente(int id) {
        Paciente paciente = null;
        String sql = "SELECT * FROM pacientes WHERE id = ?";
        try {
            dbConnection.open();
            PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                paciente = new Paciente(rs.getInt("id"), rs.getString("nombre"), rs.getString("dni"), rs.getString("diagnostico"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }
        return paciente;
    }

    public void actualizarPaciente(Paciente paciente) {
        String sql = "UPDATE pacientes SET nombre = ?, dni = ?, diagnostico = ? WHERE id = ?";
        try {
            dbConnection.open();
            PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql);
            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getDni());
            pstmt.setString(3, paciente.getDiagnostico());
            pstmt.setInt(4, paciente.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }
    }
}