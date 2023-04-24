package neumorphism;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.effect.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.*;

public class Neumorphism {

    private static final Color BLACK = Color.BLACK;
    private static final Color WHITE = Color.WHITE;
    private static final double WHITE_THRESHOLD = 0.9;
    private static final double BLACK_THRESHOLD = 0.1;

    public static void setNeumorphism(Node node, TypeNeumorphism neumorphism, Double radius, Paint paint) {
        Color[] myColors = getGlowShade(paint);
        setNeumorphism(node, paint, myColors[0], myColors[1], neumorphism, radius, false);
    }

    public static void setNeumorphism(Node node, TypeNeumorphism neumorphism, Double radius, Paint paint, Boolean neumorphismText) {
        Color[] myColors = getGlowShade(paint);
        setNeumorphism(node, paint, myColors[0], myColors[1], neumorphism, radius, neumorphismText);
    }

    public static void setNeumorphismActive(Node node, TypeNeumorphism neumorphism, Double radius, Paint paint) {
        Color[] myColors = getGlowShadeFocus(paint);
        setNeumorphism(node, paint, myColors[0], myColors[1], neumorphism, radius, false);
    }

    private static void setNeumorphism(Node node, Paint paint, Color Glow, Color Shade, TypeNeumorphism neumorphism, Double radius, Boolean neumorphismText) {

        if (!neumorphismText) {
            try {
                Region region = (Region) node;
                region.setBackground(new Background(new BackgroundFill(paint, new CornerRadii(radius), Insets.EMPTY)));
            } catch (ClassCastException ignored) {
            }
        }
        if (neumorphism == TypeNeumorphism.RAISED) {
            DropShadow dropShadowGlow = new DropShadow();
            dropShadowGlow.setBlurType(BlurType.ONE_PASS_BOX);
            dropShadowGlow.setColor(Shade);
            if (Shade == Color.BLACK || Shade == Color.WHITE) {
                dropShadowGlow.setSpread(1);
            }
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
            node.setEffect(dropShadowShade);

        } else if (neumorphism == TypeNeumorphism.INSET) {

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
            if (Shade == Color.BLACK || Shade == Color.WHITE) {
                innerShadowShade.setChoke(1);
            }
            innerShadowShade.setOffsetX(3);
            innerShadowShade.setOffsetY(3);
            innerShadowShade.setInput(innerShadowGlow);
            node.setEffect(innerShadowShade);
        } else if (neumorphism == TypeNeumorphism.RIDGE) {
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
            if (Shade == Color.BLACK || Shade == Color.WHITE) {
                innerShadowShade.setChoke(1);
            }
            innerShadowShade.setOffsetX(3);
            innerShadowShade.setOffsetY(3);
            innerShadowShade.setInput(innerShadowGlow);

            DropShadow dropShadowGlow = new DropShadow();
            dropShadowGlow.setBlurType(BlurType.ONE_PASS_BOX);
            dropShadowGlow.setColor(Shade);
            dropShadowGlow.setRadius(10);
            if (Shade == Color.BLACK || Shade == Color.WHITE) {
                dropShadowGlow.setSpread(1);
            }
            dropShadowGlow.setOffsetX(3);
            dropShadowGlow.setOffsetY(3);
            dropShadowGlow.setInput(innerShadowShade);

            DropShadow dropShadowShade = new DropShadow();
            dropShadowShade.setBlurType(BlurType.ONE_PASS_BOX);
            dropShadowShade.setColor(Glow);
            dropShadowShade.setRadius(10);
            dropShadowShade.setOffsetX(-3);
            dropShadowShade.setOffsetY(-3);
            dropShadowShade.setInput(dropShadowGlow);
            node.setEffect(dropShadowShade);
        } else {
            node.setEffect(null);
        }
    }

