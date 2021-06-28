package br.com.senai;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.loja.Venda;
import br.com.senai.loja.VendaController;
import br.com.senai.pessoa.Pessoa;
import br.com.senai.pessoa.PessoaController;
import br.com.senai.produto.Produto;
import br.com.senai.produto.ProdutoController;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		List<Pessoa> pessoas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<Produto>();
		List<Venda> vendas = new ArrayList<Venda>();
		
		ProdutoController produtoController = new ProdutoController();
		PessoaController pessoaController = new PessoaController();
		VendaController vendaController = new VendaController();
		
		boolean sair = false;

		do {
			System.out.println("\n------ MENU -------");
			System.out.println("1) Pessoa");
			System.out.println("2) Produto");
			System.out.println("3) Vendas");
			System.out.println("4) Sair do sistema");
			System.out.println("------------------------------");
			
			int opcao = pessoaController.leOpcao();
			
			switch(opcao){
			case 1:
				pessoaController.menu(pessoas);
				break;

			case 2:
				produtoController.menu(produtos);
				break;
					
			case 3:
				vendaController.menu(vendas,produtos,pessoas);
				break;
					
			case 4:
				sair = true;
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while(!sair);

		System.out.println("Sistema finalizado!");
		
		}
		
	}