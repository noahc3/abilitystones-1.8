package com.noahc3.abilitystones.crafting;

import com.noahc3.abilitystones.items.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class InfuserRecipes {
	
	public static ItemStack infuserCraftingResult(ItemStack input1, ItemStack input2, ItemStack input3){
		
		if (input1 != null){
			if (input2 != null){
				if (input3 != null){
					
					//Add Recipes
					
					if(input2.getItem() == new ItemStack(ModItems.boringStone).getItem()){
						
						if(input3.getItem() == new ItemStack(ModItems.magicalDust).getItem()){
							
							if (input1.getItem() == new ItemStack(Items.potionitem).getItem()){
								
								if (input1.getItemDamage() == new ItemStack(Items.potionitem,1,8225).getItemDamage()){
									return new ItemStack(ModItems.regenerationStone);
								}
								else if (input1.getItemDamage() == new ItemStack(Items.potionitem,1,8226).getItemDamage()){
									return new ItemStack(ModItems.swiftnessStone);
								}
								else if (input1.getItemDamage() == new ItemStack(Items.potionitem,1,8259).getItemDamage()){
									return new ItemStack(ModItems.fireResistanceStone);
								}
								else if (input1.getItemDamage() == new ItemStack(Items.potionitem,1,8262).getItemDamage()){
									return new ItemStack(ModItems.nightVisionStone);
								}
								else {
									return null;
								}
							}
							else {
								return null;
							}
						}
						
						else {
							return null;
						}
					}
					else {
						return null;
					}
				}
				else {
					return null;
				}
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

}
