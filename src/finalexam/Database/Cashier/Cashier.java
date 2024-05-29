package finalexam.Database.Cashier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cashier {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/xiaoshou?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";

    public static void main(String[] args) throws Exception {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(DBURL);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner scanner = new Scanner(System.in);
        boolean continueCashier = true;
        int sequence = 0;
        String lastDate = "";
        while (continueCashier) {
            System.out.println("欢迎使用阳光超市收银系统");
            System.out.print("请输入商品条形码（6位数字字符）：");
            String barcode = scanner.nextLine();
            pstmt = conn.prepareStatement("SELECT * FROM t_shangping WHERE tiaoma = ?");
            pstmt.setString(1, barcode);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.print("输入商品数量：");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                System.out.print("请输入收银员：");
                String cashier = scanner.nextLine();
                String productName = rs.getString("mingcheng");
                double price = rs.getDouble("danjia");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentTime = sdf.format(new Date());
                String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
                if (!lastDate.equals(currentDate)) {
                    sequence = 0;
                    lastDate = currentDate;
                }
                String transactionId = currentDate + String.format("%04d", ++sequence);
                pstmt = conn.prepareStatement(
                        "INSERT INTO t_shouyinmingxi (liushuihao, tiaoma, mingcheng, danjia, shuliang, shouyinyuan, xiaoshoushijian) VALUES (?, ?, ?, ?, ?, ?, ?)");
                pstmt.setString(1, transactionId);
                pstmt.setString(2, barcode);
                pstmt.setString(3, productName);
                pstmt.setDouble(4, price);
                pstmt.setInt(5, quantity);
                pstmt.setString(6, cashier);
                pstmt.setString(7, currentTime);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0)
                    System.out.println("成功增加一笔销售数据");
            } else
                System.out.println("您输入的商品条形码不存在，请确认后重新输入");
            System.out.print("是否继续收银（y/n）：");
            String choice = scanner.nextLine();
            if ("n".equalsIgnoreCase(choice))
                continueCashier = false;
        }
        System.out.println("成功退出收银程序");
        rs.close();
        pstmt.close();
        conn.close();
    }
}
