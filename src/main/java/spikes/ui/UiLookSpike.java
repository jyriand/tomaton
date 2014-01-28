package spikes.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UiLookSpike extends JFrame {


    public UiLookSpike() throws Exception {
        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());

        createFrame();
    }

    private void createFrame() {
        setSize(800,400);
        setTitle("Tomaton");
        setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        JPanel mainPanel = new JPanel(new GridBagLayout());
        JPanel timerPanel = new SpikeEggTimerBoard();
        JPanel addActivityPanel = new ActivityPanel();

        JPanel listPanel = new SpikeActivityListPanel();

        addActivityPanel.setBorder(BorderFactory.createTitledBorder("Add activity"));

        setLayout(new GridBagLayout());
        c.gridx = 0;
        c.weightx = 2.0;
        c.gridy = 0;
        mainPanel.add(timerPanel, c);
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(addActivityPanel, c);

        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(listPanel, c);

        getContentPane().add(mainPanel);

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private Component table() {
        DefaultTableModel defaultModel = new DefaultTableModel(0,3);

        defaultModel.addRow(new String[]{"1","2","3"});
        JTable table = new JTable(defaultModel);
        return table;
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable(){

            @Override
            public void run() {

                try {
                    new UiLookSpike();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
