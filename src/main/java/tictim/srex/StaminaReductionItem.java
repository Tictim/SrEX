package tictim.srex;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public class StaminaReductionItem extends Item{
	private final UUID uuid;
	private final double reductionRate;

	public StaminaReductionItem(Properties p, @NotNull UUID uuid, double reductionRate){
		super(p);
		this.uuid = Objects.requireNonNull(uuid, "fuyck you");
		this.reductionRate = reductionRate;
	}

	@SuppressWarnings("deprecation")
	@Override @NotNull public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot slot){
		HashMultimap<Attribute, AttributeModifier> mm = HashMultimap.create();
		mm.put(SrEX.STAMINA_REDUCTION.get(), new AttributeModifier(uuid, "this is so sikbidi", reductionRate, Operation.MULTIPLY_BASE));
		return mm;
	}
}
