package net.mcreator.magicmod.interfaces;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;

public interface RendersPlayerArms {
	void setRenderArms(boolean renderArms);

	boolean shouldAllowHandRender(ItemStack mainhand, ItemStack offhand, InteractionHand renderingHand);
}
