package com.sologile.collaborators;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JLabelDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;

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

    public void clickClose() {

    }
}
