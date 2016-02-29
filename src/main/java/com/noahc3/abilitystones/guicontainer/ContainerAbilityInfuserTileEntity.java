package com.noahc3.abilitystones.guicontainer;

import com.noahc3.abilitystones.guicontainer.slot.OutputSlot;
import com.noahc3.abilitystones.guicontainer.slot.SingleSlot;
import com.noahc3.abilitystones.tileentity.AbilityInfuserTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

//well aint this a mouthful \/
public class ContainerAbilityInfuserTileEntity extends Container {
	
	private AbilityInfuserTileEntity te;

    public ContainerAbilityInfuserTileEntity(IInventory playerInv, AbilityInfuserTileEntity te) {
        this.te = te;
        
        
        this.addSlotToContainer(new Slot(te, 0, 23, 28));
        this.addSlotToContainer(new Slot(te, 1, 81, 28));
        this.addSlotToContainer(new Slot(te, 2, 139, 28));
        this.addSlotToContainer(new OutputSlot(te, 3, 81, 79));
        
     // Player Inventory, Slot 9-35, Slot IDs 9-35
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 132 + y * 18));
            }
        }

        // Player Inventory, Slot 0-8, Slot IDs 36-44
        for (int x = 0; x < 9; ++x) {
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 190));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.te.isUseableByPlayer(playerIn);
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = null;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();

            if (fromSlot < 4) {
                // From TE Inventory to Player Inventory
                if (!this.mergeItemStack(current, 4, 40, true))

                    return null;
            } else {
                // From Player Inventory to TE Inventory
                if (!this.mergeItemStack(current, 0, 4, false))
                    return null;
            }

            if (current.stackSize == 0)
                slot.putStack((ItemStack) null);
            	if (fromSlot == 3){
            		te.decrStackSize(0, 1);
            		te.decrStackSize(1, 1);
            		te.decrStackSize(2, 1);
            		}
            else
                slot.onSlotChanged();

            if (current.stackSize == previous.stackSize)
                return null;
            slot.onPickupFromSlot(playerIn, current);
        }
        return previous;
    }
    

	

}
