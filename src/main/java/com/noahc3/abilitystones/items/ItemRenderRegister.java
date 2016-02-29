package com.noahc3.abilitystones.items;

import com.noahc3.abilitystones.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderRegister {
	
	static String modid = Reference.MODID;
	
	public static void registerItemRenderer(){
		reg(ModItems.boringStone);
		reg(ModItems.regenerationStone);
		reg(ModItems.swiftnessStone);
		reg(ModItems.fireResistanceStone);
		reg(ModItems.nightVisionStone);
		reg(ModItems.magicalDust);
	}
	
	public static void reg(Item item) {
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		
    }

}
