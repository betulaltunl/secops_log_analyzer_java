import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String logFilePath = "src/main/resources/logs/log1.txt";
        String outputFilePath = "reports/suspicious_ips_report.csv";
        int threshold = 5;

        List<String> logLines = LogReader.readLogFile(logFilePath);
        Map<String, Integer> failedAttempts = LogAnalyzer.analyzeFailedAttempts(logLines);
        List<String> suspiciousIPs = LogAnalyzer.findSuspiciousIPs(failedAttempts, threshold);
        ReportWriter.writeToCSV(suspiciousIPs, outputFilePath);

        System.out.println("Şüpheli IP adresleri " + outputFilePath + " dosyasına yazıldı.");
    }
}
