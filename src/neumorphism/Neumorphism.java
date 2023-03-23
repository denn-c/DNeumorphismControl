package neumorphism;

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
    private static final String darkColor = "#243441";
    private static final String darkInnerGlowColor = "#4F5D67";
    private static final String darkInnerShadeColor = "#0C1116";

    private static final String lightColor = "#e1e6ec";
    private static final String lightDropGlowColor = "#ffffff";
    private static final String lightDropShadeColor = "#bac1d3";

    public static void setNeumorphism(Region region, TypeNeumorphism neumorphism, Double radius) {
        setNeumorphism(region, darkColor, darkInnerGlowColor, darkInnerShadeColor, neumorphism, radius);
    }

    private static void setNeumorphism(Region region, String backgroundColor, String Glow, String Shade, TypeNeumorphism neumorphism, Double radius) {
        region.setBackground(new Background(new BackgroundFill(Color.web(backgroundColor), new CornerRadii(radius), Insets.EMPTY)));

        if (neumorphism == TypeNeumorphism.OUTER) {
            DropShadow dropShadowGlow = new DropShadow();
            dropShadowGlow.setBlurType(BlurType.ONE_PASS_BOX);
            dropShadowGlow.setColor(Color.web(Shade));
            dropShadowGlow.setRadius(10);
            dropShadowGlow.setOffsetX(3);
            dropShadowGlow.setOffsetY(3);

            DropShadow dropShadowShade = new DropShadow();
            dropShadowShade.setBlurType(BlurType.ONE_PASS_BOX);
            dropShadowShade.setColor(Color.web(Glow));
            dropShadowShade.setRadius(10);
            dropShadowShade.setOffsetX(-3);
            dropShadowShade.setOffsetY(-3);
            dropShadowShade.setInput(dropShadowGlow);
            region.setEffect(dropShadowShade);
        } else if (neumorphism == TypeNeumorphism.INNER) {
            InnerShadow innerShadowGlow = new InnerShadow();
            innerShadowGlow.setBlurType(BlurType.ONE_PASS_BOX);
            innerShadowGlow.setColor(Color.web(Glow));
            innerShadowGlow.setRadius(10);
            innerShadowGlow.setOffsetX(-3);
            innerShadowGlow.setOffsetY(-3);

            InnerShadow innerShadowShade = new InnerShadow();
            innerShadowShade.setColor(Color.web(Shade));
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
