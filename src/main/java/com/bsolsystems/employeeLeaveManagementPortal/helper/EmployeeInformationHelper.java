package com.bsolsystems.employeeLeaveManagementPortal.helper;

import com.bsolsystems.employeeLeaveManagementPortal.Entity.EmployeeInformation;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeInformationHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "employee_id","first_name", "last_name", "email", "gender", "ip_address", "mobile" };
    static String SHEET = "Mock_Data_custom";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static ByteArrayInputStream dbToExcel(List<EmployeeInformation> employeeInformations) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (EmployeeInformation employeeInformation : employeeInformations) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(employeeInformation.getEmployeeId());
                row.createCell(1).setCellValue(employeeInformation.getFirstName());
                row.createCell(2).setCellValue(employeeInformation.getLastName());
                row.createCell(3).setCellValue(employeeInformation.getEmail());
                row.createCell(4).setCellValue(employeeInformation.getGender());
                row.createCell(5).setCellValue(employeeInformation.getIpAddress());
                row.createCell(6).setCellValue(employeeInformation.getMobile());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

    public static List<EmployeeInformation> excelToDB(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<EmployeeInformation> employeeInformations = new ArrayList<EmployeeInformation>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                EmployeeInformation employeeInformation = new EmployeeInformation();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
//                        case 0:
//                            employeeInformation.setEmployeeId((int)currentCell.getNumericCellValue());
//                            break;
                        case 0:
                            employeeInformation.setFirstName(currentCell.getStringCellValue());
                            break;
                        case 1:
                            employeeInformation.setLastName(currentCell.getStringCellValue());
                            break;
                        case 2:
                            employeeInformation.setEmail(currentCell.getStringCellValue());
                            break;
                        case 3:
                            employeeInformation.setGender(currentCell.getStringCellValue());
                            break;
                        case 4:
                            employeeInformation.setIpAddress(currentCell.getStringCellValue());
                            break;
                        case 5:
                            employeeInformation.setMobile(currentCell.getStringCellValue());
                            break;
                        default: break;
                    }

                    cellIdx++;
                }

                employeeInformations.add(employeeInformation);
            }

            workbook.close();

            return employeeInformations;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

}