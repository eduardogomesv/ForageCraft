package com.theishiopian.foragecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockStick extends Block
{

	public BlockStick()
	{
		super(Material.WOOD);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		setUnlocalizedName("stick_block");
		setRegistryName("stick_block");
		setSoundType(SoundType.WOOD);
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
}
