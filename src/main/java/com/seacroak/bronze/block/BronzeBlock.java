package com.seacroak.bronze.block;

import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;

public class BronzeBlock extends Block {
  public BronzeBlock() {
    super(Settings.create().strength(3.5f).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sounds(BlockSoundGroup.METAL).requiresTool());
  }
}
