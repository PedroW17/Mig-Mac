package projeto_valendo_nota;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Contador_E_Botoes implements Pratos
{
	// Cria a variável painel
	private JPanel painel;
	public int Contador = 0;
	int Mesa;
	
	public Contador_E_Botoes(JPanel painel, int i, int mesa)
	{
		this.Mesa = mesa;
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
        
        JTextField Observacao = new JTextField();
        Observacao.setBounds(10, 175, 300, 20);
        painel.add(Observacao);
        Observacao.getDocument().addDocumentListener(new DocumentListener()
        		{
        	@Override 
        	public void insertUpdate(DocumentEvent e)
        	{
        		atObs();
        	}
        	
        	@Override 
        	public void removeUpdate(DocumentEvent e)
        	{
        		atObs();
        	}
        	
        	@Override
        	public void changedUpdate(DocumentEvent e)
        	{
        		atObs();
        	}
        	
        	public void atObs()
        	{
        		
        		Obs[ID][Mesa] = Observacao.getText();
        	}
        		});
        
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
        		Quantidade[ID][Mesa] = Contador;
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
        			Quantidade[ID][Mesa] = Contador;
        			contador.setText(String.valueOf(Contador));
        		}
        	}
        		});
        
       switch(ID)
        {
        case 0:
        {
        	Nomes[ID][Mesa] = "Bruschetta";
        	Preco[ID][Mesa] = 50.00f;
        }
        break;
        
        case 1:
        {
        	Nomes[ID][Mesa] = "Casca de Caranguejo";
        	Preco[ID][Mesa] = 75.00f;
        }
        break;
        
        case 2:
        {
        	Nomes[ID][Mesa] = "Bolinho de Pirarucu";
        	Preco[ID][Mesa] = 55.00f;
        }
        break;
        
        case 3:
        {
        	Nomes[ID][Mesa]= "Ratatouille";
        	Preco[ID][Mesa] = 180.00f;
        }
        break;
        
        case 4:
        { 
        	Nomes[ID][Mesa] = "Risotos de frutos do mar";
        	Preco[ID][Mesa] = 10.00f;
        }
        break;
        
        case 5:
        {
        	Nomes[ID][Mesa] = "Medalhão de filé mignon";
        	Preco[ID][Mesa] = 10.00f;
        }
        break;
        
        case 6:
        { 
        	Nomes[ID][Mesa] = "Tiramisu";
        	Preco[ID][Mesa] = 60.00f;
        }
        break;
        
        case 7:
        {
        	Nomes[ID][Mesa] = "Cheesecake";
        	Preco[ID][Mesa] = 47.00f;
        }
        break;
        
        case 8:
        {
        	Nomes[ID][Mesa] = "Brownie";
        	Preco[ID][Mesa] = 47.00f;
        }
        break;
        
        case 9:
        {
        	Nomes[ID][Mesa] = "Água";
        	Preco[ID][Mesa] = 6.00f;
        }
        break;
        
        case 10:
        {
        	Nomes[ID][Mesa] = "Refrigerante";
        	Preco[ID][Mesa] = 9.00f;
        }
        break;
        
        case 11:
        {
        	Nomes[ID][Mesa] = "Suco";
        	Preco[ID][Mesa] = 12.00f;
        }
        break;
        }
	}
}
