package com.company.MVC.subscriber;

import com.company.MVC.state.State;
import com.company.model.vehicle.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

import static com.company.MVC.state.State.STATE;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    // TODO: Make this genereal for all cars

    private BufferedImage getImageByVehicle(Vehicle vehicle) {
        try {
            return ImageIO.read(getClass().getResource("pics/"+vehicle.getModelName()+".jpg"));
        } catch (IOException e) {
            throw new RuntimeException("Wrong uri");
        }
    }
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        STATE().getAll().forEach(c -> g.drawImage(getImageByVehicle(c), (int) c.getPosition().getX(), (int) c.getPosition().getY(), null));
    }

}
