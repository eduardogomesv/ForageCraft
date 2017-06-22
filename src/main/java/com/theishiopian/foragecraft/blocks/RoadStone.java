package com.theishiopian.foragecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class RoadStone extends Block
{

	public RoadStone()
	{
		super(Material.ROCK, MapColor.GRAY);
		setUnlocalizedName("road_stone");
		setRegistryName("road_stone");
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setSoundType(SoundType.STONE);
	}
}
