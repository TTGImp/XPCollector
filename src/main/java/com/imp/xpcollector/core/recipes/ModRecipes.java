package com.imp.xpcollector.core.recipes;

import com.imp.xpcollector.core.ModBlocks;

import crazypants.enderio.EnderIO;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModRecipes {

	public static final void init(){
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.xpCollector,1),new Object[] {
			"xhx",
			"rpr",
			"xxx",
			Character.valueOf('h'),Blocks.HOPPER,
			Character.valueOf('x'),Blocks.STONE,
			Character.valueOf('r'),EnderIO.itemXpTransfer,
			Character.valueOf('p'),EnderIO.blockExperianceOblisk
		}));
	}
}
