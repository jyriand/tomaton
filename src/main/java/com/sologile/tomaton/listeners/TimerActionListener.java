package com.sologile.tomaton.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerActionListener implements ActionListener {

    public static final int TEN = 10;
    public static final String DELIMITER = ":";
    public static final String EXTRA_ZERO = "0";
    private JLabel timerLabel;

    public TimerActionListener(JLabel timerLabel) {
        this.timerLabel = timerLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String[] split = timerLabel.getText().split(DELIMITER);
        Integer min = Integer.valueOf(split[0]);
        Integer sec = Integer.valueOf(split[1]);

        if(sec > 0){
            sec--;
        }
        else if(min > 0){
            min--;
            sec = 59;
        }
        else{
            min = 25;
            sec = 0;
        }

        timerLabel.setText(formatTime(min, sec));
    }

    private String formatTime(Integer min, Integer sec) {
        return (min < TEN ? EXTRA_ZERO + min : min) + DELIMITER + (sec < TEN ? EXTRA_ZERO + sec : sec);
    }
}
