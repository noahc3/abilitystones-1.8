package com.noahc3.abilitystones.client;

import com.noahc3.abilitystones.items.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AbilityStonesTab extends CreativeTabs {

	public AbilityStonesTab(String label) {
		super(label);
		
		
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.regenerationStone;
	}
	
	

}
