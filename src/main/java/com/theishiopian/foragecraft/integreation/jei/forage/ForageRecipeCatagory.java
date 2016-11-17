package com.theishiopian.foragecraft.integreation.jei.forage;

import java.util.Collection;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import com.theishiopian.foragecraft.init.ModBlocks;

public class ForageRecipeCatagory implements IRecipeCategory
{
    public static final String UID = "foragecraft.forage";
    private final IDrawable background;
    private final String localizedName;
    private final IDrawable overlay;

    public ForageRecipeCatagory(IGuiHelper guiHelper)
    {
        background = guiHelper.createBlankDrawable(168, 64);
        localizedName = I18n.format("foragecraft.jei.foraging");
        overlay = guiHelper.createDrawable(new ResourceLocation("foragecraft", "textures/gui/foragingOverlay.png"), 0, 0, 64, 46);

    }

    @Nonnull
    @Override
    public String getUid()
    {
        return UID;
    }

    @Nonnull
    @Override
    public String getTitle()
    {
        return localizedName;
    }

    @Nonnull
    @Override
    public IDrawable getBackground()
    {
        return background;
    }

    @Override
    public void drawExtras(@Nonnull Minecraft minecraft)
    {
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        overlay.draw(minecraft, 48, 0);
        GlStateManager.disableBlend();
        GlStateManager.disableAlpha();
    }

    @Override
    public void drawAnimations(@Nonnull Minecraft minecraft)
    {
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setRecipe
}
