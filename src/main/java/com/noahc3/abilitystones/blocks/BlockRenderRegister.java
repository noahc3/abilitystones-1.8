package com.noahc3.abilitystones.blocks;

import com.noahc3.abilitystones.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class BlockRenderRegister {
		
	public static void registerBlockRenderer() 
	{
		reg(ModBlocks.abilityInfuser);
	}
	
	public static void reg(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation("abilstones:ability_infuser", "inventory"));
	}

}
