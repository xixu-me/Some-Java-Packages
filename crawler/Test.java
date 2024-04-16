package crawler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;

public class Test {
    public static void main(String[] args) {
        String regex = "<em class=\"\">(\\d+)</em>.*?<span class=\"title\">(.*?)</span>.*?导演: (.*?)&nbsp;&nbsp;&nbsp;主演: (.*?)<br>.*?(\\d{4})&nbsp;/&nbsp;.*?<span class=\"rating_num\" property=\"v:average\">(.*?)</span>";
        String htmlContent = HtmlFetcher.fetchHtmlContent("https://movie.douban.com/top250");
        Matcher m = MatcherGetter.getMatcher(regex, htmlContent);
        StringBuilder movieInfo = new StringBuilder();
        movieInfo.append("豆瓣电影 Top 250\n\n");
        while (m.find()) {
            movieInfo.append("排名: ").append(m.group(1)).append("\n");
            movieInfo.append("电影名: ").append(m.group(2)).append("\n");
            movieInfo.append("导演: ").append(m.group(3)).append("\n");
            movieInfo.append("主演: ").append(m.group(4)).append("\n");
            movieInfo.append("年份: ").append(m.group(5)).append("\n");
            movieInfo.append("评分: ").append(m.group(6)).append("\n");
            movieInfo.append("\n");
        }
        try (PrintWriter out = new PrintWriter("crawler\\movieInfo.txt")) {
            out.println(movieInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
