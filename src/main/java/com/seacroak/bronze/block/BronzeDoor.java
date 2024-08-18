package com.seacroak.bronze.block;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

public class BronzeDoor extends DoorBlock {
  public BronzeDoor() {
    super(Settings.create().strength(5.5f).nonOpaque().instrument(Instrument.IRON_XYLOPHONE).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.GOLD).sounds(BlockSoundGroup.METAL).requiresTool(), BlockSetType.IRON);
  }
}
