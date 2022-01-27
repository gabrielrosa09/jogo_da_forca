package tp1;

import java.util.Scanner;
import java.util.Random;

public class TP1 {
	
	public static void main(String[] args) {
		
	// declaracao de variaveis
		
	String[][] temasPalavras =  new String[51][51];
	int opcoes, opcoesPalavras, opcoesTemas;
	
	do {
		
		opcoes = MostrarMenu(); // funcao para mostrar o menu
		
		switch (opcoes) {
		
		case 1:	
				// menu de temas
				opcoesTemas = MenuTema();
			
				if (opcoesTemas == 1) {
					// void para cadastrar temas
					CadastrarTema(temasPalavras);
					
				} else if (opcoesTemas == 2) {
					// void para deletar temas
					DeletaTema(temasPalavras);
					
				} else if (opcoesTemas == 3) {
					// void para buscar temas
					BuscarTemas(temasPalavras);
					
				} else if (opcoesTemas == 4) {
					System.out.println("Menu de Cadastro Finalizado!");
					break;
				}
					
				break;
				
		case 2: 
				
				// funcao menu das palavras
				opcoesPalavras = MenuPalavra();
				
				if (opcoesPalavras == 1) {
					// void para cadastrar as palavras
					CadastrarPalavras(temasPalavras);
					
				} else if (opcoesPalavras == 2) {
					// void para deletar as palavras
					DeletaPalavra(temasPalavras);
					
				} else if (opcoesPalavras == 3) {
					// void para buscar as palavras
					BuscarPalavra(temasPalavras);
					
				} else if (opcoesPalavras == 4) {
					// void para listar as palavras
					ListarPalavras(temasPalavras);
					
				} else if (opcoesPalavras == 5) {
					break;
				}
					
				break; 
				
		case 3: 
				JogoForca(temasPalavras); // void para selecionar um tema e jogar a Forca
	
				break;
		
		case 4: System.out.print("Programa Finalizado!");
				break;
				
		default: System.out.println("Não existe essa opção! Digite novamente: ");
		
		}
		
	} while (opcoes != 4);
		
	}
	
	// Função Mostrar Menu
	
	static int MostrarMenu () {
		Scanner ler = new Scanner(System.in);
		int op;
		System.out.println("========= MENU =========");
		System.out.println("1 - Menu Cadastrar Temas");
		System.out.println("2 - Menu Cadastrar Palavras");
		System.out.println("3 - Jogar");
		System.out.println("4 - Sair");
		op = ler.nextInt();
		
		return op;
	}
	// funcao para mostrar o menu de opcoes do tema
	static int MenuTema() {
		Scanner ler = new Scanner(System.in);
		int op;
		
		System.out.println("========= MENU TEMAS =========");
		System.out.println("1 - Cadastrar Temas");
		System.out.println("2 - Deletar Tema");
		System.out.println("3 - Buscar Tema");
		System.out.println("4 - Sair");
		op = ler.nextInt();
		
		return op;
	}
	// funcao para mostrar o menu de opcoes das palavras
	static int MenuPalavra() {
		Scanner ler = new Scanner(System.in);
		int op;
		
		System.out.println("========= MENU PALAVRAS =========");
		System.out.println("1 - Cadastrar Palavras");
		System.out.println("2 - Deletar Palavras");
		System.out.println("3 - Buscar Palavras");
		System.out.println("4 - Listar Palavras");
		System.out.println("5 - Sair");
		op = ler.nextInt();
		
		return op;
	}
	
