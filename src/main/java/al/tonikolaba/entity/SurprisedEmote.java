package al.tonikolaba.entity;


import java.awt.Graphics2D;

/**
 * @see al.tonikolaba.entity.Player#SURPRISED_EMOTE
 */
public class SurprisedEmote extends Emote {
	public int getEmote() {
		return Player.SURPRISED_EMOTE;
	}

	public void draw(Graphics2D g, Player player) {
		g.drawImage(player.getSurprised(), (int) (player.getX() + player.getXmap() - player.getCWidth() / 2.0),
				(int) (player.getY() + player.getYmap() - 40), null);
	}
}