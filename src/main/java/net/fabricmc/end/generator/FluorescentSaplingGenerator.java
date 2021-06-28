package net.fabricmc.end.generator;

import java.util.Random;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.end.Main;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class FluorescentSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return Main.FLUORESCENT_TREE;
    }
}
