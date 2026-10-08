package com.destroyerpvp;

import com.destroyerpvp.modules.*;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

public final class ModuleManager {
    private static final List<Module> MODULES = new ArrayList<>();

    public static void init() {
        MODULES.clear();

        MODULES.add(new AimTraining());
        MODULES.add(new Keystrokes());
        MODULES.add(new CPSCounter());
        MODULES.add(new Zoom());
        MODULES.add(new FPS());
    }

    public static List<Module> getModules() {
        return MODULES;
    }

    public static void tick(Minecraft client) {
        for (Module module : MODULES) {
            if (module.isEnabled()) {
                module.onTick(client);
            }
        }
    }
}
