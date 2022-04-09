package com.cursedcauldron.unvotedandshelved.core.registries;

import com.cursedcauldron.unvotedandshelved.common.blocks.CopperButtonBlock;
import com.cursedcauldron.unvotedandshelved.common.blocks.GlowberryDustBlock;
import com.cursedcauldron.unvotedandshelved.common.blocks.WeatheringCopperButtonBlock;
import com.cursedcauldron.unvotedandshelved.core.UnvotedAndShelved;
import java.util.concurrent.ConcurrentHashMap;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class USBlocks {
    public static void init() {}


    public static final Block GLOWBERRY_DUST = register("glowberry_dust", new GlowberryDustBlock(BlockBehaviour.Properties.of(Material.AIR).strength(-1.0f, 3600000.8f).noDrops().sound(UnvotedAndShelved.GLOW).lightLevel(GlowberryDustBlock.LIGHT_EMISSION)));
    public static final Block COPPER_BUTTON = register("copper_button", new WeatheringCopperButtonBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).noCollission().strength(0.5F).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final Block EXPOSED_COPPER_BUTTON = register("exposed_copper_button", new WeatheringCopperButtonBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).noCollission().strength(0.5F).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final Block WEATHERED_COPPER_BUTTON = register("weathered_copper_button", new WeatheringCopperButtonBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).noCollission().strength(0.5F).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final Block OXIDIZED_COPPER_BUTTON = register("oxidized_copper_button", new WeatheringCopperButtonBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).noCollission().strength(0.5F).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final Block WAXED_COPPER_BUTTON = register("waxed_copper_button", new CopperButtonBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).noCollission().strength(0.5F).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final Block WAXED_EXPOSED_COPPER_BUTTON = register("waxed_exposed_copper_button", new CopperButtonBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).noCollission().strength(0.5F).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final Block WAXED_WEATHERED_COPPER_BUTTON = register("waxed_weathered_copper_button", new CopperButtonBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).noCollission().strength(0.5F).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final Block WAXED_OXIDIZED_COPPER_BUTTON = register("waxed_oxidized_copper_button", new CopperButtonBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).noCollission().strength(0.5F).requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new ResourceLocation(UnvotedAndShelved.MODID, id), block);
    }
}