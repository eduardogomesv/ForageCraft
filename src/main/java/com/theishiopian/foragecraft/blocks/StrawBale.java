package com.theishiopian.foragecraft.blocks;

import net.minecraft.block.BlockHay;
import net.minecraft.block.SoundType;

public class StrawBale extends BlockHay
{
	public StrawBale()
	{
		setUnlocalizedName("straw_bale");
		setRegistryName("straw_bale");
		setSoundType(SoundType.PLANT);
	}
}
