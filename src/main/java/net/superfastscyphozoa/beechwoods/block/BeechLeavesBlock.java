package net.superfastscyphozoa.beechwoods.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.CherryLeavesBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.superfastscyphozoa.beechwoods.registry.RegisterParticles;

public class BeechLeavesBlock extends LeavesBlock {
    public static final MapCodec<CherryLeavesBlock> CODEC = createCodec(CherryLeavesBlock::new);

    @Override
    public MapCodec<CherryLeavesBlock> getCodec() {
        return CODEC;
    }

    public BeechLeavesBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        if (random.nextInt(10) == 0) {
            BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            if (!isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
                ParticleUtil.spawnParticle(world, pos, random, RegisterParticles.BEECH_LEAVES);
            }
        }
    }
}
