package spaghetti;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import mindustry.content.*;
import mindustry.ctype.ContentList;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.with;

import javax.management.Descriptor;

public class SpaghettiBlocks implements ContentList {
    public static Block crusher, nanoDrill;

    @Override
    public void load() {
        crusher = new Crusher("crusher") {
            {
                requirements(Category.crafting, with(Items.silicon, 10, Items.copper, 50, Items.lead, 70));
                description = "Crushes metal into pieces of scrap for further processing";
                health = 300;
                size = 2;
                super.craftTime = 20f;
                super.craftEffect = Fx.pulverize;
                powerConsumption = 2;

                super.hasItems = true;
                super.hasPower = true;
            }
        };

        nanoDrill = new Drill("nano-drill") {
            {
                requirements(Category.production, with(Items.copper, 4, Items.lead, 4));
                size = 1;
                tier = 2; // Up to coal
                health = 20;
                rotateSpeed = 10f;
                drillTime = 700f;

                description = "Isn't it just adorable!";
            }
        };
    }
}
