package trader;

import trader.gui.*;

public class Broker2TierApp {
    
    BrokerModel model;
    BrokerViewImpl view;
    BrokerController con;
    
    /** Creates a new instance of Broker2TierApp */
    public static void main(String args[]) {
        try {
            Broker2TierApp app = new Broker2TierApp();
            app.model = trader.BrokerModelImpl.getInstance();
            app.view = new BrokerViewImpl(app.model);
            app.con = new BrokerControllerImpl(app.model, app.view);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
