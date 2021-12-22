package com.molybdenum.alloyed.blocks.custom;

import com.simibubi.create.foundation.utility.BlockHelper;
import com.simibubi.create.foundation.utility.Iterate;
import com.simibubi.create.foundation.worldgen.OxidizingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.LinkedList;
import java.util.OptionalDouble;
import java.util.Random;

public class BronzeBlock extends OxidizingBlock {
    public static final IntegerProperty OXIDIZATION = IntegerProperty.create("oxidization", 0, 2);
    private float chance;

    public BronzeBlock(Properties properties, float chance) {
        super(properties, chance);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return super.isRandomlyTicking(state) || (Integer)state.getValue(OXIDIZATION) < 2;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (worldIn.getRandom().nextFloat() <= this.chance) {
            int currentState = (Integer)state.getValue(OXIDIZATION);
            boolean canIncrease = false;
            LinkedList<Integer> neighbors = new LinkedList();
            Direction[] var8 = Iterate.directions;
            int var9 = var8.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                Direction facing = var8[var10];
                BlockPos neighbourPos = pos.relative(facing);
                if (worldIn.isAreaLoaded(neighbourPos, 0) && worldIn.isLoaded(neighbourPos)) {
                    BlockState neighborState = worldIn.getBlockState(neighbourPos);
                    if (neighborState.hasProperty(OXIDIZATION) && (Integer)neighborState.getValue(OXIDIZATION) != 0) {
                        neighbors.add(neighborState.getValue(OXIDIZATION));
                    }

                    if (!BlockHelper.hasBlockSolidSide(neighborState, worldIn, neighbourPos, facing.getOpposite())) {
                        canIncrease = true;
                    }
                }
            }

            if (canIncrease) {
                OptionalDouble average = neighbors.stream().mapToInt((v) -> {
                    return v;
                }).average();
                if (average.orElse(2.0D) >= (double)currentState) {
                    worldIn.setBlockAndUpdate(pos, (BlockState)state.setValue(OXIDIZATION, Math.min(currentState + 1, 2)));
                }
            }
        }
    }


}
