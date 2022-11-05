package a.a;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class EventListner implements Listener {
    public static HashMap<String,Integer> map = new HashMap<>();
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        map.putIfAbsent(p.getName(),0);
    }

    @EventHandler
    public void onBreakBlockEvent(BlockBreakEvent e){
        Player p = e.getPlayer();
        int value = map.get(p.getName());
        map.replace(p.getName(),value + 1);
        Bukkit.broadcastMessage("個数:" + map.get(p.getName()));
    }
}
