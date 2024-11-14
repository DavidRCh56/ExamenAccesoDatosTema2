package com.accesodatos;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import com.accesodatos.Reserva;
import com.accesodatos.DatabaseManager;
import com.accesodatos.ExcelUnmarshaller;
import com.accesodatos.SQLMarshaller;

public class App {
    public static void main(String[] args) {
        String sqlFilePath = "stack/scripts/initdb.sql";

        try (InputStream excelFile = App.class.getResourceAsStream("/reservas.xlsx")) {

            // Unmarshal: Leer el archivo Excel y convertirlo en objetos Reserva
            List<Reserva> reservas = ExcelUnmarshaller.unmarshal(excelFile);

            // Marshal: Convertir los objetos Reserva en sentencias SQL
            SQLMarshaller.marshal(reservas, sqlFilePath);

            // Cargar datos en la base de datos y ejecutar el menú
            try (Connection connection = DatabaseManager.getConnection()) {
                DatabaseManager.loadSQLFile(sqlFilePath, connection);
                DatabaseManager.runMenu(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}