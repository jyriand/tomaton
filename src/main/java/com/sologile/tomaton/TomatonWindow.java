package com.sologile.tomaton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sologile.tomaton.Tomaton.APP_NAME;

public class TomatonWindow extends JFrame {

    private JLabel timer;

    public TomatonWindow(){
        setSize(new Dimension(800, 600));
        setName(APP_NAME);

        timer = label("timer", "25:00");
        addToContent(label(APP_NAME, APP_NAME));
        addToContent(button());
        addToContent(timer);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
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

    private void addToContent(Component component) {
        getContentPane().add(component);
    }

}
