package projeto_valendo_nota;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Contador_E_Botoes
{
	// Cria a variável painel
	private JPanel painel;
	public int Contador = 0;
	
	public Contador_E_Botoes(JPanel painel, int i)
	{
		int ID = i+1;
		
		// Declara que a variável painel vai ser o JPanel pego em Tela_inicial
		this.painel = painel;
		
		//Fonte dos Botões e Contador
		Font fonte = new Font("Serif", Font.PLAIN, 12);
		
		// Contador de Quantidade
        JLabel contador = new JLabel(String.valueOf(0));
        contador.setBounds(220, 135, 50, 50);
        contador.setFont(fonte);
        painel.add(contador);
        
        // Botões pro contador
        JButton BotaoMais = new JButton("+");
        BotaoMais.setBounds(158, 138, 42, 42);
        BotaoMais.setBackground(Color.DARK_GRAY);
        BotaoMais.setForeground(Color.WHITE);
        BotaoMais.setFont(fonte);
        painel.add(BotaoMais);
        BotaoMais.addActionListener(new ActionListener()
        		{
        	public void actionPerformed(ActionEvent e)
        	{
        		Contador++;
        		contador.setText(String.valueOf(Contador));
        	}
        		});
        
        JButton BotaoMenos = new JButton("-");
        BotaoMenos.setBounds(240, 138, 42, 42);
        BotaoMenos.setBackground(Color.DARK_GRAY);
        BotaoMenos.setForeground(Color.WHITE);
        BotaoMenos.setFont(fonte);
        painel.add(BotaoMenos);
        BotaoMenos.addActionListener(new ActionListener()
        		{
        	public void actionPerformed(ActionEvent e)
        	{
        		if(Contador > 0)
        		{
        			Contador--;
        			contador.setText(String.valueOf(Contador));
        		}
        	}
        		});
	}
}
