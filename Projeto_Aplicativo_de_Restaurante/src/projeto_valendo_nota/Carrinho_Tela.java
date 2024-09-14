package projeto_valendo_nota;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Carrinho_Tela implements Pratos {

    public class Janela_Carrinho extends JFrame {
        int Mesa;

        public Janela_Carrinho(int mesa) {
            // Configurações da Janela
            setUndecorated(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(1280, 1080);
            setLocationRelativeTo(null);

            // Criação do painel principal
            JPanel painel = new JPanel();
            painel.setLayout(null);
            painel.setBackground(Color.white);
            add(painel);

            // Título "MigMac"
            JLabel MigMac = new JLabel("MigMac");
            MigMac.setBounds(545, 5, 300, 100);
            Font fonteMigMac = new Font("Serif", Font.BOLD, 48);
            MigMac.setFont(fonteMigMac);
            painel.add(MigMac);

            // Botão Voltar
            JButton BotaoVoltar = new JButton("Voltar");
            BotaoVoltar.setBounds(20, 10, 100, 100);
            BotaoVoltar.setBackground(Color.DARK_GRAY);
            BotaoVoltar.setForeground(Color.WHITE);
            painel.add(BotaoVoltar);
            BotaoVoltar.addActionListener(e -> {
                dispose(); // Fecha a janela atual
            });

            // Visor para exibição dos resultados
            JTextArea visor = new JTextArea();
            visor.setBounds(100, 130, 1080, 750);
            visor.setBackground(Color.white);
            visor.setEditable(false);
            Font font = new Font("SansSerif", Font.PLAIN, 18);
            visor.setFont(font);
            visor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            painel.add(visor);

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
                        // Gera o arquivo ao confirmar o pagamento
                        String diretorio = "C:\\Users\\ALN\\Documents\\"; // Especifique o lugar para colocar o arquivo
                        String nomeArquivo = diretorio + "Pedido.txt";
                        StringBuilder conteudo = new StringBuilder(); // Armazenar as linhas
                        double totalGeral = 0;

                        // Formatação do texto para exibição e escrita no arquivo
                        String formatHeader = "%-30s %-10s %-10s %-20s\n"; // Ajustei para alinhar melhor as colunas
                        String formatRow = "%-30s %-10d %-10.2f %-20s\n";  // Ajustei para incluir espaçamento mais uniforme
                        conteudo.append(String.format(formatHeader, "Nome", "Qtd", "Preço", "Observação"));

                        for (int ID = 0; ID <= 11; ID++) {
                            double total = Quantidade[ID][Mesa] * Preco[ID][Mesa];

                            if (total > 0) {
                                if (Obs[ID][Mesa] == null) {
                                    Obs[ID][Mesa] = "";
                                }

                                conteudo.append(String.format(formatRow,
                                        Nomes[ID][Mesa],
                                        Quantidade[ID][Mesa],
                                        Preco[ID][Mesa],
                                        Obs[ID][Mesa]));

                                totalGeral += total;
                            }
                        }
                        conteudo.append(String.format("\n%-40s %10.2f", "Total Geral", totalGeral));

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
                            writer.write(conteudo.toString());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        JOptionPane.showMessageDialog(null, "Pagamento com " + formaSelecionada + " confirmado. Compra finalizada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Pagamento com " + formaSelecionada + " cancelado.");
                    }
                });
            }

            this.Mesa = mesa;

            // Exibe o total no visor
            StringBuilder conteudoExibido = new StringBuilder();
            double totalGeralExibido = 0;

            String formatHeaderExibido = "%-30s %-10s %-10s %-20s\n"; // Alinha o cabeçalho corretamente
            String formatRowExibido = "%-30s %-10d %-10.2f %-20s\n";  // Alinha as linhas corretamente
            conteudoExibido.append(String.format(formatHeaderExibido, "Nome", "Qtd", "Preço", "Observação"));

            for (int ID = 0; ID <= 11; ID++) {
                double total = Quantidade[ID][Mesa] * Preco[ID][Mesa];

                if (total > 0) {
                    if (Obs[ID][Mesa] == null) {
                        Obs[ID][Mesa] = "";
                    }

                    conteudoExibido.append(String.format(formatRowExibido,
                            Nomes[ID][Mesa],
                            Quantidade[ID][Mesa],
                            Preco[ID][Mesa],
                            Obs[ID][Mesa]));

                    totalGeralExibido += total;
                }
            }
            conteudoExibido.append(String.format("\n%-40s %10.2f", "Total Geral", totalGeralExibido));
            visor.setText(conteudoExibido.toString());

            setVisible(true);
        }
    }
}
