package spaghetti;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.struct.*;
import arc.util.Eachable;
import arc.util.Time;
import mindustry.*;
import mindustry.content.Items;
import mindustry.ctype.*;
import mindustry.entities.bullet.*;
import mindustry.entities.units.BuildPlan;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.production.Drill.DrillBuild;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

public class Crusher extends GenericCrafter {
    public TextureRegion rotator, top;
    public float powerConsumption = 2f;

    public Crusher(String name) {
        super(name);
    }

    @Override
    public void init() {
        super.outputItem = new ItemStack(Items.scrap, 1);
        super.consumes.items(new ItemStack(Items.lead, 1));
        super.consumes.power(powerConsumption);
    }

    @Override
    public void load() {
        super.load();
        rotator = Core.atlas.find(name + "-rotator");
        top = Core.atlas.find(name + "-top");
    }

    @Override
    public TextureRegion[] icons() {
        return new TextureRegion[] { region, rotator, top };
    }

    public class CrusherBuild extends Building {
        @Override
        public void draw() {
            Draw.rect(region, x, y);
            Draw.rect(rotator, x, y, Time.time * 2);
            Draw.rect(top, x, y);
        }

        // @Override
        // public boolean acceptItem(Building source, Item item) {
        // return consumes.itemFilters.get(item.id) && items.get(item) <
        // getMaximumAccepted(item);
        // }
    }
}