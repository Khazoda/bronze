package com.seacroak.bronze.block;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;

public class DeepslateTinOre extends Block {
  public DeepslateTinOre() {
    super(Settings.create().strength(3.5f).sounds(BlockSoundGroup.METAL).requiresTool());
  }
}
