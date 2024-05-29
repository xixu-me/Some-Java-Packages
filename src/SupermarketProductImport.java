import java.io.*;
import java.sql.*;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SupermarketProductImport {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/xiaoshou?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
    private static final String USER = "root";
    private static final String PASS = "yourpassword";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====****超市商品管理维护====");
            System.out.println("1、从excel中导入数据");
            System.out.println("2、从文本文件导入数据");
            System.out.println("3、返回主菜单");
            System.out.print("请选择（1-3）：");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    importFromExcel();
                    break;
                case 2:
                    importFromTxt();
                    break;
                case 3:
                    System.out.println("返回主菜单");
                    return;
                default:
                    System.out.println("无效选择，请重新输入");
            }
        }
    }

    private static void importFromExcel() {
        String filePath = "商品信息.xls";
        int importedCount = 0;

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath))) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0)
                    continue; // Skip header row

                String tiaoma = row.getCell(0).getStringCellValue();
                String mingcheng = row.getCell(1).getStringCellValue();
                double danjia = row.getCell(2).getNumericCellValue();
                String gongyingshang = row.getCell(3).getStringCellValue();

                if (!isBarcodeExists(conn, tiaoma)) {
                    insertProduct(conn, tiaoma, mingcheng, danjia, gongyingshang);
                    importedCount++;
                }
            }

            System.out.println("成功从excel文件导入" + importedCount + "条商品数据");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void importFromTxt() {
        String filePath = "商品信息.txt";
        int importedCount = 0;

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue; // Skip empty lines
                String[] parts = line.split("\t");

                if (parts.length < 4)
                    continue; // Skip malformed lines

                String tiaoma = parts[0].trim();
                String mingcheng = parts[1].trim();
                double danjia = Double.parseDouble(parts[2].trim());
                String gongyingshang = parts[3].trim();

                if (!isBarcodeExists(conn, tiaoma)) {
                    insertProduct(conn, tiaoma, mingcheng, danjia, gongyingshang);
                    importedCount++;
                }
            }

            System.out.println("成功从文本文件导入" + importedCount + "条商品数据");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isBarcodeExists(Connection conn, String tiaoma) throws SQLException {
        String query = "SELECT COUNT(*) FROM t_shangping WHERE tiaoma = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tiaoma);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    private static void insertProduct(Connection conn, String tiaoma, String mingcheng, double danjia,
            String gongyingshang) throws SQLException {
        String query = "INSERT INTO t_shangping (tiaoma, mingcheng, danjia, gongyingshang) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tiaoma);
            pstmt.setString(2, mingcheng);
            pstmt.setDouble(3, danjia);
            pstmt.setString(4, gongyingshang);
            pstmt.executeUpdate();
        }
    }
}
