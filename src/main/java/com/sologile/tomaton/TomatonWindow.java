package com.sologile.tomaton;

import com.sologile.tomaton.models.ActivityTableModel;
import com.sologile.tomaton.view.ActivityBox;
import com.sologile.tomaton.view.ActivitySheet;
import com.sologile.tomaton.view.EggTimerBoard;
import spikes.ui.SpikeActivityTableModel;

import javax.swing.*;
import java.awt.*;

import static com.sologile.tomaton.Tomaton.APP_NAME;

public class TomatonWindow extends JFrame {

    private ActivityTableModel activityModel;
    private SpikeActivityTableModel model;

    private EggTimerBoard timerBoard;
    private ActivitySheet activitySheet;
    private ActivityBox activityBox;


    public TomatonWindow(){
        activityModel = new ActivityTableModel();
        setSize(new Dimension(800, 600));
        setName(APP_NAME);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        timerBoard = new EggTimerBoard();
        activitySheet = new ActivitySheet(activityModel);
        activityBox = new ActivityBox(activityModel);

        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;

        addToContent(timerBoard, c);
        c.gridy = 1;
        addToContent(activityBox, c);

        c.gridy = 2;
        addToContent(activitySheet, c);


    }

    private void addToContent(JPanel panel, GridBagConstraints c) {
        getContentPane().add(panel, c);
    }

    private JTable activityTable() {
        JTable table = new JTable();
        table.setName("activityList");
        model = new SpikeActivityTableModel();
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

//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                model.addRow(new Object[]{newActivityField.getText()});
//            }
//        });

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


//        final Timer tmr = new Timer(1000, new TimerActionListener(timer));

//        btn.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                tmr.start();
//            }
//        });

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
