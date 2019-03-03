package com.company.MVC.subscriber;

import javax.swing.*;
import java.awt.*;

import static com.company.MVC.state.State.STATE;

public class NewView extends JFrame implements ISubscriber {

    JTextArea carLabel = new JTextArea();

    public NewView() {
        init();
    }

    private void init(){

        this.setPreferredSize(new Dimension(150,50));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        carLabel.setEditable(false);
        this.add(carLabel);

        this.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void subscribe() {
        STATE().subscribe(this);
    }

    @Override
    public void unsubscribe() {
        STATE().unsubscribe(this);
    }

    @Override
    public void update() {
        carLabel.setText("");
        STATE().getAll().forEach(v -> {
            carLabel.setText(carLabel.getText() + "\n" + v.getModelName() + " : " + v.getCurrentSpeed());
        });
    }
}
