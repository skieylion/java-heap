package project.java;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class PlannedVacation {

    private static final String[] headers = {"ФИО", "С даты", "По дату", "Дней", "Подразделение"};
    private static final SimpleDateFormat DATE_FORMAT_DOT = new SimpleDateFormat("dd.MM.yyyy");
    private static final SimpleDateFormat DATE_FORMAT_SLASH = new SimpleDateFormat("dd/MM/yyyy");
    private static final String CAPTION = "Отчет: Запланированные отпуска по подразд-нию (за период)";
    private static final String SHEET_NAME = "Отчет";

    private final HSSFWorkbook workbook = new HSSFWorkbook();
    private final HSSFSheet sheet;

    private PlannedVacation() {
        this(SHEET_NAME);
    }

    private PlannedVacation(String sheetName) {
        sheet = workbook.createSheet(sheetName);
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue(CAPTION);
    }

    public PlannedVacation department(String department) {
        Row row = sheet.createRow(2);
        row.createCell(0).setCellValue("По подразделению : " + department);
        return this;
    }

    public PlannedVacation period(Date startDate, Date finishDate) {
        Row row = sheet.createRow(1);
        String result = String.format("c %s по %s", DATE_FORMAT_DOT.format(startDate), DATE_FORMAT_DOT.format(finishDate));
        row.createCell(0).setCellValue(result);
        return this;
    }

    public PlannedVacation table(List<PlannedVacationTable> plannedVacationTableList) {
        Row rowHeaders = sheet.createRow(4);
        for (int i = 0; i < headers.length; i++) {
            rowHeaders.createCell(i).setCellValue(headers[i]);
        }
        for (int i = 0; i < plannedVacationTableList.size(); i++) {
            var object = plannedVacationTableList.get(i);

            Row row = sheet.createRow(i + 5);
            row.createCell(0).setCellValue(object.getFullName());
            row.createCell(1).setCellValue(DATE_FORMAT_SLASH.format(object.getStartDate()));
            row.createCell(2).setCellValue(DATE_FORMAT_SLASH.format(object.getFinishDate()));
            row.createCell(3).setCellValue(String.valueOf(object.getDayCount()));
            row.createCell(4).setCellValue(object.getDepartment());
        }
        return this;
    }

    public HSSFWorkbook build() {
        return workbook;
    }

    public static PlannedVacation builder(String sheetName) {
        return new PlannedVacation(sheetName);
    }

    public static PlannedVacation builder() {
        return new PlannedVacation();
    }

}
