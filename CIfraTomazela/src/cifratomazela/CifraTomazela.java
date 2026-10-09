package cifratomazela;

import java.io.IOException;
import java.nio.file.FileSystems;
import servicos.ManipulaArquivoTexto;
import java.util.Scanner;
import cifratomazela.Encryption;
import erro.DecifragemInvalidaException;

import java.nio.file.Files;
import java.nio.file.Path;

public class CifraTomazela {
  
    public static void main(String[] args) {
        ManipulaArquivoTexto manipulaArquivoTexto = new ManipulaArquivoTexto();
        Scanner input = new Scanner(System.in);

        try {
          if(Files.exists(FileSystems.getDefault().getPath("Cryptography.txt"))) {
            processarArquivoExistente(manipulaArquivoTexto, input);
          }
        } catch(IOException e) {
          System.err.println("Erro ao acessar o arquivo: " + e.getMessage()); 
        } finally {
          input.close();
        }
  }
  private static void processarArquivoExistente(ManipulaArquivoTexto manipulaArquivoTexto, Scanner input) throws IOException {
    manipulaArquivoTexto.abrirArquivo("Cryptography.txt");

    String conteudo = manipulaArquivoTexto.leituraArquivo();
    if(conteudo == null || conteudo.isEmpty()) {
      System.err.println("Documento vazio");
      criarNovaCriptografia(manipulaArquivoTexto, input);
    }else {
      int key = manipulaArquivoTexto.leituraArquivoAchaChave(conteudo);
      String mensagemCriptografada = manipulaArquivoTexto.leituraArquivoAchaMensagem(conteudo);
      String mensagemDecodificada = Encryption.decrypting(mensagemCriptografada, key);

      System.out.println("Mensagem: " + mensagemCriptografada);
      System.out.println("Chave = " + key);

      if(tentarDecifrarMensagem(input, mensagemDecodificada))
        criarNovaCriptografia(manipulaArquivoTexto, input);
      manipulaArquivoTexto.fecharArquivo("Cryptography.txt");
    }
  }

  private static boolean tentarDecifrarMensagem(Scanner input, String mensagemDecodificada) {
    while (true) {
      try {
        System.out.println("\nDigite a mensagem decodificada (ou 0 para desistir):\n> ");
        String resposta = input.nextLine();

        if (resposta.equals("0")) {
          System.out.println("Você desistiu!");
          return false;
        }

        verificarDecifragem(resposta, mensagemDecodificada);
        System.out.println("Parabéns! Mensagem correta!");
        return true;
      } catch(DecifragemInvalidaException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private static void verificarDecifragem(String resposta, String mensagemDecodificada) throws DecifragemInvalidaException {
    if(!resposta.equalsIgnoreCase(mensagemDecodificada)) {
      throw new DecifragemInvalidaException();
    }
  }

  private static void criarNovaCriptografia(ManipulaArquivoTexto manipulaArquivoTexto, Scanner input) throws IOException {
    manipulaArquivoTexto.abrirArquivoGravacao("Cryptography.txt");

    System.out.print("\nAgora é sua vez!\nEscrava a mensagem que você deseja criptografar: ");
    String message = input.nextLine();

    System.out.print("Qual é a chave que você deseja: ");
    int key = input.nextInt();
    input.nextLine();

    String mensagemCriptografada = Encryption.encrypting(message, key);
    manipulaArquivoTexto.gravaMensagemComChave(mensagemCriptografada, key);

    manipulaArquivoTexto.fecharArquivoGravacao("Cryptography.txt");
    System.out.println("\nAté o próximo jogador!");
  }
}
