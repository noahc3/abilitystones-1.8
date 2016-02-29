package com.noahc3.abilitystones.guicontainer.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class OutputSlot extends Slot {

	public OutputSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isItemValid( final ItemStack par1ItemStack )
	{
		return false;
	}
	
	@Override
	public int getSlotStackLimit() {
		return 1;
	}
	

}
