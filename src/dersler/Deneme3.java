package dersler;

import javax.swing.*;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Deneme3 {
    public static void main(String[] args) {
    	System.setProperty("file.encoding", "UTF-8");

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Console Output to Window");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false); 
            JScrollPane scrollPane = new JScrollPane(textArea);
            Font turkishFont = new Font("Arial", Font.PLAIN, 25);
            textArea.setFont(turkishFont);
            frame.add(scrollPane);
            frame.setVisible(true);
            redirectConsoleOutput(textArea);

            String format = "Merhaba, %s! Bugün saat %tT'dir.";
            String name = "Ahmet";
            long currentTimeMillis = System.currentTimeMillis();
            System.out.printf(format, name, currentTimeMillis);
            System.err.println("Bu bir hata mesajıdır.");
            JPanel panel = new JPanel();
           

            JButton button = new JButton("Tıkla");
            panel.add(button);

            JLabel label = new JLabel("");
            panel.add(label);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label.setText("Butona tıkladınız!");
                }
            });
            JPanel inputPanel = new JPanel();
            JPanel resultPanel = new JPanel();

            JTextField textField = new JTextField(20);
            JButton button2 = new JButton("Aktar");

            JLabel resultLabel = new JLabel();

            inputPanel.add(textField);
            inputPanel.add(button2);

            resultPanel.add(resultLabel);

            button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String inputData = textField.getText();
                    resultLabel.setText("Girilen Veri: " + inputData);
                }
            });

            frame.setLayout(new GridLayout(2, 2));
            frame.add(panel);
            frame.add(inputPanel);
            frame.add(resultPanel);
        });
    }

    private static void redirectConsoleOutput(JTextArea textArea) {

		try {
			OutputStream outputStream = new CustomOutputStream(textArea);
            PrintStream printStream = new PrintStream(outputStream, true, "UTF-8");
            System.setOut(printStream);
            System.setErr(printStream);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    }

    private static class CustomOutputStream extends OutputStream {
        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            textArea.append(String.valueOf((char) b));
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }
}
