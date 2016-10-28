package com.imp.xpcollector.core.blocks;

import java.util.List;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.IHopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

import com.imp.xpcollector.LiquidXpUtils;

import crazypants.enderio.EnderIO;
import crazypants.enderio.tool.SmartTank;

public class TileEntityXPCollector extends TileEntity implements ITickable, IFluidHandler , IHopper {

	private long xpCollectedValue = 0;
	public SmartTank tank;
	
	public TileEntityXPCollector(){
		tank = new SmartTank(EnderIO.fluids.fluidXpJuice, 32000);
	}
    
	public long getCollectedValue()
	{
		return xpCollectedValue;
	}
	
	@Override
    public void update() {

		if (this.worldObj != null && !this.worldObj.isRemote)
        {
			boolean flag = false;
			flag = captureDroppedItems(this) || flag;
			if (flag)
            {
                this.markDirty();
            }
        }
    }
	
	public boolean captureDroppedItems(IHopper hopper)
    {
        for (EntityXPOrb entityorb : getCaptureItems(hopper.getWorld(), hopper.getXPos(), hopper.getYPos(), hopper.getZPos()))
        {
            if (tryConsumeOrb(entityorb))
            {
                return true;
            }
        }
		return false;
		
    }
	
	public static List<EntityXPOrb> getCaptureItems(World worldIn, double p_184292_1_, double p_184292_3_, double p_184292_5_)
    {
        return worldIn.<EntityXPOrb>getEntitiesWithinAABB(EntityXPOrb.class, new AxisAlignedBB(p_184292_1_ - 1.0D, p_184292_3_ - 1.0D, p_184292_5_ - 1.0D, p_184292_1_ + 2.5D, p_184292_3_ + 2.5D, p_184292_5_ + 2.5D), EntitySelectors.IS_ALIVE);
    }
	
	protected boolean tryConsumeOrb(EntityXPOrb orb) {
		if (!orb.isDead) {
			int xpAmount = LiquidXpUtils.xpToLiquidRatio(orb.getXpValue());
			
			long newValue = xpCollectedValue + xpAmount; 
			
			if (newValue <= tank.getCapacity())
			{
				xpCollectedValue += xpAmount;
				tank.fill(new FluidStack(EnderIO.fluids.fluidXpJuice, xpAmount), true);

				orb.setDead();
				return true;				
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "xpcollector";
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getXPos() {
		return this.getPos().getX();
	}

	@Override
	public double getYPos() {
		return this.getPos().getY();
	}

	@Override
	public double getZPos() {
		return this.getPos().getZ();
	}

	@Override
	public IFluidTankProperties[] getTankProperties() {
		return tank.getTankProperties();
	}

	@Override
	public int fill(FluidStack resource, boolean doFill) {
		return tank.fill(resource, doFill);
	}

	@Override
	public FluidStack drain(FluidStack resource, boolean doDrain) {
		xpCollectedValue -= resource.amount;
		return tank.drain(resource, doDrain);
	}

	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		return tank.drain(maxDrain, doDrain);
	}

}
