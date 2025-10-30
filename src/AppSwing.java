import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AppSwing {

    public static void main(String[] args) {
        // --- 1. Configuração da Janela Principal ---
        JFrame janela = new JFrame("Conversor de Moedas");
        janela.setSize(450, 250);
        janela.setMinimumSize(new Dimension(400, 220));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout(10, 10));

        // --- 2. Painel do Resultado (Topo) ---
        JTextArea areaResultado = new JTextArea("Insira os valores e converta");
        areaResultado.setFont(new Font("Arial", Font.BOLD, 16));
        areaResultado.setEditable(false);
        areaResultado.setOpaque(false);
        areaResultado.setBackground(UIManager.getColor("Label.background"));
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);
        areaResultado.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        janela.add(areaResultado, BorderLayout.NORTH);

        // --- 3. Painel dos Campos (Centro) ---
        String[] moedasPopulares = {
                "BRL", "USD", "EUR", "JPY", "GBP", "ARS", "CAD", "CNY", "CHF"
        };

        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new GridLayout(3, 2, 5, 5));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        JTextField campoValor = new JTextField();
        JComboBox<String> comboMoedaBase = new JComboBox<>(moedasPopulares);
        JComboBox<String> comboMoedaAlvo = new JComboBox<>(moedasPopulares);

        // Opcional: Deixa o usuário digitar um código se ele quiser
        comboMoedaBase.setEditable(true);
        comboMoedaAlvo.setEditable(true);

        // Define os valores padrão
        comboMoedaBase.setSelectedItem("USD");
        comboMoedaAlvo.setSelectedItem("BRL");

        painelCampos.add(new JLabel("  Valor a converter:"));
        painelCampos.add(campoValor);
        painelCampos.add(new JLabel("  Moeda Base:"));
        painelCampos.add(comboMoedaBase);
        painelCampos.add(new JLabel("  Moeda Alvo:"));
        painelCampos.add(comboMoedaAlvo);

        janela.add(painelCampos, BorderLayout.CENTER);

        // --- 4. Painel do Botão (Base) ---
        JPanel painelBotao = new JPanel();
        JButton botaoConverter = new JButton("Converter");
        painelBotao.add(botaoConverter);
        janela.add(painelBotao, BorderLayout.SOUTH);

        // --- 5. Lógica do Botão ---
        botaoConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String moedaBase = comboMoedaBase.getSelectedItem().toString().toUpperCase();
                    String moedaAlvo = comboMoedaAlvo.getSelectedItem().toString().toUpperCase();
                    Double valor = Double.parseDouble(campoValor.getText());

                    // A lógica de requisição e tratamento de erro continua a mesma
                    ExchangeApi requisicao = Requisicao.req(moedaBase);
                    Moeda moedaConvertida = new Moeda(requisicao, moedaAlvo, valor);

                    areaResultado.setText(moedaConvertida.toString());

                } catch (NumberFormatException ex) {
                    areaResultado.setText("Erro: O valor deve ser um número.");
                } catch (ConversaoInvalidaException ex) {
                    areaResultado.setText("Erro: " + ex.getMessage());
                } catch (IOException | InterruptedException ex) {
                    areaResultado.setText("Erro na API ou Moeda Base inválida.");
                } catch (Exception ex) {
                    areaResultado.setText("Erro inesperado: " + ex.getMessage());
                }
            }
        });

        janela.setVisible(true);
    }
}