package com.mmg.chess.core.icon;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

import com.mmg.chess.core.model.Side;

public class IconHandler {
    
    private static final ImageRegistry imageRegistry = new ImageRegistry();
    
    public static Image getIcon(String pieceName, Side side) {
        String imageName = (side == Side.WHITE ? "white" : "black") + pieceName + ".png";
        return getImage(imageName);
    }
    
    public static Image getBlankIcon() {
        return getImage("blank.png");
    }
    
    private static Image getImage(String imageName) {

        Image image = imageRegistry.get(imageName);
        if (image == null) {
            Bundle bundle = Platform.getBundle("com.mmg.chess.core");
            Path path = new Path("images/" + imageName);
            URL url = FileLocator.find(bundle, path, null);
            ImageDescriptor imageDesc = ImageDescriptor.createFromURL(url);
            image = imageDesc.createImage();
            imageRegistry.put(imageName, image);
        }
        return image;
    }
}
