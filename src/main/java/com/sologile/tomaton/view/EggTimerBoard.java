package com.sologile.tomaton.view;

import com.sologile.tomaton.listeners.TimerActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sologile.tomaton.constants.FieldNames.*;
import static com.sologile.tomaton.constants.Messages.START_POMODORO_MSG;
import static com.sologile.tomaton.constants.Messages.STOP_POMODORO_MSG;

public class EggTimerBoard extends JPanel {

    private JLabel timer;
    private JButton start;
    private JButton stop;
    private Font timerFont;

    public EggTimerBoard() {
        timer = new JLabel();
        timer.setName(TIMER);
        start = new JButton(START_POMODORO_MSG);
        start.setName(START_POMODORO_BTN);
        start.addActionListener(startClickedListener());

        stop = new JButton(STOP_POMODORO_MSG);
        stop.setName(STOP_POMODORO);

        this.timerFont = new Font("Monaco", Font.PLAIN, 70);
        draw();
    }

    private ActionListener startClickedListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final Timer tmr = new Timer(1000, new TimerActionListener(timer));
                tmr.start();
            }
        };
    }

    private void draw() {

        initTimerLabel();
        setLayout(new BorderLayout());

        add(timer, BorderLayout.PAGE_START);
        add(start, BorderLayout.LINE_START);
        add(stop, BorderLayout.LINE_END);
    }

    private void initTimerLabel() {
        timer.setFont(timerFont);
        timer.setText("25:00");
        timer.setHorizontalAlignment(SwingConstants.CENTER);
    }

}
