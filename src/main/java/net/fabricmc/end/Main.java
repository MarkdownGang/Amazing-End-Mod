package net.fabricmc.end;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.end.blocks.FluorescentSaplingBlock;
import net.fabricmc.end.blocks.FluorescentSaplingFlowerPotBlock;
import net.fabricmc.end.generator.FluorescentSaplingGenerator;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;



//new blocks and items and stuff

public class Main implements ModInitializer {
	public static final Block LIME_STONE = new Block(FabricBlockSettings.of(Material.STONE).strength(0.4F,0.4F).sounds(BlockSoundGroup.NETHERRACK).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	public static final Block COBBLED_LIME_STONE = new Block(FabricBlockSettings.of(Material.STONE).strength(0.9F,0.9F).sounds(BlockSoundGroup.NETHER_GOLD_ORE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	public static final Block SULFUR = new Block(FabricBlockSettings.of(Material.SOIL).strength(0.2F,0.2F).sounds(BlockSoundGroup.SNOW).breakByTool(FabricToolTags.SHOVELS));
	public static final Block FLUORESCENT_LEAVES = new Block(FabricBlockSettings.of(Material.LEAVES).luminance(13).strength(0.2F,0.2F).sounds(BlockSoundGroup.GRASS).breakByTool(FabricToolTags.SHEARS).breakByTool(FabricToolTags.HOES));
	public static final Item SULFUR_DUST = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item FLUORESCENT_APPLE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(FoodComponents.FLUORESCENT_APPLE));
	public static final Block FLUORESCENT_LOG = new Block(FabricBlockSettings.of(Material.WOOD).strength(2F,2F).luminance(13).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES));
	public static final Block POLISHED_LIME_STONE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F,6F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());



	public static final Block FLUORESCENT_SAPLING = new FluorescentSaplingBlock(new FluorescentSaplingGenerator(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
  public static final Block POTTED_FLUORESCENT_SAPLING = new FluorescentSaplingFlowerPotBlock(FLUORESCENT_SAPLING, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque());

	public static final ConfiguredFeature<TreeFeatureConfig, ?> FLUORESCENT_TREE = registerConfiguredFeature("end_fluorescent_tree", Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(FLUORESCENT_LOG.getDefaultState()), new StraightTrunkPlacer(4, 2, 0), new SimpleBlockStateProvider(FLUORESCENT_LEAVES.getDefaultState()), new SimpleBlockStateProvider(FLUORESCENT_SAPLING.getDefaultState()), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));


	@Override
	public void onInitialize() {

		//together

		Registry.register(Registry.BLOCK, new Identifier("end", "lime_stone"), LIME_STONE);
		Registry.register(Registry.ITEM, new Identifier("end", "lime_stone"), new BlockItem(LIME_STONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("end", "cobbled_lime_stone"), COBBLED_LIME_STONE);
		Registry.register(Registry.ITEM, new Identifier("end", "cobbled_lime_stone"), new BlockItem(COBBLED_LIME_STONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("end", "polished_lime_stone"), POLISHED_LIME_STONE);
		Registry.register(Registry.ITEM, new Identifier("end", "polished_lime_stone"), new BlockItem(POLISHED_LIME_STONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		//together

		Registry.register(Registry.BLOCK, new Identifier("end", "sulfur"), SULFUR);
		Registry.register(Registry.ITEM, new Identifier("end", "sulfur"), new BlockItem(SULFUR, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("end", "sulfur_dust"), SULFUR_DUST);

		//together

		Registry.register(Registry.BLOCK, new Identifier("end", "fluorescent_leaves"), FLUORESCENT_LEAVES);
		Registry.register(Registry.ITEM, new Identifier("end", "fluorescent_leaves"), new BlockItem(FLUORESCENT_LEAVES, new Item.Settings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("end", "fluorescent_apple"),FLUORESCENT_APPLE);
		Registry.register(Registry.BLOCK, new Identifier("end", "fluorescent_log"), FLUORESCENT_LOG);
		Registry.register(Registry.ITEM, new Identifier("end", "fluorescent_log"), new BlockItem(FLUORESCENT_LOG, new Item.Settings().group(ItemGroup.DECORATIONS)));

		//together




		BlockRenderLayerMap.INSTANCE.putBlock(FLUORESCENT_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(POTTED_FLUORESCENT_SAPLING, RenderLayer.getCutout());


		Registry.register(Registry.BLOCK, new Identifier("end", "fluorescent_sapling"), FLUORESCENT_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier("end", "potted_fluorescent_sapling"), POTTED_FLUORESCENT_SAPLING);

        Registry.register(Registry.ITEM, new Identifier("end", "fluorescent_sapling"), new BlockItem(FLUORESCENT_SAPLING, new FabricItemSettings().group(ItemGroup.DECORATIONS)));









	}
	private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> registerConfiguredFeature(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, configuredFeature);
}
}
