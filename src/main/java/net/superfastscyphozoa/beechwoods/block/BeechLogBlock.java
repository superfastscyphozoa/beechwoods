package net.superfastscyphozoa.beechwoods.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.superfastscyphozoa.beechwoods.block.util.BeechwoodsProperties;

public class BeechLogBlock extends PillarBlock {
    public static final MapCodec<BeechLogBlock> CODEC = createCodec(BeechLogBlock::new);
    public static final BooleanProperty GROUNDED = BeechwoodsProperties.GROUNDED;

    @Override
    public MapCodec<? extends BeechLogBlock> getCodec() {
        return CODEC;
    }

    public BeechLogBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(GROUNDED, Boolean.FALSE));
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        return direction == Direction.DOWN
                ? state.with(GROUNDED, isGrounded(neighborState))
                : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().down());
        return this.getDefaultState().with(GROUNDED, isGrounded(blockState)).with(AXIS, ctx.getSide().getAxis());
    }

    private static boolean isGrounded(BlockState state) {
        return state.isIn(BlockTags.DIRT) || state.isIn(BlockTags.BASE_STONE_OVERWORLD);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(GROUNDED);
    }
}
