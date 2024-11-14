package com.accesodatos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class SQLMarshaller {
    public static void marshal(List<Reserva> reservas, String sqlFilePath) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(sqlFilePath))) {
            writer.write("CREATE TABLE IF NOT EXISTS reservas (usuario VARCHAR(255), instalacion VARCHAR(255), horario VARCHAR(255), fecha DATE);\n");
            for (Reserva reserva : reservas) {
                String insertSQL = String.format(
                    "INSERT INTO reservas (usuario, instalacion, horario, fecha) VALUES ('%s', '%s', '%s', '%s');\n",
                    reserva.getUsuario(), 
                    reserva.getInstalacion(), 
                    reserva.getHorario(), 
                    reserva.getFecha()
                );
                writer.write(insertSQL);
            }
        }
    }
}