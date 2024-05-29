package finalexam.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PermissionJudgment {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/xiaoshou?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";

    public static void main(String[] args) throws Exception {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(DBURL);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String username = "";
        String password = "";
        String role = "";
        boolean loginSuccess = false;
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎使用****超市收银系统，请登陆");
        System.out.print("请输入用户名: ");
        username = input.nextLine();
        System.out.print("请输入密码: ");
        password = input.nextLine();
        String sql = "SELECT xingming, juese FROM t_yong WHERE yonghuming=? AND mima=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            role = rs.getString("juese");
            System.out.println("当前收银员：" + rs.getString("xingming"));
            loginSuccess = true;
        } else
            System.out.println("用户名或密码不正确，请重新输入");
        if (loginSuccess) {
            int choice;
            do {
                System.out.println("===****超市收银系统===");
                System.out.println("1、 收银");
                System.out.println("2、 查询统计");
                System.out.println("3、 商品维护");
                System.out.println("4、 修改密码");
                System.out.println("5、 数据导出");
                System.out.println("6、 退出");
                System.out.print("请选择（1-6）：");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                    case 2:
                    case 4:
                    case 6:
                        System.out.println("你可以执行该操作");
                        break;
                    case 3:
                    case 5:
                        if ("管理员".equals(role))
                            System.out.println("你可以执行该操作");
                        else
                            System.out.println("很抱歉，你没有权限执行该操作");
                        break;
                    default:
                        System.out.println("无效的选择，请重新选择（1-6）");
                        break;
                }
            } while (choice != 6);
        }
        rs.close();
        pstmt.close();
        conn.close();
    }
}
