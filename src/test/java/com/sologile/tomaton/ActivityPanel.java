package com.sologile.tomaton;

import javax.swing.*;
import java.awt.*;

public class ActivityPanel extends JPanel {


    private JTextField addActivity;

    private Button add;


    public ActivityPanel() {
        this.addActivity = new JTextField("Hello worldasdadadadadad");
        this.add = new Button("Add activity");
        draw();
    }

    private void draw() {

        init();
        add(addActivity, BorderLayout.WEST);
        add(add, BorderLayout.EAST);
    }

    private void init() {
        addActivity.setMinimumSize(new Dimension(100,20));

    }


}
