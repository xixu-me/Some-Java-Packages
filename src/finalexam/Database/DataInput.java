package finalexam.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class DataInput {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/xiaoshou?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";

    public static void main(String[] args) throws Exception {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(DBURL);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("====超市商品管理维护====");
        System.out.println("1、从excel中导入数据");
        System.out.println("2、从文本文件导入数据");
        System.out.println("3、返回主菜单");
        System.out.print("请选择（1-3）：");
        int choice = sc.nextInt();
        int cnt = 0;
        switch (choice) {
            case 1:
                cnt = 0;
                Workbook workbook = Workbook.getWorkbook(new File("商品信息.xls"));
                Sheet sheet = workbook.getSheet(0);
                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell[] cells = sheet.getRow(i);
                    String tiaoma = cells[0].getContents();
                    pstmt = conn.prepareStatement("SELECT COUNT(*) FROM t_shangping WHERE tiaoma = ?");
                    pstmt.setString(1, tiaoma);
                    rs = pstmt.executeQuery();
                    if (rs.next() && rs.getInt(1) == 0) {
                        pstmt = conn.prepareStatement(
                                "INSERT INTO t_shangping (tiaoma, mingcheng, danjia, gongyingshang) VALUES (?, ?, ?, ?)");
                        pstmt.setString(1, tiaoma);
                        pstmt.setString(2, cells[1].getContents());
                        pstmt.setDouble(3, Double.parseDouble(cells[2].getContents()));
                        pstmt.setString(4, cells[3].getContents());
                        pstmt.executeUpdate();
                        cnt++;
                    }
                }
                System.out.println("成功从excel文件导入" + cnt + "条商品数据");
                workbook.close();
                break;
            case 2:
                cnt = 0;
                BufferedReader reader = new BufferedReader(new FileReader("商品信息.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("\t");
                    String tiaoma = data[0];
                    pstmt = conn.prepareStatement("SELECT COUNT(*) FROM t_shangping WHERE tiaoma = ?");
                    pstmt.setString(1, tiaoma);
                    rs = pstmt.executeQuery();
                    if (rs.next() && rs.getInt(1) == 0) {
                        pstmt = conn.prepareStatement(
                                "INSERT INTO t_shangping (tiaoma, mingcheng, danjia, gongyingshang) VALUES (?, ?, ?, ?)");
                        pstmt.setString(1, tiaoma);
                        pstmt.setString(2, data[1]);
                        pstmt.setDouble(3, Double.parseDouble(data[2]));
                        pstmt.setString(4, data[3]);
                        pstmt.executeUpdate();
                        cnt++;
                    }
                }
                reader.close();
                System.out.println("成功从文本文件导入" + cnt + "条商品数据");
                break;
            case 3:
                break;
            default:
                System.out.println("无效的选择，请重新输入！");
                break;
        }
        rs.close();
        pstmt.close();
        conn.close();
    }
}
