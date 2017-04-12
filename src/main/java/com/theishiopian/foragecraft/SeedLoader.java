package com.theishiopian.foragecraft;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class SeedLoader {
	
	public static void seed()
	{
		MinecraftForge.addGrassSeed(new ItemStack(Items.PUMPKIN_SEEDS),6);
		MinecraftForge.addGrassSeed(new ItemStack(Items.MELON_SEEDS),6);
		MinecraftForge.addGrassSeed(new ItemStack(Items.BEETROOT_SEEDS), 4);
		MinecraftForge.addGrassSeed(new ItemStack(Items.STICK),10);
	}
}
