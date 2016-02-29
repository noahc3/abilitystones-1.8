package com.noahc3.abilitystones;

import com.noahc3.abilitystones.client.AbilityStonesTab;
import com.noahc3.abilitystones.tileentity.AbilityInfuserTileEntity;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class Main {
	
	@Instance
    public static Main instance = new Main();
	
	public static final AbilityStonesTab abilityStonesTab = new AbilityStonesTab("abilityStonesTab");

	
	@SidedProxy(clientSide="com.noahc3.abilitystones.ClientProxy", serverSide="com.noahc3.abilitystones.ServerProxy")
    public static CommonProxy proxy;
	
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) 
    {
    	this.proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) 
    {
    	this.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) 
    {
    	this.proxy.postInit(e);
    }
	
    
	
	
	
	
	

}
