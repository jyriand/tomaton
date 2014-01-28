package spikes.ui;

import javax.swing.*;

public class SpikeActivityListPanel extends JPanel {

    private JTable table;
    public SpikeActivityListPanel() {

        SpikeActivityListModel model = new SpikeActivityListModel();
        model.addRow(new Object[]{"Yks", "Kaks", "Kolm"});
        this.table = new JTable(model);

        table.setModel(model);

        add(table);
        setVisible(true);
    }
}
