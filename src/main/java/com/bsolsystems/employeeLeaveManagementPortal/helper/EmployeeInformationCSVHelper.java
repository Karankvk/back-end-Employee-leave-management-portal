package com.bsolsystems.employeeLeaveManagementPortal.helper;

import com.bsolsystems.employeeLeaveManagementPortal.Entity.EmployeeInformationCSV;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeInformationCSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"employee_id", "first_name", "last_name", "email", "gender", "ip_address", "mobile"};

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<EmployeeInformationCSV> csvToDb(InputStream inputStream) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
             CSVParser csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<EmployeeInformationCSV> employeeInformationCSVS = new ArrayList<EmployeeInformationCSV>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                EmployeeInformationCSV employeeInformationCSV = new EmployeeInformationCSV(
                        csvRecord.get("first_name"),
                        csvRecord.get("last_name"),
                        csvRecord.get("email"),
                        csvRecord.get("gender"),
                        csvRecord.get("ip_address"),
                        csvRecord.get("mobile")
                );
                employeeInformationCSVS.add(employeeInformationCSV);
            }
            return employeeInformationCSVS;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream dbToCSV(List<EmployeeInformationCSV> employeeInformationCSVS) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(outputStream), format);) {
            for (EmployeeInformationCSV employeeInformationCSV : employeeInformationCSVS) {
                List<String> data = Arrays.asList(
                        String.valueOf(employeeInformationCSV.getEmployeeId()),
                        employeeInformationCSV.getFirst_name(),
                        employeeInformationCSV.getLast_name(),
                        employeeInformationCSV.getEmail(),
                        employeeInformationCSV.getGender(),
                        employeeInformationCSV.getIpAddress(),
                        employeeInformationCSV.getMobile()
                );
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Fail to import data to CSV file: " + e.getMessage());
        }
    }
}
