package me.blendycat.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import me.blendycat.screen.Screen;
import me.blendycat.util.Sprite;

public class Main extends JavaPlugin{
	private HashMap<String,Screen> screens = new HashMap<String,Screen>();
	@Override
	public void onEnable(){
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.runTaskTimerAsynchronously(this, new Runnable() {	
            @Override
            public void run() {
				update(1L);
            }
            
        }, 0L, 1L);
	}

	@Override
	public void onDisable(){
		
	}
	
	protected void update(long l) {
		for(Screen screen : screens.values()){
			for(Sprite sprite : screen.getSprites()){
				if(sprite.getX()<=0 && sprite.getVX()<0){
					sprite.setVX(-sprite.getVX());
				}else if(sprite.getX()+1>=screen.getWidth()){
					
				}
				sprite.update(l);
			}
		}
	}
	
	protected void draw(long l){}
	
}
