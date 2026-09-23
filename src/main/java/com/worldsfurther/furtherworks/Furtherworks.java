package com.worldsfurther.furtherworks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Furtherworks.MODID)
public final class Furtherworks {
    public static final String MODID = "furtherworks";

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredItem<Item> RELIC_HEART = ITEMS.registerSimpleItem(
            "relic_heart", new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16));
    public static final DeferredItem<Item> SKY_HEART = ITEMS.registerSimpleItem(
            "sky_heart", new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16));
    public static final DeferredItem<Item> SOURCE_HEART = ITEMS.registerSimpleItem(
            "source_heart", new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16));
    public static final DeferredItem<Item> HOMESTEAD_HEART = ITEMS.registerSimpleItem(
            "homestead_heart", new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16));
    public static final DeferredItem<Item> THE_FURTHER = ITEMS.registerSimpleItem(
            "the_further", new Item.Properties().rarity(Rarity.EPIC).fireResistant().stacksTo(1));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = TABS.register("furtherworks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.furtherworks"))
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .icon(() -> THE_FURTHER.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(RELIC_HEART.get());
                output.accept(SKY_HEART.get());
                output.accept(SOURCE_HEART.get());
                output.accept(HOMESTEAD_HEART.get());
                output.accept(THE_FURTHER.get());
            })
            .build());

    public Furtherworks(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        TABS.register(modEventBus);
    }
}
