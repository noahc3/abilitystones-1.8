package com.noahc3.abilitystones.blocks;

import com.noahc3.abilitystones.Main;
import com.noahc3.abilitystones.network.GuiHandler;
import com.noahc3.abilitystones.tileentity.AbilityInfuserTileEntity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAbilityInfuser extends BlockContainer {
	
	public BlockAbilityInfuser(String unlocalizedName, Material material, float hardness, float resistance) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(Main.abilityStonesTab);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel("pickaxe", 0);
    }

    public BlockAbilityInfuser(String unlocalizedName, float hardness, float resistance) {
        this(unlocalizedName, Material.rock, hardness, resistance);
    }

    public BlockAbilityInfuser(String unlocalizedName) {
        this(unlocalizedName, 2.0f, 10.0f);
    }
    
    @Override
	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos) {
		
	
		this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.75F, 0.875F);
	}


	public BlockAbilityInfuser(Material materialIn) {
		super(materialIn);
		
	}
	
	@Override
	public boolean isOpaqueCube() {
		
		return false;
	}
	
	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		
		return EnumWorldBlockLayer.CUTOUT;
	}
	
	@Override
	public boolean isFullCube() {
		return false;
	}
	
	//Tile Entity
	
	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AbilityInfuserTileEntity();
    }
	
	@Override
	public int getRenderType() {
		return 3;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
	    AbilityInfuserTileEntity te = (AbilityInfuserTileEntity) world.getTileEntity(pos);
	    InventoryHelper.dropInventoryItems(world, pos, te);
	    super.breakBlock(world, pos, blockstate);
	}


	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
	    if (stack.hasDisplayName()) {
	        ((AbilityInfuserTileEntity) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
	    }
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
	    if (!world.isRemote) {
	        player.openGui(Main.instance, GuiHandler.ABILITY_INFUSER_TILE_ENTITY_GUI, world, pos.getX(), pos.getY(), pos.getZ());
	    }
	    return true;
	}

}
