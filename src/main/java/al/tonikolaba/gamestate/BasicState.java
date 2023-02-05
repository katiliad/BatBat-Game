/** Copyright to N.Kolaba
All rights reserved ©.
**/
package al.tonikolaba.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import al.tonikolaba.audio.JukeBox;
import al.tonikolaba.entity.Player;
import al.tonikolaba.handlers.Keys;
import al.tonikolaba.handlers.LoggingHelper;
import al.tonikolaba.main.GamePanel;
import al.tonikolaba.tilemap.TileMap;

/**
 * Created by tonikolaba on 03-Jan-18.
 */

public abstract class BasicState {
	private BasicStateDrawer basicStateDrawer = new BasicStateDrawer();
	private static final String MENU_OPTION = "menuoption";
	protected GameStateManager gsm;
	protected Player player;
	protected TileMap tileMap;
	protected boolean blockInput = false;
	protected int currentChoice = 0;
	protected String[] options;
	protected Font font;
	protected Font fontMenu;

	public BasicState(GameStateManager gsm) {
		this.gsm = gsm;
		try {

			basicStateDrawer.setBg(ImageIO.read(getClass().getResourceAsStream("/Backgrounds/sfondi1.gif"))
					.getSubimage(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT));

			// load floating head
			basicStateDrawer
					.setHead(ImageIO.read(getClass().getResourceAsStream("/HUD/Hud.gif")).getSubimage(0, 12, 12, 11));

			// titles and fonts
			fontMenu = new Font("Arial", Font.BOLD, 18);
			font = new Font("Arial", Font.BOLD, 15);
			basicStateDrawer.setFont2(new Font("Arial", Font.PLAIN, 9));

			// load sound sfx
			JukeBox.load("/SFX/menuoption.mp3", MENU_OPTION);
			JukeBox.load("/SFX/menuselect.mp3", "menuselect");

		} catch (Exception e) {
			LoggingHelper.LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

	public void update() {
		// check keys
		handleInput();
	}

	public void draw(Graphics2D g) {
		basicStateDrawer.draw(g, this.font, this.currentChoice);
	}

	protected void select() {
		throw new IllegalStateException("Needs to be overwritten");
	}

	public void handleInput() {
		if (Keys.isPressed(Keys.ENTER))
			select();
		if (Keys.isPressed(Keys.UP) && currentChoice > 0) {
			JukeBox.play(MENU_OPTION, 0);
			currentChoice--;
		}
		if (Keys.isPressed(Keys.DOWN) && currentChoice < options.length - 1) {
			JukeBox.play(MENU_OPTION, 0);
			currentChoice++;
		}
	}
}
