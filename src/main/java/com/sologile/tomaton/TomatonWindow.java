package com.sologile.tomaton;

import com.sologile.tomaton.models.ActivityTableModel;
import com.sologile.tomaton.view.ActivityBox;
import com.sologile.tomaton.view.ActivitySheet;
import com.sologile.tomaton.view.EggTimerBoard;
import spikes.ui.SpikeActivityTableModel;

import javax.swing.*;
import java.awt.*;

import static com.sologile.tomaton.Tomaton.APP_NAME;

public class TomatonWindow extends JFrame {

    private ActivityTableModel activityModel;
    private SpikeActivityTableModel model;

    private EggTimerBoard timerBoard;
    private ActivitySheet activitySheet;
    private ActivityBox activityBox;


    public TomatonWindow(){
        activityModel = new ActivityTableModel();
        timerBoard = new EggTimerBoard();
        activitySheet = new ActivitySheet(activityModel);
        activityBox = new ActivityBox(activityModel);

        drawPanels();
    }

    private void drawPanels() {
        setSize(new Dimension(800, 600));
        setName(APP_NAME);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setVisible(true);
        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;

        addToContent(timerBoard, c);
        c.gridy = 1;
        addToContent(activityBox, c);

        c.gridy = 2;
        addToContent(activitySheet, c);
        pack();
    }


    private void addToContent(JPanel panel, GridBagConstraints c) {
        getContentPane().add(panel, c);
    }

}
