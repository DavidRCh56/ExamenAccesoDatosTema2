package com.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DatabaseManager {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/db-reservas";
        String user = "root";
        String password = "9128736901";
        return DriverManager.getConnection(url, user, password);
    }

    public static void loadSQLFile(String sqlFilePath, Connection connection) throws Exception {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("source " + sqlFilePath); // Ejecuta el script SQL
        }
    }

    public static void runMenu(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1) Ver todas las reservas con información");
            System.out.println("2) Ver historial de reservas por usuario");
            System.out.println("3) Ver horarios disponibles por instalación");
            System.out.println("0) Salir");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    showAllReservations(connection);
                    break;
                case 2:
                    showUserReservations(connection);
                    break;
                case 3:
                    showAvailableSchedules(connection);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (option != 0);
    }

    private static void showAllReservations(Connection connection) {
        String query = "SELECT * FROM reservas";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String usuario = rs.getString("usuario");
                String instalacion = rs.getString("instalacion");
                String horario = rs.getString("horario");
                Date fecha = rs.getDate("fecha");
                System.out.printf("Usuario: %s, Instalación: %s, Horario: %s, Fecha: %s%n", usuario, instalacion, horario, fecha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showUserReservations(Connection connection) {
        // Implementar la consulta para ver el historial de reservas por usuario
    }

    private static void showAvailableSchedules(Connection connection) {
        // Implementar la consulta para ver horarios disponibles
    }
}