package com.sologile.tomaton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sologile.tomaton.Tomaton.APP_NAME;

public class TomatonWindow extends JFrame {

    private JLabel timer;
    private ActivityTableModel model;
    private final JTextField newActivityField;

    public TomatonWindow(){
        setSize(new Dimension(800, 600));
        setName(APP_NAME);

        timer = label("timer", "25:00");
        newActivityField = newActivity();

        addToContent(label(APP_NAME, APP_NAME), BorderLayout.PAGE_START);
        addToContent(button(), BorderLayout.PAGE_START);
        addToContent(timer, BorderLayout.LINE_START);
        addToContent(newActivityField, BorderLayout.CENTER);
        addToContent(addActivityButton(), BorderLayout.LINE_END);
        addToContent(activityTable(), BorderLayout.PAGE_END);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JTable activityTable() {
        JTable table = new JTable();
        table.setName("activityList");
        model = new ActivityTableModel();
        model.addColumn("Col1");
        model.addRow(new Object[]{"activity"});

        table.setModel(model);
        table.setVisible(true);
        return table;
    }

    private Component addActivityButton() {
        JButton btn = new JButton();
        btn.setName("addActivity");
        btn.setSize(50,50);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[]{newActivityField.getText()});
            }
        });

        btn.setAlignmentX(100);
        return btn;
    }

    private JTextField newActivity() {
        JTextField field = new JTextField();
        field.setName("newActivity");
        return field;
    }

    private JButton button() {
        JButton btn = new JButton();
        btn.setName("startPomodoro");
        btn.setText("Start pomodoro");
        btn.setSize(50,50);


        final Timer tmr = new Timer(1000, new TimerActionListener(timer));

        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                tmr.start();
            }
        });

        return btn;
    }

    private JLabel label(String name, String text) {
        JLabel label = new JLabel(text);
        label.setName(name);
        label.setVisible(true);
        return label;
    }

    private void addToContent(Component component, String layout) {
        getContentPane().add(component, layout);
    }

}
