package projeto_valendo_nota;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Salao extends JFrame
{
	int i;
	public Salao()
	{
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
        MigMac.setBounds(370, 5, 300, 100);
        Font fonteMigMac = new Font("Serif", Font.BOLD, 48);
        MigMac.setFont(fonteMigMac);
        
        for(i = 0; i <= 8; i++)
        {
        	int xPos = 100 + (i % 3) * 290;
            int yPos = 250 + (i / 3) * 250;
            
        	// Criando o painel para cada Mesa
            JButton Mesa = new JButton(String.valueOf(i+1));
            Mesa.setLayout(null);
            Mesa.setBounds(xPos, yPos, 100, 100);
            painel.add(Mesa);
            Mesa.setBackground(Color.white);
            Mesa.setForeground(Color.black);
            Mesa.addActionListener(new ActionListener()
            		{
            	@Override
            	public void actionPerformed(ActionEvent e)
            	{
            		String mesa = e.getActionCommand();
            		new Tela_inicial().new Janela(Integer.valueOf(mesa));
            	}
            		});
        }
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
        new Salao();
    }
}
