package code;

import converters.IConverterMaster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsavel pela interface de conversão do sistema
 */
public class Interface extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JTextField txtFromValue;
    private final JTextField txtToValue;
    private final JTextField txtUnitConverters;

    Interface(String title) {
        super("Unit Measurement Converter");
        this.setSize(862, 225);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        /**
         * ComboBox com as medidas de conversão
         */
        JComboBox<Object> cbToMeasurements = new JComboBox<Object>();
        cbToMeasurements.setMaximumRowCount(15);
        cbToMeasurements.setBounds(382, 89, 454, 62);
        getContentPane().add(cbToMeasurements);

        JPanel pnlConvertFrom = new JPanel();
        pnlConvertFrom.setBackground(Color.LIGHT_GRAY);
        pnlConvertFrom.setBounds(10, 16, 168, 62);
        getContentPane().add(pnlConvertFrom);
        pnlConvertFrom.setLayout(null);

        JLabel lblConvertFrom = new JLabel("Convert from");
        lblConvertFrom.setBounds(46, 23, 75, 14);
        lblConvertFrom.setFont(new Font("Tahoma", Font.BOLD, 11));
        pnlConvertFrom.add(lblConvertFrom);

        JPanel pnlConvertTo = new JPanel();
        pnlConvertTo.setBackground(Color.LIGHT_GRAY);
        pnlConvertTo.setBounds(10, 89, 168, 62);
        getContentPane().add(pnlConvertTo);
        pnlConvertTo.setLayout(null);

        JLabel lblConvertTo = new JLabel("to");
        lblConvertTo.setBounds(77, 24, 12, 14);
        lblConvertTo.setHorizontalAlignment(SwingConstants.CENTER);
        lblConvertTo.setFont(new Font("Tahoma", Font.BOLD, 11));
        pnlConvertTo.add(lblConvertTo);

        txtFromValue = new JTextField();
        txtFromValue.setHorizontalAlignment(SwingConstants.RIGHT);
        txtFromValue.setBounds(188, 16, 184, 62);
        getContentPane().add(txtFromValue);
        txtFromValue.setColumns(10);

        txtToValue = new JTextField();
        txtToValue.setHorizontalAlignment(SwingConstants.RIGHT);
        txtToValue.setColumns(10);
        txtToValue.setEditable(false);
        txtToValue.setBounds(188, 89, 184, 62);
        getContentPane().add(txtToValue);

        JComboBox<Object> cbFromMeasurements = new JComboBox<Object>();
        cbFromMeasurements.setMaximumRowCount(15);
        cbFromMeasurements.setBounds(382, 16, 454, 62);
        getContentPane().add(cbFromMeasurements);

        ArrayList<IConverterMaster> listMeasurements = LoadConverters.InstaceConverters();

        for (Object clazz : listMeasurements) {
            cbFromMeasurements.addItem(clazz);
        }

        addToMeasurementsItens(cbFromMeasurements, cbToMeasurements, listMeasurements);

        txtUnitConverters = new JTextField();

        txtUnitConverters.setBackground(Color.GRAY);
        txtUnitConverters.setHorizontalAlignment(SwingConstants.CENTER);
        txtUnitConverters.setColumns(10);
        txtUnitConverters.setBounds(0, 165, 846, 21);
        getContentPane().add(txtUnitConverters);

        Integer countUnitConverters = listMeasurements.size();

        txtUnitConverters.setText(countUnitConverters + " unit converters are available.");

        cbFromMeasurements.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                addToMeasurementsItens(cbFromMeasurements, cbToMeasurements, listMeasurements);
                doConvert(cbFromMeasurements, cbToMeasurements, txtFromValue, txtToValue, null);
            }

        });

        cbToMeasurements.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                doConvert(cbFromMeasurements, cbToMeasurements, txtFromValue, txtToValue, null);
            }

        });

        txtFromValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();

                if (!(ch >= '0' && ch <= '9') && ch != '.' && ch != '\b' && e.getKeyCode() != 0) {
                    e.consume();
                } else {
                    doConvert(cbFromMeasurements, cbToMeasurements, txtFromValue, txtToValue, e);
                }
            }
        });
    }

    /**
     * @param cbFromMeasurements
     * @param cbToMeasurements
     * @param txtFromValue
     * @param txtToValue
     * @param e                  Pega o item selecionado do comboBox os convete pela
     *                           IConverterMaster, as valida e realiza a conversão
     */
    private static void doConvert(JComboBox<Object> cbFromMeasurements, JComboBox<Object> cbToMeasurements,
            JTextField txtFromValue, JTextField txtToValue, KeyEvent e) {
        IConverterMaster fromConverter = (IConverterMaster) cbFromMeasurements.getSelectedItem();
        IConverterMaster toConverter = (IConverterMaster) cbToMeasurements.getSelectedItem();

        String value = txtFromValue.getText();

        if (e != null && e.getKeyChar() != '\b')
            value += e.getKeyChar();

        if (!value.isEmpty() && toConverter != null) {
            txtToValue.setText(toConverter.convert(fromConverter, Double.parseDouble(value)).toString());

        }
    }

    /**
     * @param cbFromMeasurements
     * @param cbToMeasurements
     * @param listMeasurements   Responsavel por adicionar as unidades de conversão
     *                           do mesmo tipo
     */
    private static void addToMeasurementsItens(JComboBox<Object> cbFromMeasurements, JComboBox<Object> cbToMeasurements,
            List<IConverterMaster> listMeasurements) {
        cbToMeasurements.removeAllItems();

        String sourceMeasurementItem = cbFromMeasurements.getSelectedItem().toString();
        String filter = sourceMeasurementItem.substring(sourceMeasurementItem.indexOf("["),
                sourceMeasurementItem.lastIndexOf("]"));

        List<Object> listToMeasurements = listMeasurements.stream().filter(x -> x.toString().contains(filter))
                .collect(Collectors.toList());

        for (Object clazz : listToMeasurements) {
            cbToMeasurements.addItem(clazz);
        }
    }
}