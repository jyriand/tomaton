package spikes.ui;

import javax.swing.*;
import java.awt.*;

public class SpikeEggTimerBoard extends JPanel {

    private JLabel timer;
    private Button start;
    private Button stop;
    private Font timerFont;

    SpikeEggTimerBoard() {
        this.timer = new JLabel();
        this.start = new Button("Start");
        this.stop = new Button("Stop");
        this.timerFont = new Font("Monaco", Font.PLAIN, 70);
        draw();
    }

    private void draw() {

        initTimerLabel();
        setLayout(new BorderLayout());

        add(timer, BorderLayout.PAGE_START);
        add(start, BorderLayout.LINE_START);
        add(stop, BorderLayout.LINE_END);
    }

    private void initTimerLabel() {
        timer.setFont(timerFont);
        timer.setText("25:00");
        timer.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
