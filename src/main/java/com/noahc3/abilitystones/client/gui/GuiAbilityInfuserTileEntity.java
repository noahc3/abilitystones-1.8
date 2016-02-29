package com.noahc3.abilitystones.client.gui;

import com.noahc3.abilitystones.guicontainer.ContainerAbilityInfuserTileEntity;
import com.noahc3.abilitystones.tileentity.AbilityInfuserTileEntity;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiAbilityInfuserTileEntity extends GuiContainer {
	
	private IInventory tileInfuser;
	
	public GuiAbilityInfuserTileEntity(Container container) {
		super(container);

        this.xSize = 176;
        this.ySize = 214;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
    {
    	GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    	this.mc.getTextureManager().bindTexture(new ResourceLocation("abilstones:textures/gui/ability_infuser.png"));
    	
    	
    	int k = width / 2 - xSize / 2;
        int l = height / 2 - ySize / 2;
        
        
        
        
        
        drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
        
        }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
    	AbilityInfuserTileEntity infuser = new AbilityInfuserTileEntity();
        String s = "Ability Infuser";
        
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 8, 4210752);
        
    }
	
	
	
	
	
	
	

}
