import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;;

public class PalindromeGUI extends JFrame {
    private JTextField inputTextField;
    private JTextField resultTextField;
    private JButton btn1, btn2;// 判断是否是回文串

    public PalindromeGUI() {
        createUI();
    }

    private void createUI() {
        inputTextField = new JTextField(20);
        resultTextField = new JTextField(20);
        btn1 = new JButton("Check Palindrome (Recursive)");
        btn2 = new JButton("Check Palindrome (Non-Recursive)");

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputTextField.getText();
                resultTextField.setText(isPalindromeRecursive(input) ? "Palindrome" : "Not Palindrome");
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputTextField.getText();
                resultTextField.setText(isPalindromeNonRecursive(input) ? "Palindrome" : "Not Palindrome");
            }
        });

        this.setLayout(new FlowLayout());
        this.add(inputTextField);
        this.add(btn1);
        this.add(btn2);
        this.add(resultTextField);
        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private boolean isPalindromeRecursive(String str) {
        if (str == null || str.isEmpty())
            return true;
        return str.charAt(0) == str.charAt(str.length() - 1)
                && isPalindromeRecursive(str.substring(1, str.length() - 1));
    }

    private boolean isPalindromeNonRecursive(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.CHINA);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PalindromeGUI();
            }
        });
    }
}