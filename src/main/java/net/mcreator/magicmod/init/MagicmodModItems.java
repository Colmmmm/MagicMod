
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.magicmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.magicmod.item.FireballItem;
import net.mcreator.magicmod.item.BasicSpellItem;
import net.mcreator.magicmod.MagicmodMod;

public class MagicmodModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MagicmodMod.MODID);
	public static final RegistryObject<Item> BASIC_SPELL = REGISTRY.register("basic_spell", () -> new BasicSpellItem());
	public static final RegistryObject<Item> FIREBALL = REGISTRY.register("fireball", () -> new FireballItem());
	public static final RegistryObject<Item> BASIC_ORE = block(MagicmodModBlocks.BASIC_ORE, CreativeModeTab.TAB_DECORATIONS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
