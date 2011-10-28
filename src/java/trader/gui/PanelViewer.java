package trader.gui;

import trader.*;
import javax.swing.*;

public interface PanelViewer {
    void addView(JPanel panel, String name);
    void showView(String name);
    JPanel getPanel();
}

