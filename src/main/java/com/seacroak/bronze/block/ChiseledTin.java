package com.seacroak.bronze.block;

import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;

public class ChiseledTin extends Block {
  public ChiseledTin() {
    super(Settings.create().strength(2.5f).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sounds(BlockSoundGroup.COPPER).requiresTool());  }
}
