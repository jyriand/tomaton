package com.sologile.tomaton.view;

import com.sologile.tomaton.models.ActivityTableModel;

import javax.swing.*;

import static com.sologile.tomaton.constants.FieldNames.ACTIVITY_LIST;

public class ActivitySheet extends JPanel {

    private JTable table;

    public ActivitySheet(ActivityTableModel activityModel) {
        table = new JTable(activityModel);
        table.setName(ACTIVITY_LIST);
        add(table);
    }
}
