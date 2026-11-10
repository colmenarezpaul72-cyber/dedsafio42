package dedsafio4.client;

import dedsafio4.entity.NautilusOseoEntity;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

import java.util.ArrayList;
import java.util.List;

/** Modelo generado desde NautilusOseopequeño.bbmodel (Blockbench). */
public class NautilusOseoModel extends EntityModel<NautilusOseoEntity> {
	private static final String[] TENTACULOS = {"tentaculo3", "tentaculo7", "tentaculo8", "tentaculo2", "tentaculo4", "tentaculo5"};

	private final ModelPart raiz;
	private final ModelPart nauti;
	private final float nautiPivotY;
	private final List<ModelPart> tentaculos = new ArrayList<>();
	private final List<Float> tentaculosRoll = new ArrayList<>();

	public NautilusOseoModel(ModelPart raiz) {
		this.raiz = raiz;
		this.nauti = raiz.getChild("nauti");
		this.nautiPivotY = nauti.pivotY;
		for (String nombre : TENTACULOS) {
			ModelPart parte = nauti.getChild(nombre);
			tentaculos.add(parte);
			tentaculosRoll.add(parte.roll);
		}
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData datos = new ModelData();
		ModelPartData raiz = datos.getRoot();
		ModelPartData v_nauti = raiz.addChild("nauti", ModelPartBuilder.create(), ModelTransform.of(0.0F, 14.0F, 10.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		ModelPartData v_body = v_nauti.addChild("body", ModelPartBuilder.create(), ModelTransform.of(0.0F, -15.0F, 10.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		ModelPartData v_espina = v_body.addChild("espina", ModelPartBuilder.create(), ModelTransform.of(0.0F, 25.0F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_espina.addChild("c", ModelPartBuilder.create().uv(2, 2).cuboid(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F), ModelTransform.of(-10.0F, -5.0F, -10.0F, (float) Math.toRadians(90.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_espina.addChild("c_2", ModelPartBuilder.create().uv(2, 2).cuboid(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F), ModelTransform.of(-9.0F, -5.0F, -9.0F, (float) Math.toRadians(90.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_espina.addChild("c_3", ModelPartBuilder.create().uv(2, 2).cuboid(-1.0F, -2.0F, 0.0F, 2.0F, 3.0F, 0.0F), ModelTransform.of(-7.0F, -5.0F, -9.0F, (float) Math.toRadians(90.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		ModelPartData v_espina3 = v_body.addChild("espina3", ModelPartBuilder.create(), ModelTransform.of(7.0F, 20.0F, -11.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-180.0F)));
		v_espina3.addChild("c_4", ModelPartBuilder.create().uv(2, 2).cuboid(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F), ModelTransform.of(-3.0F, 0.0F, 0.0F, (float) Math.toRadians(90.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_espina3.addChild("c_5", ModelPartBuilder.create().uv(2, 2).cuboid(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F), ModelTransform.of(-2.0F, 0.0F, 1.0F, (float) Math.toRadians(90.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_espina3.addChild("c_6", ModelPartBuilder.create().uv(2, 2).cuboid(-1.0F, -2.0F, 0.0F, 2.0F, 3.0F, 0.0F), ModelTransform.of(0.0F, 0.0F, 1.0F, (float) Math.toRadians(90.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		ModelPartData v_espina2 = v_body.addChild("espina2", ModelPartBuilder.create(), ModelTransform.of(-5.0F, 19.0F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(2.5F), (float) Math.toRadians(-90.0F)));
		v_espina2.addChild("c_7", ModelPartBuilder.create().uv(59, 77).cuboid(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F), ModelTransform.of(-10.0F, -5.0F, -10.0F, (float) Math.toRadians(90.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_espina2.addChild("c_8", ModelPartBuilder.create().uv(59, 77).cuboid(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F), ModelTransform.of(-9.0F, -5.0F, -9.0F, (float) Math.toRadians(90.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_espina2.addChild("c_9", ModelPartBuilder.create().uv(59, 77).cuboid(-1.0F, -2.0F, 0.0F, 2.0F, 3.0F, 0.0F), ModelTransform.of(-7.0F, -5.0F, -9.0F, (float) Math.toRadians(90.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_body.addChild("c_10", ModelPartBuilder.create().uv(0, 33).cuboid(-6.0F, -11.0F, -6.0F, 12.0F, 12.0F, 7.0F), ModelTransform.of(0.0F, 24.0F, -8.0F, (float) Math.toRadians(2.5F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_body.addChild("c_11", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -10.0F, -7.0F, 10.0F, 10.0F, 15.0F), ModelTransform.of(0.0F, 24.0F, -4.0F, (float) Math.toRadians(-2.5F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_body.addChild("c_12", ModelPartBuilder.create().uv(81, 44).cuboid(-4.0F, -8.0F, -7.0F, 8.0F, 7.0F, 9.0F), ModelTransform.of(0.0F, 23.0F, 7.0F, (float) Math.toRadians(7.5F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		ModelPartData v_group7 = v_body.addChild("group7", ModelPartBuilder.create(), ModelTransform.of(-3.0F, 35.0F, -3.0F, (float) Math.toRadians(-2.5F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group7.addChild("c_13", ModelPartBuilder.create().uv(105, 31).cuboid(-1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(4.0F, -21.0F, 4.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group7.addChild("c_14", ModelPartBuilder.create().uv(103, 29).cuboid(-1.0F, -1.0F, -3.0F, 0.0F, 1.0F, 4.0F), ModelTransform.of(4.0F, -21.0F, 0.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group7.addChild("c_15", ModelPartBuilder.create().uv(104, 30).cuboid(-1.0F, -1.0F, -3.0F, 0.0F, 1.0F, 3.0F), ModelTransform.of(4.0F, -22.0F, 0.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group7.addChild("c_16", ModelPartBuilder.create().uv(105, 31).cuboid(-1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(4.0F, -22.0F, 3.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group7.addChild("c_17", ModelPartBuilder.create().uv(104, 30).cuboid(-1.0F, -1.0F, -2.0F, 0.0F, 1.0F, 3.0F), ModelTransform.of(4.0F, -23.0F, -2.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		ModelPartData v_group10 = v_body.addChild("group10", ModelPartBuilder.create(), ModelTransform.of(-16.0F, 18.0F, -2.0F, (float) Math.toRadians(-0.288F), (float) Math.toRadians(-1.9296F), (float) Math.toRadians(-86.9831F)));
		v_group10.addChild("c_18", ModelPartBuilder.create().uv(79, 15).cuboid(-1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(4.0F, -21.0F, 4.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group10.addChild("c_19", ModelPartBuilder.create().uv(77, 13).cuboid(-1.0F, -1.0F, -3.0F, 0.0F, 1.0F, 4.0F), ModelTransform.of(4.0F, -21.0F, 0.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group10.addChild("c_20", ModelPartBuilder.create().uv(78, 14).cuboid(-1.0F, -1.0F, -3.0F, 0.0F, 1.0F, 3.0F), ModelTransform.of(4.0F, -22.0F, 0.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group10.addChild("c_21", ModelPartBuilder.create().uv(79, 15).cuboid(-1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(4.0F, -22.0F, 3.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group10.addChild("c_22", ModelPartBuilder.create().uv(78, 14).cuboid(-1.0F, -1.0F, -2.0F, 0.0F, 1.0F, 3.0F), ModelTransform.of(4.0F, -23.0F, -2.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		ModelPartData v_group11 = v_body.addChild("group11", ModelPartBuilder.create(), ModelTransform.of(16.0F, 24.0F, -2.0F, (float) Math.toRadians(-0.7241F), (float) Math.toRadians(3.5394F), (float) Math.toRadians(86.5773F)));
		v_group11.addChild("c_23", ModelPartBuilder.create().uv(78, 3).cuboid(-1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(4.0F, -21.0F, 4.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group11.addChild("c_24", ModelPartBuilder.create().uv(76, 1).cuboid(-1.0F, -1.0F, -3.0F, 0.0F, 1.0F, 4.0F), ModelTransform.of(4.0F, -21.0F, 0.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group11.addChild("c_25", ModelPartBuilder.create().uv(77, 2).cuboid(-1.0F, -1.0F, -3.0F, 0.0F, 1.0F, 3.0F), ModelTransform.of(4.0F, -22.0F, 0.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group11.addChild("c_26", ModelPartBuilder.create().uv(78, 3).cuboid(-1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(4.0F, -22.0F, 3.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group11.addChild("c_27", ModelPartBuilder.create().uv(77, 2).cuboid(-1.0F, -1.0F, -2.0F, 0.0F, 1.0F, 3.0F), ModelTransform.of(4.0F, -23.0F, -2.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		ModelPartData v_group6 = v_body.addChild("group6", ModelPartBuilder.create(), ModelTransform.of(-3.0F, 37.0F, 9.0F, (float) Math.toRadians(2.5F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group6.addChild("c_28", ModelPartBuilder.create().uv(42, 75).cuboid(-1.0F, -1.0F, -3.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(4.0F, -22.0F, 0.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group6.addChild("c_29", ModelPartBuilder.create().uv(42, 75).cuboid(-1.0F, -1.0F, -2.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(4.0F, -23.0F, -2.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		ModelPartData v_group9 = v_body.addChild("group9", ModelPartBuilder.create(), ModelTransform.of(-4.0F, 23.0F, -12.0F, (float) Math.toRadians(-80.4159F), (float) Math.toRadians(-2.1848F), (float) Math.toRadians(-0.552F)));
		v_group9.addChild("c_30", ModelPartBuilder.create().uv(27, 76).cuboid(-1.0F, -1.0F, -3.0F, 0.0F, 1.0F, 4.0F), ModelTransform.of(4.0F, -21.0F, 0.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group9.addChild("c_31", ModelPartBuilder.create().uv(28, 77).cuboid(-1.0F, -1.0F, -3.0F, 0.0F, 1.0F, 3.0F), ModelTransform.of(4.0F, -22.0F, 0.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group9.addChild("c_32", ModelPartBuilder.create().uv(28, 77).cuboid(-1.0F, -1.0F, -2.0F, 0.0F, 1.0F, 3.0F), ModelTransform.of(4.0F, -23.0F, -2.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		ModelPartData v_tentaculo3 = v_nauti.addChild("tentaculo3", ModelPartBuilder.create(), ModelTransform.of(2.4F, 0.0F, -4.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_tentaculo3.addChild("c_33", ModelPartBuilder.create().uv(49, -1).cuboid(-1.0F, -3.0F, -6.0F, 3.0F, 3.0F, 8.0F), ModelTransform.of(-1.0F, 1.5F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		ModelPartData v_group = v_tentaculo3.addChild("group", ModelPartBuilder.create(), ModelTransform.of(-1.0F, -0.5F, -7.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group.addChild("c_34", ModelPartBuilder.create().uv(48, 63).cuboid(0.5F, -3.5F, 1.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(0.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group.addChild("c_35", ModelPartBuilder.create().uv(4, 62).cuboid(0.5F, -5.5F, -1.0F, 0.0F, 3.0F, 2.0F), ModelTransform.of(0.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group.addChild("c_36", ModelPartBuilder.create().uv(28, 52).cuboid(0.5F, -6.5F, 0.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(0.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group.addChild("c_37", ModelPartBuilder.create().uv(50, 63).cuboid(0.5F, -7.5F, 1.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(0.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group.addChild("c_38", ModelPartBuilder.create().uv(64, 62).cuboid(0.5F, -2.5F, 0.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(0.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group.addChild("c_39", ModelPartBuilder.create().uv(60, 62).cuboid(0.5F, -2.5F, -1.0F, 0.0F, 2.0F, 2.0F), ModelTransform.of(0.0F, 2.0F, -7.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group.addChild("c_40", ModelPartBuilder.create().uv(53, 45).cuboid(-0.5F, -2.5F, -5.0F, 2.0F, 2.0F, 7.0F), ModelTransform.of(0.0F, 2.0F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		ModelPartData v_tentaculo7 = v_nauti.addChild("tentaculo7", ModelPartBuilder.create(), ModelTransform.of(-2.4F, 0.1F, -4.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(35.0F)));
		v_tentaculo7.addChild("c_41", ModelPartBuilder.create().uv(49, -1).cuboid(-1.0F, -3.0F, -6.0F, 3.0F, 3.0F, 8.0F), ModelTransform.of(-1.0F, 1.5F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		ModelPartData v_group8 = v_tentaculo7.addChild("group8", ModelPartBuilder.create(), ModelTransform.of(0.0F, -0.5F, -7.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group8.addChild("c_42", ModelPartBuilder.create().uv(48, 63).cuboid(0.5F, -3.5F, 1.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group8.addChild("c_43", ModelPartBuilder.create().uv(4, 62).cuboid(0.5F, -5.5F, -1.0F, 0.0F, 3.0F, 2.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group8.addChild("c_44", ModelPartBuilder.create().uv(28, 52).cuboid(0.5F, -6.5F, 0.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group8.addChild("c_45", ModelPartBuilder.create().uv(50, 63).cuboid(0.5F, -7.5F, 1.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group8.addChild("c_46", ModelPartBuilder.create().uv(64, 62).cuboid(0.5F, -2.5F, 0.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group8.addChild("c_47", ModelPartBuilder.create().uv(60, 62).cuboid(0.5F, -2.5F, -1.0F, 0.0F, 2.0F, 2.0F), ModelTransform.of(-1.0F, 2.0F, -7.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group8.addChild("c_48", ModelPartBuilder.create().uv(53, 45).cuboid(-0.5F, -2.5F, -5.0F, 2.0F, 2.0F, 7.0F), ModelTransform.of(-1.0F, 2.0F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		ModelPartData v_tentaculo8 = v_nauti.addChild("tentaculo8", ModelPartBuilder.create(), ModelTransform.of(-3.9F, 4.0F, -4.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(105.0F)));
		v_tentaculo8.addChild("c_49", ModelPartBuilder.create().uv(49, -1).cuboid(-1.0F, -3.0F, -6.0F, 3.0F, 3.0F, 8.0F), ModelTransform.of(-1.0F, 1.5F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		ModelPartData v_group2 = v_tentaculo8.addChild("group2", ModelPartBuilder.create(), ModelTransform.of(0.0F, -0.5F, -7.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group2.addChild("c_50", ModelPartBuilder.create().uv(48, 63).cuboid(0.5F, -3.5F, 1.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group2.addChild("c_51", ModelPartBuilder.create().uv(4, 62).cuboid(0.5F, -5.5F, -1.0F, 0.0F, 3.0F, 2.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group2.addChild("c_52", ModelPartBuilder.create().uv(28, 52).cuboid(0.5F, -6.5F, 0.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group2.addChild("c_53", ModelPartBuilder.create().uv(50, 63).cuboid(0.5F, -7.5F, 1.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group2.addChild("c_54", ModelPartBuilder.create().uv(64, 62).cuboid(0.5F, -2.5F, 0.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group2.addChild("c_55", ModelPartBuilder.create().uv(60, 62).cuboid(0.5F, -2.5F, -1.0F, 0.0F, 2.0F, 2.0F), ModelTransform.of(-1.0F, 2.0F, -7.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group2.addChild("c_56", ModelPartBuilder.create().uv(52, 44).cuboid(-0.5F, -2.5F, -5.0F, 2.0F, 2.0F, 8.0F), ModelTransform.of(-1.0F, 2.0F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		ModelPartData v_tentaculo2 = v_nauti.addChild("tentaculo2", ModelPartBuilder.create(), ModelTransform.of(4.1F, 4.0F, -4.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-75.0F)));
		v_tentaculo2.addChild("c_57", ModelPartBuilder.create().uv(49, -1).cuboid(-1.0F, -3.0F, -6.0F, 3.0F, 3.0F, 8.0F), ModelTransform.of(-1.0F, 1.5F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		ModelPartData v_group3 = v_tentaculo2.addChild("group3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.5F, -7.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group3.addChild("c_58", ModelPartBuilder.create().uv(48, 63).cuboid(0.5F, -3.5F, 1.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 1.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group3.addChild("c_59", ModelPartBuilder.create().uv(4, 62).cuboid(0.5F, -5.5F, -1.0F, 0.0F, 3.0F, 2.0F), ModelTransform.of(-1.0F, 1.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group3.addChild("c_60", ModelPartBuilder.create().uv(28, 52).cuboid(0.5F, -6.5F, 0.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(-1.0F, 1.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group3.addChild("c_61", ModelPartBuilder.create().uv(50, 63).cuboid(0.5F, -7.5F, 1.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 1.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group3.addChild("c_62", ModelPartBuilder.create().uv(64, 62).cuboid(0.5F, -2.5F, 0.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 1.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group3.addChild("c_63", ModelPartBuilder.create().uv(60, 62).cuboid(0.5F, -2.5F, -1.0F, 0.0F, 2.0F, 2.0F), ModelTransform.of(-1.0F, 1.0F, -7.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group3.addChild("c_64", ModelPartBuilder.create().uv(53, 45).cuboid(-0.5F, -2.5F, -5.0F, 2.0F, 2.0F, 7.0F), ModelTransform.of(-1.0F, 1.0F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		ModelPartData v_tentaculo4 = v_nauti.addChild("tentaculo4", ModelPartBuilder.create(), ModelTransform.of(2.0F, 7.8F, -4.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-125.0F)));
		v_tentaculo4.addChild("c_65", ModelPartBuilder.create().uv(49, -1).cuboid(-1.0F, -3.0F, -6.0F, 3.0F, 3.0F, 8.0F), ModelTransform.of(-1.0F, 1.5F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		ModelPartData v_group4 = v_tentaculo4.addChild("group4", ModelPartBuilder.create(), ModelTransform.of(0.0F, -0.5F, -7.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group4.addChild("c_66", ModelPartBuilder.create().uv(48, 63).cuboid(0.5F, -3.5F, 1.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group4.addChild("c_67", ModelPartBuilder.create().uv(4, 62).cuboid(0.5F, -5.5F, -1.0F, 0.0F, 3.0F, 2.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group4.addChild("c_68", ModelPartBuilder.create().uv(28, 52).cuboid(0.5F, -6.5F, 0.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group4.addChild("c_69", ModelPartBuilder.create().uv(50, 63).cuboid(0.5F, -7.5F, 1.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group4.addChild("c_70", ModelPartBuilder.create().uv(64, 62).cuboid(0.5F, -2.5F, 0.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 2.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group4.addChild("c_71", ModelPartBuilder.create().uv(60, 62).cuboid(0.5F, -2.5F, -1.0F, 0.0F, 2.0F, 2.0F), ModelTransform.of(-1.0F, 2.0F, -7.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group4.addChild("c_72", ModelPartBuilder.create().uv(53, 45).cuboid(-0.5F, -2.5F, -5.0F, 2.0F, 2.0F, 7.0F), ModelTransform.of(-1.0F, 2.0F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		ModelPartData v_tentaculo5 = v_nauti.addChild("tentaculo5", ModelPartBuilder.create(), ModelTransform.of(-2.4F, 7.9F, -4.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(172.5F)));
		v_tentaculo5.addChild("c_73", ModelPartBuilder.create().uv(49, -1).cuboid(-1.0F, -3.0F, -6.0F, 3.0F, 3.0F, 8.0F), ModelTransform.of(-1.0F, 1.5F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		ModelPartData v_group5 = v_tentaculo5.addChild("group5", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.5F, -7.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F)));
		v_group5.addChild("c_74", ModelPartBuilder.create().uv(48, 63).cuboid(0.5F, -3.5F, 1.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 1.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group5.addChild("c_75", ModelPartBuilder.create().uv(4, 62).cuboid(0.5F, -5.5F, -1.0F, 0.0F, 3.0F, 2.0F), ModelTransform.of(-1.0F, 1.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group5.addChild("c_76", ModelPartBuilder.create().uv(28, 52).cuboid(0.5F, -6.5F, 0.0F, 0.0F, 1.0F, 2.0F), ModelTransform.of(-1.0F, 1.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group5.addChild("c_77", ModelPartBuilder.create().uv(50, 63).cuboid(0.5F, -7.5F, 1.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 1.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group5.addChild("c_78", ModelPartBuilder.create().uv(64, 62).cuboid(0.5F, -2.5F, 0.0F, 0.0F, 1.0F, 1.0F), ModelTransform.of(-1.0F, 1.0F, -9.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group5.addChild("c_79", ModelPartBuilder.create().uv(60, 62).cuboid(0.5F, -2.5F, -1.0F, 0.0F, 2.0F, 2.0F), ModelTransform.of(-1.0F, 1.0F, -7.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		v_group5.addChild("c_80", ModelPartBuilder.create().uv(52, 44).cuboid(-0.5F, -2.5F, -5.0F, 2.0F, 2.0F, 8.0F), ModelTransform.of(-1.0F, 1.0F, -1.0F, (float) Math.toRadians(0.0F), (float) Math.toRadians(0.0F), (float) Math.toRadians(-15.0F)));
		return TexturedModelData.of(datos, 128, 128);
	}

	@Override
	public void setAngles(NautilusOseoEntity entidad, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		nauti.pivotY = nautiPivotY + MathHelper.sin(animationProgress * 0.12F) * 1.6F;
		for (int i = 0; i < tentaculos.size(); i++) {
			tentaculos.get(i).roll = tentaculosRoll.get(i) + MathHelper.sin(animationProgress * 0.25F + i * 1.1F) * 0.18F;
		}
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		raiz.render(matrices, vertices, light, overlay, color);
	}
}
