
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.magicmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.magicmod.block.BasicOreBlock;
import net.mcreator.magicmod.MagicmodMod;

public class MagicmodModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MagicmodMod.MODID);
	public static final RegistryObject<Block> BASIC_ORE = REGISTRY.register("basic_ore", () -> new BasicOreBlock());
}
