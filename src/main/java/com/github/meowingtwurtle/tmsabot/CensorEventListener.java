package com.github.meowingtwurtle.tmsabot;

import com.srgood.reasons.config.BotConfigManager;
import com.srgood.reasons.impl.commands.utils.CensorUtils;
import com.srgood.reasons.impl.commands.utils.GuildDataManager;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CensorEventListener extends ListenerAdapter {
    private final BotConfigManager configManager;

    public CensorEventListener(BotConfigManager configManager) {
        this.configManager = configManager;
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        CensorUtils.checkCensor(GuildDataManager.getGuildCensorList(configManager, event.getGuild()), event.getMessage());
    }
}
