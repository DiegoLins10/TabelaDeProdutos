import javax.swing.JOptionPane;

/**
 *
 * @author tecnico
 */
public class Teste {
	public static void main(String[] args) {
		ListaLigada lc = new ListaLigada();
		int a, b, nome;
		String msg;
		Produto r;
		int op = 0;

		while (op != 4) {
			op = Integer.parseInt(JOptionPane.showInputDialog(
					"Menu de opções\n1 - Adicionar produto\n2- Remover produto\n3 - Exibir produtos\n4 - Sair"));
			switch (op) {
			case 1:
				a = Integer.parseInt((JOptionPane.showInputDialog("Informe o numero do produto: ")));
				b = Integer.parseInt((JOptionPane.showInputDialog("Informe o numero do produto: ")));
				lc.adicionaFinal(new Produto(a, b));
				break;
			case 2:
				nome = Integer.parseInt((JOptionPane.showInputDialog("Informe o numero do produto: ")));
				
				r = lc.remove(nome);
				System.out.println("O contato:\n" + r + "\nfoi removido da lista!");
				break;
			case 3:
				msg = lc.toString();
				if (msg.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Lista vazia!");
				} else {
					JOptionPane.showMessageDialog(null, msg);
				}
				break;
			}
		}
	}
}
