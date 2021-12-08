package net.justcopper;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod("jct")
public class JustCopperTools {
    public static final String MODID = "jct";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MODID);

    public static final Tier COPPER_TIER = new ForgeTier(
            1, 131, 12F, 1F, 14,
            BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.COPPER_INGOT)
    );

    public static final RegistryObject<Item>
            COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(COPPER_TIER, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))),
            COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(COPPER_TIER, 1.5F, -3F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS))),
            COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(COPPER_TIER, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS))),
            COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(COPPER_TIER, 6F, -3.1F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS))),
            COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(COPPER_TIER, -2, -1F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<RecipeSerializer<?>> REPAIR_COPPER_ITEM_SERIALIZER =
            RECIPE_SERIALIZERS.register("repair_copper_item", () -> new SimpleRecipeSerializer<>(RecipeCopperItemRecipe::new));

    public JustCopperTools() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        RECIPE_SERIALIZERS.register(bus);
    }
}
