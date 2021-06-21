package br.com.senai.pessoa;

import java.util.List;
import java.util.Scanner;

import br.com.senai.endereco.Endereco;
import br.com.senai.pessoa.Pessoa;

public class PessoaController {

	private Scanner tec;

	public PessoaController(){
		tec = new Scanner(System.in);
	}

	public int leOpcao(){
		System.out.print("> ");
		return tec.nextInt();
	}

	public Pessoa cadastrarPessoa(){
		Pessoa pessoa = new Pessoa();

		System.out.println("--- CADASTRAR PESSOA ---");
		System.out.print("Informe o nome: ");
		tec.nextLine();
		pessoa.setNome(tec.nextLine());

		System.out.print("Informe o ano de nascimento: ");
		pessoa.setAnoDeNascimento(tec.nextInt());

		System.out.print("Informe a altura: ");
		pessoa.setAltura(tec.nextDouble());
		
		System.out.print("Informe o pais: ");
		tec.nextLine();
		pessoa.setNomeDopais(tec.nextLine());
		
		return pessoa;
	}

	public List<Pessoa> listarPessoas(List<Pessoa> pessoas){
		
		if(pessoas.isEmpty()) {
			System.out.println("Não possui pessoas cadastradas.");
			return null;
		}
		
		System.out.println("--- PESSOAS CADASTRADAS ---");

		System.out.printf("| %2s | %20s | %4s | %5s | %6s | %10s |\n",
				"ID","Nome", "Ano", "Idade", "Altura", "Pais");

		for(int i = 0; i < pessoas.size(); i++){
			System.out.printf("| %2d | %20s | %4d | %5d | %6.2f | %10s |\n",
					i,
					pessoas.get(i).getNome(),
					pessoas.get(i).getAnoDeNascimento(),
					pessoas.get(i).getIdade(),
					pessoas.get(i).getAltura(),
					pessoas.get(i).getNomeDopais());
		}

		return pessoas;
	}
	
	public Endereco cadEndereco() {
		Endereco endereco = new Endereco();
		return endereco;
	}
	 
	public List<Pessoa> editarPessoa(List<Pessoa> pessoas) {
		Pessoa pessoa = new Pessoa();
		listarPessoas(pessoas);
		
		if(pessoas.isEmpty()) {
			return null;
		}
		
		System.out.print("Informe o Id da pessoa para editar: ");
		int idPessoa = tec.nextInt();
		
		System.out.println("1) Nome da pessoa");
		System.out.println("2) Nascimento");
		System.out.println("3) Altura");
		System.out.print("Informe o campo para ser editado: ");
		int opcao = tec.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.println("--- EDITAR NOME DA PESSOA ---");
			System.out.print("Informe o novo correto da pessoa: ");
			pessoa.setNome(tec.next());
			
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			pessoa.setIdade(pessoas.get(idPessoa).getIdade());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			
			pessoas.set(idPessoa, pessoa);
			break;

		case 2:
			System.out.println("---------EDITAR ANO DE NASCIMENTO---------");
			System.out.println("Informe o ano correto de nascimento: ");
			pessoa.setAnoDeNascimento(tec.nextInt());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setIdade(pessoas.get(idPessoa).getIdade());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			
			pessoas.set(idPessoa, pessoa);
			break;
			
		case 3:
			System.out.println("---------EDITAR ALTURA---------");
			System.out.println("Informe o ano correto de nascimento: ");
			pessoa.setAltura(tec.nextDouble());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setIdade(pessoas.get(idPessoa).getIdade());
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			
			pessoas.set(idPessoa, pessoa);
			break;

		default:
			System.out.println("Opção inválida!");
			break;
		}
		return pessoas;
		
	}
	
	public void excluirPessoa(List<Pessoa> pessoas) {
		
		listarPessoas(pessoas);
		
		if(pessoas.isEmpty()) {
			return;
		}
		
		System.out.println("--- EXCLUIR PESSOA ---");
		
		System.out.print("Informe o ID da pessoa para excluir: ");
		int idPessoa = tec.nextInt();
		
		if(pessoas.size() <= idPessoa) {
			System.out.println("Pessoa não cadastrado.");
			return;
		}
		
		pessoas.remove(idPessoa);
	}
}
