package com.accesodatos;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ExcelUnmarshaller {
    public static List<Reserva> unmarshal(InputStream excelFile) throws Exception {
        List<Reserva> reservas = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(excelFile)) {
            Sheet sheet = workbook.getSheetAt(0);
            Map<Integer, String> columnTypes = new HashMap<>();

            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                String cellValue = cell.getStringCellValue();
                if (cellValue.contains("_")) {
                    String[] parts = cellValue.split("_");
                    String columnName = parts[0];
                    String columnType = parts[parts.length - 1].toUpperCase();
                    columnTypes.put(cell.getColumnIndex(), columnType);
                } else {
                    System.out.println("Formato incorrecto en la celda: " + cellValue);
                }
            }

            for (Row row : sheet) {

                Reserva reserva = new Reserva();

                for (Cell cell : row) {
                    int columnIndex = cell.getColumnIndex();
                    String columnType = columnTypes.get(columnIndex);

                    switch (columnType) {
                        case "VARCHAR":
                        case "VARCHAR(50)":
                        case "VARCHAR(65)":
                        case "VARCHAR(80)":
                            if (columnIndex == 0) {
                                reserva.setUsuario(getCellValueAsString(cell));
                            } else if (columnIndex == 1) {
                                reserva.setInstalacion(getCellValueAsString(cell));
                            } else if (columnIndex == 2) {
                                reserva.setHorario(getCellValueAsString(cell));
                            }
                            break;
                        case "INT":
                        if (columnIndex == 0) {
                            reserva.setUsuario(getCellValueAsString(cell));
                        } else if (columnIndex == 1) {
                            reserva.setInstalacion(getCellValueAsString(cell));
                        } else if (columnIndex == 2) {
                            reserva.setHorario(getCellValueAsString(cell));
                        }
                            break;
                        case "DATE":
                            reserva.setFecha(getCellValueAsDate(cell));
                            break;
                        default:
                            System.out.println("Tipo de dato no soportado: " + columnType);
                            break;
                    }
                }
                reservas.add(reserva);
            }
        }
        return reservas;
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return null;
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

    private static java.util.Date getCellValueAsDate(Cell cell) {
        if (cell == null || cell.getCellType() != CellType.NUMERIC) return null;
        if (DateUtil.isCellDateFormatted(cell)) {
            return cell.getDateCellValue();
        } else {
            throw new IllegalArgumentException("La celda no contiene una fecha válida.");
        }
    }
}