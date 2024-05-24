package crawler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherGetter {
    public static Matcher getMatcher(String regex, String htmlContent) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(htmlContent);
    }
}
