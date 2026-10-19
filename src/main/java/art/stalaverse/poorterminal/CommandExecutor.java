package art.stalaverse.poorterminal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CommandExecutor {
  public static String executeBashCommand(String command) throws IOException, InterruptedException {
    ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
    processBuilder.redirectErrorStream(true);
    Process process = processBuilder.start();
    StringBuilder output = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
      String line;
      while ((line=reader.readLine()) != null) {
        output.append(line).append(System.lineSeparator());
      }
    }
    process.waitFor();
    return output.toString();
  }
}
