import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField txtNumber1, txtNumber2, txtResult;
    private JButton btnAdd, btnSubt, btnMulti, btnDivide, btnClear;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblHeading = new JLabel("edSlash Coding Hub Calculator");
        lblHeading.setFont(lblHeading.getFont().deriveFont(Font.BOLD, 18f));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lblHeading, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(new JLabel("Number 1:"), gbc);
        txtNumber1 = new JTextField();
        gbc.gridx = 1;
        add(txtNumber1, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        add(new JLabel("Number 2:"), gbc);
        txtNumber2 = new JTextField();
        gbc.gridx = 1;
        add(txtNumber2, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        add(new JLabel("Result:"), gbc);
        txtResult = new JTextField();
        txtResult.setEditable(false);
        gbc.gridx = 1;
        add(txtResult, gbc);

        JPanel panelButtons = new JPanel(new GridLayout(1, 5, 10, 0));
        btnAdd = new JButton("Add");
        btnAdd.setToolTipText("Add Number 1 and Number 2");
        btnSubt = new JButton("Subt.");
        btnSubt.setToolTipText("Subtract Number 2 from Number 1");
        btnMulti = new JButton("Multi.");
        btnMulti.setToolTipText("Multiply Number 1 and Number 2");
        btnDivide = new JButton("Divide");
        btnDivide.setToolTipText("Divide Number 1 by Number 2");
        btnClear = new JButton("Clear");
        btnClear.setToolTipText("Clear all fields");

        btnAdd.addActionListener(this);
        btnSubt.addActionListener(this);
        btnMulti.addActionListener(this);
        btnDivide.addActionListener(this);
        btnClear.addActionListener(this);

        panelButtons.add(btnAdd);
        panelButtons.add(btnSubt);
        panelButtons.add(btnMulti);
        panelButtons.add(btnDivide);
        panelButtons.add(btnClear);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(panelButtons, gbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str1 = txtNumber1.getText().trim();
        String str2 = txtNumber2.getText().trim();

        if (e.getSource() == btnClear) {
            txtNumber1.setText("");
            txtNumber2.setText("");
            txtResult.setText("");
            return;
        }

        if (str1.isEmpty() || str2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double num1, num2;
        try {
            num1 = Double.parseDouble(str1);
            num2 = Double.parseDouble(str2);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double result = 0;
        String command = e.getActionCommand();

        switch (command) {
            case "Add":
                result = num1 + num2;
                break;
            case "Subt.":
                result = num1 - num2;
                break;
            case "Multi.":
                result = num1 * num2;
                break;
            case "Divide":
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero.", "Math Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = num1 / num2;
                break;
        }

        txtResult.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleCalculator::new);
    }
}
