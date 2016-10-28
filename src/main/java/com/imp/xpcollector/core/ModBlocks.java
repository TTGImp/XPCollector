package com.imp.xpcollector.core;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.imp.xpcollector.core.blocks.BlockXPCollector;
import com.imp.xpcollector.core.blocks.TileEntityXPCollector;
import com.imp.xpcollector.core.items.ItemXPCollector;
import com.imp.xpcollector.lib.ModLib;

public class ModBlocks {
	public static BlockXPCollector xpCollector;
	public static ItemBlock xpCollectorItem;
	
	public static final CreativeTabs tabXPCollector = new CreativeTabs("XPCollector") {
	    @Override public Item getTabIconItem() {
	        return Items.EXPERIENCE_BOTTLE;
	    }
	};

	
	public static void register() {
		
		GameRegistry.register(xpCollector = new BlockXPCollector());
		
		GameRegistry.register(new ItemXPCollector(xpCollector).setRegistryName(xpCollector.getRegistryName()));
		
		GameRegistry.registerTileEntity(TileEntityXPCollector.class, "xpcollector_tile_entity");
	}
	
	public static void registerRenders() {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		String resLoc = ModLib.MOD_ID + ":" + xpCollector.getBlockName();
		ModelResourceLocation loc = new ModelResourceLocation(resLoc, "inventory");
		Item item = Item.getItemFromBlock(xpCollector);
		item.setUnlocalizedName(xpCollector.getBlockName());
		mesher.register(item, 0, loc);
	}
}
