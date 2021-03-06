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
public class AddNewEvaluatorPanel implements Visibility {
    private JButton addBtn;
    private JButton cancelBtn;
    private JPanel panel;

    public AddNewEvaluatorPanel() {
        createComponents();
        createEvents();
    }

    private void createEvents() {
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    private void createComponents() {
        panel = new JPanel();
        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);

        addBtn = new JButton("افزودن کارمند به لیست ارزیابان دسته");
        addBtn.setForeground(new Color(0, 128, 0));

        cancelBtn = new JButton("لغو عملیات");
        cancelBtn.setForeground(new Color(255, 20, 147));

        String[] columnNames = {"نام کارمند",
                " نام خانوادگی کارمند", "شماره پرسنلی کارمند"};

        Object[][] data = {
                {"افرا", "امینی",
                        "015234", new Integer(5), new Boolean(false)},
                {"پری‌شاد", "بهنام قادر",
                        "015523", new Integer(3), new Boolean(true)},

                {"یگانه", "علی‌محمدی",
                        "11258", new Integer(3), new Boolean(true)},
        };

        JScrollPane scrollPane = new JScrollPane();
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(30)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(addBtn)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addBtn)
                                        .addComponent(cancelBtn))
                                .addGap(261))
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
