package com.seacroak.bronze;

import com.seacroak.bronze.registry.MainRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BronzeModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.BRONZE_DOOR, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.BRONZE_TRAPDOOR, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.TIN_FRAMED_GLASS, RenderLayer.getTranslucent());

	}
}