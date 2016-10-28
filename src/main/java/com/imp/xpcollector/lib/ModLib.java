package com.imp.xpcollector.lib;

public class ModLib {
    public static final int MAJOR = 1, MINOR = 0, REVISION = 0;
    public static final String VERSION = MAJOR + "." + MINOR + "." + REVISION;
    public static final String MOD_ID = "xpcollector", MOD_NAME = "XP Collector";
    public static final String CLIENT = "com.imp.xpcollector.client.ClientProxy", COMMON = "com.imp.xpcollector.core.CommonProxy";
    
    public static enum xpBlocks {
    	XPCOLLECTOR("xpCollector", "BlockXPCollector");
    	
    	private String unlocalizedName;
    	private String registryName;
    	
    	xpBlocks(String unlocalizedName, String registryName) {
    		this.unlocalizedName = unlocalizedName;
    		this.registryName = registryName;
    	}
    	
    	public String getUnlocalizedName() {
    		return unlocalizedName;
    	}
    	
    	public String getRegistryName() {
    		return registryName;
    	}
    }
}
