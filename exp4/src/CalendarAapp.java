import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarAapp extends JFrame {
    private JPanel pCenter;
    private JLabel yearMonthLabel;
    private JPanel pSouth;
    private JButton nextMonthButton;
    private JButton previousMonthButton;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;

    public CalendarAapp() {
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("yyyy年MM月");

        setTitle("日历应用程序");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 北部标签显示年月
        yearMonthLabel = new JLabel(dateFormat.format(calendar.getTime()));
        add(yearMonthLabel, BorderLayout.NORTH);

        // 中部面板展示日历
        pCenter = new JPanel(new GridLayout(8, 7));
        populateCalendar();
        add(pCenter, BorderLayout.CENTER);

        // 南部面板，包含按钮
        pSouth = new JPanel(new FlowLayout());
        nextMonthButton = new JButton("下一个月");
        previousMonthButton = new JButton("上一个月");
        pSouth.add(previousMonthButton);
        pSouth.add(nextMonthButton);
        add(pSouth, BorderLayout.SOUTH);

        // 添加按钮事件监听器
        nextMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.MONTH, 1);
                updateCalendar();
            }
        });

        previousMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.MONTH, -1);
                updateCalendar();
            }
        });
    }

    private void populateCalendar() {
        // 清除旧的组件
        pCenter.removeAll();

        // 添加星期
        String[] daysOfWeek = { "日", "一", "二", "三", "四", "五", "六" };
        for (String day : daysOfWeek) {
            JLabel label = new JLabel(day);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            pCenter.add(label);
        }

        // 计算并添加日期
        calendar.set(Calendar.DAY_OF_MONTH, 1); // 设置为当月第一天
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        for (int i = 0; i < firstDayOfWeek - 1; i++) {
            pCenter.add(new JLabel()); // 添加空白标签
        }
        for (int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            JLabel label = new JLabel(String.valueOf(i));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            pCenter.add(label);
        }

        // 重新验证面板
        pCenter.revalidate();
    }

    private void updateCalendar() {
        yearMonthLabel.setText(dateFormat.format(calendar.getTime()));
        populateCalendar();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalendarApp().setVisible(true);
            }
        });
    }
}