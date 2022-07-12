package edu.up.ui.ControlesVisuales;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public abstract class ControlBase extends JPanel {
    protected JTextField textfield;

    public ControlBase(String etiqueta) {
        Dimension dimension = new Dimension(200, 25);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setAlignmentX(LEFT_ALIGNMENT);
        this.setAlignmentY(TOP_ALIGNMENT);

        //this.setBorder( LineBorder.createBlackLineBorder() );

        JLabel label = new JLabel(etiqueta);
        label.setAlignmentX(LEFT_ALIGNMENT);
        label.setMinimumSize(dimension);
        //this.add(label);

        this.textfield = new JTextField();
        textfield.setMaximumSize(dimension);
        textfield.setMinimumSize(dimension);


        JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, label, textfield);
        pane.setMaximumSize(new Dimension(600, 25));

        this.add(pane);
    }
}
