package skins;

import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Skin;
import javafx.scene.control.SkinBase;


public class CustomColorPickerSkin extends SkinBase<ColorPicker> {

    public CustomColorPickerSkin(ColorPicker colorPicker) {
        super(colorPicker);
    }

    public static Skin<?> createSkin(ColorPicker colorPicker) {
        return new CustomColorPickerSkin(colorPicker);
    }

    @Override
    protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
        super.layoutChildren(contentX, contentY, contentWidth, contentHeight);
        // personalizar la disposición de los elementos de la interfaz de usuario aquí

        ColorPicker colorPicker = getSkinnable();
        Node button = colorPicker.lookup(".color-picker-label");
        Node colorBox = colorPicker.lookup(".color-picker-color-rect");
        if (button != null && colorBox != null) {
            double buttonWidth = button.prefWidth(-1);
            double buttonHeight = button.prefHeight(-1);
            double colorBoxWidth = colorBox.prefWidth(-1);
            double colorBoxHeight = colorBox.prefHeight(-1);
            button.relocate(contentX + colorBoxWidth + 5, contentY + (contentHeight - buttonHeight) / 2);
        }
    }


//    protected void updateSelection(Color color) {
//        super.updateSelection(color);
//        // personalizar el comportamiento cuando se selecciona un color aquí
//    }
}