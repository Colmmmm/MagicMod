package net.mcreator.magicmod.item.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.magicmod.item.FireballItem;

public class FireballItemModel extends AnimatedGeoModel<FireballItem> {
	@Override
	public ResourceLocation getAnimationResource(FireballItem animatable) {
		return new ResourceLocation("magicmod", "animations/fireball.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FireballItem animatable) {
		return new ResourceLocation("magicmod", "geo/fireball.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FireballItem animatable) {
		return new ResourceLocation("magicmod", "textures/items/fireball.png");
	}
}
