import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TypingPractice extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 300;
    private static final String[] CHINESE_CHARACTERS = {
            "的", "一", "是", "在", "我", "你", "他", "有", "和", "就", "不", "人", "都", "要", "会", "没有", "可以", "这", "个", "上", "也",
            "到", "说", "去", "能", "看", "好", "自己", "我们", "出来", "什么", "时候", "做", "想", "但是", "因为", "所以", "如果", "他们", "她",
            "让", "被", "对", "事情", "用", "工作", "里", "小", "非常", "东西", "然后", "天", "地方", "全", "但是", "还是", "或者", "得到", "很多",
            "东西", "只有", "部分", "因为", "但是", "而且", "虽然", "或者", "就是", "例如", "或者", "以及", "而且", "那么", "所以", "如果", "只要", "当",
            "时间", "时间", "时候", "时候", "时候", "时候", "时候", "事情", "事情", "事情", "事情", "事情", "事情", "事情", "事情"
    };
    private static final Random random = new Random();

    private JLabel labelToShow;
    private JTextField textField;
    private JButton submitButton;
    private JButton resetButton;

    public TypingPractice() {
        createUI();
        startGiveWordThread();
    }

    private void createUI() {
        setTitle("打字练习");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        labelToShow = new JLabel("等待汉字...");
        textField = new JTextField(20);
        submitButton = new JButton("提交");
        resetButton = new JButton("重置");

        JPanel southPanel = new JPanel();
        southPanel.add(submitButton);
        southPanel.add(resetButton);

        add(labelToShow, BorderLayout.NORTH);
        add(textField, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                if (input.equals(labelToShow.getText())) {
                    JOptionPane.showMessageDialog(TypingPractice.this, "输入正确！");
                } else {
                    JOptionPane.showMessageDialog(TypingPractice.this, "输入错误，正确答案是：" + labelToShow.getText());
                }
                textField.setText("");
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelToShow.setText("等待汉字...");
                textField.setText("");
            }
        });
    }

    private void startGiveWordThread() {
        Thread giveWord = new Thread(() -> {
            try {
                while (true) {
                    String chineseCharacter = CHINESE_CHARACTERS[random.nextInt(CHINESE_CHARACTERS.length)];
                    SwingUtilities.invokeAndWait(() -> {
                        labelToShow.setText(chineseCharacter);
                    });
                    Thread.sleep(2000);
                }
            } catch (InterruptedException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        giveWord.start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TypingPractice frame = new TypingPractice();
            frame.setVisible(true);
        });
    }
}