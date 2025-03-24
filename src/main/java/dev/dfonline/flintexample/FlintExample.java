package dev.dfonline.flintexample;

import dev.dfonline.flint.FlintAPI;
import dev.dfonline.flintexample.feature.TestFeature;
import net.fabricmc.api.ClientModInitializer;

public class FlintExample implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        FlintAPI.confirmLocationWithLocate();

        FlintAPI.registerFeatures(
                new TestFeature()
        );

    }

}
