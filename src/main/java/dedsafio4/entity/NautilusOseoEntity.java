package dedsafio4.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.FlyGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Nautilus Óseo Pequeño: criatura voladora de Gleba. Ataca si te acercas, aplica Levitación
 * y NO se puede empujar (ni con el cuerpo ni con golpes). Muy peligrosa en grupo.
 */
public class NautilusOseoEntity extends HostileEntity {
	public NautilusOseoEntity(EntityType<? extends HostileEntity> tipo, World mundo) {
		super(tipo, mundo);
		this.moveControl = new FlightMoveControl(this, 20, true);
		this.setNoGravity(true);
	}

	public static DefaultAttributeContainer.Builder crearAtributos() {
		return HostileEntity.createHostileAttributes()
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
				.add(EntityAttributes.GENERIC_FLYING_SPEED, 0.5)
				.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 14.0)
				.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(1, new MeleeAttackGoal(this, 1.3, true));
		this.goalSelector.add(5, new FlyGoal(this, 1.0));
		this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.add(7, new LookAroundGoal(this));
		this.targetSelector.add(1, new RevengeGoal(this));
		this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
	}

	@Override
	protected EntityNavigation createNavigation(World mundo) {
		BirdNavigation navegacion = new BirdNavigation(this, mundo);
		navegacion.setCanPathThroughDoors(false);
		navegacion.setCanSwim(true);
		navegacion.setCanEnterOpenDoors(true);
		return navegacion;
	}

	@Override
	public boolean tryAttack(Entity objetivo) {
		boolean golpeo = super.tryAttack(objetivo);
		if (golpeo && objetivo instanceof LivingEntity vivo) {
			vivo.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 60, 0));
		}
		return golpeo;
	}

	// --- No se puede empujar ---
	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void pushAway(Entity entidad) {
	}

	@Override
	public void takeKnockback(double fuerza, double x, double z) {
	}

	// --- Vuela: sin daño por caída ---
	@Override
	public boolean handleFallDamage(float distancia, float multiplicador, DamageSource fuente) {
		return false;
	}

	@Override
	protected void fall(double alturaDiferencia, boolean enSuelo, BlockState estado, BlockPos pos) {
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource fuente) {
		return SoundEvents.ENTITY_SQUID_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SQUID_DEATH;
	}
}
