package tictim.srex;

import org.jetbrains.annotations.NotNull;
import tictim.paraglider.api.movement.MovementPlugin;
import tictim.paraglider.api.movement.MovementPluginAction;
import tictim.paraglider.api.movement.PlayerState;
import tictim.paraglider.api.plugin.ConflictResolver;
import tictim.paraglider.api.plugin.ParagliderPlugin;

@ParagliderPlugin
public class ShitPlugin implements MovementPlugin{
	@Override public void modifyRegisteredStates(@NotNull MovementPlugin.PlayerStateModifier modifier){
		for(PlayerState state : modifier.playerStates().values()){
			// have to do this if i want to see noticeable changes from minor stamina reduction lol
			modifier.changeDefaultStaminaDelta(state.id(), state.staminaDelta()*10);
		}
	}

	@Override public void registerStaminaReductionLogic(@NotNull MovementPlugin.StaminaReductionLogicRegister register){
		register.register(new StaminaReductionAttributeLogic());
		register.register(new ShitLogic());
	}

	@Override public @NotNull ConflictResolver<MovementPlugin, MovementPluginAction> getMovementPluginConflictResolver(){
		return ConflictResolver.error(); // it's my mod, how dare you stand against me
	}
}
