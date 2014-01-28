package com.sologile.tomaton.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerActionListener implements ActionListener {

    private JLabel timerLabel;

    public TimerActionListener(JLabel timerLabel) {

        this.timerLabel = timerLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String currentTime = timerLabel.getText();
        String[] split = currentTime.split(":");
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

        timerLabel.setText(min.toString() + ":" + sec.toString());
    }
}
