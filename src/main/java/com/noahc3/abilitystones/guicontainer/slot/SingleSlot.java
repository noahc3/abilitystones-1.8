package com.noahc3.abilitystones.guicontainer.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SingleSlot extends Slot {

	public SingleSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	
	@Override
	public boolean isItemValid( final ItemStack par1ItemStack )
	{
		return true;
	}
	
	@Override
	public int getSlotStackLimit() {
		return 1;
	}
}
