package projeto_valendo_nota;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Contador_E_Botoes implements Pratos
{
	// Cria a variável painel
	private JPanel painel;
	public int Contador = 0;
	
	public Contador_E_Botoes(JPanel painel, int i)
	{
		int ID = i;
		
		// Declara que a variável painel vai ser o JPanel pego em Tela_inicial
		this.painel = painel;
		
		//Fonte dos Botões e Contador
		Font fonte = new Font("Serif", Font.PLAIN, 12);
		
		// Contador de Quantidade
        JLabel contador = new JLabel(String.valueOf(0));
        contador.setBounds(220, 117, 50, 50);
        contador.setFont(fonte);
        painel.add(contador);
        
        // Botões pro contador
        JButton BotaoMais = new JButton("+");
        BotaoMais.setBounds(240, 120, 42, 42);
        BotaoMais.setBackground(Color.DARK_GRAY);
        BotaoMais.setForeground(Color.WHITE);
        BotaoMais.setFont(fonte);
        painel.add(BotaoMais);
        BotaoMais.addActionListener(new ActionListener()
        		{
        	public void actionPerformed(ActionEvent e)
        	{
        		Contador++;
        		Quantidade[ID] = Contador;
        		contador.setText(String.valueOf(Contador));
        	}
        		});
        
        JButton BotaoMenos = new JButton("-");
        BotaoMenos.setBounds(158, 120, 42, 42);
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
        			Quantidade[ID] = Contador;
        			contador.setText(String.valueOf(Contador));
        		}
        	}
        		});
        
        JTextField Observacao = new JTextField();
        Observacao.setBounds(1, 175, 300, 20);
        painel.add(Observacao);
        Obs[ID] = String.valueOf(Observacao.getText());
        
        switch(ID)
        {
        case 0:
        {
        	Nomes[ID] = "Bruschetta";
        	Preco[ID] = 50.00f;
        }
        break;
        
        case 1:
        {
        	Nomes[ID] = "Casca de Caranguejo";
        	Preco[ID] = 75.00f;
        }
        break;
        
        case 2:
        {
        	Nomes[ID] = "Bolinho de Pirarucu";
        	Preco[ID] = 55.00f;
        }
        break;
        
        case 3:
        {
        	Nomes[ID] = "Ratatouille";
        	Preco[ID] = 180.00f;
        }
        break;
        
        case 4:
        { 
        	Nomes[ID] = "Risotos de frutos do mar";
        	Preco[ID] = 10.00f;
        }
        break;
        
        case 5:
        {
        	Nomes[ID] = "Medalhão de filé mignon com bacon";
        	Preco[ID] = 10.00f;
        }
        break;
        
        case 6:
        {
        	Nomes[ID] = "Tiramisu";
        	Preco[ID] = 60.00f;
        }
        break;
        
        case 7:
        {
        	Nomes[ID] = "Cheesecake";
        	Preco[ID] = 47.00f;
        }
        break;
        
        case 8:
        {
        	Nomes[ID] = "Brownie";
        	Preco[ID] = 47.00f;
        }
        break;
        }
	}
}
