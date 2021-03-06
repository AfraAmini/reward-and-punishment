package UI.ManagerUI;

import UI.MainFrame;
import UI.Visibility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by parishad on 5/27/18.
 */
public class CategorizePanel implements Visibility {
    private JPanel panel;
    private JButton addBtn;
    private JButton cancelBtn;

    public CategorizePanel() {
        createComponents();
        createEvents();
    }
    private void createEvents(){
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().getFrame().setTitle("دسته بندی یک معیار");
                categorizeAEvaluation categorizeAEvaluation = new categorizeAEvaluation();
                setVisible(false);
                categorizeAEvaluation.setVisible(true);
            }
        });
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                MainFrame.getInstance().getFrame().setTitle("پنل کاربری");
            }
        });

    }

    private void createComponents() {
        panel = new JPanel();
        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);

        addBtn = new JButton("انتخاب معیار");
        addBtn.setForeground(new Color(0, 128, 0));

        cancelBtn = new JButton("لغو عملیات");
        cancelBtn.setForeground(new Color(255, 20, 147));


        String[] columnNames = {"ماهیت معیار",
                "دسته ارزیابی",};

        Object[][] data = {
                {"تجربه", "تعریف نشده",
                        "ارتباط انسانی", new Integer(5), new Boolean(false)},
                {"مهارت کار گروهی", "تعریف نشده",
                        "دانش", new Integer(3), new Boolean(true)},
                {"ساعت کاری مناسب", "کمی کیفی",
                        "اخلاق", new Integer(2), new Boolean(false)},
                {"نظم کاری", "کیفی",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"اهمیت دادن به مسائل کاری", "کیفی",
                        "وقت شناسی", new Integer(10), new Boolean(false)}
        };

        JScrollPane scrollPane = new JScrollPane();
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(30)
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(100)
                                                .addComponent(addBtn)
                                                .addGap(107)
                                                .addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(33, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelBtn)
                                        .addComponent(addBtn))
                                .addGap(214))
        );

        JTable table = new JTable(data, columnNames);
        scrollPane.setViewportView(table);
    }


    @Override
    public void setVisible(Boolean visible) {
        if(visible){
            MainFrame.getInstance().getFrame().getContentPane().add(panel);
            MainFrame.getInstance().getFrame().validate();
            MainFrame.getInstance().setPanel(panel);
        }else{
            MainFrame.getInstance().getFrame().getContentPane().remove(panel);
        }
    }
}
