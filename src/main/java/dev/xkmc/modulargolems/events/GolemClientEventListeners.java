package dev.xkmc.modulargolems.events;

import dev.xkmc.modulargolems.content.entity.humanoid.skin.ClientProfileManager;
import dev.xkmc.modulargolems.events.event.HumanoidSkinEvent;
import dev.xkmc.modulargolems.init.ModularGolems;
import dev.xkmc.modulargolems.init.data.MGTagGen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = ModularGolems.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GolemClientEventListeners {

	@SubscribeEvent
	public static void onHumanoidSkin(HumanoidSkinEvent event) {
		if (event.getStack().is(MGTagGen.PLAYER_SKIN)) {
			event.setSkin(ClientProfileManager.get(event.getStack().getHoverName().getString()));
		}
	}

}