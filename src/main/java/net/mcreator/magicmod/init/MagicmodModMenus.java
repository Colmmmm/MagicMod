
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.magicmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.magicmod.world.inventory.AltarMenu;
import net.mcreator.magicmod.MagicmodMod;

public class MagicmodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MagicmodMod.MODID);
	public static final RegistryObject<MenuType<AltarMenu>> ALTAR = REGISTRY.register("altar", () -> IForgeMenuType.create(AltarMenu::new));
}
