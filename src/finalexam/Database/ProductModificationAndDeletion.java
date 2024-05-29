package finalexam.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProductModificationAndDeletion {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/xiaoshou?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";

    public static void main(String[] args) throws Exception {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(DBURL);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("====超市商品管理维护====");
            System.out.println("1、删除商品");
            System.out.println("2、修改商品");
            System.out.println("3、退出");
            System.out.print("请选择（1-3）：");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("输入商品编码：");
                    String codeToDelete = sc.next();
                    pstmt = conn.prepareStatement("SELECT * FROM t_shangping WHERE tiaoma = ?");
                    pstmt.setString(1, codeToDelete);
                    rs = pstmt.executeQuery();
                    if (!rs.next())
                        System.out.println("你输入的编码不存在，请重新输入");
                    else {
                        pstmt = conn.prepareStatement("DELETE FROM t_shangping WHERE tiaoma = ?");
                        pstmt.setString(1, codeToDelete);
                        pstmt.executeUpdate();
                        System.out.println("你成功删除该商品");
                    }
                    break;
                case 2:
                    System.out.print("输入商品编码：");
                    String codeToModify = sc.next();
                    pstmt = conn.prepareStatement("SELECT * FROM t_shangping WHERE tiaoma = ?");
                    pstmt.setString(1, codeToModify);
                    rs = pstmt.executeQuery();
                    if (!rs.next())
                        System.out.println("你输入的编码不存在，请重新输入");
                    else {
                        System.out.print("商品名称（" + rs.getString("mingcheng") + "）：");
                        String name = sc.nextLine();
                        sc.nextLine();
                        System.out.print("商品单价（" + rs.getDouble("danjia") + "）：");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("商品供应商（" + rs.getString("gongyingshang") + "）：");
                        String supplier = sc.nextLine();
                        pstmt = conn.prepareStatement(
                                "UPDATE t_shangping SET mingcheng = ?, danjia = ?, gongyingshang = ? WHERE tiaoma = ?");
                        pstmt.setString(1, name.isEmpty() ? rs.getString("mingcheng") : name);
                        pstmt.setDouble(2, price == 0.0 ? rs.getDouble("danjia") : price);
                        pstmt.setString(3, supplier.isEmpty() ? rs.getString("gongyingshang") : supplier);
                        pstmt.setString(4, codeToModify);
                        pstmt.executeUpdate();
                        System.out.println("成功修改该商品");
                    }
                    break;
                case 3:
                    System.out.println("退出系统");
                    break;
                default:
                    System.out.println("无效的选择，请重新输入");
                    break;
            }
        } while (choice != 3);
        rs.close();
        pstmt.close();
        conn.close();
    }
}
