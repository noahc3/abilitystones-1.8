package com.noahc3.abilitystones.crafting;

import com.noahc3.abilitystones.blocks.ModBlocks;
import com.noahc3.abilitystones.items.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
	
	
	//Called in CommonProxy Init()
	public static void initCrafting(){
		GameRegistry.addRecipe(new ItemStack(ModBlocks.abilityInfuser), "#}#", "###", " # ", '#', Blocks.cobblestone, '}', Items.water_bucket);
		GameRegistry.addRecipe(new ItemStack(ModItems.magicalDust), "##|", "#}|", "#||", '#', Blocks.glowstone, '}', Items.gunpowder, '|', Blocks.redstone_block);
		GameRegistry.addRecipe(new ItemStack(ModItems.boringStone), "###", "#}#", "###", '#', Blocks.cobblestone, '}', Blocks.stone);
	}

}
