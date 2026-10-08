package com.destroyerpvp.gui;

import com.destroyerpvp.ModuleManager;
import com.destroyerpvp.modules.Module;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ClickGuiScreen extends Screen {

    public ClickGuiScreen() {
        super(Component.literal("DestroyerPvP"));
    }

    @Override
    protected void init() {
        int y = 55;

        for (Module module : ModuleManager.getModules()) {
            final Module m = module;

            addRenderableWidget(
                net.minecraft.client.gui.components.Button.builder(
                    Component.literal(
                        (m.isEnabled() ? "[ON] " : "[OFF] ") + m.getName()
                    ),
                    button -> {
                        m.toggle();

                        button.setMessage(
                            Component.literal(
                                (m.isEnabled() ? "[ON] " : "[OFF] ") + m.getName()
                            )
                        );
                    }
                ).bounds(width / 2 - 100, y, 200, 22).build()
            );

            y += 28;
        }
    }

    @Override
    public void render(
            GuiGraphics graphics,
            int mouseX,
            int mouseY,
            float delta
    ) {
        renderBackground(graphics, mouseX, mouseY, delta);

        graphics.drawCenteredString(
            font,
            "DESTROYER PvP",
            width / 2,
            20,
            0xFFFFFF
        );

        super.render(graphics, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}
