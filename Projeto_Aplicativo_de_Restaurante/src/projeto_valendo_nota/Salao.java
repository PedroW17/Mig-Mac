package projeto_valendo_nota;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class Salao extends JFrame implements Pratos 
{
    private static Salao instance;
    private JPanel painel;
    private JButton[] botoesMesa;

    public static Salao getInstance() 
    {
        if (instance == null) {
            instance = new Salao();
        }
        return instance;
    }

    private Salao() {
        // Configurações da Janela
        setSize(1280, 1080);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criação do painel principal
        painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(Color.white);
        add(painel);

        // Título "MigMac"
        JLabel MigMac = new JLabel("MigMac");
        MigMac.setBounds(0, 10, getWidth(), 60);
        MigMac.setHorizontalAlignment(SwingConstants.CENTER);
        Font fonteMigMac = new Font("Serif", Font.BOLD, 48);
        MigMac.setFont(fonteMigMac);
        MigMac.setForeground(Color.black);
        painel.add(MigMac);

        botoesMesa = new JButton[9];
        for (int i = 0; i < 9; i++) {
            int xPos = 300 + (i % 3) * 290;
            int yPos = 250 + (i / 3) * 250;

            // Criando o botão para cada Mesa
            botoesMesa[i] = new JButton(String.valueOf(i + 1)) { 
                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setColor(getBackground());
                    g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                    super.paintComponent(g);
                    g2d.dispose();
                }

                @Override
                public void updateUI() {
                    super.updateUI();
                    setContentAreaFilled(false);
                    setBorder(BorderFactory.createEmptyBorder());
                }
            };

            botoesMesa[i].setBounds(xPos, yPos, 100, 100);
            painel.add(botoesMesa[i]);
            botoesMesa[i].setBackground(Color.BLACK);
            botoesMesa[i].setForeground(Color.WHITE);
            botoesMesa[i].setFont(new Font("Serif", Font.BOLD, 24));
            botoesMesa[i].setFocusPainted(false);
            botoesMesa[i].setOpaque(true);

            final int mesa = i; // Necessário para o ActionListener

            botoesMesa[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Tela_inicial telaInicial = new Tela_inicial();
                    telaInicial.new Janela(mesa + 1); // Passa o número da mesa para Tela_inicial
                    dispose();// Oculta a janela Salao
                }
            });
        }

        // Atualiza as cores das mesas ao inicializar
        atualizarCoresMesas();

        setVisible(true);
    }

    // Método para atualizar a cor dos botões de mesa
    public void atualizarCoresMesas() {
        for (int mesa = 0; mesa < 9; mesa++) {
            boolean temPedido = false;

            // Verifica se há algum pedido na mesa
            for (int ID = 0; ID < 12; ID++) {
                if (Quantidade[ID][mesa] > 0) {
                    temPedido = true;
                    break; // Se encontrar um pedido, pode parar a verificação
                }
            }

            // Se houver pedidos, muda a cor do botão para vermelho
            if (temPedido) {
                botoesMesa[mesa].setBackground(Color.RED); // Indica que há pedidos
            } else {
                botoesMesa[mesa].setBackground(Color.BLACK); // Cor padrão para mesas sem pedidos
            }
        }
    }

    // Método para atualizar a tela quando voltar
    public void atualizarTela() {
        atualizarCoresMesas();
        setVisible(true); // Garante que a tela está visível
    }

    public static void main(String[] args) {
        new Salao();
    }
}
