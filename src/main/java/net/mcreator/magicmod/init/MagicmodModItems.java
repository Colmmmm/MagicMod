
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.magicmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.magicmod.item.BasicSpellItem;
import net.mcreator.magicmod.MagicmodMod;

public class MagicmodModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MagicmodMod.MODID);
	public static final RegistryObject<Item> BASIC_SPELL = REGISTRY.register("basic_spell", () -> new BasicSpellItem());
}
