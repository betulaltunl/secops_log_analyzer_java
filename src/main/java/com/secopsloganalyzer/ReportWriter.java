import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriter {
    public static void writeToCSV(List<String> suspiciousIPs, String outputFilePath) {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.append("suspicious_ip\n");
            for (String ip : suspiciousIPs) {
                writer.append(ip + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}