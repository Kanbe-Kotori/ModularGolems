package dev.xkmc.modulargolems.init.advancement;

import dev.xkmc.l2library.serial.advancements.BaseCriterion;
import dev.xkmc.l2library.serial.advancements.BaseCriterionInstance;
import dev.xkmc.l2serial.serialization.SerialClass;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class GolemEquipTrigger extends BaseCriterion<GolemEquipTrigger.Ins, GolemEquipTrigger> {

	public static Ins ins(int min) {
		Ins ans = new Ins(GolemTriggers.EQUIP.getId(), ContextAwarePredicate.ANY);
		ans.minimum = min;
		return ans;
	}

	public GolemEquipTrigger(ResourceLocation id) {
		super(id, Ins::new, Ins.class);
	}

	public void trigger(ServerPlayer player, int count) {
		this.trigger(player, e -> e.minimum <= count);
	}

	@SerialClass
	public static class Ins extends BaseCriterionInstance<Ins, GolemEquipTrigger> {

		@SerialClass.SerialField
		private int minimum = 0;

		public Ins(ResourceLocation id, ContextAwarePredicate player) {
			super(id, player);
		}

	}

}
