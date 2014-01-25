package com.sologile.tomaton;

import javax.swing.*;
import java.awt.*;

import static com.sologile.tomaton.Tomaton.APP_NAME;

public class TomatonWindow extends JFrame {


    public TomatonWindow(){
        setSize(new Dimension(800, 600));
        setName(APP_NAME);

        JLabel label = new JLabel();
        label.setText(APP_NAME);
        label.setName(APP_NAME);
        setName(APP_NAME);
        getContentPane().add(label);
        setVisible(true);
    }
}
