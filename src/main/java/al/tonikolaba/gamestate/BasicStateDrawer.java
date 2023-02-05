/**
 * Copyright to N.Kolaba All rights reserved ©.
 */
package al.tonikolaba.gamestate;


import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Color;

public class BasicStateDrawer {
	private BufferedImage bg;
	private BufferedImage head;
	private Font font2;

	public void setBg(BufferedImage bg) {
		this.bg = bg;
	}

	public void setHead(BufferedImage head) {
		this.head = head;
	}

	public void setFont2(Font font2) {
		this.font2 = font2;
	}

	public void draw(Graphics2D g, Font thisFont, int thisCurrentChoice) {
		g.drawImage(bg, 0, 0, null);
		g.setFont(thisFont);
		g.setColor(Color.YELLOW);
		g.drawRoundRect(220, 170, 245, 140, 50, 50);
		g.fillRect(230, 180, 225, 120);
		g.setColor(Color.WHITE);
		if (thisCurrentChoice == 0)
			g.drawImage(head, 270, 213, null);
		else if (thisCurrentChoice == 1)
			g.drawImage(head, 270, 238, null);
		else if (thisCurrentChoice == 2)
			g.drawImage(head, 270, 263, null);
		else if (thisCurrentChoice == 3)
			g.drawImage(head, 270, 281, null);
		else if (thisCurrentChoice == 4)
			g.drawImage(head, 270, 299, null);
		else if (thisCurrentChoice == 5)
			g.drawImage(head, 270, 317, null);
		g.setFont(font2);
		g.drawString("tonikolaba \u00A9 \u00AE", 20, 468);
	}
}