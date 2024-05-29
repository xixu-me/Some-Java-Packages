package finalexam.Database.CashierStatistics;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CashierStatistics {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/xiaoshou?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";

    public static void main(String[] args) throws Exception {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(DBURL);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String inputDate;
        Date saleDate = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.print("请输入销售日期（yyyy-mm-dd）:");
            inputDate = scanner.nextLine();
            try {
                saleDate = sdf.parse(inputDate);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("你输入的日期格式不正确，请重新输入");
            }
        }
        String sql = "SELECT liushuihao, mingcheng, danjia, shuliang, (danjia * shuliang) as jine, xiaoshoushijian FROM t_shouyinmingxi WHERE DATE(xiaoshoushijian) = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setDate(1, new java.sql.Date(saleDate.getTime()));
        rs = pstmt.executeQuery();
        System.out.println(sdf.format(saleDate) + "年销售如下");
        System.out.println("流水号\t商品名称\t单价\t数量\t金额\t时间");
        System.out.println("=======================================================================================");
        int totalRecords = 0;
        int totalQuantity = 0;
        BigDecimal totalAmount = BigDecimal.ZERO;
        while (rs.next()) {
            System.out.printf("%s\t%s\t%.2f\t%d\t%.2f\t%s\n",
                    rs.getString("liushuihao"),
                    rs.getString("mingcheng"),
                    rs.getBigDecimal("danjia"),
                    rs.getInt("shuliang"),
                    rs.getBigDecimal("jine"),
                    sdf.format(rs.getTimestamp("xiaoshoushijian")));
            totalRecords++;
            totalQuantity += rs.getInt("shuliang");
            totalAmount = totalAmount.add(rs.getBigDecimal("jine"));
        }
        System.out.println("销售总记录条数：" + totalRecords + "；商品总数量：" + totalQuantity + "；销售总金额：" + totalAmount);
        System.out.println("日期：" + sdf.format(saleDate));
        String continueInput;
        do {
            System.out.print("是否继续查询（y/n）:");
            continueInput = scanner.nextLine();
            if ("n".equalsIgnoreCase(continueInput)) {
                System.out.println("程序成功退出");
                break;
            }
        } while ("y".equalsIgnoreCase(continueInput));
        rs.close();
        pstmt.close();
        conn.close();
    }
}