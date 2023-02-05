package al.tonikolaba.entity;

import al.tonikolaba.handlers.LoggingHelper;
import al.tonikolaba.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;

/**
 * @author ArtOfSoul
 */

public class Title {

    private TitleUpdater titleUpdater = new TitleUpdater();

	private double dx;

    public Title(String s) {

        try {
            titleUpdater.setImage(ImageIO.read(getClass().getResourceAsStream(s)));
            titleUpdater.setWidth(titleUpdater.getImage().getWidth());
            titleUpdater.setX(-titleUpdater.getWidth());
            titleUpdater.setDone(false);
        } catch (Exception e) {
            LoggingHelper.LOGGER.log(Level.SEVERE, e.getMessage());
        }

    }

    public Title(BufferedImage image) {
        titleUpdater.setImage(image);
        titleUpdater.setWidth(image.getWidth());
        titleUpdater.setX(-titleUpdater.getWidth());
        titleUpdater.setDone(false);
    }

    public void reset() {
        titleUpdater.reset();
    }

    public void sety(double y) {
        titleUpdater.setY(y);
    }

    public void begin() {
        dx = 10;
    }

    public boolean shouldRemove() {
        return titleUpdater.getRemove();
    }

    public void update() {
        titleUpdater.update(this.dx);
    }

    public void draw(Graphics2D g) {
        titleUpdater.draw(g);
    }

}