    private static Color[] getGlowShade(Paint paint) {
        Color color = null;
        Color[] colors = new Color[2];

        if (paint instanceof Color) {
            color = (Color) paint;
        } else if (paint instanceof RadialGradient) {
            color = ((RadialGradient) paint).getStops().get(((RadialGradient) paint).getStops().size() - 1).getColor();
        } else if (paint instanceof LinearGradient) {
            Color glow = ((LinearGradient) paint).getStops().get(0).getColor();
            Color shade = ((LinearGradient) paint).getStops().get(((LinearGradient) paint).getStops().size() - 1).getColor();
            double r = glow.getRed(), g = glow.getGreen(), b = glow.getBlue(), opacity = glow.getOpacity();
            colors[0] = new Color(Math.min(r + 0.20, 1.0), Math.min(g + 0.20, 1.0), Math.min(b + 0.20, 1.0), opacity);
            r = shade.getRed();
            g = shade.getGreen();
            b = shade.getBlue();
            opacity = shade.getOpacity();
            colors[1] = new Color(Math.max(r - 0.20, 0.0), Math.max(g - 0.20, 0.0), Math.max(b - 0.20, 0.0), opacity);
            return colors;
        }
        assert color != null;
        double r = color.getRed(), g = color.getGreen(), b = color.getBlue(), opacity = color.getOpacity(), brightness = (r + g + b) / 3;
        if (brightness < BLACK_THRESHOLD) {
            colors[0] = new Color(Math.min(r + 0.20, 1.0), Math.min(g + 0.20, 1.0), Math.min(b + 0.20, 1.0), opacity);
            colors[1] = BLACK;
        } else if (brightness > WHITE_THRESHOLD) {
            colors[0] = WHITE;
            colors[1] = new Color(Math.max(r - 0.20, 0.0), Math.max(g - 0.20, 0.0), Math.max(b - 0.20, 0.0), opacity);
        } else {
            colors[0] = new Color(Math.min(r + 0.20, 1.0), Math.min(g + 0.20, 1.0), Math.min(b + 0.20, 1.0), opacity);
            colors[1] = new Color(Math.max(r - 0.20, 0.0), Math.max(g - 0.20, 0.0), Math.max(b - 0.20, 0.0), opacity);
        }
        return colors;
    }

    private static Color[] getGlowShadeFocus(Paint paint) {

        Color color = null;
        Color[] colors = new Color[2];

        if (paint instanceof Color) {
            color = (Color) paint;
        } else if (paint instanceof RadialGradient) {
            color = ((RadialGradient) paint).getStops().get(((RadialGradient) paint).getStops().size() - 1).getColor();
        } else if (paint instanceof LinearGradient) {
            Color glow = ((LinearGradient) paint).getStops().get(0).getColor();
            Color shade = ((LinearGradient) paint).getStops().get(((LinearGradient) paint).getStops().size() - 1).getColor();
            double r = glow.getRed(), g = glow.getGreen(), b = glow.getBlue(), opacity = glow.getOpacity();
            colors[0] = new Color(Math.min(r + 0.40, 1.0), Math.min(g + 0.40, 1.0), Math.min(b + 0.40, 1.0), opacity);
            r = shade.getRed();
            g = shade.getGreen();
            b = shade.getBlue();
            opacity = shade.getOpacity();
            colors[1] = new Color(Math.max(r - 0.40, 0.0), Math.max(g - 0.40, 0.0), Math.max(b - 0.40, 0.0), opacity);
            return colors;
        }
        assert color != null;
        double r = color.getRed(), g = color.getGreen(), b = color.getBlue(), opacity = color.getOpacity();
        colors[0] = new Color(Math.min(r + 0.40, 1.0), Math.min(g + 0.40, 1.0), Math.min(b + 0.40, 1.0), opacity);
        colors[1] = new Color(Math.max(r - 0.40, 0.0), Math.max(g - 0.40, 0.0), Math.max(b - 0.40, 0.0), opacity);
        return colors;
    }

    public static Color getTextFill(Paint paint) {
        Color color = null;
        if (paint instanceof Color) {
            color = (Color) paint;
        } else if (paint instanceof RadialGradient) {
            color = ((RadialGradient) paint).getStops().get(0).getColor();
        } else if (paint instanceof LinearGradient) {
            int numTonalidadesBlancas = 0;
            int numTonalidadesTotales = 0;

            Stop[] stops = ((LinearGradient) paint).getStops().toArray(new Stop[0]);

            for (Stop stop : stops) {
                color = stop.getColor();
                numTonalidadesTotales++;
                if (color.getBrightness() >= 0.5) {
                    numTonalidadesBlancas++;
                }
            }

            if ((double) numTonalidadesBlancas / numTonalidadesTotales > 0.5) {
                return BLACK;
            } else {
                return WHITE;
            }
        }
        assert color != null;
        double brightness = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        if (brightness < 0.5) {
            return WHITE;
        } else {
            return BLACK;
        }
    }
}
