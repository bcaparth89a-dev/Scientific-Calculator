package ui;

import service.CalculatorService;
import utils.ExpressionEvaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorUI extends JFrame {

    private JTextField display;
    private CalculatorService service;
    private boolean isDegree = true;

    public CalculatorUI() {

        service = new CalculatorService();

        setTitle("Scientific Calculator (DEG)");
        setSize(380, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        // DISPLAY
        display = new JTextField();
        display.setFont(new Font("Segoe UI", Font.BOLD, 30));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        display.setBackground(new Color(25,25,25));
        display.setForeground(Color.GREEN);
        display.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        add(display, BorderLayout.NORTH);

        // PANEL (FIXED ROWS 🔥)
        JPanel panel = new JPanel(new GridLayout(7,4,10,10));
        panel.setBackground(new Color(20,20,20));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        String[] buttons = {
                "sin","cos","tan","log",
                "√","^","(",")",
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0",".","=","+",
                "C","⌫","DEG",""
        };

        for (String text : buttons) {

            if (text.equals("")) {
                panel.add(new JLabel());
                continue;
            }

            JButton btn = createButton(text);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);

        setupKeyBindings();

        setVisible(true);
    }

    private JButton createButton(String text) {

        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setFocusPainted(false);

        // Color styling
        if (text.matches("[0-9]")) {
            btn.setBackground(new Color(60,60,60));
        } else if (text.equals("=")) {
            btn.setBackground(new Color(0,120,215));
        } else if (text.equals("C")) {
            btn.setBackground(new Color(200,50,50));
        } else {
            btn.setBackground(new Color(80,80,80));
        }

        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        btn.addActionListener(e -> handle(text));

        return btn;
    }

    private void handle(String value) {

        switch (value) {

            case "=":
                calculate();
                break;

            case "C":
                display.setText("");
                break;

            case "⌫":
                backspace();
                break;

            case "sin":
            case "cos":
            case "tan":
            case "log":
                display.setText(display.getText() + value + "(");
                break;

            case "√":
                display.setText(display.getText() + "sqrt(");
                break;

            case "DEG":
                toggleMode();
                break;

            default:
                display.setText(display.getText() + value);
        }
    }

    private void toggleMode() {
        isDegree = !isDegree;
        ExpressionEvaluator.setDegree(isDegree);
        setTitle(isDegree ? "Calculator (DEG)" : "Calculator (RAD)");
    }

    private void calculate() {
        display.setText(service.calculate(display.getText()));
    }

    private void backspace() {
        String text = display.getText();
        if (!text.isEmpty()) {
            display.setText(text.substring(0, text.length() - 1));
        }
    }

    // 🔥 Keyboard Support
    private void setupKeyBindings() {

        JComponent comp = this.getRootPane();

        InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = comp.getActionMap();

        for (char c = '0'; c <= '9'; c++) {
            char key = c;
            im.put(KeyStroke.getKeyStroke(key), "num_" + key);
            am.put("num_" + key, new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText() + key);
                }
            });
        }

        String ops = "+-*/.%";
        for (char op : ops.toCharArray()) {
            im.put(KeyStroke.getKeyStroke(op), "op_" + op);
            am.put("op_" + op, new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText() + op);
                }
            });
        }

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "equals");
        am.put("equals", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "back");
        am.put("back", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                backspace();
            }
        });

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "clear");
        am.put("clear", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                display.setText("");
            }
        });
    }
}