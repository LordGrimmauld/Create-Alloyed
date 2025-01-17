package com.molybdenum.alloyed.items;

import com.molybdenum.alloyed.Alloyed;
import com.molybdenum.alloyed.util.ModTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.entry.ItemEntry;
import net.minecraft.item.*;
import net.minecraft.tags.ITag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/*public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Alloyed.MOD_ID);


    // Bronze
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.MAIN_GROUP)));

    public static final RegistryObject<Item> BRONZE_SHEET = ITEMS.register("bronze_sheet",
            () -> new Item(new Item.Properties().tab(ModItemGroup.MAIN_GROUP)));

    // Steel
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.MAIN_GROUP)));

    public static final RegistryObject<Item> STEEL_SHEET = ITEMS.register("steel_sheet",
            () -> new Item(new Item.Properties().tab(ModItemGroup.MAIN_GROUP)));

    // Steel tools
    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ModItemTiers.STEEL, 3, -2.4F, (new Item.Properties())
                    .tab(ModItemGroup.MAIN_GROUP)));

    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModItemTiers.STEEL, 1.5F, -3.0F, (new Item.Properties())
                    .tab(ModItemGroup.MAIN_GROUP)));

    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModItemTiers.STEEL, 1, -2.8F, (new Item.Properties())
                    .tab(ModItemGroup.MAIN_GROUP)));

    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ModItemTiers.STEEL, 5.0F, -3.0F, (new Item.Properties())
                    .tab(ModItemGroup.MAIN_GROUP)));

    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ModItemTiers.STEEL, -3, 0.0F, (new Item.Properties())
                    .tab(ModItemGroup.MAIN_GROUP)));

    public static final RegistryObject<Item> STEEL_SHEARS = ITEMS.register("steel_shears",
            () -> new ShearsItem(new Item.Properties()
                    .durability(476)
                    .tab(ModItemGroup.MAIN_GROUP)));

    public static final RegistryObject<Item> STEEL_FISHING_ROD = ITEMS.register("steel_fishing_rod",
            () -> new FishingRodItem(new Item.Properties()
                    .durability(128)
                    .tab(ModItemGroup.MAIN_GROUP)));



    //public static final RegistryObject<Item> OIL_BUCKET = ITEMS.register("oil_bucket",
    //        () -> new BucketItem(() -> ModFluids.OIL_FLUID.get(), new Item.Properties().maxStackSize(1).group(ModItemGroup.TEST_GROUP)));


    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }


}*/

public class ModItems {
    private static final CreateRegistrate REGISTRATE = Alloyed.getRegistrate().itemGroup(() -> {
        return ModItemGroup.MAIN_GROUP;
    });

    // Item Entries
    public static final ItemEntry<Item> BRONZE_INGOT = taggedIngredient("bronze_ingot", ModTags.Items.BRONZE_INGOT);
    public static final ItemEntry<Item> STEEL_INGOT = taggedIngredient("steel_ingot", ModTags.Items.STEEL_INGOT);

    public static final ItemEntry<Item> BRONZE_SHEET = taggedIngredient("bronze_sheet", ModTags.Items.BRONZE_SHEET);
    public static final ItemEntry<Item> STEEL_SHEET = taggedIngredient("steel_sheet", ModTags.Items.STEEL_SHEET);

    public static final ItemEntry<SwordItem> STEEL_SWORD = REGISTRATE
            .object("steel_sword")
            .item((p) -> new SwordItem(ModItemTiers.STEEL, 3, -2.4F, p))
            .register();

    public static final ItemEntry<PickaxeItem> STEEL_PICKAXE = REGISTRATE
            .object("steel_pickaxe")
            .item((p) -> new PickaxeItem(ModItemTiers.STEEL, 1, -2.8F,p))
            .register();

    public static final ItemEntry<AxeItem> STEEL_AXE = REGISTRATE
            .object("steel_axe")
            .item((p) -> new AxeItem(ModItemTiers.STEEL, 5.0F, -3.0F,p))
            .register();

    public static final ItemEntry<ShovelItem> STEEL_SHOVEL = REGISTRATE
            .object("steel_shovel")
            .item((p) -> new ShovelItem(ModItemTiers.STEEL, 1.5F, -3.0F, p))
            .register();

    public static final ItemEntry<HoeItem> STEEL_HOE = REGISTRATE
            .object("steel_hoe")
            .item((p) -> new HoeItem(ModItemTiers.STEEL, -3, 0.0F, p))
            .register();

    public static final ItemEntry<ShearsItem> STEEL_SHEARS = REGISTRATE
            .object("steel_shears")
            .item((p) -> new ShearsItem(p.durability(476)))
            .register();

    public static final ItemEntry<FishingRodItem> STEEL_FISHING_ROD = REGISTRATE
            .object("steel_fishing_rod")
            .item((p) -> new FishingRodItem(p.durability(128)))
            .register();

    // End Item Entries

    public ModItems() {}

    public static void register() {
        Create.registrate().addToSection(BRONZE_INGOT, AllSections.MATERIALS);
        Create.registrate().addToSection(STEEL_INGOT, AllSections.MATERIALS);

        Create.registrate().addToSection(BRONZE_SHEET, AllSections.MATERIALS);
        Create.registrate().addToSection(STEEL_SHEET, AllSections.MATERIALS);

        Create.registrate().addToSection(STEEL_SWORD, AllSections.CURIOSITIES);
        Create.registrate().addToSection(STEEL_PICKAXE, AllSections.CURIOSITIES);
        Create.registrate().addToSection(STEEL_AXE, AllSections.CURIOSITIES);
        Create.registrate().addToSection(STEEL_SHOVEL, AllSections.CURIOSITIES);
        Create.registrate().addToSection(STEEL_HOE, AllSections.CURIOSITIES);
        Create.registrate().addToSection(STEEL_SHEARS, AllSections.CURIOSITIES);
        Create.registrate().addToSection(STEEL_FISHING_ROD, AllSections.CURIOSITIES);
    }

    // Functions from Create's item registrate. Found them useful, so copied them over.
    private static ItemEntry<Item> ingredient(String name) {
        return REGISTRATE.item(name, Item::new).register();
    }

    @SafeVarargs
    private static ItemEntry<Item> taggedIngredient(String name, ITag.INamedTag<Item>... tags) {
        return REGISTRATE.item(name, Item::new).tag(tags).register();
    }
}
