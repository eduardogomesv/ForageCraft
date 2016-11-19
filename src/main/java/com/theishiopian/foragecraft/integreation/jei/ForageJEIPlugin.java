package com.theishiopian.foragecraft.integreation.jei;

import com.theishiopian.foragecraft.init.ModBlocks;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

@mezz.jei.api.JEIPlugin
public class ForageJEIPlugin extends BlankModPlugin
{
    @Override
    public void register(IModRegistry registry) {

        IJeiHelpers jeiHelpers = registry.getJeiHelpers();

        registry.addDescription(new ItemStack(Items.STICK), "jei.description.foraging.stick")
    }

    @Override
    public void onRuntimeAvailable(@Nonnull IJeiRuntime jeiRuntime) {
    }
}
