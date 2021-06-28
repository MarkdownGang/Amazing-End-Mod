package net.fabricmc.example.blocks;


import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;


public class FluorescentSaplingBlock extends SaplingBlock {
    public FluorescentSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.END_STONE);
    }
}
