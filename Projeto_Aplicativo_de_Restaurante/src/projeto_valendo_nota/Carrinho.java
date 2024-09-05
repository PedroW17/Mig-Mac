package projeto_valendo_nota;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Carrinho implements Pratos{
	public Carrinho()
	{
		CarrinhoFinal();
	}
    public void CarrinhoFinal() {
        String diretorio = "C:\\Users\\ALN\\Documents\\"; // Especifique o lugar para colocar o arquivo
        String nomeArquivo = diretorio + "Pedido.txt"; 
        StringBuilder conteudo = new StringBuilder(); //armazenar as linhas 
        double totalGeral = 0; 

        for (int ID = 0; ID <= 8; ID++) {
            double total = Quantidade[ID] * Preco[ID];
            
            if (total > 0) {
                conteudo.append(Nomes[ID]).append("\t")  // para separar em colunas
                        .append(Quantidade[ID]).append("\t")
                        .append(Preco[ID]).append("\t")
                        .append(Obs[ID]).append("\t")
                        .append(total).append("\n");

                
                totalGeral += total;
                
                System.out.println("Nome: " + Nomes[ID]);
                System.out.println("Quantidade: " + Quantidade[ID]);
                System.out.println("Preço: " + Preco[ID]);
                System.out.println("Observação: " + Obs[ID]);
                System.out.println("Total: " + total);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            
        	// Cabeçalho da saida
            writer.write("Nome\tQuantidade\tPreço\tTotal");
            writer.newLine();

            // Escreve o conteúdo gerado no arquivo
            writer.write(conteudo.toString());

            // Escreve o total do preço
            writer.write("\nTotal Geral\t\t\t" + totalGeral);
            System.out.println("Total Geral: " + totalGeral);
            System.out.println("Arquivo criado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
