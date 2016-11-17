package com.theishiopian.foragecraft.integreation.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.*;

@JEIPlugin
public class ForageCraftJEIPlugin extends BlankModPlugin
{
    public void register(@Nonnull IModRegistry registry)
    {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
    }
}
