package com.sologile.collaborators;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.*;
import com.objogate.wl.swing.gesture.GesturePerformer;

import javax.swing.*;

import static org.hamcrest.Matchers.equalTo;

public class TomatonDriver extends JFrameDriver {
    public TomatonDriver(int timeout) {
        super(new GesturePerformer(),
                JFrameDriver.topLevelFrame(named("Tomaton"), showingOnScreen()),
                new AWTEventQueueProber(timeout, 100));
    }

    public void mainWindowIsOpened(String windowTitle) {
            new JLabelDriver(this, named(windowTitle)).hasText(equalTo(windowTitle));
    }

    public void hasTimerWithTime(String time) {
        label("timer").hasText(equalTo(time));
        label("timer").is(showingOnScreen());
    }

    public void hasStartPomodoroButton(String buttonName) {
        button(buttonName).hasText(equalTo("Start pomodoro"));
    }

    public void clickButton(String startPomodoro) {
        button(startPomodoro).click();
    }

    private JButtonDriver button(String name){
        return new JButtonDriver(this, JButton.class, named(name));
    }

    private JLabelDriver label(String name) {
        return new JLabelDriver(this, named(name));
    }

    public void writeToTextField(String name, String content) {
        new JTextFieldDriver(this, JTextField.class, named(name)).replaceAllText(content);
    }

    public void showsActivityList() {
        table("activityList").cellRenderedWithText(0, 0, equalTo("activity"));
    }

    public void createsNewRowInActivityTable(String cellName) {
        nap(100);
        table("activityList").cellRenderedWithText(1, 0, equalTo(cellName));
    }

    private void nap(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private JTableDriver table(String name) {
        return new JTableDriver(this, JTable.class, named(name));
    }


}