	// void para cadastrar temas
	static void CadastrarTema(String temasPalavras[][]) {
		Scanner ler = new Scanner(System.in);
		
		for (int i = 0; i < temasPalavras.length; i++) {
			for (int j = 0; j < temasPalavras[i].length; j++) {
				if (temasPalavras[i][j] == temasPalavras[i][0] && temasPalavras[i][0] == temasPalavras[0][0]) { 
					System.out.println("Digite uma Tema: "); 
					temasPalavras[i][0] = ler.nextLine(); // entradas dos temas
				} else if (temasPalavras[i][j] == temasPalavras[i][0]) {
					System.out.println("Digite uma Tema: ");
					temasPalavras[i][0] = ler.nextLine();
					do {
						if (temasPalavras[i][0].equals(temasPalavras[i-1][j])) { // aqui estar verificando se os temas sao iguais
							System.out.println("Tema já cadastrado! Digite novamente: ");
							temasPalavras[i][0] = ler.nextLine();
						}
					} while (temasPalavras[i][0].equals(temasPalavras[i-1][j]));
				}
			}
		}
		
	}
	// void para deletar temas
	static void DeletaTema(String temasPalavras[][]) {
		
		Scanner ler = new Scanner(System.in);
		String temaEscolhido;
	
		System.out.println("Qual tema deseja deletar?");
		for (int i = 0; i < temasPalavras.length; i++) {
			System.out.println((i+1) +  ". " + temasPalavras[i][0]);
		}
		
		temaEscolhido = ler.nextLine(); // entrada em forma de string para deletar o tema

		for (int i = 0; i < temasPalavras.length; i++) {
			for (int j = 0; j < temasPalavras[i].length; j++) {
				if (temaEscolhido.equals(temasPalavras[i][j]) && temasPalavras[i][j+1] == null) { // verificacao se ha palavras no tema
					temasPalavras[i][0] = null; // exlusao do tema
					System.out.println("Tema excluído!");
				} else if (temaEscolhido.equals(temasPalavras[i][j]) && temasPalavras[i][j+1] != null) { // caso ha palavras, retorna uma mensagem de erro
					System.out.println("Não foi possível excluir o tema. Verifique se existem palavras cadastradas nesse tema.");
					break;
				}
			}
		}
		
	}
	// void para buscar temas
	static void BuscarTemas(String temasPalavras[][]) {
		
		Scanner ler = new Scanner(System.in);
		String temaEscolhido;
		
		System.out.println("Qual tema deseja buscar?");
		temaEscolhido = ler.nextLine(); // entrada do tema a ser buscado
		
		for (int i = 0; i < temasPalavras.length; i++) {
			if (temaEscolhido.equals(temasPalavras[i][0])) { // verificacao se ha o tema pesquisado
				System.out.println("Este tema existe! " + temasPalavras[i][0]);
			}
		}
		
	}
	// void para cadastrar palavras
	static void CadastrarPalavras(String temasPalavras[][]) {
		Scanner ler = new Scanner(System.in);
		String escolhaTema;
		
		System.out.println("Escolha um tema: ");
		for (int i = 0; i < temasPalavras.length; i++) { 
			System.out.println((i+1) + ". " + temasPalavras[i][0]);
		}
		escolhaTema = ler.nextLine(); // escolher o tema para ser cadastrado as palavras
		
		
		for (int i = 0; i < temasPalavras.length; i++) {
			for (int j = 1; j < temasPalavras[i].length; j++) {
				if (escolhaTema.equals(temasPalavras[i][0]) ) {
					System.out.println("Digite uma Palavra: ");
					temasPalavras[i][j] = ler.nextLine().toUpperCase(); //entrada das palavras cadastradas
					do {
						if (temasPalavras[i][j].equals(temasPalavras[i][j-1]) ) { // verificacao se a palavra existe
							System.out.println("Palavra já cadastrada! Digite novamente: "); 
							temasPalavras[i][j] = ler.nextLine().toUpperCase();
						}
					} while (temasPalavras[i][j].equals(temasPalavras[i][j-1]));
				}
			}
		}
	}
	// void para deletar palavras
	static void DeletaPalavra(String temasPalavras[][]) {
		Scanner ler = new Scanner(System.in);
		String palavraEscolhida;
	
		System.out.println("Qual palavra deseja deletar?");
		for (int i = 0; i < temasPalavras.length; i++) {
			for (int j = 1; j < temasPalavras[i].length; j++) {
				System.out.print(temasPalavras[i][j] + " - ");
			}
			System.out.println();
		}
		
		palavraEscolhida = ler.nextLine(); // entrada da palavra a ser deletada

		for (int i = 0; i < temasPalavras.length; i++) {
			for (int j = 1; j < temasPalavras[i].length; j++) {
				if (palavraEscolhida.equals(temasPalavras[i][j])) {
					temasPalavras[i][j] = null;  // aqui a palavra esta sendo excluida
					System.out.println("Palavra Excluída!");
				}
			}
		}
		
	}
	// void para buscar palavras
	static void BuscarPalavra(String temasPalavras[][]) {
		Scanner ler = new Scanner(System.in);
		String palavraEscolhida;
		
		System.out.println("Qual palavra deseja buscar?");
		palavraEscolhida = ler.nextLine(); // entrada da palavra desejada a ser buscada
		
		for (int i = 0; i < temasPalavras.length; i++) {
			for (int j = 1; j < temasPalavras[i].length; j++) {
				if (palavraEscolhida.equals(temasPalavras[i][j])) { //verificacao se ha essa palavra
					System.out.println("Palavra encontrada no tema: " + temasPalavras[i][0]);
				} else if (palavraEscolhida != temasPalavras[i][j]) {
					palavraEscolhida = "Não existe";
				}
			}
		}
		
		if (palavraEscolhida == "Não existe") { 
			System.out.println("Palavra não existe!"); // caso não exista essa mensagem sera retornada!
		}
		
	
	}
	// void para listar palavras
	static void ListarPalavras(String temasPalavras[][]) {
		// aqui esta apenas sendo lsitar as palavras cadastradas
		for (int i = 0; i < temasPalavras.length; i++) {
			for (int j = 1; j < temasPalavras[i].length; j++) {
				System.out.print(temasPalavras[i][j] + " - ");
			}
			System.out.println();
		}
		
	}
	
