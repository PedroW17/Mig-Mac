package projeto_valendo_nota;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

public class Salao extends JFrame {

    public Salao() {
        // Configurações da Janela
        setSize(880, 1080);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criação do painel principal
        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(Color.white);
        add(painel);

        // Título "MigMac"
        JLabel MigMac = new JLabel("MigMac");
        painel.add(MigMac);
        MigMac.setBounds(0, 10, getWidth(), 60);
        MigMac.setHorizontalAlignment(SwingConstants.CENTER);
        Font fonteMigMac = new Font("Serif", Font.BOLD, 48);
        MigMac.setFont(fonteMigMac);
        MigMac.setForeground(Color.black);

        for (int i = 0; i < 9; i++) {
            int xPos = 100 + (i % 3) * 290;
            int yPos = 250 + (i / 3) * 250;

            // Criando o botão para cada Mesa
            JButton Mesa = new JButton(String.valueOf(i + 1)) {
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

            Mesa.setBounds(xPos, yPos, 100, 100);
            painel.add(Mesa);
            Mesa.setBackground(Color.black);
            Mesa.setForeground(Color.white);
            Mesa.setFont(new Font("Serif", Font.BOLD, 24));
            Mesa.setFocusPainted(false);
            Mesa.setOpaque(true);

            Mesa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String mesa = e.getActionCommand();
                    new Tela_inicial().new Janela(Integer.valueOf(mesa));
                }
            });

            // Adicionar um efeito de hover
            Mesa.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    Mesa.setBackground(new Color(0, 85, 153));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    Mesa.setBackground(new Color(0, 102, 204));
                }
            });
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Salao();
    }
}
