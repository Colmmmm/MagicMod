
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.magicmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.magicmod.world.features.ores.BasicOreFeature;
import net.mcreator.magicmod.MagicmodMod;

@Mod.EventBusSubscriber
public class MagicmodModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, MagicmodMod.MODID);
	public static final RegistryObject<Feature<?>> BASIC_ORE = REGISTRY.register("basic_ore", BasicOreFeature::feature);
}
