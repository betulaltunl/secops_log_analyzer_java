import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogAnalyzer {
    public static Map<String, Integer> analyzeFailedAttempts(List<String> logLines) {
        Map<String, Integer> failedAttempts = new HashMap<>();
        Pattern pattern = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3}");

        for (String line : logLines) {
            if (line.contains("Failed password")) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String ip = matcher.group();
                    failedAttempts.put(ip, failedAttempts.getOrDefault(ip, 0) + 1);
                }
            }
        }
        return failedAttempts;
    }

    public static List<String> findSuspiciousIPs(Map<String, Integer> failedAttempts, int threshold) {
        List<String> suspiciousIPs = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : failedAttempts.entrySet()) {
            if (entry.getValue() > threshold) {
                suspiciousIPs.add(entry.getKey());
            }
        }
        return suspiciousIPs;
    }
}