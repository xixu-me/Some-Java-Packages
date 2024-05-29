package excel;

import java.io.File;
import java.util.Scanner;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        WritableWorkbook book = Workbook.createWorkbook(new File("src/excel/求职简历.xls"));
        WritableFont font = new WritableFont(WritableFont.createFont("SimSun"), 11);
        WritableCellFormat borderFormat = new WritableCellFormat(font);
        borderFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
        borderFormat.setAlignment(Alignment.CENTRE);
        borderFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
        WritableFont font1 = new WritableFont(WritableFont.createFont("FangSong"), 20);
        WritableCellFormat title = new WritableCellFormat(font1);
        title.setBorder(Border.ALL, BorderLineStyle.THIN);
        title.setAlignment(Alignment.CENTRE);
        title.setVerticalAlignment(VerticalAlignment.CENTRE);
        WritableSheet sheet = book.createSheet("Sheet1", 0);
        sheet.mergeCells(0, 0, 7, 0);
        sheet.mergeCells(6, 1, 7, 6);
        sheet.mergeCells(1, 3, 5, 3);
        sheet.mergeCells(0, 7, 7, 7);
        sheet.mergeCells(0, 8, 7, 17);
        sheet.mergeCells(0, 18, 7, 18);
        sheet.mergeCells(0, 19, 7, 30);
        sheet.addCell(new Label(0, 0, "求职简历", title));
        sheet.addCell(new Label(0, 1, "姓名", borderFormat));
        sheet.addCell(new Label(2, 1, "性别", borderFormat));
        sheet.addCell(new Label(4, 1, "籍贯", borderFormat));
        sheet.addCell(new Label(0, 2, "出生日期", borderFormat));
        sheet.addCell(new Label(2, 2, "民族", borderFormat));
        sheet.addCell(new Label(4, 2, "邮箱", borderFormat));
        sheet.addCell(new Label(0, 3, "家庭地址", borderFormat));
        sheet.addCell(new Label(0, 4, "政治面貌", borderFormat));
        sheet.addCell(new Label(2, 4, "电话", borderFormat));
        sheet.addCell(new Label(4, 4, "专业", borderFormat));
        sheet.addCell(new Label(6, 1, "照片", borderFormat));
        sheet.addCell(new Label(0, 7, "个人简介", borderFormat));
        sheet.addCell(new Label(0, 18, "专长", borderFormat));
        sheet.setRowView(0, 520);
        System.out.println("姓名：");
        sheet.addCell(new Label(1, 1, sc.next(), borderFormat));
        System.out.println("性别：");
        sheet.addCell(new Label(3, 1, sc.next(), borderFormat));
        System.out.println("籍贯：");
        sheet.addCell(new Label(5, 1, sc.next(), borderFormat));
        System.out.println("出生日期：");
        sheet.addCell(new Label(1, 2, sc.next(), borderFormat));
        System.out.println("民族：");
        sheet.addCell(new Label(3, 2, sc.next(), borderFormat));
        System.out.println("邮箱：");
        sheet.addCell(new Label(5, 2, sc.next(), borderFormat));
        System.out.println("家庭地址：");
        sheet.addCell(new Label(1, 3, sc.next(), borderFormat));
        System.out.println("政治面貌：");
        sheet.addCell(new Label(1, 4, sc.next(), borderFormat));
        System.out.println("电话：");
        sheet.addCell(new Label(3, 4, sc.next(), borderFormat));
        System.out.println("专业：");
        sheet.addCell(new Label(5, 4, sc.next(), borderFormat));
        System.out.println("个人简介：");
        sheet.addCell(new Label(0, 8, sc.next(), borderFormat));
        System.out.println("特长：");
        sheet.addCell(new Label(0, 19, sc.next(), borderFormat));
        for (int i = 0; i <= 5; i++)
            for (int j = 5; j <= 6; j++)
                sheet.addCell(new Label(i, j, " ", borderFormat));
        book.write();
        book.close();
    }
}
