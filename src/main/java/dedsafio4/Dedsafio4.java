package dedsafio4;

import dedsafio4.entity.NautilusOseoEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dedsafio4 implements ModInitializer {
	public static final String ID = "dedsafio4";

	/** Mods propios: sus items entran al catalogo "Dedsafio". El orden es la prioridad cuando un item esta repetido. */
	public static final List<String> NAMESPACES = List.of(
			ID, "ruleta", "ruleta_anim", "ghostitem", "ghostsafio", "sacos", "silla");

	/** Una pestaña de un mod se esconde (y sus items pasan a "Dedsafio"). Solo quedan las de Minecraft y la nuestra. */
	public static boolean esPestanaOculta(String namespace) {
		return !namespace.equals("minecraft") && !namespace.equals(ID);
	}

	/** Items que NO aparecen en el catalogo (totems y la nave duplicada). */
	private static boolean excluido(Identifier id) {
		String p = id.getPath();
		if (p.contains("totem")) return true;
		return id.getNamespace().equals("ruleta") && p.equals("nave_espacial");
	}

	public static Item ANTIDOTO, FRUTA_ESPACIO, FRUTO_QUIU, GIGANTOFRUTA, PASTILLA_VACIA,
			SANGRE_REPTISAURIO, CARNE_GLEBANOIDE, CEREBRO_GLEBA, COSTILLA, CUERO, ESPADA_GLEBA,
			NAUTILUS_OSEO_HUEVO;
	public static Block PELOS_DE_GLEBA, GARRA_GLEBA;
	public static EntityType<NautilusOseoEntity> NAUTILUS_OSEO;

	private static Item reg(String id, Item item) {
		return Registry.register(Registries.ITEM, Identifier.of(ID, id), item);
	}

	private static Block regBloque(String id, Block bloque) {
		Registry.register(Registries.BLOCK, Identifier.of(ID, id), bloque);
		Registry.register(Registries.ITEM, Identifier.of(ID, id), new BlockItem(bloque, new Item.Settings()));
		return bloque;
	}

	private static Item.Settings s() {
		return new Item.Settings();
	}

	@Override
	public void onInitialize() {
		ANTIDOTO = reg("antidoto", new AntidotoItem(s().maxCount(16).food(
				new FoodComponent.Builder().nutrition(0).saturationModifier(0f).alwaysEdible().build())));
		FRUTA_ESPACIO = reg("fruta_espacio", new Item(s().food(
				new FoodComponent.Builder().nutrition(4).saturationModifier(0.4f).alwaysEdible().build())));
		FRUTO_QUIU = reg("fruto_quiu", new Item(s().food(
				new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
		GIGANTOFRUTA = reg("gigantofruta", new Item(s().food(
				new FoodComponent.Builder().nutrition(8).saturationModifier(0.8f).build())));
		CARNE_GLEBANOIDE = reg("carne_glebanoide", new Item(s().food(
				new FoodComponent.Builder().nutrition(5).saturationModifier(0.5f)
						.statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200), 0.3f).build())));
		PASTILLA_VACIA = reg("pastilla_vacia", new Item(s()));
		SANGRE_REPTISAURIO = reg("sangre_reptisaurio", new Item(s()));
		CEREBRO_GLEBA = reg("cerebro_gleba", new Item(s()));
		COSTILLA = reg("costilla", new Item(s()));
		CUERO = reg("cuero", new Item(s()));
		ESPADA_GLEBA = reg("espada_gleba", new SwordItem(ToolMaterials.IRON, s().attributeModifiers(
				SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, -2.4f))));

		// Pelo de Gleba y Garra de Gleba ahora son bloques
		PELOS_DE_GLEBA = regBloque("pelos_de_gleba", new Block(AbstractBlock.Settings.create()
				.mapColor(MapColor.PINK).strength(0.8f).sounds(BlockSoundGroup.WOOL)));
		GARRA_GLEBA = regBloque("garra_gleba", new Block(AbstractBlock.Settings.create()
				.mapColor(MapColor.OFF_WHITE).strength(1.5f, 3.0f).sounds(BlockSoundGroup.BONE)));

		// Nautilus Óseo Pequeño
		NAUTILUS_OSEO = Registry.register(Registries.ENTITY_TYPE, Identifier.of(ID, "nautilus_oseo_pequeno"),
				EntityType.Builder.create(NautilusOseoEntity::new, SpawnGroup.MONSTER)
						.dimensions(0.9f, 0.8f).maxTrackingRange(10).build("nautilus_oseo_pequeno"));
		FabricDefaultAttributeRegistry.register(NAUTILUS_OSEO, NautilusOseoEntity.crearAtributos());
		SpawnRestriction.register(NAUTILUS_OSEO, SpawnLocationTypes.UNRESTRICTED, Heightmap.Type.MOTION_BLOCKING,
				(tipo, mundo, motivo, pos, azar) -> true);
		NAUTILUS_OSEO_HUEVO = reg("nautilus_oseo_pequeno_spawn_egg",
				new SpawnEggItem(NAUTILUS_OSEO, 0xDCCDB0, 0x7A2E3A, s()));

		registrarPestana();
		mejorarGleba();
	}

	private static void registrarPestana() {
		RegistryKey<ItemGroup> clave = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(ID, "dedsafio"));
		Registry.register(Registries.ITEM_GROUP, clave, FabricItemGroup.builder()
				.icon(() -> {
					Item icono = Registries.ITEM.get(Identifier.of("ghostsafio", "manzana_de_ambar"));
					return new ItemStack(icono == Items.AIR ? GIGANTOFRUTA : icono);
				})
				.displayName(Text.translatable("itemGroup.dedsafio4.dedsafio"))
				.entries((contexto, entradas) -> {
					// Nuestros mods primero (en orden de prioridad); despues cualquier otro mod que tenga su propia pestaña
					List<String> espacios = new ArrayList<>(NAMESPACES);
					for (Identifier grupo : Registries.ITEM_GROUP.getIds()) {
						if (esPestanaOculta(grupo.getNamespace()) && !espacios.contains(grupo.getNamespace())) {
							espacios.add(grupo.getNamespace());
						}
					}
					List<Item> normales = new ArrayList<>();
					List<Item> bloques = new ArrayList<>();
					Set<String> vistos = new HashSet<>();
					for (String ns : espacios) {
						List<Identifier> ids = new ArrayList<>();
						for (Identifier id : Registries.ITEM.getIds()) {
							if (id.getNamespace().equals(ns)) ids.add(id);
						}
						ids.sort(null);
						for (Identifier id : ids) {
							if (excluido(id)) continue;
							// repetido entre nuestros mods: se queda el de mayor prioridad
							if (NAMESPACES.contains(ns) && !vistos.add(id.getPath())) continue;
							Item item = Registries.ITEM.get(id);
							if (item == Items.AIR) continue;
							(item instanceof BlockItem ? bloques : normales).add(item);
						}
					}
					for (Item item : normales) entradas.add(item);
					for (Item item : bloques) entradas.add(item); // los bloques van de ultimo
				})
				.build());
	}

	/** Gleba: features que ya existian en los datos de Ghostsafio + el Nautilus Óseo Pequeño. */
	private static void mejorarGleba() {
		RegistryKey<Biome> gleba = RegistryKey.of(RegistryKeys.BIOME, Identifier.of("ghostsafio", "gleba"));
		agregar(gleba, GenerationStep.Feature.UNDERGROUND_ORES, "grasa_ore");
		agregar(gleba, GenerationStep.Feature.VEGETAL_DECORATION, "raices_colgantes");
		agregar(gleba, GenerationStep.Feature.VEGETAL_DECORATION, "cuerdas_colgantes");
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(gleba), SpawnGroup.MONSTER, NAUTILUS_OSEO, 12, 3, 6);
	}

	private static void agregar(RegistryKey<Biome> bioma, GenerationStep.Feature paso, String feature) {
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(bioma), paso,
				RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("ghostsafio", feature)));
	}
}
