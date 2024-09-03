package projeto_valendo_nota;

public class Carrinho
{
	int ID;
	int contador;
	String nomesPratos = "";
	
	public void Lista(int id, int contador)
	{
		this.ID = id;
		this.contador = contador;
		
		
		if(contador > 1)
		{
			switch(ID)
			{
			case 1:
			{
				nomesPratos = nomesPratos + "- " + "Bruschetta x" + contador + "\n";
			}
			break;
			
			case 2:
			{
				nomesPratos = nomesPratos + "- " + "Casca de Caranguejo x" + contador + "\n";
			}
			break;
			
			case 3:
			{
				nomesPratos = nomesPratos + "- " + "Bolinho de Pirarucu x" + contador + "\n";
			}
			break;
			
			case 4:
			{
				nomesPratos = nomesPratos + "- " + "Ratatouille x" + contador + "\n";
			}
			break;
			
			case 5:
			{
				nomesPratos = nomesPratos + "- " + "Prato 2 x" + contador + "\n";
			}
			break;
			
			case 6:
			{
				nomesPratos = nomesPratos + "- " + "Prato 3 x" + contador + "\n"; 
			}
			break;
			
			case 7:
			{
				nomesPratos = nomesPratos + "- " + "Tiramisu x" + contador + "\n";
			}
			break;
			
			case 8:
			{
				nomesPratos = nomesPratos + "- " + "Cheesecake x" + contador + "\n";
			}
			break;
			
			case 9:
			{
				nomesPratos = nomesPratos + "- " + "Brownie x" + contador + "\n";
			}
			break;
			}
		}
	}
	
	public void ExibirCarrinho()
	{
		System.out.println(nomesPratos);
	}
}
