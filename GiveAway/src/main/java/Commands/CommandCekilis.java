package Commands;

import Utilites.Utils;
import me.arec.giveawayarec.GiveAwayArec;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class CommandCekilis implements CommandExecutor {

    private GiveAwayArec plugin;

    public CommandCekilis(GiveAwayArec plugin) {
        plugin.getCommand("cekilis").setExecutor(this);
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(Utils.color("&cBu komutu sadece oyuncular kullanabilir!"));
            return true;
        }
        Player p = (Player) sender;

        if(!p.hasPermission("cekilis.admin")){
            p.sendMessage(Utils.color("&cGerekli yetkilere sahip değilsin!"));
            return true;
        }
        ArrayList<String> allPlayers = new ArrayList<String>();
        for(Player players : Bukkit.getOnlinePlayers()) {
            allPlayers.add(players.getName());
        }
        int random = new Random().nextInt(allPlayers.size());
        Object picked = allPlayers.get(random);
        for(Player players : Bukkit.getOnlinePlayers()){
            players.sendTitle(Utils.color("&b" + p.getName() + " Bir Çekiliş Başlattı!"),"Sonuçlar Birazdan açıklanacak." );
            Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {


                int time = 15;

                @Override
                public void run() {


                    if (this.time == 10) {
                       players.sendTitle(Utils.color("&6 10"), "");
                    }
                    if (this.time == 8) {
                        players.sendTitle(Utils.color(""), "");
                    }

                    if (this.time == 5) {
                        players.sendTitle(Utils.color("&6 5"), "");

                    }

                    if (this.time == 4) {
                        players.sendTitle(Utils.color("&6 4"), "");
                    }


                    if (this.time == 3) {
                        players.sendTitle(Utils.color("&6 3"), "");
                    }

                    if (this.time == 2) {
                        players.sendTitle(Utils.color("&6 2"), "");
                    }
                    if (this.time == 1) {
                        players.sendTitle(Utils.color("&6 1"), "");
                    }
                    if(this.time == 0){
                        players.sendTitle(Utils.color("&b" + picked.toString()), Utils.color("&6Şanslı Kişi!"));
                    }
                    if (this.time == -1) {

                    }


                    this.time--;
                }
            }, 0L, 20L);
        }



        return true;
    }
}