	// void para selecionar um tema e o jogo da forca
	static void JogoForca(String temasPalavras[][]) {
		// variaveis para a selecao do tema
		Random random = new Random();
		Scanner ler = new Scanner(System.in);
		int temaEscolhido, quantPalavra = 0, posicaoPalavra = 0;
		String palavraSorteada = "";
		
		int escolha = 0;
		
		do {
			// aqui a entrada do NUMERO relacionado ao tema -------- coloquei em forma de numero para poder usar a biblioteca RANDOM
			System.out.println("Digite o número do tema para iniciar o jogo: ");
			for (int i = 0; i < temasPalavras.length; i++) {
			System.out.println((i+1) + ". " + temasPalavras[i][0]);
			}
			temaEscolhido = ler.nextInt(); // LISTAGEM DOS TEMAS E ENTRADA DO NUMERO CORRESPONDENTE AO TEMA
		
			for (int i = -1; i < temaEscolhido-1; i++) {
				for (int j = 1; j < temasPalavras[temaEscolhido-1].length; j++) {
					quantPalavra = temasPalavras[j].length; // AQUI ESTOU PEGANDO A QUANTIDADE DE PALAVRAS EM UMA LINHA
					posicaoPalavra = random.nextInt(quantPalavra) + 1; // AQUI ESTOU PEGANDO A POSICAO ALEATORIA DAS PALAVRAS DO TEMA
					palavraSorteada = temasPalavras[temaEscolhido-1][posicaoPalavra];// AQUI ESTOU TRANFORMANDO A PALAVRA SORTEADA DE VOLTA PARA STRING
					break;
				}
				System.out.println();
			}
			
			char [] acertos = new char[palavraSorteada.length()]; // AQUI É UM VETOR PARA PASSAR O TAMANHO DA PALAVRA SELECIONADA
			
			for (int i = 0; i < acertos.length; i++) {
				
				acertos[i] = 0; // APENAS UM CONTADOR DE ACERTOS
				
			}
			
			for (int i = 0; i < palavraSorteada.length(); i++) {
				
				System.out.print(" _ "); // AQUI SAO AS BARRAS QUE AINDA NÃO ADVINHADAS
				
			}
			
			// VARIAVEIS PARA A CRIACAO DO JOGO
			String letrasUsadas = "";
			char letra;
			boolean vitoria = false;
			int qtdVidas = 5;
			
			do {
			
				System.out.println("\n" + "Você tem " + qtdVidas + " vidas" + "\nLetra utilizadas:  " + letrasUsadas + "\nDigite uma letra: ");
				letra = ler.next().toUpperCase().charAt(0); // ENTRADA DAS LETRAS PELO USUARIO EM FORMA MINUSCULA
				letrasUsadas += " " + letra; // SAO AS LETRAS JA ENTRADAS PELO USUARIO
				
				boolean perdeVida = true;
				for (int i = 0; i < palavraSorteada.length(); i++) {
					
					if (letra == palavraSorteada.charAt(i)) {
						acertos[i] = 1; // ACERTOS DO USUARIO
						perdeVida = false; // SE ACERTA NAO PERDE VIDA
					}
					
				}
				
				if (perdeVida) { 
					qtdVidas--; // SE ERRAR PERDE VIDA
				}
				
				vitoria = true;
				for (int i = 0; i < palavraSorteada.length(); i++) {
					
					if(acertos[i] == 0) {
						System.out.print(" _ "); // CASO NAO HA ACERTOS SERA DIANTE DAS VIDAS SERA DERROTADO
						vitoria = false;
					} else {
						System.out.print(" " + palavraSorteada.charAt(i) + " ");
					}
						
				}
			
			} while (!vitoria && qtdVidas > 0);
			
			if (qtdVidas != 0) {
				System.out.println("\n\t Você ganhou!"); // SE QTD DE VIDAS FOR != VOCE SERA VENCEDOR
			} else {
				System.out.println("\n\t Você perdeu!"); // CASO A QTD VIDAS == 0 VOCE SERA DERROTADO
				System.out.println("\tA palavra era: " + palavraSorteada); // PALAVRA SORTEADA
			}
			
			System.out.print("\nDeseja jogar novamente?"); // JOGAR NOVAMENTE
			System.out.println("\n1- SIM ou qualquer outro número para sair!");
			escolha = ler.nextInt();
			
		} while (escolha == 1);
		
		
	}

}