package trader.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabPanelViewer implements PanelViewer{
  private JPanel viewer = new JPanel();
  private JTabbedPane tabs = new JTabbedPane();

  public TabPanelViewer(){
    viewer.add(tabs);
  }

  public void addView(JPanel panel, String name){
    tabs.addTab(name, panel);
  }

  public void showView(String name){
    // Not required when using a JTabbedPanel
  }

  public JPanel getPanel(){
    return viewer;
  }
}

  
