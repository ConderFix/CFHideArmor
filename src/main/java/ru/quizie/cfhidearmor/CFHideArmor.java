package ru.quizie.cfhidearmor;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import com.github.retrooper.packetevents.settings.PacketEventsSettings;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import org.bukkit.plugin.java.JavaPlugin;
import ru.quizie.cfhidearmor.packets.FakeStrengthArmorPacket;

public final class CFHideArmor extends JavaPlugin {

    @Override
    public void onLoad() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().load();
    }
    @Override
    public void onEnable() {
        PacketEvents.getAPI().init();

        final PacketEventsSettings settings = PacketEvents.getAPI().getSettings();
        settings.checkForUpdates(false);
        settings.debug(false);

        PacketEvents.getAPI().getEventManager().registerListener(new FakeStrengthArmorPacket(), PacketListenerPriority.NORMAL);
    }

    @Override
    public void onDisable() {
        PacketEvents.getAPI().terminate();
    }
}
