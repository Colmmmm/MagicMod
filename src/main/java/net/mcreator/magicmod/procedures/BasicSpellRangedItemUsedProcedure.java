package net.mcreator.magicmod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.magicmod.network.MagicmodModVariables;

public class BasicSpellRangedItemUsedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(MagicmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MagicmodModVariables.PlayerVariables())).Mana - 10;
			entity.getCapability(MagicmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Mana = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
