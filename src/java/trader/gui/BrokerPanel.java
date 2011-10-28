package trader.gui;

import trader.*;
import javax.swing.*;

public interface BrokerPanel {
    void registerController(BrokerController controller);
    void display(Object obj);
    void refresh();
    JPanel getPanel();
}
