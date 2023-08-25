
package net.mcreator.magicmod.item;

import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import net.mcreator.magicmod.item.renderer.FireballItemRenderer;

import java.util.stream.Collectors;
import java.util.function.Consumer;
import java.util.List;
import java.util.Arrays;

import com.mojang.blaze3d.vertex.PoseStack;

public class FireballItem extends Item implements IAnimatable {
	public AnimationFactory factory = GeckoLibUtil.createFactory(this);
	public String animationprocedure = "empty";
	public static ItemTransforms.TransformType transformType;

	public FireballItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		super.initializeClient(consumer);
		consumer.accept(new IClientItemExtensions() {
			private final BlockEntityWithoutLevelRenderer renderer = new FireballItemRenderer();

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return renderer;
			}
		});
	}

	public void getTransformType(ItemTransforms.TransformType type) {
		this.transformType = type;
	}

	protected <P extends IAnimatable> void customInstructionListener(CustomInstructionKeyframeEvent<P> event) {
		List<String> instructions = Arrays.stream(event.instructions.split(";")).filter(s -> s.length() > 0).collect(Collectors.toList());
		List<List<String>> instructionTokens = instructions.stream().map(s -> Arrays.asList(s.split(" ")).stream().filter(tk -> tk.length() > 0).collect(Collectors.toList())).filter(tks -> !tks.isEmpty()).collect(Collectors.toList());
		if (instructionTokens.isEmpty())
			return;
		BlockEntityWithoutLevelRenderer ister = new FireballItemRenderer();
		if (!(ister instanceof FireballItemRenderer))
			return;
		FireballItemRenderer renderer = (FireballItemRenderer) ister;
		instructionTokens.stream().filter(tks -> !tks.isEmpty()).forEach(tks -> this.interpretFirstPersonInstructions(tks, renderer));
	}

	protected void interpretFirstPersonInstructions(List<String> tokens, FireballItemRenderer renderer) {
		String firstTok = tokens.get(0);
		if (tokens.size() < 2)
			return;
		String boneName = tokens.get(1);
		if (firstTok.equals("set_hidden")) {
			boolean hidden = Boolean.valueOf(tokens.get(2));
			renderer.hideBone(boneName, hidden);
		} else if (firstTok.equals("move")) {
			float x = Float.valueOf(tokens.get(2));
			float y = Float.valueOf(tokens.get(3));
			float z = Float.valueOf(tokens.get(4));
			renderer.setBonePosition(boneName, x, y, z);
		} else if (firstTok.equals("rotate")) {
			float x = Float.valueOf(tokens.get(2));
			float y = Float.valueOf(tokens.get(3));
			float z = Float.valueOf(tokens.get(4));
			renderer.setBoneRotation(boneName, x, y, z);
		} else if (firstTok.equals("suppress_mod")) {
			renderer.suppressModification(boneName);
		} else if (firstTok.equals("allow_mod")) {
			renderer.allowModification(boneName);
		}
	}

	private <P extends Item & IAnimatable> PlayState idlePredicate(AnimationEvent<P> event) {
		if (this.transformType != null ? true : false) {
			if (this.animationprocedure.equals("empty")) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("fireball.animation.json", EDefaultLoopTypes.LOOP));
				return PlayState.CONTINUE;
			}
		}
		return PlayState.STOP;
	}

	private <P extends Item & IAnimatable> PlayState procedurePredicate(AnimationEvent<P> event) {
		if (this.transformType != null ? true : false) {
			if (!(this.animationprocedure.equals("empty")) && event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.PLAY_ONCE));
				if (event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
					this.animationprocedure = "empty";
					event.getController().markNeedsReload();
				}
			}
		}
		return PlayState.CONTINUE;
	}

	public void setupAnimationState(FireballItemRenderer renderer, ItemStack stack, PoseStack matrixStack, float aimProgress) {
	}

	@Override
	public void registerControllers(AnimationData data) {
		AnimationController procedureController = new AnimationController(this, "procedureController", 0, this::procedurePredicate);
		data.addAnimationController(procedureController);
		AnimationController idleController = new AnimationController(this, "idleController", 0, this::idlePredicate);
		data.addAnimationController(idleController);
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
