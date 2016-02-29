package com.noahc3.abilitystones;

import com.noahc3.abilitystones.blocks.ModBlocks;
import com.noahc3.abilitystones.crafting.Recipes;
import com.noahc3.abilitystones.items.ModItems;
import com.noahc3.abilitystones.network.GuiHandler;
import com.noahc3.abilitystones.tileentity.TileEntities;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) 
	{
		ModBlocks.createBlocks();
		ModItems.createItems();
		TileEntities.init();
    }

    public void init(FMLInitializationEvent e) 
    {
    	Recipes.initCrafting();
    	NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent e) 
    {	

    }

}
