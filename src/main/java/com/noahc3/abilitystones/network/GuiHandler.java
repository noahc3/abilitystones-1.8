package com.noahc3.abilitystones.network;

import com.noahc3.abilitystones.client.gui.GuiAbilityInfuserTileEntity;
import com.noahc3.abilitystones.guicontainer.ContainerAbilityInfuserTileEntity;
import com.noahc3.abilitystones.tileentity.AbilityInfuserTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	//Registered in CommonProxy Init()
	
	public static final int ABILITY_INFUSER_TILE_ENTITY_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	    if (ID == ABILITY_INFUSER_TILE_ENTITY_GUI)
	        return new ContainerAbilityInfuserTileEntity(player.inventory, (AbilityInfuserTileEntity) world.getTileEntity(new BlockPos(x, y, z)));

	    return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	    if (ID == ABILITY_INFUSER_TILE_ENTITY_GUI)
	    	return new GuiAbilityInfuserTileEntity(new ContainerAbilityInfuserTileEntity(player.inventory, (AbilityInfuserTileEntity) world.getTileEntity(new BlockPos(x, y, z))));

	    return null;
	}

}
