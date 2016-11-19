package com.theishiopian.foragecraft.integreation.jei.forage;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.item.ItemStack;

import java.util.Collections;
import java.util.List;

public class ForageRecipeWrapper extends BlankRecipeWrapper {
    private List<ItemStack> inputs;
    private ItemStack output;

    public ForageRecipeWrapper(List<ItemStack> inputs, ItemStack output) {
        this.inputs = inputs;
        this.output = output;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputs(ItemStack.class, inputs);
        ingredients.setOutput(ItemStack.class, output);
    }

    @Override
    @SuppressWarnings("deprecation")
    public List<ItemStack> getInputs() {
        return inputs;
    }

    @Override
    @SuppressWarnings("deprecation")
    public List<ItemStack> getOutputs() {
        return Collections.singletonList(output);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ForageRecipeWrapper)) {
            return false;
        }

        ForageRecipeWrapper other = (ForageRecipeWrapper) obj;

        for (int i = 0; i < inputs.size(); i++) {
            if (!ItemStack.areItemStacksEqual(inputs.get(i), other.inputs.get(i))) {
                return false;
            }
        }

        return ItemStack.areItemStacksEqual(output, other.output);
    }

    @Override
    public String toString() {
        return inputs + " = " + output;
    }
}