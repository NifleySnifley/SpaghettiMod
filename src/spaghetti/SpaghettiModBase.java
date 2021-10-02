package spaghetti;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class SpaghettiModBase extends Mod {
    public SpaghettiModBase() {
    }

    @Override
    public void loadContent() {
        new SpaghettiBlocks().load();
    }
}
