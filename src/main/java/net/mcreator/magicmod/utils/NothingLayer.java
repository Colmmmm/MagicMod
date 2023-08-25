package net.mcreator.magicmod.utils;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.PoseStack;

public class NothingLayer<T extends Entity, M extends EntityModel<T>> extends RenderLayer<T, M> {
	private final RenderLayer<?, ?> replacedLayer;

	public NothingLayer(RenderLayerParent<T, M> renderer, RenderLayer<?, ?> replacedLayer) {
		super(renderer);
		this.replacedLayer = replacedLayer;
	}

	@Override
	public void render(PoseStack p_225628_1_, MultiBufferSource p_225628_2_, int p_225628_3_, T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
	}

	public RenderLayer<?, ?> getReplacedLayer() {
		return this.replacedLayer;
	}
}
