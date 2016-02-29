package com.noahc3.abilitystones.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {
	
	public static Item boringStone;
	public static Item regenerationStone;
	public static Item magicalDust;
	public static Item swiftnessStone;
	public static Item fireResistanceStone;
	public static Item nightVisionStone;
	
	public static void createItems(){
		
		GameRegistry.registerItem(boringStone = new ItemBoringStone("boring_stone"), "boring_stone");
		GameRegistry.registerItem(regenerationStone = new ItemRegenerationStone("regeneration_stone"), "regeneration_stone");
		GameRegistry.registerItem(swiftnessStone = new ItemSwiftnessStone("swiftness_stone"), "swiftness_stone");
		GameRegistry.registerItem(fireResistanceStone = new ItemFireResistanceStone("fire_resistance_stone"), "fire_resistance_stone");
		GameRegistry.registerItem(nightVisionStone = new ItemNightVisionStone("night_vision_stone"), "night_vision_stone");
		GameRegistry.registerItem(magicalDust = new ItemMagicalDust("magical_dust"), "magical_dust");
		
	}

}
