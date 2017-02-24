package com.theishiopian.foragecraft.init;

import com.theishiopian.foragecraft.blocks.Fascine;
import com.theishiopian.foragecraft.blocks.Scarecrow;
import com.theishiopian.foragecraft.blocks.StrawBale;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks 
{
	
	public static Block fascine;
	public static Block straw_bale;
	public static Block scarecrow;
	
	public static void init()
	{
		fascine = new Fascine();
		straw_bale = new StrawBale();
		scarecrow = new Scarecrow();
	}
	
	public static void register()
	{
		registerBlock(fascine);
		registerBlock(straw_bale);
		registerBlock(scarecrow);
	}
	
	private static void registerBlock(Block block)
	{
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRenders()
	{
		registerRender(fascine);
		registerRender(straw_bale);
		registerRender(scarecrow);
	}
	
	public static void registerRender(Block block)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "Inventory"));
	}
}
