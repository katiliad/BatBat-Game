package al.tonikolaba.entity;


import java.awt.Graphics2D;

/**
 * @see al.tonikolaba.entity.Player#CONFUSED_EMOTE
 */
public class ConfusedEmote extends Emote {
	public int getEmote() {
		return Player.CONFUSED_EMOTE;
	}

	public void draw(Graphics2D g, Player player) {
		g.drawImage(player.getConfused(), (int) (player.getX() + player.getXmap() - player.getCWidth() / 2.0),
				(int) (player.getY() + player.getYmap() - 40), null);
	}
}