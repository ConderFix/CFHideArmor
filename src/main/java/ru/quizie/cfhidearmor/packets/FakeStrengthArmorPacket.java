package ru.quizie.cfhidearmor.packets;

import com.github.retrooper.packetevents.event.PacketListener;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityEquipment;
import org.bukkit.entity.Player;

public class FakeStrengthArmorPacket implements PacketListener {

    @Override
    public void onPacketSend(PacketSendEvent event) {
        if (!(event.getPlayer() instanceof Player player)) return;
        if (event.getPacketType() != PacketType.Play.Server.ENTITY_EQUIPMENT) return;

        final WrapperPlayServerEntityEquipment wrapper = new WrapperPlayServerEntityEquipment(event);

        wrapper.getEquipment().forEach(armor -> {
            final ItemStack stack = armor.getItem();

            stack.setAmount(64);
            stack.setDamageValue(Integer.MAX_VALUE);
        });
    }
}
