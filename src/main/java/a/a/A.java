package a.a;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public final class A extends JavaPlugin {

    public static A plugin;
    public static A instance;
    public A(){instance = this;}
    public static A getInstance(){return instance;}

    public static Scoreboard board;
    ScoreboardManager sbManager;

    public static Objective mainObject;
    public static Score ascore;
    public static Score bscore;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new EventListner(),this);

        sbManager = Bukkit.getScoreboardManager();
        board = sbManager.getMainScoreboard();


        mainObject = board.registerNewObjective("mainBoard","dummy", "ランキング");
        ascore = mainObject.getScore(EventListner.map.keySet()+":");
        ascore.setScore(11);
        bscore = mainObject.getScore(ChatColor.AQUA + "あお：");
        bscore.setScore(15);
        mainObject.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
