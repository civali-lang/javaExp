import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class CalendarApp extends JFrame {
    private JPanel pCenter;
    private JLabel currentMonthLabel;
    private JPanel pSouth;
    private JButton nextMonthButton, previousMonthButton;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月");
    private YearMonth currentYearMonth;

    public CalendarApp() {
        this.setTitle("日历");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // 初始化当前日期
        currentYearMonth = YearMonth.now();

        // 北部组件：显示当前年月
        currentMonthLabel = new JLabel(currentYearMonth.format(formatter));
        this.add(currentMonthLabel, BorderLayout.NORTH);

        // 中部组件：日历显示
        pCenter = new JPanel(new GridLayout(8, 7)); // 7行7列
        this.add(pCenter, BorderLayout.CENTER);

        // 添加星期
        String[] daysOfWeek = { "日", "一", "二", "三", "四", "五", "六" };
        for (String day : daysOfWeek) {
            JLabel label = new JLabel(day);
            pCenter.add(label);
        }

        // 添加日历
        showCalendar(currentYearMonth);

        // 南部组件：按钮切换月份
        pSouth = new JPanel(new FlowLayout());
        nextMonthButton = new JButton("下一个月");
        previousMonthButton = new JButton("上个月");
        pSouth.add(previousMonthButton);
        pSouth.add(nextMonthButton);
        this.add(pSouth, BorderLayout.SOUTH);

        // 按钮事件处理
        nextMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentYearMonth = currentYearMonth.plusMonths(1);
                showCalendar(currentYearMonth);
                currentMonthLabel.setText(currentYearMonth.format(formatter));
            }
        });

        previousMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentYearMonth = currentYearMonth.minusMonths(1);
                showCalendar(currentYearMonth);
                currentMonthLabel.setText(currentYearMonth.format(formatter));
            }
        });
    }

    private void showCalendar(YearMonth yearMonth) {
        // 清空日历面板
        pCenter.removeAll();

        // 添加星期
        String[] daysOfWeek = { "日", "一", "二", "三", "四", "五", "六" };
        for (String day : daysOfWeek) {
            JLabel label = new JLabel(day);
            pCenter.add(label);
        }

        // 获取当前月份的第一天是星期几
        LocalDate firstDayOfMonth = yearMonth.atDay(1);
        int firstDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();

        // 计算需要填充的空白格数
        for (int i = 0; i < firstDayOfWeek - 1; i++) {
            JLabel label = new JLabel();
            pCenter.add(label);
        }

        // 添加日历天数
        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
            JLabel label = new JLabel(String.valueOf(day));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            pCenter.add(label);
        }

        // 重新设置布局管理器
        pCenter.setLayout(new GridLayout(8, 7));
        pCenter.revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalendarAapp().setVisible(true);
            }
        });
    }
}