package dev.dfonline.flintexample.feature;

import dev.dfonline.flint.Flint;
import dev.dfonline.flint.feature.trait.ModeSwitchListeningFeature;
import dev.dfonline.flint.hypercube.Mode;
import dev.dfonline.flint.util.message.impl.prefix.InfoMessage;
import net.kyori.adventure.text.Component;

public class TestFeature implements ModeSwitchListeningFeature {

    @Override
    public void onSwitchMode(Mode oldMode, Mode newMode) {
        Flint.getUser().sendMessage(new InfoMessage("feature.test", Component.text(oldMode == null ? "none" : oldMode.getName()), Component.text(newMode.getName())));
    }

}
