package projeto_valendo_nota;

public class Carrinho implements Pratos
{
	public Carrinho()
	{
		for(int ID = 0; ID <= 8; ID++)
		{
			System.out.println(Nomes[ID]);
			System.out.println(Quantidade[ID]);
			System.out.println(Preco[ID]);
		}
	}
}
