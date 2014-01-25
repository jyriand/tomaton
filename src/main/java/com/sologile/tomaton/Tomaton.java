package com.sologile.tomaton;


import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Tomaton {

    public static final String APP_NAME = "Tomaton";

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(new Runnable(){
            @Override
            public void run() {
                JFrame frame = new JFrame();
                JLabel label = new JLabel();
                label.setText(APP_NAME);
                label.setName(APP_NAME);
                frame.setName(APP_NAME);
                frame.getContentPane().add(label);
                frame.setVisible(true);
            }
        });
    }

}
