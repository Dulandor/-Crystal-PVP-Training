package dulandor.crystaltrainingmod.zombie;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class zombieEntity extends ZombieEntity {
    public zombieEntity(EntityType<ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    // Add any custom behavior or attributes here if needed
}
