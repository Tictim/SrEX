package tictim.srex;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import tictim.paraglider.api.movement.PlayerState;
import tictim.paraglider.api.movement.StaminaReductionLogic;

public class StaminaReductionAttributeLogic implements StaminaReductionLogic{
	@Override public boolean isApplicable(@NotNull Player player, @NotNull PlayerState playerState){
		if(playerState.staminaDelta()>=0) return false;
		AttributeInstance attrib = player.getAttribute(SrEX.STAMINA_REDUCTION.get());
		if(attrib==null) return false;
		return attrib.getValue()>1;
	}

	@Override public double getReductionRate(@NotNull Player player, @NotNull PlayerState playerState){
		return player.getAttributeValue(SrEX.STAMINA_REDUCTION.get())-1;
	}

	@Override public double getMinReduction(@NotNull Player player, @NotNull PlayerState state){
		return SrEX.STAMINA_REDUCTION.get().getMinValue()-1;
	}

	@Override public double getMaxReduction(@NotNull Player player, @NotNull PlayerState state){
		return SrEX.STAMINA_REDUCTION.get().getMaxValue()-1;
	}
}
