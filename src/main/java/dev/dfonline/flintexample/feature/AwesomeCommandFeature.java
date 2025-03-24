package dev.dfonline.flintexample.feature;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.dfonline.flint.Flint;
import dev.dfonline.flint.feature.trait.CommandFeature;
import dev.dfonline.flint.util.FlintSound;
import dev.dfonline.flint.util.message.impl.CompoundMessage;
import dev.dfonline.flint.util.message.impl.SoundMessage;
import dev.dfonline.flint.util.message.impl.prefix.SuccessMessage;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.kyori.adventure.text.Component;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.sound.SoundEvents;

public class AwesomeCommandFeature implements CommandFeature {

    @Override
    public String commandName() {
        return "awesome";
    }

    @Override
    public LiteralArgumentBuilder<FabricClientCommandSource> createCommand(LiteralArgumentBuilder<FabricClientCommandSource> cmd, CommandRegistryAccess registryAccess) {
        return cmd.executes(context -> {
            Flint.getUser().sendMessage(new CompoundMessage(
                    new SuccessMessage("feature.awesome", Component.text(Flint.getUser().getPlayer().getNameForScoreboard())),
                    new SoundMessage(FlintSound.builder()
                            .setSound(SoundEvents.ENTITY_ALLAY_ITEM_GIVEN)
                            .build()
                    )
            ));
            return 1;
        });
    }

}
