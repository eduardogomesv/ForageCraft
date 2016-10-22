package com.theishiopian.foragecraft.proxy;

import com.theishiopian.foragecraft.init.ModBlocks;
import com.theishiopian.foragecraft.init.ModItems;

public class Client implements CommonProxy
{
	@Override
	public void init()
	{
		System.out.println("Initializing ForageCraft...");

		ModBlocks.registerRenders();
		ModItems.registerRenders();
	}
}
