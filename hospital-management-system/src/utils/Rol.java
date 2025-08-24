public enum Rol {
    ADMINISTRADOR,
    MEDICO,
    ENFERMERA,
    RECEPCIONISTA;

    public String getPermisos() {
        switch (this) {
            case ADMINISTRADOR:
                return "Acceso total al sistema.";
            case MEDICO:
                return "Acceso a la información de pacientes y gestión de historias clínicas.";
            case ENFERMERA:
                return "Acceso a la información de pacientes y gestión de tratamientos.";
            case RECEPCIONISTA:
                return "Acceso a la gestión de citas y registro de pacientes.";
            default:
                return "Sin permisos asignados.";
        }
    }
}