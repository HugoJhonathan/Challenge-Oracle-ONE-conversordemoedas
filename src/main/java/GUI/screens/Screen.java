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
import java.math.BigDecimal;
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

    private JTextField input;
    private JTextField output;
    private JComboBox<Unit> selectInputUnit;
    private JComboBox<Unit> selectOutputUnit;
    private JTextPane jpanel;

    public Screen() {
        init();
        events();
    }

    private void init() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(15, 15, 15, 15));
        setName(getName());
        add(getPanelForm(), BorderLayout.PAGE_START);
        add(getJpanel(), BorderLayout.PAGE_END);
    }

    private String createTableWithAllConversion(BigDecimal amount, Unit unit) {
        StringBuilder sb = new StringBuilder();
        String value = unit.getFormattedValue(String.valueOf(amount));
        sb.append("<table><th colspan=2>" + value + " (" + unit.getName() + ") é igual a:</th>");
        for (Unit u : getValues()) {
            Result convert = Conversor.convert(amount, unit, u);
            sb.append("<tr>");
            sb.append("<td>" + u.getFormattedValue(convert.getResult().toPlainString()) + "</td>");
            sb.append("<td>" + u.getName() + "</td>");
            sb.append("</td>");
        }
        sb.append("</table>");
        return sb.toString();
    }

    public JTextPane getJpanel() {
        if (Objects.nonNull(jpanel)) return jpanel;
        jpanel = new JTextPane();
        jpanel.setContentType("text/html");
        jpanel.setOpaque(false);
        return jpanel;
    }

    public JPanel getPanelForm() {
        GridLayout gl_divForm = new GridLayout(2, 0);
        gl_divForm.setVgap(15);
        gl_divForm.setHgap(15);
        JPanel divForm = new JPanel(gl_divForm);
        divForm.setMaximumSize(new Dimension(500, 100));
        divForm.add(getInput());
        divForm.add(getSelectInputUnit());
        divForm.add(getOutput());
        divForm.add(getSelectOutputUnit());
        return divForm;
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
            BigDecimal amount = new BigDecimal(input.getText());

            Result result = Conversor.convert(amount, sourceUnit, targetUnit);
            String resultString = result.getResult().toPlainString();
            getOutput().setText(targetUnit.getFormattedValue(resultString));
            getJpanel().setText(createTableWithAllConversion(amount, sourceUnit));
        } catch (NumberFormatException nfe) {
            getOutput().setText(null);
            getJpanel().setText(null);
        }
    }

}

