import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) {
        File fQ = new File("question.txt");
        File fA = new File("answer.txt");
        try {
            Scanner sc = new Scanner(fQ);
            FileWriter fw = new FileWriter(fA);
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] arr = s.split("[\\(\\),]");
                double ans = 0;
                switch (arr[0]) {
                    case "add":
                        ans = Double.parseDouble(arr[1]) + Double.parseDouble(arr[2]);
                        break;
                    case "sub":
                        ans = Double.parseDouble(arr[1]) - Double.parseDouble(arr[2]);
                        break;
                    case "max":
                        ans = Math.max(Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));
                        break;
                    case "min":
                        ans = Math.min(Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));
                        break;
                    case "doubleMe":
                        ans = Double.parseDouble(arr[1]) * 2;
                        break;
                }
                fw.write(s + "=" + ans + '\n');
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
