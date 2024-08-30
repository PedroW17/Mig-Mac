package projeto_valendo_nota;
import java.awt.*;
import javax.swing.*;

public class Contador_E_Botoes extends JPanel
{
	public Contador_E_Botoes()
	{
		// Contador de Quantidade
        JLabel contadorE = new JLabel(String.valueOf(0));
        contadorE.setBounds(220, 135, 50, 50);
        
        // Botões pro contador
        JButton BotaoMaisE = new JButton("+");
        BotaoMaisE.setBounds(158, 138, 42, 42);
        BotaoMaisE.setBackground(Color.DARK_GRAY);
        BotaoMaisE.setForeground(Color.WHITE);
        
        JButton BotaoMenosE = new JButton("-");
        BotaoMenosE.setBounds(240, 138, 42, 42);
        BotaoMenosE.setBackground(Color.DARK_GRAY);
        BotaoMenosE.setForeground(Color.WHITE);
	}
}
