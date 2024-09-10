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

            // Visor para exibição dos resultados
            JTextArea visor = new JTextArea();
            visor.setBounds(100, 130, 1080, 750);
            visor.setBackground(Color.white);
            visor.setEditable(false);
            Font font = new Font("SansSerif", Font.PLAIN, 24);
            visor.setFont(font);
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
                        JOptionPane.showMessageDialog(null, "Pagamento com " + formaSelecionada + " confirmado. Compra finalizada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Pagamento com " + formaSelecionada + " cancelado.");
                    }
                });
            }

            this.Mesa = mesa;
            String diretorio = "C:\\Users\\ALN\\Documents\\"; // Especifique o lugar para colocar o arquivo
            String nomeArquivo = diretorio + "Pedido.txt";
            StringBuilder conteudo = new StringBuilder(); // Armazenar as linhas
            double totalGeral = 0;

            for (int ID = 0; ID <= 8; ID++) {
                double total = Quantidade[ID][Mesa] * Preco[ID][Mesa];

                if (total > 0) {
                    conteudo.append(Nomes[ID][Mesa]).append("\t")  // Para separar em colunas
                            .append(Quantidade[ID][Mesa]).append("\t")
                            .append(Preco[ID][Mesa]).append("\t")
                            .append(Obs[ID][Mesa]).append("\t")
                            .append(total).append("\n");

                    totalGeral += total;

                    System.out.println("Nome: " + Nomes[ID][Mesa]);
                    System.out.println("Quantidade: " + Quantidade[ID][Mesa]);
                    System.out.println("Preço: " + Preco[ID][Mesa]);
                    System.out.println("Observação: " + Obs[ID][Mesa]);
                    System.out.println("Total: " + total);
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
                // Cabeçalho da saída
                writer.write("Nome\tQuantidade\tPreço\tObservação\tTotal");
                writer.newLine();

                // Escreve o conteúdo gerado no arquivo
                writer.write(conteudo.toString());
                // Escreve o total do preço
                writer.write("\nTotal Geral\t\t\t\t" + totalGeral);
                System.out.println("Total Geral: " + totalGeral);
                System.out.println("Arquivo criado com sucesso!");

            } catch (IOException e) {
                e.printStackTrace();
            }

            // Exibe o total no visor
            visor.setText(conteudo.toString() + "\nTotal Geral\t\t\t\t" + totalGeral);

            setVisible(true);
        }
    }
}
