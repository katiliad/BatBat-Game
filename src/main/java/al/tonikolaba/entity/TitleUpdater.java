package al.tonikolaba.entity;


import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import al.tonikolaba.main.GamePanel;

public class TitleUpdater {
	private BufferedImage image;
	private int count;
	private boolean done;
	private boolean remove;
	private double x;
	private double y;
	private int width;

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public boolean getRemove() {
		return remove;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void draw(Graphics2D g) {
		if (!remove)
			g.drawImage(image, (int) x, (int) y, null);
	}

	public void reset() {
		done = false;
		remove = false;
		x = -width;
	}

	public void update(double thisDx) {
		if (!done) {
			if (x >= (GamePanel.WIDTH - width) / 2.0) {
				x = (GamePanel.WIDTH - width) / 2.0;
				count++;
				if (count >= 120)
					done = true;
			} else {
				x += thisDx;
			}
		} else {
			x += thisDx;
			if (x > GamePanel.WIDTH)
				remove = true;
		}
	}
}