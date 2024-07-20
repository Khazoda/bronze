package com.seacroak.bronze.item;

import com.seacroak.bronze.util.GenericUtils;
import net.minecraft.block.*;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class Sickle extends MiningToolItem {

  public static final TagKey<Block> EFFECTIVE_BLOCKS = TagKey.of(RegistryKeys.BLOCK, GenericUtils.ID("mineable/sickle"));

  public Sickle(ToolMaterial toolMaterial, Settings settings) {
    super(toolMaterial, EFFECTIVE_BLOCKS, settings);
  }

  public static ToolComponent createToolComponent() {
    return new ToolComponent(List.of(ToolComponent.Rule.ofAlwaysDropping(List.of(Blocks.COBWEB), 15.0F), ToolComponent.Rule.of(BlockTags.LEAVES, 15.0F), ToolComponent.Rule.of(BlockTags.WOOL, 5.0F), ToolComponent.Rule.of(List.of(Blocks.VINE, Blocks.GLOW_LICHEN), 2.0F)), 1.0F, 1);
  }

  @Override
  public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
    if (state.getBlock() instanceof CropBlock || state.getBlock() instanceof NetherWartBlock) {
      return isMature(state);
    }
    return true;
  }

  @Override
  public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
    stack.damage(1, miner, EquipmentSlot.MAINHAND);
    aoeHarvest(world, state, state, pos, 0);
    return true;
  }

  public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    return true;
  }

  private static void aoeHarvest(World worldIn, BlockState initialBlockState, BlockState currentBlockState, BlockPos pos, int time) {
    if (worldIn.isClient()) return;

    /* True when block mined is a crop*/
    if (initialBlockState.getBlock() instanceof CropBlock || initialBlockState.getBlock() instanceof NetherWartBlock) {
      if (isMature(initialBlockState) && !worldIn.isClient()) {
        worldIn.breakBlock(pos, true);
        if (initialBlockState.getBlock() instanceof BeetrootsBlock) {
          worldIn.setBlockState(pos, initialBlockState.with(Properties.AGE_3, 0));
        } else if (initialBlockState.getBlock() instanceof NetherWartBlock) {
          worldIn.setBlockState(pos, initialBlockState.with(Properties.AGE_3, 0));
        } else if (initialBlockState.getBlock() instanceof CropBlock) {
          worldIn.setBlockState(pos, initialBlockState.with(Properties.AGE_7, 0));
        }

        if (time < 2) {
          aoeHarvest(worldIn, worldIn.getBlockState(pos.east()), worldIn.getBlockState(pos.east()), pos.east(), time + 1);
          aoeHarvest(worldIn, worldIn.getBlockState(pos.north()), worldIn.getBlockState(pos.north()), pos.north(), time + 1);
          aoeHarvest(worldIn, worldIn.getBlockState(pos.west()), worldIn.getBlockState(pos.west()), pos.west(), time + 1);
          aoeHarvest(worldIn, worldIn.getBlockState(pos.south()), worldIn.getBlockState(pos.south()), pos.south(), time + 1);
        }
      }
    }
    /* True when block mined is grass*/
    if (initialBlockState.getBlock() instanceof ShortPlantBlock || initialBlockState.getBlock() instanceof TallPlantBlock) {
      Block currentBlock = currentBlockState.getBlock();
      if (currentBlock instanceof ShortPlantBlock || currentBlock instanceof TallPlantBlock) {
        worldIn.breakBlock(pos, true);
      }
      if (time < 4) {
        aoeHarvest(worldIn, initialBlockState, worldIn.getBlockState(pos.east()), pos.east(), time + 1);
        aoeHarvest(worldIn, initialBlockState, worldIn.getBlockState(pos.north()), pos.north(), time + 1);
        aoeHarvest(worldIn, initialBlockState, worldIn.getBlockState(pos.west()), pos.west(), time + 1);
        aoeHarvest(worldIn, initialBlockState, worldIn.getBlockState(pos.south()), pos.south(), time + 1);
      }

    }
  }

  private static boolean isMature(BlockState state) {
    if (state.getBlock() instanceof CropBlock cropBlock) {
      return cropBlock.isMature(state);
    } else if (state.getBlock() instanceof NetherWartBlock) {
      return state.get(NetherWartBlock.AGE) >= NetherWartBlock.MAX_AGE;
    }
    return false;
  }

}


