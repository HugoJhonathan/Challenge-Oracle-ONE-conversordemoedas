package GUI.screens;

import GUI.ScreenProperties;
import GUI.util.DistanceRenderer;
import GUI.util.Util;
import application.Conversor;
import application.Result;
import units.Unit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public abstract class Screen extends JPanel implements ScreenProperties {
    public abstract Unit[] getValues();

    public abstract String getName();

    public abstract ImageIcon getImageIcon();

    @Override
    public String getTitle() {
        return "Conversor de " + getName();
    }

    private JLabel titleLabel;
    private JTextField input;
    private JTextField output;
    private JComboBox<Unit> selectInputUnit;
    private JComboBox<Unit> selectOutputUnit;
    private JLabel jpanel;

    public Screen() {
        init();
        events();
    }

    private void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setName(getName());
        add(getTitleLabel());
        add(getPanelForm());
        add(getJpanel());
    }

    public JLabel getJpanel() {
        if (Objects.nonNull(jpanel)) return jpanel;
        jpanel = new JLabel();
        jpanel.setBackground(Color.red);
        jpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return jpanel;
    }

    public JPanel getPanelForm() {
        GridLayout gl_divForm = new GridLayout(2, 0);
        gl_divForm.setVgap(15);
        gl_divForm.setHgap(15);
        JPanel divForm = new JPanel(gl_divForm);
        divForm.setMaximumSize(new Dimension(500, 100));
        divForm.setBorder(new EmptyBorder(15, 15, 15, 15));
        divForm.add(getInput());
        divForm.add(getSelectInputUnit());
        divForm.add(getOutput());
        divForm.add(getSelectOutputUnit());
        return divForm;
    }

    public JLabel getTitleLabel() {
        if (Objects.nonNull(titleLabel)) return titleLabel;
        titleLabel = new JLabel();
        titleLabel.setText("Conversor: " + getName());
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setBorder(new EmptyBorder(15, 15, 15, 15));
        return titleLabel;
    }

    public JTextField getInput() {
        if (Objects.nonNull(input)) return input;
        input = new JTextField();
        Util.increaseFont(input, 16);
        return input;
    }

    public JComboBox<Unit> getSelectInputUnit() {
        if (selectInputUnit != null) return selectInputUnit;
        selectInputUnit = new JComboBox<>();
        Arrays.stream(getValues()).forEach(el -> {
            this.selectInputUnit.addItem(el);
        });
        selectInputUnit.setRenderer(new DistanceRenderer());
        return selectInputUnit;
    }

    public JComboBox<Unit> getSelectOutputUnit() {
        if (selectOutputUnit != null) return selectOutputUnit;
        selectOutputUnit = new JComboBox<>();
        Arrays.stream(getValues()).forEach(el -> {
            this.selectOutputUnit.addItem(el);
        });
        selectOutputUnit.setSelectedIndex(1);
        selectOutputUnit.setRenderer(new DistanceRenderer());
        return selectOutputUnit;
    }

    public JTextField getOutput() {
        if (output != null) return output;
        output = new JTextField();
        output.setBorder(null);
        output.setEditable(false);
        output.setForeground(new Color(0, 180, 0));
        Util.increaseFont(output, 18);
        return output;
    }

    public void events() {
        input.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                btnCalcularClick();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                btnCalcularClick();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        selectInputUnit.addActionListener((e) -> btnCalcularClick());
        selectOutputUnit.addActionListener((e) -> btnCalcularClick());
    }

    protected void btnCalcularClick() {
        try {
            Unit sourceUnit = (Unit) selectInputUnit.getSelectedItem();
            Unit targetUnit = (Unit) selectOutputUnit.getSelectedItem();
            double amount = Double.parseDouble(input.getText());
            Result result = Conversor.convert(amount, sourceUnit, targetUnit);
            double resultDouble = result.getResult();
            output.setText(targetUnit.getFormattedValue(resultDouble));
            jpanel.setText(result.toString());
        } catch (NumberFormatException nfe) {
            output.setText(null);
            jpanel.setText(null);
        }
    }

}

