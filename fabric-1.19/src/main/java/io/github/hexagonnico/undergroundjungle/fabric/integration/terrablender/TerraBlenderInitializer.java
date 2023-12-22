package io.github.hexagonnico.undergroundjungle.fabric.integration.terrablender;

import io.github.hexagonnico.undergroundjungle.integration.IntegrationHelper;
import terrablender.api.TerraBlenderApi;

public class TerraBlenderInitializer implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        IntegrationHelper.addTerraBlenderRegions();
    }
}
