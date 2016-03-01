package com.noahc3.abilitystones.items;

import java.util.List;

import com.noahc3.abilitystones.Main;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStrengthStone extends Item {

	public ItemStrengthStone(String unlocalizedName){
		super();
		
		this.maxStackSize = 1;
		
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.abilityStonesTab);
	


	}
	
	/* Debug Crap
	
	public static void debugState(System system, ItemStack stack) //remove when done debugging
	{
		System.out.println(stack.getTagCompound().getInteger("Enabled"));
	}
	
	public static void debugTimer(System system, ItemStack stack) //remove when done debugging
	{
		System.out.println(stack.getTagCompound().getInteger("Timer"));
	}
	*/
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged)
    {
        return false;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
		if(stack.getTagCompound().getInteger("Enabled") == 1 && stack.getTagCompound().getInteger("Cooldown") == 0)
		{
			stack.clearCustomName();
			stack.getTagCompound().setInteger("Enabled", 0);
			stack.getTagCompound().setInteger("Cooldown", 20);
			//debugState(null, stack); //remove when done debugging
			return stack;
		}
		else if(stack.getTagCompound().getInteger("Enabled") == 0 && stack.getTagCompound().getInteger("Cooldown") == 0)
		{
			stack.setStackDisplayName(EnumChatFormatting.AQUA + "Strength Stone");
			stack.getTagCompound().setInteger("Enabled", 1);
			stack.getTagCompound().setInteger("Cooldown", 20);
			//debugState(null, stack);
			return stack;
		}
		return stack;
       
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced)
	{
		if(!(stack.getTagCompound() == null))
		 {
			 tooltip.add("Minutes Remaining: " + (((stack.getTagCompound().getInteger("Timer"))/20)/60+1));
		 }
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
		if (!(stack.getTagCompound() == null))
		{
			if (stack.getTagCompound().getInteger("Enabled") == 1)
			{
				return true;
			}
			else if (stack.getTagCompound().getInteger("Enabled") == 0)
			{
				return false;
			}
		}
		
		return false;
    }

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int metadata, boolean bool)
	{
	        if (stack.getTagCompound() == null)
	        {
	        	stack.setTagCompound(new NBTTagCompound());
	        	stack.getTagCompound().setInteger("Enabled", 0);
	        	stack.getTagCompound().setInteger("Cooldown", 0);
	        	stack.getTagCompound().setInteger("Timer", 11999);
	        	stack.getTagCompound().setInteger("TagsSet", 1);
	        }
	        
	        if (!(stack.getTagCompound() == null))
	        {
	        	EntityPlayer player = (EntityPlayer)entity;
		        if(stack.getTagCompound().getInteger("Timer") <= 0 && stack.getTagCompound().getInteger("TagsSet") == 1)
		        {
		        	player.inventory.consumeInventoryItem(this);
		        }
	        }
	        
	        if (stack.getTagCompound().getInteger("Enabled") == 1)
	        {
	        	
	        	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.damageBoost.id, 60, 2));
	        	
	        	if (stack.getTagCompound().getInteger("Timer") > 0)
		        {
		        	stack.getTagCompound().setInteger("Timer", stack.getTagCompound().getInteger("Timer") + -1);
		        }
	        	
	        	
	        }
	        else if (stack.getTagCompound().getInteger("Enabled") == 0)
	        {
	        	
	        }
	        
	        if (stack.getTagCompound().getInteger("Cooldown") > 0)
	        {
	        	stack.getTagCompound().setInteger("Cooldown", stack.getTagCompound().getInteger("Cooldown") + -1);
	        }
	        
	        //debugTimer(null, stack);
	}
	
	
}
