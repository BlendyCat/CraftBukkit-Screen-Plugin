package me.blendycat.screen;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import me.blendycat.util.Sprite;

public class Screen {
	private Location origin;
	private int width;
	private int height;
	private List<Sprite> sprites = new ArrayList<Sprite>();
	public Screen(Location origin,int width, int height){
		this.origin = origin;
		this.width = width;
		this.height = height;
	}
	
	public void refresh(){
		double z = origin.getZ();
		double x1 = origin.getX()+width;
		double y1 = origin.getY()+height;
		World world = origin.getWorld();
		
		for(int x = origin.getBlockX();x<x1;x++){
			for(int y = origin.getBlockY();y<y1;y++){
				world.getBlockAt(new Location(world,x,y,z)).setType(Material.AIR);
			}
		}
	}
	
	public Location getOrigin(){
		return origin;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void addSprite(Sprite sprite){
		sprites.add(sprite);
	}
	
	public Sprite[] getSprites(){
		return sprites.toArray(new Sprite[0]);
	}
}
