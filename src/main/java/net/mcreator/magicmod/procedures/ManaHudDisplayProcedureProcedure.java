package net.mcreator.magicmod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.magicmod.network.MagicmodModVariables;

public class ManaHudDisplayProcedureProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return (entity.getCapability(MagicmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MagicmodModVariables.PlayerVariables())).Mana;
	}
}
