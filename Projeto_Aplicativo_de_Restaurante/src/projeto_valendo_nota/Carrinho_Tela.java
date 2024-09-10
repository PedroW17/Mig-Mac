package projeto_valendo_nota;

import java.awt.*;
import javax.swing.*;

public class Carrinho_Tela {

    public class Janela_Carrinho extends JFrame {
        public Janela_Carrinho() {

            // Configurações da Janela
            setUndecorated(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1280, 1080);
            setLocationRelativeTo(null);

            // Criação do painel principal
            JPanel painel = new JPanel();
            painel.setLayout(null);
            painel.setBackground(Color.white);
            add(painel);

            // Título "MigMac"
            JLabel MigMac = new JLabel("MigMac");
            painel.add(MigMac);
            MigMac.setBounds(545, 5, 300, 100);
            Font fonteMigMac = new Font("Serif", Font.BOLD, 48);
            MigMac.setFont(fonteMigMac);

            // Botão Voltar
            JButton BotaoVoltar = new JButton("Voltar");
            BotaoVoltar.setBounds(20, 10, 100, 100);
            BotaoVoltar.setBackground(Color.DARK_GRAY);
            BotaoVoltar.setForeground(Color.WHITE);
            painel.add(BotaoVoltar);

            // Visor para exibição dos resultados
            JTextArea visor = new JTextArea();
            painel.add(visor);
            visor.setBounds(100, 130, 1080, 750);
            visor.setBackground(Color.white);
            visor.setEditable(false);
            Font font = new Font("SansSerif", Font.PLAIN, 24);
            visor.setFont(font);
            visor.setText(""); // Visor ainda vazio

            // Adicionando o rótulo para formas de pagamento
            JLabel pagamentoLabel = new JLabel("Formas de Pagamento:");
            pagamentoLabel.setBounds(100, 900, 300, 30);
            Font fontePagamento = new Font("SansSerif", Font.BOLD, 24);
            pagamentoLabel.setFont(fontePagamento);
            painel.add(pagamentoLabel);

            // Textos e ações para os botões de pagamento
            String[] formasPagamento = { "PIX", "Cartão de Crédito", "Cartão de Débito" };
            int posicaoXInicial = 300;
            int espacamento = 250;

            for (int i = 0; i < formasPagamento.length; i++) {
                JButton botaoPagamento = new JButton(formasPagamento[i]);
                botaoPagamento.setBounds(posicaoXInicial + i * espacamento, 950, 200, 50);
                botaoPagamento.setBackground(Color.LIGHT_GRAY);
                botaoPagamento.setForeground(Color.BLACK);
                painel.add(botaoPagamento);

                // Ação dos botões
                String formaSelecionada = formasPagamento[i];
                botaoPagamento.addActionListener(e -> {
                    int resposta = JOptionPane.showConfirmDialog(null,
                            "Confirmar forma de pagamento: " + formaSelecionada + "?",
                            "Confirmar Pagamento",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (resposta == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Pagamento com " + formaSelecionada + " confirmado. Compra finalizada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Pagamento com " + formaSelecionada + " cancelado.");
                    }
                });
            }

            setVisible(true);
        }
    }
}