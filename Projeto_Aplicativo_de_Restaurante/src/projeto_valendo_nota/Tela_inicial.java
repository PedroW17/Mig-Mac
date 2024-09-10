package projeto_valendo_nota;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tela_inicial {
    public class Janela extends JFrame {
        int Mesa;
		public Janela(int mesa) {
        	this.Mesa = mesa;
        	Mesa = Mesa-1;
        	int i = 0;
            // Configurações da Janela
            setUndecorated(true);
            setSize(1280,1080);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            
            // Criação do painel principal
            JPanel painel = new JPanel();
            painel.setLayout(null);
            painel.setBackground(Color.white);

            // Adiciona o painel principal a um JScrollPane
            JScrollPane scrollPane = new JScrollPane(painel);
            scrollPane.getVerticalScrollBar().setUnitIncrement(10);
            add(scrollPane);

            // Título "MigMac"
            JLabel MigMac = new JLabel("MigMac");
            painel.add(MigMac);
            MigMac.setBounds(545, 5, 300, 100);
            Font fonteMigMac = new Font("Serif", Font.BOLD, 48);
            MigMac.setFont(fonteMigMac);

            // Título "ENTRADAS"
            JLabel Entradas = new JLabel("ENTRADAS");
            painel.add(Entradas);
            Entradas.setBounds(100, 100, 300, 100);
            Font fonteEntradas = new Font("Serif", Font.BOLD, 20);
            Entradas.setFont(fonteEntradas);    
            
            //Comanda
            JButton Comanda = new JButton ("Comanda");
            Comanda.setBounds(150,10,100,100);
            painel.add(Comanda);
            
            
            
            
            
            
            
            
            //Carrinho
            JButton carrinho = new JButton("Carrinho");
            carrinho.setBounds(10, 10, 100, 100);
            painel.add(carrinho);
            carrinho.addActionListener(new ActionListener()
            		{
            	public void actionPerformed(ActionEvent e)
            	{
            		new Carrinho_Tela().new Janela_Carrinho(Mesa);
            	}
            		});
            
            // Configurações das entradas
            String[] caminhosImagens = {
                "C:\\Users\\docinho\\Bruschetta.jpg",                 //tá errado
                "C:\\Users\\docinho\\casquinha-de-caranguejo.jpg",   //tá errado
                "C:\\Users\\docinho\\bolinho-de-pirarucu.jpg"       //tá errado
            };

            String[] nomesPratos = {
                "Bruschetta",
                "Casca de Caranguejo", 
                "Bolinho de Pirarucu"
            };

            String[] ingredientes = {
                "Pão italiano, Tomate, Alho, Manjericão",
                "Caranguejo, Leite de coco, Pimentão, Farinha de rosca",
                "Pirarucu, Batata, Cebola, Pimenta"
            };

            int larguraImagem = 150;
            int alturaImagem = 150;
            int espacamento = 250;
            int posicaoInicialX = 100;
            int posicaoY = 200;

            for (i = 0; i < caminhosImagens.length; i++) {
                // Criando o painel para cada entrada
                JPanel painelEntrada = new JPanel();
                painelEntrada.setLayout(null);
                painelEntrada.setBounds(posicaoInicialX + i * (larguraImagem + espacamento), posicaoY, 300, 200);
                painel.add(painelEntrada);

                // Adicionando a imagem
                JLabel imagem = new JLabel();
                imagem.setBounds(0, 0, larguraImagem, alturaImagem);
                ImageIcon icone = new ImageIcon(new ImageIcon(caminhosImagens[i]).getImage().getScaledInstance(larguraImagem, alturaImagem, Image.SCALE_SMOOTH));
                imagem.setIcon(icone);
                painelEntrada.add(imagem);

                // Adicionando o nome do prato
                JLabel nomePrato = new JLabel(nomesPratos[i]);
                nomePrato.setBounds(larguraImagem + 10, 0, 150, 30);
                Font fonteNomePrato = new Font("Serif", Font.BOLD, 14);
                nomePrato.setFont(fonteNomePrato);
                painelEntrada.add(nomePrato);

                // Adicionando os ingredientes
                JLabel listaIngredientes = new JLabel("<html>" + ingredientes[i].replace(", ", "<br>") + "</html>");
                listaIngredientes.setBounds(larguraImagem + 10, 20, 150, 100);
                Font fonteIngredientes = new Font("Serif", Font.PLAIN, 12);
                listaIngredientes.setFont(fonteIngredientes);
                painelEntrada.add(listaIngredientes);
                
                // Contador de Quantidade
                new Contador_E_Botoes(painelEntrada, i, Mesa);
            }

            // Título "PRATO PRINCIPAL"
            JLabel PratoPrincipal = new JLabel("PRATO PRINCIPAL");
            painel.add(PratoPrincipal);
            PratoPrincipal.setBounds(120, 450, 300, 100);
            PratoPrincipal.setFont(fonteEntradas);

            // Configurações dos pratos principais
            String[] caminhosImagensPP = {
                "C:\\Users\\docinho\\Ratatouille.jpg",   //tá errado
                "C:\\Users\\docinho\\prato2.jpg",       //tá errado
                "C:\\Users\\docinho\\prato3.jpg"       //tá errado
            };

            String[] nomesPratosPP = {
                "Ratatouille",
                "Risotos de frutos do mar",
                "Medalhão de filé mignon com bacon"
            };

            String[] ingredientesPP = {
                "Berinjela, Abobrinha, Tomate, Pimentão",
                "Arroz, Frutos do mar variados, Caldo de peixe, Temperos diversos ",
                "Filé mignon, Bacon, Sal, Pimenta-do-reino, Manteiga"
            };

            int larguraImagemPP = 150;
            int alturaImagemPP = 150;
            int espacamentoPP = 250;
            int posicaoInicialXPP = 100;
            int posicaoYPP = 550;

            for (i = 0; i < caminhosImagensPP.length; i++) {
                // Criando o painel para cada prato principal
                JPanel painelPrincipal = new JPanel();
                painelPrincipal.setLayout(null);
                painelPrincipal.setBounds(posicaoInicialXPP + i * (larguraImagemPP + espacamentoPP), posicaoYPP, 300, 200);
                painel.add(painelPrincipal);

                // Adicionando a imagem
                JLabel imagemPP = new JLabel();
                imagemPP.setBounds(0, 0, larguraImagemPP, alturaImagemPP);
                ImageIcon iconePP = new ImageIcon(new ImageIcon(caminhosImagensPP[i]).getImage().getScaledInstance(larguraImagemPP, alturaImagemPP, Image.SCALE_SMOOTH));
                imagemPP.setIcon(iconePP);
                painelPrincipal.add(imagemPP);

                // Adicionando o nome do prato
                JLabel nomePratoPP = new JLabel(nomesPratosPP[i]);
                nomePratoPP.setBounds(larguraImagemPP + 10, 0, 150, 30);
                Font fonteNomePratoPP = new Font("Serif", Font.BOLD, 14);
                nomePratoPP.setFont(fonteNomePratoPP);
                painelPrincipal.add(nomePratoPP);

                // Adicionando os ingredientes
                JLabel listaIngredientesPP = new JLabel("<html>" + ingredientesPP[i].replace(", ", "<br>") + "</html>");
                listaIngredientesPP.setBounds(larguraImagemPP + 10, 20, 150, 100);
                Font fonteIngredientesPP = new Font("Serif", Font.PLAIN, 12);
                listaIngredientesPP.setFont(fonteIngredientesPP);
                painelPrincipal.add(listaIngredientesPP);
                
                // Contador de Quantidade
                new Contador_E_Botoes(painelPrincipal, i+3, Mesa);
            }

            // Título "SOBREMESA"
            JLabel Sobremesa = new JLabel("SOBREMESA");
            painel.add(Sobremesa);
            Sobremesa.setBounds(100, 800, 300, 100);
            Sobremesa.setFont(fonteEntradas);

            // Configurações das sobremesas
            String[] caminhosImagensS = {
                "C:\\Users\\docinho\\Tiramisu.jpg",
                "C:\\Users\\docinho\\cheesecake.jpg",
                "C:\\Users\\docinho\\brownie.jpg"
            };

            String[] nomesPratosS = {
                "Tiramisu",
                "Cheesecake",
                "Brownie"
            };

            String[] ingredientesS = {
                "Mascarpone, Café, Cacau",
                "Queijo, Biscoito, Açúcar",
                "Chocolate, Manteiga, Nozes"
            };

            int larguraImagemS = 150;
            int alturaImagemS = 150;
            int espacamentoS = 250;
            int posicaoInicialXS = 100;
            int posicaoYS = 900;

            for (i = 0; i < caminhosImagensS.length; i++) {
                // Criando o painel para cada sobremesa
                JPanel painelSobremesa = new JPanel();
                painelSobremesa.setLayout(null);
                painelSobremesa.setBounds(posicaoInicialXS + i * (larguraImagemS + espacamentoS), posicaoYS, 300, 200);
                painel.add(painelSobremesa);

                // Adicionando a imagem
                JLabel imagemS = new JLabel();
                imagemS.setBounds(0, 0, larguraImagemS, alturaImagemS);
                ImageIcon iconeS = new ImageIcon(new ImageIcon(caminhosImagensS[i]).getImage().getScaledInstance(larguraImagemS, alturaImagemS, Image.SCALE_SMOOTH));
                imagemS.setIcon(iconeS);
                painelSobremesa.add(imagemS);

                // Adicionando o nome do prato
                JLabel nomePratoS = new JLabel(nomesPratosS[i]);
                nomePratoS.setBounds(larguraImagemS + 10, 0, 150, 30);
                Font fonteNomePratoS = new Font("Serif", Font.BOLD, 14);
                nomePratoS.setFont(fonteNomePratoS);
                painelSobremesa.add(nomePratoS);

                // Adicionando os ingredientes
                JLabel listaIngredientesS = new JLabel("<html>" + ingredientesS[i].replace(", ", "<br>") + "</html>");
                listaIngredientesS.setBounds(larguraImagemS + 10, 20, 150, 100);
                Font fonteIngredientesS = new Font("Serif", Font.PLAIN, 12);
                listaIngredientesS.setFont(fonteIngredientesS);
                painelSobremesa.add(listaIngredientesS);
                
                // Contador de Quantidade
                new Contador_E_Botoes(painelSobremesa, i+6, Mesa);
            }
            

            // Ajusta o tamanho do painel principal para o tamanho necessário
            painel.setPreferredSize(new Dimension(1200, 1200)); // Ajuste conforme necessário        
            setVisible(true);
        }
    }
}