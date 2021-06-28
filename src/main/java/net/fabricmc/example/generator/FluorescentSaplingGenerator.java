package net.fabricmc.example.generator;

import java.util.Random;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.example.ExampleMod;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class FluorescentSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return ExampleMod.FLUORESCENT_TREE;
    }
}
