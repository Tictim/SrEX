package tictim.srex;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ShitItem extends Item{
	public ShitItem(Properties p){
		super(p);
	}

	@Override public void appendHoverText(@NotNull ItemStack stack,
	                                      @Nullable Level level,
	                                      List<Component> list,
	                                      @NotNull TooltipFlag flags){
		list.add(Component.translatable("item.srex.4.tooltip"));
	}
}
