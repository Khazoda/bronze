package com.seacroak.bronze.block;

import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;

public class TinTiles extends Block {
  public TinTiles() {
    super(Settings.create().strength(2.5F, 6.0F).mapColor(MapColor.WHITE).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sounds(BlockSoundGroup.COPPER).requiresTool());  }
}
