package com.noahc3.abilitystones.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public final class TileEntities {
	
	public static void init() {
		GameRegistry.registerTileEntity(AbilityInfuserTileEntity.class, "tutorial_tile_entity");
    }

}
