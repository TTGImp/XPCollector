package com.imp.xpcollector.client;

import com.imp.xpcollector.core.CommonProxy;
import com.imp.xpcollector.core.ModBlocks;


public class ClientProxy extends CommonProxy {
	
		public void init(){
		}
		
		@Override
	    public void registerEvents() {
	        super.registerEvents();
	    }
		
		@Override
	    public void registerRenders() {
			ModBlocks.registerRenders();
		}
		
}
