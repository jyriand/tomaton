package com.sologile.tomaton.listeners;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TimerActionListenerTest {

    JLabel label = new JLabel("25:00");
    TimerActionListener listener = new TimerActionListener(label);

    @Test
    public void reduces_one_second_from_timer() throws Exception {
        listener.actionPerformed(actionEvent());
        assertThat(label.getText(), is("24:59"));
    }

    @Test
    public void reduces_two_seconds_when_called_twice() throws Exception {

        listener.actionPerformed(actionEvent());
        assertThat(label.getText(), is("24:59"));

        listener.actionPerformed(actionEvent());
        assertThat(label.getText(), is("24:58"));
    }

    @Test
    public void reduces_one_minute_after_zero_seconds() throws Exception {
        label.setText("24:00");
        listener.actionPerformed(actionEvent());
        assertThat(label.getText(), is("23:59"));
    }

    @Test
    public void shows_zero_in_front_if_less_than_10_seconds() throws Exception {
        label.setText("24:01");
        listener.actionPerformed(actionEvent());
        assertThat(label.getText(), is("24:00"));
    }

    @Test
    public void shows_zero_in_front_if_less_than_10_minutes() throws Exception {
        label.setText("10:00");
        listener.actionPerformed(actionEvent());
        assertThat(label.getText(), is("09:59"));
    }

    private ActionEvent actionEvent() {
        return null;
    }
}
