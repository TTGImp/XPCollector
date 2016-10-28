package com.imp.xpcollector;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.imp.xpcollector.core.CommonProxy;
import com.imp.xpcollector.core.ModBlocks;
import com.imp.xpcollector.lib.ModLib;

@Mod(modid = ModLib.MOD_ID, name = ModLib.MOD_NAME, version = ModLib.VERSION)
public class XPCollector {
	@Mod.Instance
	public static XPCollector instance;
	
	
	@SidedProxy(clientSide = ModLib.CLIENT, serverSide = ModLib.COMMON)
    public static CommonProxy proxy;

	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{

		ModBlocks.register();		
	}
	
	@Mod.EventHandler
    public void Init(FMLInitializationEvent event) {
		
		proxy.registerRenders();
		
	}
	
	@Mod.EventHandler
    public void Load(FMLLoadEvent event) {
		proxy.registerLayers();
	}
}
