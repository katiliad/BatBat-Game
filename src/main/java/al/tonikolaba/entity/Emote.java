package al.tonikolaba.entity;


import java.awt.Graphics2D;

public abstract class Emote {
	public abstract int getEmote();

	public abstract void draw(Graphics2D g, Player player);
}