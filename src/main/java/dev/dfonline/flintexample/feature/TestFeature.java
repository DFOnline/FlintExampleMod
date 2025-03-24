package dev.dfonline.flintexample.feature;

import dev.dfonline.flint.Flint;
import dev.dfonline.flint.feature.trait.ModeSwitchListeningFeature;
import dev.dfonline.flint.feature.trait.UserMessageListeningFeature;
import dev.dfonline.flint.hypercube.Mode;
import dev.dfonline.flint.util.message.impl.prefix.InfoMessage;
import dev.dfonline.flint.util.result.ReplacementEventResult;
import net.kyori.adventure.text.Component;

public class TestFeature implements ModeSwitchListeningFeature, UserMessageListeningFeature {

    // Sends a message when the user switches modes
    @Override
    public void onSwitchMode(Mode oldMode, Mode newMode) {
        Flint.getUser().sendMessage(new InfoMessage("feature.test", Component.text(oldMode == null ? "none" : oldMode.getName()), Component.text(newMode.getName())));
    }

    // When a player sends a message, this will replace "flint" with "flont"
    @Override
    public ReplacementEventResult<String> sendMessage(String message) {
        if (message.contains("flint")) {
            return ReplacementEventResult.replace(message.replace("flint", "flont"));
        }
        return ReplacementEventResult.pass();
    }

}
