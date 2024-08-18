package com.seacroak.bronze.block;

import net.minecraft.block.Block;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

public class TinBlock extends Block {
  public TinBlock() {
    super(Settings.create().strength(2.5f).instrument(Instrument.IRON_XYLOPHONE).sounds(BlockSoundGroup.COPPER).requiresTool());
  }
}
