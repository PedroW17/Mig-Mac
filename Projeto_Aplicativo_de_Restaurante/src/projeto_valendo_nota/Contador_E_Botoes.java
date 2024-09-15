package projeto_valendo_nota;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Contador_E_Botoes implements Pratos {
    private JPanel painel;
    private int contador;
    private int mesa;
    private int id;

    public Contador_E_Botoes(JPanel painel, int id, int mesa) {
        this.painel = painel;
        this.id = id;
        this.mesa = mesa;

        // Inicializa o contador com o valor armazenado
        this.contador = Quantidade[id][mesa]; // Carrega a quantidade existente

        // Fonte dos Botões e Contador
        Font fonte = new Font("Serif", Font.PLAIN, 12);

        // Contador de Quantidade
        JLabel contadorLabel = new JLabel(String.valueOf(contador));
        contadorLabel.setBounds(220, 117, 50, 50);
        contadorLabel.setFont(fonte);
        painel.add(contadorLabel);

        // Campo de Observação
        JTextField observacaoField = new JTextField(20);
        observacaoField.setBounds(10, 175, 300, 20);
        painel.add(observacaoField);
        observacaoField.setText(Obs[id][mesa]); // Carrega a observação existente
        observacaoField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                atualizarObservacao();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                atualizarObservacao();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                atualizarObservacao();
            }

            private void atualizarObservacao() {
                Obs[id][mesa] = observacaoField.getText();
            }
        });

        // Botão + (Adicionar)
        JButton botaoMais = new JButton("+");
        botaoMais.setBounds(240, 120, 42, 42);
        botaoMais.setBackground(Color.DARK_GRAY);
        botaoMais.setForeground(Color.WHITE);
        botaoMais.setFont(fonte);
        painel.add(botaoMais);
        botaoMais.addActionListener(e -> {
            contador++;
            Quantidade[id][mesa] = contador; // Atualiza a quantidade
            contadorLabel.setText(String.valueOf(contador));
        });

        // Botão - (Remover)
        JButton botaoMenos = new JButton("-");
        botaoMenos.setBounds(158, 120, 42, 42);
        botaoMenos.setBackground(Color.DARK_GRAY);
        botaoMenos.setForeground(Color.WHITE);
        botaoMenos.setFont(fonte);
        painel.add(botaoMenos);
        botaoMenos.addActionListener(e -> {
            if (contador > 0) {
                contador--;
                Quantidade[id][mesa] = contador; // Atualiza a quantidade
                contadorLabel.setText(String.valueOf(contador));
            }
        });

        // Definindo os nomes e preços dos pratos com base no ID
        switch (id) {
            case 0:
                Nomes[id][mesa] = "Bruschetta";
                Preco[id][mesa] = 50.00f;
                break;
            case 1:
                Nomes[id][mesa] = "Casca de Caranguejo";
                Preco[id][mesa] = 75.00f;
                break;
            case 2:
                Nomes[id][mesa] = "Bolinho de Pirarucu";
                Preco[id][mesa] = 55.00f;
                break;
            case 3:
                Nomes[id][mesa] = "Ratatouille";
                Preco[id][mesa] = 180.00f;
                break;
            case 4:
                Nomes[id][mesa] = "Risoto de Frutos do Mar";
                Preco[id][mesa] = 100.00f;
                break;
            case 5:
                Nomes[id][mesa] = "Medalhão de Filé Mignon";
                Preco[id][mesa] = 120.00f;
                break;
            case 6:
                Nomes[id][mesa] = "Tiramisu";
                Preco[id][mesa] = 60.00f;
                break;
            case 7:
                Nomes[id][mesa] = "Cheesecake";
                Preco[id][mesa] = 47.00f;
                break;
            case 8:
                Nomes[id][mesa] = "Brownie";
                Preco[id][mesa] = 47.00f;
                break;
            case 9:
                Nomes[id][mesa] = "Água";
                Preco[id][mesa] = 6.00f;
                break;
            case 10:
                Nomes[id][mesa] = "Refrigerante";
                Preco[id][mesa] = 9.00f;
                break;
            case 11:
                Nomes[id][mesa] = "Suco";
                Preco[id][mesa] = 12.00f;
                break;
        }
    }
}
