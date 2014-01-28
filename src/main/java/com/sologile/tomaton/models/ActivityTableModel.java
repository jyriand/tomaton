package com.sologile.tomaton.models;

import javax.swing.table.DefaultTableModel;

public class ActivityTableModel extends DefaultTableModel{


    public ActivityTableModel() {
        super(0, 1);
        addRow(new Object[]{"activity"});
    }
}
