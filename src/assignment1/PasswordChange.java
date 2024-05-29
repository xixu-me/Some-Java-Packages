package assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChange {
    static final String DBURL = "jdbc:mysql://localhost:3306/xiaoshou?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL);
            System.out.print("请输入用户名：");
            String username = sc.nextLine();
            String checkUserSql = "SELECT xingming FROM t_yong WHERE yonghuming=?";
            pstmt = conn.prepareStatement(checkUserSql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (!rs.next()) {
                System.out.println("该用户不存在，请重新输入");
                return;
            }
            System.out.print("请输入当前用户的原密码：");
            String oldPassword = sc.nextLine();
            String checkPasswordSql = "SELECT xingming FROM t_yong WHERE yonghuming=? AND mima=MD5(?)";
            pstmt = conn.prepareStatement(checkPasswordSql);
            pstmt.setString(1, username);
            pstmt.setString(2, oldPassword);
            rs = pstmt.executeQuery();
            if (!rs.next()) {
                System.out.println("原密码输入不正确，请重新输入");
                return;
            }
            String newPassword;
            while (true) {
                System.out.print("请设置新的密码：");
                newPassword = sc.nextLine();
                if (!isPasswordComplex(newPassword))
                    System.out.println("您的密码不符合复杂性要求（密码长度不少于6个字符，至少有一个小写字母，至少有一个大写字母，至少一个数字），请重新输入：");
                else
                    break;
            }
            System.out.print("请输入确认密码：");
            String confirmPassword = sc.nextLine();
            if (!newPassword.equals(confirmPassword)) {
                System.out.println("两次输入的密码必须一致，请重新输入确认密码：");
                return;
            }
            String updatePasswordSql = "UPDATE t_yong SET mima=? WHERE yonghuming=?";
            pstmt = conn.prepareStatement(updatePasswordSql);
            pstmt.setString(1, Encrypt.MD5(newPassword));
            pstmt.setString(2, username);
            int result = pstmt.executeUpdate();
            if (result > 0)
                System.out.println("您已成功修改密码，请谨记");
            else
                System.out.println("密码修改失败，请重试");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static boolean isPasswordComplex(String password) {
        if (password.length() < 6)
            return false;
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
