package br.com.senai;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.loja.VendaController;
import br.com.senai.pessoa.Pessoa;
import br.com.senai.pessoa.PessoaController;
import br.com.senai.produto.Produto;
import br.com.senai.produto.ProdutoController;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		List<Pessoa> pessoas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<Produto>();
 
		PessoaController pessoaController = new PessoaController();
		ProdutoController produtoController = new ProdutoController();
		
		Produto produto = new Produto (
			"Maracujá",
			3.0,
			40,
			2.5 * 40
			);
		
		produtos.add(produto);
		
		boolean sair = false;

		do {
			menu();

			int opcao = pessoaController.leOpcao();

			switch(opcao){
				case 1:
					pessoas.add(pessoaController.cadastrarPessoa());
					break;

				case 2:
					pessoaController.listarPessoas(pessoas);
					break;
					
				case 3:
					pessoaController.editarPessoa(pessoas);
					break;
					
				case 4:
					pessoaController.excluirPessoa(pessoas);
					break;
					
				case 5:
					produtos.add(produtoController.cadastrarProduto());
					break;
					
				case 6:
					produtoController.listarProdutos(produtos);
					break;	
					
				case 7:
					produtoController.editarProduto(produtos);
					break;
					
				case 8:
					produtoController.excluirProduto(produtos);
					break;

				case 9:
					sair = true;
					break;

				default:
					System.out.println("Opção inválida!");
					break;
			}
		}while(!sair);

		System.out.println("Sistema finalizado!");
	}
	
	public static void menu(){
		System.out.println("\n--- MENU ---");
		System.out.println("1) Cadastrar pessoa");
		System.out.println("2) Listar pessoas cadastradas");
		System.out.println("3) Editar pessoas");
		System.out.println("4) Excluir pessoa");
		System.out.println("5) Cadastrar produto");
		System.out.println("6) Listar produtos");
		System.out.println("7) Editar produto");
		System.out.println("8) Excluir produto");
		System.out.println("9) Sair do sistema");
		System.out.println("-------------------");
	}

}
