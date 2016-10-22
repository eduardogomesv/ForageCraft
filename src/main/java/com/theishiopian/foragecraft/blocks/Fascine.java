package com.theishiopian.foragecraft.blocks;

import com.theishiopian.foragecraft.Reference;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;

public class Fascine extends BlockRotatedPillar
{
	public Fascine()
	{
		super(Material.GRASS, MapColor.BROWN);
		
		setUnlocalizedName(Reference.Fascine.FASCINE.getUnlocalizedName());
		setRegistryName(Reference.Fascine.FASCINE.getRegistryName());
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setSoundType(SoundType.PLANT);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y));
	}
}
