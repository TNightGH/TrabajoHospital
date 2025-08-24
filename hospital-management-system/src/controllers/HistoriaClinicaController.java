public class HistoriaClinicaController {
    private SQLiteConnection dbConnection;

    public HistoriaClinicaController() {
        dbConnection = new SQLiteConnection();
    }

    public void crearHistoriaClinica(HistoriaClinica historia) {
        String sql = "INSERT INTO historias_clinicas (paciente_id, diagnostico, tratamiento) VALUES (?, ?, ?)";
        try {
            dbConnection.open();
            PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql);
            pstmt.setInt(1, historia.getPacienteId());
            pstmt.setString(2, historia.getDiagnostico());
            pstmt.setString(3, historia.getTratamiento());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }
    }

    public HistoriaClinica obtenerHistoriaClinica(int id) {
        String sql = "SELECT * FROM historias_clinicas WHERE id = ?";
        HistoriaClinica historia = null;
        try {
            dbConnection.open();
            PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                historia = new HistoriaClinica(rs.getInt("id"), rs.getInt("paciente_id"), rs.getString("diagnostico"), rs.getString("tratamiento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }
        return historia;
    }

    public void actualizarHistoriaClinica(HistoriaClinica historia) {
        String sql = "UPDATE historias_clinicas SET diagnostico = ?, tratamiento = ? WHERE id = ?";
        try {
            dbConnection.open();
            PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql);
            pstmt.setString(1, historia.getDiagnostico());
            pstmt.setString(2, historia.getTratamiento());
            pstmt.setInt(3, historia.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }
    }
}