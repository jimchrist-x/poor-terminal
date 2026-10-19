package art.stalaverse.poorterminal;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;

import java.io.IOException;
public class TerminalFrame extends JFrame {
  private JTextField inputField;
  private JButton sendButton;
  private JTextArea terminalOutputArea;
  private JPanel panel;
  private JPanel inputPanel; 

  private final int INPUT_WIDTH;
  private final String BUTTON_LABEL;
  private final int OUTPUT_WIDTH;
  private final int OUTPUT_HEIGHT;
  public TerminalFrame() {
    super("PoorTerminal - Made by Dimitris Christodoulou");
    INPUT_WIDTH=40;
    OUTPUT_WIDTH=100;
    OUTPUT_HEIGHT=30;
    BUTTON_LABEL="Send";
    setSize(1920, 1080);
    createComponents();
    add(panel);
  }

  private void createComponents() {
    inputField = new JTextField(INPUT_WIDTH);
    terminalOutputArea = new JTextArea(OUTPUT_HEIGHT, OUTPUT_WIDTH);
    terminalOutputArea.setEditable(false);
    sendButton = new JButton(BUTTON_LABEL);
    sendButton.addActionListener((ActionEvent event) -> {
      try {
        terminalOutputArea.append(CommandExecutor.executeBashCommand(inputField.getText()));
      } catch (IOException ioe) {
        terminalOutputArea.append("Error: " + ioe.getMessage() + "\n");
      } catch (InterruptedException ie) {
        terminalOutputArea.append("Error: " + ie.getMessage() + "\n");
      }
    });
    panel = new JPanel(new BorderLayout());
    panel.add(new JScrollPane(terminalOutputArea), BorderLayout.CENTER);
    inputPanel = new JPanel(new BorderLayout());
    inputPanel.add(inputField, BorderLayout.CENTER);
    inputPanel.add(sendButton, BorderLayout.EAST);
    panel.add(inputPanel, BorderLayout.SOUTH); 
  }
}
