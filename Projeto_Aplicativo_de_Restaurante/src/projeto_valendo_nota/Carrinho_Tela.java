package projeto_valendo_nota;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class Carrinho_Tela implements Pratos {

    private Salao salao;
    private Tela_inicial telaInicial; // Referência à Tela_inicial

    public Carrinho_Tela(Salao salao, Tela_inicial telaInicial) {
        this.salao = salao;
        this.telaInicial = telaInicial;
    }

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
            ImageIcon migmac = new ImageIcon(getClass().getResource("/Pratos/MIGMAC.jpg"));
            JLabel MigMac = new JLabel(migmac);
            MigMac.setBounds(500, 5, 300, 140);
            painel.add(MigMac);

            // Botão Voltar
            ImageIcon voltar = new ImageIcon(getClass().getResource("/Pratos/Voltar.png"));
            JButton BotaoVoltar = new JButton(voltar);
            BotaoVoltar.setBounds(50, 10, 90, 90);
            BotaoVoltar.setBackground(Color.DARK_GRAY);
            painel.add(BotaoVoltar);
            BotaoVoltar.addActionListener(e -> {
            	Tela_inicial telaInicial = new Tela_inicial();
            	telaInicial.new Janela(mesa+1);
                dispose(); // Fecha a janela atual
            });

            // Visor para exibição dos resultados
            JTextArea visor = new JTextArea();
            visor.setBounds(100, 160, 1080, 750);
            visor.setBackground(Color.DARK_GRAY);
            visor.setForeground(Color.WHITE);
            visor.setEditable(false);
            
            // Configurando fonte monoespaçada para alinhamento correto
            Font fontMonoespacada = new Font("Courier New", Font.PLAIN, 24);
            visor.setFont(fontMonoespacada);
            
            visor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            painel.add(visor);

            // Adicionando o rótulo para formas de pagamento
            JLabel pagamentoLabel = new JLabel("Formas de Pagamento:");
            pagamentoLabel.setBounds(100, 920, 300, 30);
            Font fontePagamento = new Font("SansSerif", Font.BOLD, 24);
            pagamentoLabel.setFont(fontePagamento);
            painel.add(pagamentoLabel);

            // Textos e ações para os botões de pagamento
            String[] formasPagamento = { "PIX", "Cartão de Crédito", "Cartão de Débito" };
            int posicaoXInicial = 300;
            int espacamento = 250;

            for (int i = 0; i < formasPagamento.length; i++) {
                JButton botaoPagamento = new JButton(formasPagamento[i]);
                botaoPagamento.setBounds(posicaoXInicial + i * espacamento, 970, 200, 50);
                botaoPagamento.setBackground(Color.DARK_GRAY);
                botaoPagamento.setForeground(Color.WHITE);
                painel.add(botaoPagamento);

                // Ação dos botões
                String formaSelecionada = formasPagamento[i];
                botaoPagamento.addActionListener(e -> {
                    int resposta = JOptionPane.showConfirmDialog(null,
                            "Confirmar forma de pagamento: " + formaSelecionada + "?",
                            "Confirmar Pagamento",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null);
                    if (resposta == JOptionPane.YES_OPTION) {
                        // Gera o arquivo ao confirmar o pagamento
                        String pastaDocumentos = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
                        String nomeArquivo = ("Pedido_Mesa_" + (Mesa+1) + ".txt"); // Nome do arquivo usando o número da mesa
                        File pedido = new File(pastaDocumentos, nomeArquivo);
                        StringBuilder conteudo = new StringBuilder();
                        double totalGeral = 0;

                        // Formatação do texto para exibição e escrita no arquivo
                        String formatHeader = "%-30s %-10s %-10s %-20s\n";
                        String formatRow = "%-30s %-10d %-10.2f %-20s\n";
                        conteudo.append(String.format(formatHeader, "Nome", "Qtd", "Preço", "Observação"));

                        for (int ID = 0; ID < 12; ID++) {
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
                        conteudo.append(String.format("\n%-30s %10.2f", "Total Geral", totalGeral));

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pedido))) {
                            writer.write(conteudo.toString());
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo. Tente novamente.", "ERRO!" ,JOptionPane.PLAIN_MESSAGE, null);
                            ex.printStackTrace();
                        }
                        
                        JOptionPane.showMessageDialog(null, "Pagamento com " + formaSelecionada + " confirmado. Compra finalizada.", "Confirmação de Pagamento:" ,JOptionPane.PLAIN_MESSAGE, null);

                        // Zerar pedidos e voltar para a tela do salão
                        for (int ID = 0; ID < 12; ID++) {
                            Quantidade[ID][Mesa] = 0;
                            Obs[ID][Mesa] = "";
                        }
                        salao.atualizarTela(); // Atualiza a tela do salão

                        dispose(); // Fecha a janela do carrinho

                        // Fecha a tela inicial
                        if (telaInicial != null) {
                            telaInicial.dispose(); // Fecha a tela inicial
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Pagamento com " + formaSelecionada + " cancelado.", "Confirmação de Pagamento:" ,JOptionPane.PLAIN_MESSAGE, null);
                    }
                });
            }

            this.Mesa = mesa;

            // Exibe o total no visor com formatação ajustada
            StringBuilder conteudoExibido = new StringBuilder();
            double totalGeralExibido = 0;

            // Ajustando a formatação para alinhamento adequado
            String formatHeaderExibido = "%-30s %-10s %-10s %-20s\n";
            String formatRowExibido = "%-30s %-10d %-10.2f %-20s\n";
            conteudoExibido.append(String.format(formatHeaderExibido, "Nome", "Qtd", "Preço", "Observação"));

            for (int ID = 0; ID < 12; ID++) {
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
            conteudoExibido.append(String.format("\n%-36s %10.2f", "Total Geral", totalGeralExibido));
            visor.setText(conteudoExibido.toString());

            setVisible(true);
        }
    }
}
