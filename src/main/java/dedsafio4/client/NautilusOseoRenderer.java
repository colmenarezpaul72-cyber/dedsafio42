package dedsafio4.client;

import dedsafio4.Dedsafio4;
import dedsafio4.entity.NautilusOseoEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class NautilusOseoRenderer extends MobEntityRenderer<NautilusOseoEntity, NautilusOseoModel> {
	public static final EntityModelLayer CAPA = new EntityModelLayer(Identifier.of(Dedsafio4.ID, "nautilus_oseo_pequeno"), "main");
	private static final Identifier TEXTURA = Identifier.of(Dedsafio4.ID, "textures/entity/nautilus_oseo_pequeno.png");

	public NautilusOseoRenderer(EntityRendererFactory.Context contexto) {
		super(contexto, new NautilusOseoModel(contexto.getPart(CAPA)), 0.4F);
	}

	@Override
	public Identifier getTexture(NautilusOseoEntity entidad) {
		return TEXTURA;
	}

	@Override
	protected void scale(NautilusOseoEntity entidad, MatrixStack matrices, float cantidad) {
		matrices.scale(0.6F, 0.6F, 0.6F);
	}
}
