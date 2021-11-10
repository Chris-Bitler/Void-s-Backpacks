package io.cbitler.voidsbackpacks.util;

import java.awt.*;

public class ColorUtil {
    public static int RGBToInt(Color color) {
        return ((color.getRed() & 0x0ff) << 16) |
                ((color.getGreen() & 0x0ff) << 16) |
                ((color.getBlue() & 0x0ff) << 16);
    }
}
