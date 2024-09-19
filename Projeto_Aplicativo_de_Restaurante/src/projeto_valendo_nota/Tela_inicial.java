package projeto_valendo_nota;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tela_inicial {
    public class Janela extends JFrame {
        private int Mesa;

        public Janela(int mesa) {
            this.Mesa = mesa - 1;

            // Configurações da Janela
            setUndecorated(true);
            setSize(1280, 1080);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Criação do painel principal
            JPanel painel = new JPanel();
            painel.setLayout(null);
            painel.setBackground(Color.white);

            JScrollPane scrollPane = new JScrollPane(painel);

            // Definir a política para a barra de rolagem horizontal (nunca aparecer)
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            // Definir a política para a barra de rolagem vertical (aparecer quando necessário)
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            //Personalizar a barra de rolagem
            JScrollBar barra = scrollPane.getVerticalScrollBar();
            barra.setPreferredSize(new Dimension(10,0));
            barra.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = Color.DARK_GRAY; // Cor da barra
                    this.trackColor = Color.LIGHT_GRAY; // Cor do trilho
                }
            });

            scrollPane.getVerticalScrollBar().setUnitIncrement(70); // Velocidade ao rolar com a roda do mouse
            scrollPane.getVerticalScrollBar().setBlockIncrement(50); // Velocidade ao rolar com "Page Up/Down"
            add(scrollPane);

            
            // Título "MigMac"
            ImageIcon migmac = new ImageIcon(getClass().getResource("/Pratos/MIGMAC.jpg"));
            JLabel MigMac = new JLabel(migmac);
            painel.add(MigMac);
            MigMac.setBounds(500, 5, 300, 140);
            Font fonteMigMac = new Font("Serif", Font.BOLD, 48);
            MigMac.setFont(fonteMigMac);

            // Voltar
            ImageIcon voltar = new ImageIcon(getClass().getResource("/Pratos/Voltar.png"));
            JButton Voltar = new JButton(voltar);
            Voltar.setBounds(50, 10, 90, 90);
            Voltar.setBackground(Color.DARK_GRAY);
            painel.add(Voltar);
            Voltar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    Salao sala = Salao.getInstance();
                    sala.atualizarTela();
                }
            });

            // Carrinho
            ImageIcon Carrinho = new ImageIcon(getClass().getResource("/Pratos/Carrinho.png"));
            JButton carrinho = new JButton(Carrinho);
            carrinho.setBounds(1160, 10, 90, 90);
            carrinho.setBackground(Color.DARK_GRAY);
            carrinho.setForeground(Color.WHITE);
            painel.add(carrinho);
            carrinho.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new Carrinho_Tela(Salao.getInstance(), Tela_inicial.this).new Janela_Carrinho(Mesa);
                    Salao.getInstance().dispose();
                    dispose();
                }
            });

            // Adicionar seções e pratos
            adicionarSeçõesEPedidos(painel);

            // Ajusta o tamanho do painel principal para o tamanho necessário
            painel.setPreferredSize(new Dimension(1200, 1600)); // Ajustado para acomodar mais itens
            setVisible(true);
        }

        private void adicionarSeçõesEPedidos(JPanel painel) {
            // Exemplo de como adicionar seções e pratos
            adicionarSeção(painel, "ENTRADAS", 50, 150, new String[] {
                "/Pratos/Bruschetta.jpeg",
                "/Pratos/Casca de Caranguejo.jpeg",
                "/Pratos/Bolinho de Pirarucu.jpeg"
            }, new String[] {
                "Bruschetta - R$ 50,00",
                "Casca de Caranguejo - R$ 75,00", 
                "Bolinho de Pirarucu - R$ 55,00"
            }, new String[] {
                "Pão italiano, Tomate, Alho, Manjericão",
                "Caranguejo, Leite de coco, Pimentão, Farinha de rosca",
                "Pirarucu, Batata, Cebola, Pimenta"
            }, 0);

            adicionarSeção(painel, "PRATO PRINCIPAL", 50, 500, new String[] {
                "/Pratos/Ratattouile.jpeg",
                "/Pratos/Risoto de Frutos do Mar.jpeg",
                "/Pratos/Filé MIgnon.jpeg"
            }, new String[] {
                "Ratatouille - R$ 180,00",
                "Risotos frutos do mar - R$ 100,00",
                "Filé mignon - R$ 120,00"
            }, new String[] {
                "Berinjela, Abobrinha, Tomate, Pimentão",
                "Arroz, Frutos do mar variados, Caldo de peixe, Temperos diversos",
                "Filé mignon, Bacon, Sal, Pimenta-do-reino, Manteiga"
            }, 3);

            adicionarSeção(painel, "SOBREMESA", 50, 850, new String[] {
                "/Pratos/Tiramisú.jpeg",
                "/Pratos/Cheescake.jpeg",
                "/Pratos/Brownie.jpeg"
            }, new String[] {
                "Tiramisu - R$ 60,00",
                "Cheesecake - R$ 47,00",
                "Brownie - R$ 47,00"
            }, new String[] {
                "Mascarpone, Café, Cacau",
                "Queijo, Biscoito, Açúcar",
                "Chocolate, Manteiga, Nozes"
            }, 6);

            adicionarSeção(painel, "BEBIDAS", 50, 1200, new String[] {
                "/Pratos/Água.jpeg",
                "/Pratos/Refrigerante.jpeg",
                "/Pratos/Sucos.jpeg"
            }, new String[] {
                "Água - R$ 6,00",
                "Refrigerante - R$ 9,00",
                "Suco - R$ 12,00"
            }, new String[] {
                "Com gás, Sem gás",
                "Coca-cola, Guaraná, Fanta Uva, Sprite",
                "Maracujá, Laranja, Manga, Goiaba"
            }, 9);
        }

        private void adicionarSeção(JPanel painel, String título, int x, int y, String[] caminhosImagens, String[] nomes, String[] ingredientes, int offset) {
            JLabel seçãoLabel = new JLabel(título);
            painel.add(seçãoLabel);
            seçãoLabel.setBounds(x, y - 40, 300, 40); // Ajuste a posição para não sobrepor
            Font fonteSeção = new Font("Serif", Font.BOLD, 24);
            seçãoLabel.setFont(fonteSeção);

            int larguraImagem = 150;
            int alturaImagem = 150;
            int espacamento = 260; // Ajustado para mais espaçamento

            for (int i = 0; i < caminhosImagens.length; i++) {
                // Criando o painel para cada item
                JPanel painelItem = new JPanel();
                painelItem.setLayout(null);
                painelItem.setBounds(x + i * (larguraImagem + espacamento), y, 380, 200);
                painel.add(painelItem);
                
                // Pega os caminhos relativos das imagens
                ImageIcon pratos = new ImageIcon(getClass().getResource(caminhosImagens[i]));

                // Adicionando a imagem
                JLabel imagem = new JLabel();
                imagem.setBounds(0, 0, larguraImagem, alturaImagem);
                ImageIcon icone = new ImageIcon(pratos.getImage().getScaledInstance(larguraImagem, alturaImagem, Image.SCALE_SMOOTH));
                imagem.setIcon(icone);
                painelItem.add(imagem);

                // Adicionando o nome do prato
                JLabel nomePrato = new JLabel(nomes[i]);
                nomePrato.setBounds(larguraImagem + 10, 0, 210, 30);
                Font fonteNomePrato = new Font("Serif", Font.BOLD, 14);
                nomePrato.setFont(fonteNomePrato);
                painelItem.add(nomePrato);

                // Adicionando os ingredientes
                JLabel listaIngredientes = new JLabel("<html>" + ingredientes[i].replace(", ", "<br>") + "</html>");
                listaIngredientes.setBounds(larguraImagem + 10, 30, 150, 100);
                Font fonteIngredientes = new Font("Serif", Font.PLAIN, 12);
                listaIngredientes.setFont(fonteIngredientes);
                painelItem.add(listaIngredientes);

                // Contador de Quantidade
                new Contador_E_Botoes(painelItem, i + offset, Mesa);
            }
        }
    }

    public void dispose() {
        // Fechar a janela
    }
}
