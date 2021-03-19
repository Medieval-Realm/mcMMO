package com.gmail.nossr50.runnables;

import com.gmail.nossr50.mcMMO;
import com.neetgames.mcmmo.player.OnlineMMOPlayer;
import org.bukkit.scheduler.BukkitRunnable;

public class SaveTimerTask extends BukkitRunnable {
    @Override
    public void run() {
        mcMMO.p.debug("[User Data] Saving...");
        // All player data will be saved periodically through this
        int count = 1;

        //TODO: write a more efficient bulk save
        for (OnlineMMOPlayer mmoPlayer : UserManager.getPlayers()) {
            UserManager.saveUserWithDelay(mmoPlayer.getPersistentPlayerData(), false, count);
            count++;
        }

        mcMMO.getPartyManager().saveParties();
    }
}
