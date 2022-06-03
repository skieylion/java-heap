package project.java;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import project.java.trip.TripRec;

import javax.xml.bind.JAXB;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy H:m:s");

    public static void main(String[] args) throws IOException {
        run11();
        //run10();
        //run9();
        //run8();
        //run7();
        //run6();
        //run5();
        //run4();
        //run3();
    }

    private static void run11() {
        int x=4;
        char s='\241';
    }

    private static void run10() {
        List<CollectionSigner> collectionSignerList = new ArrayList<>();
        collectionSignerList.add(new CollectionSigner("Иванов", "аналитик"));
        collectionSignerList.add(new CollectionSigner("Петров", "аналитик"));
        collectionSignerList.add(new CollectionSigner("Иванов", "аналитик"));
        collectionSignerList.add(new CollectionSigner("Петров", "аналитик"));
        collectionSignerList.add(new CollectionSigner("Петров", "аналитик"));
        collectionSignerList.stream().distinct().forEach(System.out::println);

    }

    private static void run9() {
        TripRec tripRec = new TripRec();
        //tripRec.setCodeMission(null);
        tripRec.setCancelReason("asdasd asdas as dasd");
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(tripRec, stringWriter);
        System.out.println(stringWriter.toString());
    }

    private static void run8() {
        System.out.println(0x0.Ap1);
        System.out.println("\u1111 \u1111");
        int x = 1, f, s = 2;
        int $d, _D$;

        byte x1 = 2;
        short x2 = 5;
        //int x3=1+2L;
        int[] arr = {1, 2, 3};
        int[][] arr2 = new int[2][];
        System.out.println(arr2[1]);
        int[] g1, g2, g3;
        int f1[], f2[], f3[];

        int q = 1;
        System.out.println(q++ + q++);//1 + 2
        System.out.println(q);
        byte h1 = (byte) 0b1111_1000 >> 1;
        byte h2 = (byte) 0b1111_1100;


        System.out.println(h1);
        System.out.println((byte) 0xf1);

        int a1, a2, a3, a4, a5;
        a1 = a2 = a3 = 100 + (a4 = 2 + (a5 = 1));
        System.out.println(1223232355.11111111111111111111111f);
        int w = (int) 888.8;
        byte _x = (byte) 1000L;
        long _y = (byte) 100;
        byte _d = (byte) 100L;
    }

    private static void run7() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String startDateExpression = "22.05.2022 11:33:00";
        TemporalAccessor temporalAccessor = dateTimeFormatter.parse(startDateExpression);
        LocalTime timeStart = LocalTime.from(temporalAccessor);
        Date dateStart = Date.from(LocalDate.from(temporalAccessor).atStartOfDay(ZoneOffset.UTC).toInstant());
        System.out.println(dateStart.getTime());
        System.out.println(dateStart);
        System.out.println(timeStart);
    }

    private static void run6() {
        byte zero = 0b0000_0000;
        byte one = (byte) 0b0_100_0000;
        byte g = (byte) 0xf1;
        byte x = (byte) 0b1111_0001;
        byte x4 = (byte) 0b1111_1111;
        byte x_4 = (byte) 0b0000_1111;
        int xi = (int) (x >>> 4);
        byte xb = (byte) xi;
        int x15 = 0b11111111_11111111_11111111_11110001;
        int x15_4 = 0b0000_11111111_11111111_11111111_1111;
        int f = 1;
        int q = 0;
        q >>= 4;
        System.out.println(~f);

        System.out.println(Integer.toBinaryString(x15_4));
        System.out.println(x15);
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(xi));


        System.out.println(Integer.compare(0b0000_0011 | 0b0000_0110, 0b0000_0111));
        System.out.println((byte) (0b1111_1100 >>> 2));
        System.out.println(0xf1);
        System.out.println(g);
        System.out.println((byte) (g >> 4));
        System.out.println((byte) (g >>> 4));
        System.out.println(x);
        System.out.println(x4);
        System.out.println((byte) (x >>> 4));
        System.out.println(xi);
        System.out.println(xb);
        //System.out.println((byte)(0b1_0000000_00000000_00000000_00001111));
    }

    private static void addHead(XWPFDocument document, String externalId) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setText("Заявка на поставку буфетной продукции в кабинете руководителя " + externalId);
        run.setFontFamily("Times New Roman");
        run.setFontSize(16);
    }

    private static void addRow(XWPFTable table, String name, String value) {
        XWPFTableRow newRow = table.createRow();

        newRow.getCell(0).getParagraphs().get(0).createRun().setText(name);
        newRow.getCell(0).getParagraphs().get(0).setFontAlignment(ParagraphAlignment.LEFT.getValue());

        newRow.getCell(1).getParagraphs().get(0).createRun().setText(value);
        newRow.getCell(1).getParagraphs().get(0).setFontAlignment(ParagraphAlignment.LEFT.getValue());

    }

    private static void addHeadTable(XWPFDocument document) {
        XWPFTable table = document.createTable();
        table.setTableAlignment(TableRowAlign.LEFT);
        XWPFTableRow tableRow = table.getRow(0);
        tableRow.addNewTableCell();

        table.setCellMargins(0, 0, 0, 3500);

        table.getCTTbl().getTblPr().getTblBorders().getLeft().setVal(STBorder.NONE);
        table.getCTTbl().getTblPr().getTblBorders().getRight().setVal(STBorder.NONE);
        table.getCTTbl().getTblPr().getTblBorders().getTop().setVal(STBorder.NONE);
        table.getCTTbl().getTblPr().getTblBorders().getBottom().setVal(STBorder.NONE);
        table.getCTTbl().getTblPr().getTblBorders().getInsideH().setVal(STBorder.NONE);
        table.getCTTbl().getTblPr().getTblBorders().getInsideV().setVal(STBorder.NONE);

        addRow(table, "Инициатор", "Иванов Иван Иванович");
        addRow(table, "Подотчетное лицо", "Петров Иван Иванович");
        addRow(table, "Адрес поставки", "г. Москва ул. Ленина 1");
        addRow(table, "Номер комнаты", "25");

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(" ");
        run.setFontSize(16);

    }

    static void run5() throws IOException {
        XWPFDocument document = new XWPFDocument();
        CTDocument1 document1 = document.getDocument();
        CTBody body = document1.getBody();

        if (!body.isSetSectPr()) {
            body.addNewSectPr();
        }
        CTSectPr section = body.getSectPr();
        if (!section.isSetPgSz()) {
            section.addNewPgSz();
        }
        CTPageSz pageSize = section.getPgSz();
        pageSize.setOrient(STPageOrientation.LANDSCAPE);
        pageSize.setW(BigInteger.valueOf(16840));
        pageSize.setH(BigInteger.valueOf(11900));

        addHead(document, "SD123123");
        addHeadTable(document);

        XWPFTable table = document.createTable();
        table.setTableAlignment(TableRowAlign.CENTER);
        XWPFTableRow tableRow = table.getRow(0);

        XWPFTableCell code = tableRow.getCell(0);
        XWPFRun runCode = code.getParagraphs().get(0).createRun();
        runCode.setText("Артикул");
        code.getParagraphs().get(0).setFontAlignment(ParagraphAlignment.CENTER.getValue());
        code.setWidth("15%");

        XWPFTableCell title = tableRow.addNewTableCell();
        XWPFRun runTitle = title.getParagraphs().get(0).createRun();
        runTitle.setText("Наименование продукции");
        title.getParagraphs().get(0).setFontAlignment(ParagraphAlignment.LEFT.getValue());

        XWPFTableCell unit = tableRow.addNewTableCell();
        XWPFRun runUnit = unit.getParagraphs().get(0).createRun();
        runUnit.setText("Единицы измерения");
        unit.getParagraphs().get(0).setFontAlignment(ParagraphAlignment.CENTER.getValue());

        XWPFTableCell countInPackage = tableRow.addNewTableCell();
        XWPFRun runCountInPackage = countInPackage.getParagraphs().get(0).createRun();
        runCountInPackage.setText("Количество в упаковке");
        countInPackage.getParagraphs().get(0).setFontAlignment(ParagraphAlignment.CENTER.getValue());

        XWPFTableCell amount = tableRow.addNewTableCell();
        XWPFRun runAmount = amount.getParagraphs().get(0).createRun();
        runAmount.setText("Заказанное количество");
        amount.getParagraphs().get(0).setFontAlignment(ParagraphAlignment.CENTER.getValue());

        XWPFTableCell price = tableRow.addNewTableCell();
        XWPFRun runPrice = price.getParagraphs().get(0).createRun();
        runPrice.setText("Стоимость");
        price.getParagraphs().get(0).setFontAlignment(ParagraphAlignment.CENTER.getValue());
        price.setWidth("15%");

        for (XWPFTableCell cell : tableRow.getTableCells()) {
            cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
            cell.setColor("ECECEC");
            cell.getParagraphs().get(0).getRuns().get(0).setBold(true);
            cell.getParagraphs().get(0).getRuns().get(0).setFontFamily("Times New Roman");
            cell.getParagraphs().get(0).getRuns().get(0).setFontSize(12);
        }

//        Double totalPrice = 0.0;
//        for (BuffetPropertyValue product : products) {
//            XWPFTableRow newRow = table.createRow();
//            newRow.getCell(0).getParagraphs().get(0).createRun().setText(product.getCode());
//            newRow.getCell(0).getParagraphs().get(0).setFontAlignment(ParagraphAlignment.CENTER.getValue());
//            newRow.getCell(1).getParagraphs().get(0).createRun().setText(product.getTitle());
//            newRow.getCell(1).getParagraphs().get(0).setFontAlignment(ParagraphAlignment.LEFT.getValue());
//            newRow.getCell(2).getParagraphs().get(0).createRun().setText(product.getUnit());
//            newRow.getCell(2).getParagraphs().get(0).setFontAlignment(ParagraphAlignment.CENTER.getValue());
//            newRow.getCell(3).getParagraphs().get(0).createRun().setText(product.getPackageQuantity().toString());
//            newRow.getCell(3).getParagraphs().get(0).setFontAlignment(ParagraphAlignment.CENTER.getValue());
//            newRow.getCell(4).getParagraphs().get(0).createRun().setText(product.getAmount().toString());
//            newRow.getCell(4).getParagraphs().get(0).setFontAlignment(ParagraphAlignment.CENTER.getValue());
//            newRow.getCell(5).getParagraphs().get(0).createRun().setText(product.getPrice().toString());
//            newRow.getCell(5).getParagraphs().get(0).setFontAlignment(ParagraphAlignment.RIGHT.getValue());
//            for (XWPFTableCell cell : newRow.getTableCells()) {
//                cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
//                cell.getParagraphs().get(0).getRuns().get(0).setFontFamily("Times New Roman");
//                cell.getParagraphs().get(0).getRuns().get(0).setFontSize(12);
//            }
//            totalPrice += product.getPrice() * product.getAmount();
//        }
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Итого: ");
        run.setBold(true);
        run.setFontFamily("Times New Roman");
        run.setFontSize(12);
        run = paragraph.createRun();
        run.setText("100 руб.");
        run.setFontFamily("Times New Roman");
        run.setFontSize(12);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.write(byteArrayOutputStream);


        String str = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());

        System.out.println(str);

    }

    static void run4() {
        short a = 1;
        int r = a++ + ++a;
        System.out.println(a);
        System.out.println(r);
    }

    static void run3() {
        System.out.println("run3");

        int arr[][] = new int[4][5];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = i + j;
            }
        }

        //вывод элементов массива
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }

        //разномерный массив
        int arr2[][] = new int[3][];
        arr2[0] = new int[3];
        arr2[1] = new int[5];
        arr2[2] = new int[1];

        //инициализация
        float farr[][] = {
                {1, 2, 6.1f, 9.5f},
                {3, 4.1f},
                {8, 9, 32.5f}
        };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(farr[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }

        int[] arr3;

        String str1 = "hello world";
        System.out.println(str1);

        String str2 = new String("hello world");
        System.out.println(str2);

        System.out.println(str2 == str1);

        float f1 = 1_000_000_000_000_000_000_0f;
        float f2 = 1_000_000_000_000_000_000_00f;
        float fr = -1.0f / 0.0f;
        int i1 = 1_000_000_000;
        int i2 = 1_000_000_000;


    }

    void run2() {
        byte[] nums = {1, 2, 3};
        System.out.println(nums[1]);
    }

    void run1() throws InterruptedException {
        System.out.println(" start");

        MyThread myThread1 = new MyThread("thread1");
        MyThread myThread2 = new MyThread("thread2");

        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);

        //thread1.setPriority(Thread.NORM_PRIORITY-2);
        //thread2.setPriority(Thread.NORM_PRIORITY+2);

        thread1.start();
        thread2.start();


        thread1.join(); //ждем первый поток
        System.out.println("#1 joined " + myThread1.count);
        thread2.join(); //ждем второй поток
        System.out.println("#2 joined " + myThread2.count);

        for (int i = 0; i < 10; i++) {
            Thread.sleep(400);
            System.out.println("general thread : " + i);
        }


        byte x = 127;
        x += 1;
        System.out.println(0x2);

        double d1 = 0xA_5p-1;
        System.out.println(0xA_5p-1);


        char s1 = '\141';
        char s2 = '\u1212';

        String str = "\111 like Java";

        System.out.println(str);

        float a = 474.323f;
        byte b = (byte) a;
        System.out.println(b);
    }


}
