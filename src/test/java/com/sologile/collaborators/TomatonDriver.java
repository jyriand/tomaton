package com.sologile.collaborators;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.*;
import com.objogate.wl.swing.gesture.GesturePerformer;
import com.sologile.tomaton.Tomaton;

import javax.swing.*;

import static com.sologile.tomaton.constants.FieldNames.ACTIVITY_LIST;
import static com.sologile.tomaton.constants.FieldNames.TIMER;
import static com.sologile.tomaton.constants.Messages.START_POMODORO_MSG;
import static org.hamcrest.Matchers.equalTo;

public class TomatonDriver extends JFrameDriver {



    public TomatonDriver(int timeout) {
        super(new GesturePerformer(),
                JFrameDriver.topLevelFrame(named(Tomaton.APP_NAME), showingOnScreen()),
                new AWTEventQueueProber(timeout, 100));
    }

    public void mainWindowIsOpened(String windowTitle) {
//            new JLabelDriver(this, named(windowTitle)).hasText(equalTo(windowTitle));
    }

    public void hasTimerWithTime(String time) {
        label(TIMER).hasText(equalTo(time));
        label(TIMER).is(showingOnScreen());
    }

    public void hasStartPomodoroButton(String buttonName) {
        button(buttonName).hasText(equalTo(START_POMODORO_MSG));
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
        table(ACTIVITY_LIST).cellRenderedWithText(0, 0, equalTo("activity"));
    }

    public void createsNewRowInActivityTable(String cellName) {
        nap(100);
        table(ACTIVITY_LIST).cellRenderedWithText(1, 0, equalTo(cellName));
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
