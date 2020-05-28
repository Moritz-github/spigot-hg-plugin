package com.imdrops.xhg.scoreboard;

import com.imdrops.xhg.XHG;
import net.md_5.bungee.protocol.packet.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ScoreBoardHandler {

    private XHG plugin;

    public ScoreBoardHandler(XHG plugin){
        this.plugin = plugin;
        updateScoreboard();
    }

    public void updateScoreboard(){
        ScoreboardManager m = Bukkit.getScoreboardManager();
        Scoreboard board = m.getNewScoreboard();

        Objective objective = board.registerNewObjective("sb", "", ChatColor.DARK_AQUA +""+  ChatColor.BOLD + "xHG");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        ArrayList<Score> scores = new ArrayList<>();

        scores.add(0, objective.getScore("                         "));
        scores.get(0).setScore(0);

        scores.add(1, objective.getScore("  " + ChatColor.RED + plugin.gameStateManager.getGameState().toString().toLowerCase()));
        scores.get(1).setScore(1);

        scores.add(2, objective.getScore(ChatColor.GREEN + "Game Status:"));
        scores.get(2).setScore(2);

        for (Player p : Bukkit.getOnlinePlayers()){
            p.setScoreboard(board);
        }
    }
}
