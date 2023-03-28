package neumorphism;

import Themes.Dark;
import javafx.geometry.Insets;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class Neumorphism {

    public static void setNeumorphism(Region region, TypeNeumorphism neumorphism, Double radius) {
        setNeumorphism(region, Dark.ROOT, Dark.GLOW, Dark.SHADE, neumorphism, radius);
    }
    public static void setNeumorphismFocus(Region region, TypeNeumorphism neumorphism, Double radius) {
        setNeumorphism(region, Dark.FOCUS_ROOT, Dark.FOCUS_GLOW, Dark.FOCUS_SHADE, neumorphism, radius);
    }

    private static void setNeumorphism(Region region, Color background, Color Glow, Color Shade, TypeNeumorphism neumorphism, Double radius) {
        region.setBackground(new Background(new BackgroundFill(background, new CornerRadii(radius), Insets.EMPTY)));

        if (neumorphism == TypeNeumorphism.OUTER) {
            DropShadow dropShadowGlow = new DropShadow();
            dropShadowGlow.setBlurType(BlurType.ONE_PASS_BOX);
            dropShadowGlow.setColor(Shade);
            dropShadowGlow.setRadius(10);
            dropShadowGlow.setOffsetX(3);
            dropShadowGlow.setOffsetY(3);

            DropShadow dropShadowShade = new DropShadow();
            dropShadowShade.setBlurType(BlurType.ONE_PASS_BOX);
            dropShadowShade.setColor(Glow);
            dropShadowShade.setRadius(10);
            dropShadowShade.setOffsetX(-3);
            dropShadowShade.setOffsetY(-3);
            dropShadowShade.setInput(dropShadowGlow);
            region.setEffect(dropShadowShade);
        } else if (neumorphism == TypeNeumorphism.INNER) {
            InnerShadow innerShadowGlow = new InnerShadow();
            innerShadowGlow.setBlurType(BlurType.ONE_PASS_BOX);
            innerShadowGlow.setColor(Glow);
            innerShadowGlow.setRadius(10);
            innerShadowGlow.setOffsetX(-3);
            innerShadowGlow.setOffsetY(-3);

            InnerShadow innerShadowShade = new InnerShadow();
            innerShadowShade.setColor(Shade);
            innerShadowShade.setBlurType(BlurType.ONE_PASS_BOX);
            innerShadowShade.setRadius(10);
            innerShadowShade.setOffsetX(3);
            innerShadowShade.setOffsetY(3);
            innerShadowShade.setInput(innerShadowGlow);
            region.setEffect(innerShadowShade);
        } else {
            region.setEffect(null);
        }
    }
}
