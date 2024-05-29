package finalexam.Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DataOutput {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/xiaoshou?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";

    public static void main(String[] args) throws Exception {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(DBURL);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("===****超市商品管理维护====");
        System.out.println("1、导出商品信息至excel");
        System.out.println("2、导出商品信息至文本文件");
        System.out.println("3、返回主菜单");
        System.out.print("请选择（1-3）：");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                WritableWorkbook workbook = Workbook.createWorkbook(new File("商品导出.xls"));
                WritableSheet sheet = workbook.createSheet("商品信息", 0);
                sheet.addCell(new Label(0, 0, "条码"));
                sheet.addCell(new Label(1, 0, "名称"));
                sheet.addCell(new Label(2, 0, "单价"));
                sheet.addCell(new Label(3, 0, "供应商"));
                pstmt = conn.prepareStatement("SELECT * FROM t_shangping");
                rs = pstmt.executeQuery();
                int row = 1;
                while (rs.next()) {
                    sheet.addCell(new Label(0, row, rs.getString("tiaoma")));
                    sheet.addCell(new Label(1, row, rs.getString("mingcheng")));
                    sheet.addCell(new Label(2, row, rs.getString("danjia")));
                    sheet.addCell(new Label(3, row, rs.getString("gongyingshang")));
                    row++;
                }
                workbook.write();
                workbook.close();
                System.out.println("成功导出" + (row - 1) + "条商品数据到excel中");
                break;
            case 2:
                FileWriter fw = new FileWriter("商品导出.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("条码\t名称\t单价\t供应商\n");
                pstmt = conn.prepareStatement("SELECT * FROM t_shangping");
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    bw.write(rs.getString("tiaoma") + "\t");
                    bw.write(rs.getString("mingcheng") + "\t");
                    bw.write(rs.getString("danjia") + "\t");
                    bw.write(rs.getString("gongyingshang") + "\n");
                }
                bw.close();
                fw.close();
                System.out.println("成功导出XXX条商品数据到txt中");
                break;
            case 3:
                break;
            default:
                System.out.println("无效的选择，请重新选择（1-3）：");
                break;
        }
        rs.close();
        pstmt.close();
        conn.close();
    }
}
