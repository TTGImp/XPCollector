package com.imp.xpcollector.core.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.imp.xpcollector.core.ModBlocks;
import com.imp.xpcollector.lib.ModLib;

public class BlockXPCollector extends Block implements ITileEntityProvider{

	private String blockName;

    public BlockXPCollector () {
    	super(Material.IRON);        
        
        setCreativeTab(ModBlocks.tabXPCollector);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(7.0f);
        this.setResistance(8.0f);
        setSoundType(SoundType.METAL);
        setUnlocalizedName(ModLib.xpBlocks.XPCOLLECTOR.getUnlocalizedName());
        this.blockName = ModLib.xpBlocks.XPCOLLECTOR.getUnlocalizedName();
        setRegistryName(ModLib.xpBlocks.XPCOLLECTOR.getRegistryName());
        isBlockContainer = true;
       
    }
	
    public String getBlockName()
	{
		return this.blockName;
	}
    
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if(!worldIn.isRemote && hand == EnumHand.MAIN_HAND)
    	{
    	TileEntityXPCollector col = (TileEntityXPCollector) worldIn.getTileEntity(pos);

    	int testMessage = col.tank.getFluidAmount();
    	
    	playerIn.addChatMessage(new TextComponentString("XP Collected - " + testMessage));
		return true;
    	}
    	else 
    	{
    		return false;
    	}
    }
    
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityXPCollector();
	}
    
//	@Override
//    public void breakBlock(World world, BlockPos pos, IBlockState state) {
//        super.breakBlock(world, pos, state);
//        world.removeTileEntity(pos);
//    }

	@SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(this);
    }
}
