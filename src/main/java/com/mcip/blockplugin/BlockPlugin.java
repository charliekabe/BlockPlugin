package com.mcip.blockplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockPlugin extends JavaPlugin implements Listener {

  @Override
  public void onEnable() {
    getServer().getPluginManager().registerEvents(this, this);
    getLogger().info("BlockPlugin enabled!");
  }

  @EventHandler
  public void BlockEvent(PlayerInteractEvent event) {
    Player player = event.getPlayer();
    Action action = event.getAction();
    if (player.hasPermission("blockplugin.use")) {
      if (player.getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD) {
        if (action == Action.RIGHT_CLICK_BLOCK) {
          Material clicked = event.getClickedBlock().getType();
          player.sendMessage(ChatColor.BLUE + "That block is " + ChatColor.YELLOW + clicked);
        }
      }
    }
  }
}