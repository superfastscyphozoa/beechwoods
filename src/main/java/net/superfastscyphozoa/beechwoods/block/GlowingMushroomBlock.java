package net.superfastscyphozoa.beechwoods.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.superfastscyphozoa.beechwoods.block.util.BeechwoodsProperties;

public class GlowingMushroomBlock extends PlantBlock implements Fertilizable {
    public static final MapCodec<GlowingMushroomBlock> CODEC = createCodec(GlowingMushroomBlock::new);
    public static final BooleanProperty GLOWING = BeechwoodsProperties.GLOWING;

    @Override
    protected MapCodec<GlowingMushroomBlock> getCodec() {
        return CODEC;
    }

    public GlowingMushroomBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(GLOWING, Boolean.FALSE));
    }

    //can place

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isIn(BlockTags.MUSHROOM_GROW_BLOCK) || world.getBaseLightLevel(pos, 0) < 13 && this.canPlantOnTop(blockState, world, blockPos);
    }

    //bonemeal

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockPos blockPos2 = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);

        for (int k = 0; k < 4; k++) {
            if (world.isAir(blockPos2) && state.canPlaceAt(world, blockPos2)) {
                pos = blockPos2;
            }

            blockPos2 = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
        }

        if (world.isAir(blockPos2) && state.canPlaceAt(world, blockPos2)) {
            world.setBlockState(blockPos2, state, Block.NOTIFY_LISTENERS);
        }
    }

    //build blockstates

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(GLOWING);
    }
}
