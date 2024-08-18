package com.seacroak.bronze.datagen.advancements;

import com.seacroak.bronze.registry.MainRegistry;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;

import java.util.function.Consumer;

import static com.seacroak.bronze.util.GenericUtils.ID;

public class BronzeAdvancements implements Consumer<Consumer<Advancement>> {
  @Override
  public void accept(Consumer<Advancement> advancementConsumer) {

    Advancement gotTinIngotAdvancement = Advancement.Builder.create()
        //                .parent(new Identifier("story/upgrade_tools"))
        .display(
            MainRegistry.TIN_INGOT,
            Text.translatable("advancement.bronze.got_tin_ingot.title"),
            Text.translatable("advancement.bronze.got_tin_ingot.description"),
            null,
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            true, // Show toast top right
            true, // Announce to chat
            false // Hidden in the advancement tab
        )
        // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
        .criterion("got_tin_ingot", InventoryChangedCriterion.Conditions.items(MainRegistry.TIN_INGOT))
        .rewards(AdvancementRewards.Builder.recipe(ID("tin_block")))
        .build(advancementConsumer, "bronze" + "/got_tin_ingot");


    Advancement gotBronzeBlendAdvancement = Advancement.Builder.create()
        //                .parent(new Identifier("story/upgrade_tools"))
        .display(
            MainRegistry.BRONZE_BLEND,
            Text.translatable("advancement.bronze.got_bronze_blend.title"),
            Text.translatable("advancement.bronze.got_bronze_blend.description"),
            null,
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            true, // Show toast top right
            false, // Announce to chat
            false // Hidden in the advancement tab
        )
        // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
        .criterion("got_bronze_blend", InventoryChangedCriterion.Conditions.items(MainRegistry.BRONZE_BLEND))
        .rewards(AdvancementRewards.Builder.recipe(ID("bronze_ingot_from_smelting_bronze_blend"))
            .addRecipe(ID("bronze_ingot_from_blasting_bronze_blend"))
            .addRecipe(ID("bronze_blend_block")))
        .build(advancementConsumer, "bronze" + "/got_bronze_blend");

    Advancement gotBronzeIngotAdvancement = Advancement.Builder.create()
        .parent(gotBronzeBlendAdvancement)
        .display(
            MainRegistry.BRONZE_INGOT,
            Text.translatable("advancement.bronze.got_bronze_ingot.title"),
            Text.translatable("advancement.bronze.got_bronze_ingot.description"),
            null,
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            true, // Show toast top right
            true, // Announce to chat
            false // Hidden in the advancement tab
        )
        // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
        .criterion("got_bronze_ingot", InventoryChangedCriterion.Conditions.items(MainRegistry.BRONZE_INGOT))
        .rewards(AdvancementRewards.Builder
            .recipe(ID("bronze_helmet"))
            .addRecipe(ID("bronze_chestplate"))
            .addRecipe(ID("bronze_leggings"))
            .addRecipe(ID("bronze_boots"))
            .addRecipe(ID("bronze_sword"))
            .addRecipe(ID("bronze_pickaxe"))
            .addRecipe(ID("bronze_shovel"))
            .addRecipe(ID("bronze_axe"))
            .addRecipe(ID("bronze_hoe"))
            .addRecipe(ID("bronze_sickle"))
            .addRecipe(ID("bronze_nugget"))
            .addRecipe(ID("bronze_nugget_from_smelting"))
            .addRecipe(ID("bronze_nugget_from_blasting"))
            .addRecipe(ID("bronze_door"))
            .addRecipe(ID("bronze_trapdoor"))
            .addRecipe(ID("bronze_block"))
        )
        .build(advancementConsumer, "bronze" + "/got_bronze_ingot");

    Advancement gotBronzeChestplateAdvancement = Advancement.Builder.create()
        .parent(gotBronzeIngotAdvancement)
        .display(
            MainRegistry.BRONZE_CHESTPLATE,
            Text.translatable("advancement.bronze.got_bronze_chestplate.title"),
            Text.translatable("advancement.bronze.got_bronze_chestplate.description"),
            null,
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            true, // Show toast top right
            true, // Announce to chat
            false // Hidden in the advancement tab
        )
        // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
        .criterion("got_bronze_helmet", InventoryChangedCriterion.Conditions.items(MainRegistry.BRONZE_HELMET))
        .criterion("got_bronze_chestplate", InventoryChangedCriterion.Conditions.items(MainRegistry.BRONZE_CHESTPLATE))
        .criterion("got_bronze_leggings", InventoryChangedCriterion.Conditions.items(MainRegistry.BRONZE_LEGGINGS))
        .criterion("got_bronze_boots", InventoryChangedCriterion.Conditions.items(MainRegistry.BRONZE_BOOTS))
        .build(advancementConsumer, "bronze" + "/got_bronze_chestplate");

    Advancement gotSickleAdvancement = Advancement.Builder.create()
        .parent(gotBronzeIngotAdvancement)
        .display(
            MainRegistry.SICKLE,
            Text.translatable("advancement.bronze.got_sickle.title"),
            Text.translatable("advancement.bronze.got_sickle.description"),
            null,
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            true, // Show toast top right
            true, // Announce to chat
            false // Hidden in the advancement tab
        )
        // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
        .criterion("got_sickle", InventoryChangedCriterion.Conditions.items(MainRegistry.SICKLE))
        .build(advancementConsumer, "bronze" + "/got_sickle");

    Advancement gotBronzePickaxeAdvancement = Advancement.Builder.create()
        .parent(gotBronzeIngotAdvancement)
        .display(
            MainRegistry.BRONZE_PICKAXE,
            Text.translatable("advancement.bronze.got_bronze_pickaxe.title"),
            Text.translatable("advancement.bronze.got_bronze_pickaxe.description"),
            null,
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            true, // Show toast top right
            true, // Announce to chat
            false // Hidden in the advancement tab
        )
        // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
        .criterion("got_bronze_pickaxe", InventoryChangedCriterion.Conditions.items(MainRegistry.BRONZE_PICKAXE))
        .build(advancementConsumer, "bronze" + "/got_bronze_pickaxe");

    /* AdvancementEntries from here are specifically only for recipe unlocks in Minecraft's recipe book */

    Advancement unlockBronzeBlendFromRawTin = Advancement.Builder.create()
//                .parent(new Identifier("recipes/root"))
        .display(
            MainRegistry.BRONZE_BLEND,
            Text.literal("recipe unlock"),
            Text.literal("recipe unlock"),
            null,
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            false, // Show toast top right
            false, // Announce to chat
            true // Hidden in the advancement tab
        )
        .criterion("got_raw_tin", InventoryChangedCriterion.Conditions.items(MainRegistry.TIN_RAW))
        .rewards(AdvancementRewards.Builder.recipe(ID("bronze_blend_from_copper_and_tin"))
            .addRecipe(ID("raw_tin_block"))
            .addRecipe(ID("tin_ingot"))
            .addRecipe(ID("tin_ingot_from_smelting_deepslate_tin_ore"))
            .addRecipe(ID("tin_ingot_from_smelting_raw_tin"))
            .addRecipe(ID("tin_ingot_from_smelting_tin_ore"))
            .addRecipe(ID("tin_ingot_from_blasting_deepslate_tin_ore"))
            .addRecipe(ID("tin_ingot_from_blasting_raw_tin"))
            .addRecipe(ID("tin_ingot_from_blasting_tin_ore"))
        )
        .build(advancementConsumer, "bronze" + "/got_raw_tin");

    Advancement unlockRawTinFromRawTinBlock = Advancement.Builder.create()
//                .parent(new Identifier("recipes/root"))
        .display(
            MainRegistry.TIN_RAW,
            Text.literal("recipe unlock"),
            Text.literal("recipe unlock"),
            null,
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            false, // Show toast top right
            false, // Announce to chat
            true // Hidden in the advancement tab
        )
        .criterion("got_raw_tin_block", InventoryChangedCriterion.Conditions.items(MainRegistry.TIN_RAW_BLOCK))
        .rewards(AdvancementRewards.Builder.recipe(ID("raw_tin")))
        .build(advancementConsumer, "bronze" + "/got_raw_tin_block");

    Advancement unlockBronzeBlendFromBronzeBlendBlock = Advancement.Builder.create()
//                .parent(new Identifier("recipes/root"))
        .display(
            MainRegistry.BRONZE_BLEND,
            Text.literal("recipe unlock"),
            Text.literal("recipe unlock"),
            null,
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            false, // Show toast top right
            false, // Announce to chat
            true // Hidden in the advancement tab
        )
        .criterion("got_bronze_blend_block", InventoryChangedCriterion.Conditions.items(MainRegistry.BRONZE_BLEND_BLOCK))
        .rewards(AdvancementRewards.Builder.recipe(ID("bronze_blend")))
        .build(advancementConsumer, "bronze" + "/got_bronze_blend_block");

    Advancement unlockBronzeIngotFromBronzeBlock = Advancement.Builder.create()
//                .parent(new Identifier("recipes/root"))
        .display(
            MainRegistry.BRONZE_INGOT,
            Text.literal("recipe unlock"),
            Text.literal("recipe unlock"),
            null,
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            false, // Show toast top right
            false, // Announce to chat
            true // Hidden in the advancement tab
        )
        .criterion("got_bronze_block", InventoryChangedCriterion.Conditions.items(MainRegistry.BRONZE_BLOCK))
        .rewards(AdvancementRewards.Builder.recipe(ID("bronze_ingot")))
        .build(advancementConsumer, "bronze" + "/got_bronze_block");

    Advancement unlockBronzeIngotFromBronzeNugget = Advancement.Builder.create()
//                .parent(new Identifier("recipes/root"))
        .display(
            MainRegistry.BRONZE_INGOT,
            Text.literal("recipe unlock"),
            Text.literal("recipe unlock"),
            null,
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            false, // Show toast top right
            false, // Announce to chat
            true // Hidden in the advancement tab
        )
        .criterion("got_bronze_nuggets", InventoryChangedCriterion.Conditions.items(MainRegistry.BRONZE_NUGGET))
        .rewards(AdvancementRewards.Builder.recipe(ID("bronze_ingot_from_nuggets")))
        .build(advancementConsumer, "bronze" + "/got_bronze_nuggets");
  }
}
