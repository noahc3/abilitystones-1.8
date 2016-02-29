package com.noahc3.abilitystones.items;

import com.noahc3.abilitystones.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBoringStone extends Item {
	
	public ItemBoringStone(String unlocalizedName) {
		super();
		
		this.setUnlocalizedName(unlocalizedName);
	    this.setCreativeTab(Main.abilityStonesTab);
	}

}
