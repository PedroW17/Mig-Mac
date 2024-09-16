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

            scrollPane.getVerticalScrollBar().setUnitIncrement(70); // Velocidade ao rolar com a roda do mouse
            scrollPane.getVerticalScrollBar().setBlockIncrement(50); // Velocidade ao rolar com "Page Up/Down"
            add(scrollPane);

            // Título "MigMac"
            JLabel MigMac = new JLabel("MigMac");
            painel.add(MigMac);
            MigMac.setBounds(545, 5, 300, 100);
            Font fonteMigMac = new Font("Serif", Font.BOLD, 48);
            MigMac.setFont(fonteMigMac);

            // Voltar
            JButton Voltar = new JButton("Voltar");
            Voltar.setBounds(1120, 10, 100, 100);
            painel.add(Voltar);
            Voltar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    Salao sala = Salao.getInstance();
                    sala.atualizarTela();
                }
            });

            // Carrinho
            JButton carrinho = new JButton("Carrinho");
            carrinho.setBounds(10, 10, 100, 100);
            painel.add(carrinho);
            carrinho.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new Carrinho_Tela(Salao.getInstance(), Tela_inicial.this).new Janela_Carrinho(Mesa);
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
                "Bruschetta.jpg",
                "C:\\Users\\tobia\\casquinha-de-caranguejo.jpg",
                "C:\\Users\\tobia\\bolinho-de-pirarucu.jpg"
            }, new String[] {
                "Bruschetta",
                "Casca de Caranguejo", 
                "Bolinho de Pirarucu"
            }, new String[] {
                "Pão italiano, Tomate, Alho, Manjericão",
                "Caranguejo, Leite de coco, Pimentão, Farinha de rosca",
                "Pirarucu, Batata, Cebola, Pimenta"
            }, 0);

            adicionarSeção(painel, "PRATO PRINCIPAL", 50, 500, new String[] {
                "C:\\Users\\tobia\\Ratatouille.jpg",
                "C:\\Users\\tobia\\Risotos_de_frutos_mar.jpg",
                "C:\\Users\\tobia\\filé_mignon.jpg"
            }, new String[] {
                "Ratatouille",
                "Risotos frutos do mar",
                "Filé mignon"
            }, new String[] {
                "Berinjela, Abobrinha, Tomate, Pimentão",
                "Arroz, Frutos do mar variados, Caldo de peixe, Temperos diversos",
                "Filé mignon, Bacon, Sal, Pimenta-do-reino, Manteiga"
            }, 3);

            adicionarSeção(painel, "SOBREMESA", 50, 850, new String[] {
                "C:\\Users\\tobia\\Tiramisu.jpg",
                "C:\\Users\\tobia\\cheesecake.jpg",
                "C:\\Users\\tobia\\brownie.jpg"
            }, new String[] {
                "Tiramisu",
                "Cheesecake",
                "Brownie"
            }, new String[] {
                "Mascarpone, Café, Cacau",
                "Queijo, Biscoito, Açúcar",
                "Chocolate, Manteiga, Nozes"
            }, 6);

            adicionarSeção(painel, "BEBIDAS", 50, 1200, new String[] {
                "C:\\Users\\tobia\\agua.jpg",
                "C:\\Users\\tobia\\Refrigerante.jpg",
                "C:\\Users\\tobia\\Suco.jpg"
            }, new String[] {
                "Água",
                "Refrigerante",
                "Suco"
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
            int espacamento = 200; // Ajustado para mais espaçamento

            for (int i = 0; i < caminhosImagens.length; i++) {
                // Criando o painel para cada item
                JPanel painelItem = new JPanel();
                painelItem.setLayout(null);
                painelItem.setBounds(x + i * (larguraImagem + espacamento), y, 320, 200);
                painel.add(painelItem);

                // Adicionando a imagem
                JLabel imagem = new JLabel();
                imagem.setBounds(0, 0, larguraImagem, alturaImagem);
                ImageIcon icone = new ImageIcon(new ImageIcon(caminhosImagens[i]).getImage().getScaledInstance(larguraImagem, alturaImagem, Image.SCALE_SMOOTH));
                imagem.setIcon(icone);
                painelItem.add(imagem);

                // Adicionando o nome do prato
                JLabel nomePrato = new JLabel(nomes[i]);
                nomePrato.setBounds(larguraImagem + 10, 0, 150, 30);
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
