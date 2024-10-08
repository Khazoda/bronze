package com.seacroak.bronze.block;

import net.minecraft.block.Blocks;
import net.minecraft.block.TransparentBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;

public class TinFramedGlass extends TransparentBlock {
  public TinFramedGlass() {
    super(Settings.create()
        .instrument(NoteBlockInstrument.HAT)
        .strength(0.7F)
        .sounds(BlockSoundGroup.GLASS)
        .nonOpaque()
        .allowsSpawning(Blocks::never)
        .solidBlock(Blocks::never)
        .suffocates(Blocks::never)
        .blockVision(Blocks::never));
  }
}
