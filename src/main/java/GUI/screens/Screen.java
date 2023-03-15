package GUI.screens;

import GUI.ScreenProperties;
import GUI.util.DistanceRenderer;
import GUI.util.Util;
import units.Money;
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

    private JTextField input;
    private JTextField output;
    protected JComboBox<Unit> selectInputUnit;
    protected JComboBox<Unit> selectOutputUnit;
    protected JPanel panelForm;
    private JTextPane jpanel;

    public Screen() {
        init();
        events();
    }

    public abstract Unit[] getValues();

    public abstract String getName();

    public abstract ImageIcon getImageIcon();

    @Override
    public String getTitle() {
        return "Conversor de " + getName();
    }

    protected void init() {
        initPanelForm();
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(15, 15, 15, 15));
        setName(getName());
        add(panelForm, BorderLayout.PAGE_START);
        add(getJpanel(), BorderLayout.PAGE_END);
    }

    private String createTableWithAllConversion(BigDecimal amount, Unit unit) {
        StringBuilder sb = new StringBuilder();
        String value = unit.getFormattedValue(String.valueOf(amount));
        sb.append("<table><th colspan=2 align=left>" + value + " (" + unit.getName() + ") equivale a:</th>");
        for (Unit u : getValues()) {
            String convert = unit.convert(amount, u).toPlainString();
            sb.append("<tr>");
            sb.append("<td>" + u.getFormattedValue(convert) + "</td>");
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
        jpanel.setEditable(false);
        return jpanel;
    }

    private void initPanelForm() {
        GridLayout gl_divForm = new GridLayout(0, 2);
        gl_divForm.setVgap(15);
        gl_divForm.setHgap(15);
        JPanel divForm = new JPanel(gl_divForm);
        divForm.add(getInput());
        divForm.add(getSelectInputUnit());
        divForm.add(getOutput());
        divForm.add(getSelectOutputUnit());
        panelForm = divForm;
    }

    public JTextField getInput() {
        if (Objects.nonNull(input)) return input;
        input = new JTextField();
        Util.increaseFont(input, 16);
        return input;
    }

    public JComboBox<Unit> getSelectInputUnit() {
        if (Objects.nonNull(selectInputUnit)) return selectInputUnit;
        selectInputUnit = new JComboBox<>(getValues());
        selectInputUnit.setRenderer(new DistanceRenderer());
        return selectInputUnit;
    }

    public JComboBox<Unit> getSelectOutputUnit() {
        if (Objects.nonNull(selectOutputUnit)) return selectOutputUnit;
        selectOutputUnit = new JComboBox<>(getValues());
        selectOutputUnit.setSelectedIndex(1);
        selectOutputUnit.setRenderer(new DistanceRenderer());
        return selectOutputUnit;
    }

    public JTextField getOutput() {
        if (Objects.nonNull(output)) return output;
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
        Unit sourceUnit = (Unit) selectInputUnit.getSelectedItem();
        Unit targetUnit = (Unit) selectOutputUnit.getSelectedItem();
        String resultString;
        try {
            BigDecimal amount = new BigDecimal(input.getText());
            if (sourceUnit instanceof Money) {
                resultString = ((Money) sourceUnit)
                        .updateAndConvert(amount, (Money) targetUnit)
                        .toPlainString();
            } else {
                resultString = sourceUnit.convert(amount, targetUnit).toPlainString();
            }
            getOutput().setText(targetUnit.getFormattedValue(resultString));
            getJpanel().setText(createTableWithAllConversion(amount, sourceUnit));
        } catch (NumberFormatException nfe) {
            if (!getInput().getText().isEmpty()) {
                getOutput().setText("Invalid input value!");
            } else {
                getOutput().setText(null);
            }
            getJpanel().setText(null);
            getInput().grabFocus();
        } catch (ArithmeticException ae) {
            getOutput().setText("Arithmetic error!");
            getJpanel().setText(ae.getMessage());
        } catch (Exception e) {
            getOutput().setText(null);
            getJpanel().setText(e.getMessage());
        }
    }

}

