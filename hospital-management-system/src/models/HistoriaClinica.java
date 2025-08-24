public class HistoriaClinica {
    private int id;
    private int pacienteId;
    private String diagnostico;
    private String tratamiento;

    public HistoriaClinica(int id, int pacienteId, String diagnostico, String tratamiento) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
}