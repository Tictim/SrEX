package tictim.srex;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.UUID;

import static tictim.srex.SrEX.MODID;

@Mod(MODID)
public class SrEX{
	public static final String MODID = "srex";

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	public static final DeferredRegister<Attribute> ATTRIBS = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, MODID);
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

	public static final RegistryObject<Item> ITEM_1 = ITEMS.register("1", () ->
			new StaminaReductionItem(new Item.Properties().stacksTo(1), UUID.fromString("9d7cb00e-413e-4662-b0c9-9419f21bb1fc"), .2));

	public static final RegistryObject<Item> ITEM_2 = ITEMS.register("2", () ->
			new StaminaReductionItem(new Item.Properties().stacksTo(1), UUID.fromString("81e6f7de-9d51-45a2-bccf-1c074365138d"), .5));

	public static final RegistryObject<Item> ITEM_3 = ITEMS.register("3", () ->
			new StaminaReductionItem(new Item.Properties().stacksTo(1), UUID.fromString("f8920d11-1327-4831-a535-1f7a11f586d3"), .7));

	public static final RegistryObject<Item> ITEM_4 = ITEMS.register("4", () ->
			new ShitItem(new Item.Properties().stacksTo(1)));

	public static final RegistryObject<RangedAttribute> STAMINA_REDUCTION = ATTRIBS.register("stamina_reduction", () ->
			new RangedAttribute("attrib.srex.stamina_reduction", 1, 1, 1.8));

	public static final RegistryObject<CreativeModeTab> TAB = TABS.register(MODID, () -> CreativeModeTab.builder()
			.icon(() -> new ItemStack(ITEM_4.get()))
			.title(Component.translatable("itemGroup."+MODID))
			.displayItems((f, o) -> {
				o.accept(ITEM_1.get());
				o.accept(ITEM_2.get());
				o.accept(ITEM_3.get());
				o.accept(ITEM_4.get());
			}).build());

	public SrEX(){
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ITEMS.register(modEventBus);
		ATTRIBS.register(modEventBus);
		TABS.register(modEventBus);

		modEventBus.addListener((EntityAttributeModificationEvent event) -> event.add(EntityType.PLAYER, STAMINA_REDUCTION.get()));
	}
}