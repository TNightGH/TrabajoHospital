# Hospital Management System

Este proyecto es un sistema de gestión hospitalaria desarrollado en Java. Utiliza una base de datos SQLite para almacenar información sobre pacientes, médicos, historias clínicas y usuarios. A continuación se detallan las características y funcionalidades del sistema.

## Estructura del Proyecto

```
hospital-management-system
├── src
│   ├── Main.java
│   ├── database
│   │   └── SQLiteConnection.java
│   ├── models
│   │   ├── Paciente.java
│   │   ├── Medico.java
│   │   ├── HistoriaClinica.java
│   │   └── Usuario.java
│   ├── controllers
│   │   ├── PacienteController.java
│   │   ├── MedicoController.java
│   │   ├── HistoriaClinicaController.java
│   │   └── UsuarioController.java
│   └── utils
│       └── Rol.java
├── lib
│   └── sqlite-jdbc.jar
└── README.md
```

## Instalación

1. Clona este repositorio en tu máquina local.
2. Asegúrate de tener Java y Maven instalados.
3. Coloca el archivo `sqlite-jdbc.jar` en la carpeta `lib`.
4. Compila el proyecto utilizando Maven o tu IDE favorito.

## Uso

1. Ejecuta la clase `Main.java` para iniciar el sistema.
2. Sigue las instrucciones en la consola para interactuar con el sistema.
3. Puedes registrar pacientes, médicos, gestionar historias clínicas y usuarios con diferentes roles.

## Funcionalidades

- **Registro de Pacientes**: Permite añadir nuevos pacientes al sistema.
- **Gestión de Médicos**: Registro y consulta de médicos disponibles.
- **Historias Clínicas**: Creación y consulta de historias clínicas asociadas a los pacientes.
- **Gestión de Usuarios**: Manejo de usuarios con diferentes roles y permisos.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas colaborar, por favor abre un issue o envía un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT.