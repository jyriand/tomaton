package com.sologile.tomaton;


import javax.swing.*;

public class Tomaton {

    public static final String APP_NAME = "Tomaton";

    private TomatonWindow tomatonWindow;

    public Tomaton() throws Exception {
        startUserInterface();
    }

    public void startUserInterface() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable(){
            @Override
            public void run() {
                tomatonWindow = new TomatonWindow();
            }
        });
    }


    public static void main(String[] args) throws Exception {
        Tomaton tomaton = new Tomaton();
    }

}
