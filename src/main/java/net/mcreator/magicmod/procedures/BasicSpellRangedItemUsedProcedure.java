package net.mcreator.magicmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.magicmod.network.MagicmodModVariables;

public class BasicSpellRangedItemUsedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(MagicmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MagicmodModVariables.PlayerVariables())).Mana >= 10) {
			{
				double _setval = (entity.getCapability(MagicmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MagicmodModVariables.PlayerVariables())).Mana - 10;
				entity.getCapability(MagicmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Not enough mana."), false);
		}
	}
}
