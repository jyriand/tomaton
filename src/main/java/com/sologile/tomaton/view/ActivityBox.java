package com.sologile.tomaton.view;

import com.sologile.tomaton.models.ActivityTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sologile.tomaton.constants.FieldNames.ADD_ACTIVITY_BTN;
import static com.sologile.tomaton.constants.FieldNames.NEW_ACTIVITY_FLD;
import static com.sologile.tomaton.constants.Messages.ADD_ACTIVITY_MSG;

public class ActivityBox extends JPanel {

    private JTextField activityField = new JTextField(15);
    private JButton addActivityBtn = new JButton();
    private ActivityTableModel activityModel;

    public ActivityBox(ActivityTableModel activityModel) {
        this.activityModel = activityModel;

        activityField.setName(NEW_ACTIVITY_FLD);
        addActivityBtn.setName(ADD_ACTIVITY_BTN);
        addActivityBtn.setText(ADD_ACTIVITY_MSG);
        addActivityBtn.addActionListener(addActivityClicked());

        add(activityField);
        add(addActivityBtn);
    }

    private ActionListener addActivityClicked() {

        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activityModel.addRow(new Object[]{activityField.getText()});
            }
        };


    }
}
