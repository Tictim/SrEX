package tictim.srex;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import tictim.paraglider.api.movement.PlayerState;
import tictim.paraglider.api.movement.StaminaReductionLogic;

public class ShitLogic implements StaminaReductionLogic{
	@Override public boolean isApplicable(@NotNull Player player, @NotNull PlayerState playerState){
		if(playerState.staminaDelta()<=0) return false;
		Inventory inv = player.getInventory();
		for(int i = 0; i<inv.getContainerSize(); i++){
			ItemStack stack = inv.getItem(i);
			if(stack.getItem()==SrEX.ITEM_4.get()){
				return true;
			}
		}
		return false;
	}

	@Override public double getReductionRate(@NotNull Player player, @NotNull PlayerState playerState){
		return -.5;
	}

	@Override public double getMinReduction(@NotNull Player player, @NotNull PlayerState state){
		return -.5;
	}

	@Override public double getMaxReduction(@NotNull Player player, @NotNull PlayerState state){
		return -.5;
	}
}
