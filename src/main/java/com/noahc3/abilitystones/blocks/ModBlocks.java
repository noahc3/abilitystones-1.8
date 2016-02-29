package com.noahc3.abilitystones.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block abilityInfuser;
	
	public static void createBlocks() 
	{
		GameRegistry.registerBlock(abilityInfuser = new BlockAbilityInfuser("ability_infuser"), "ability_infuser");
    }

}
