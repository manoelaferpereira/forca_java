import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private final Palavra palavra;
    private final Jogador jogador;

    public Jogo(Palavra palavra, Jogador jogador) {
        this.palavra = palavra;
        this.jogador = jogador;
    }

    public void iniciarJogo() {
        int numeroChutes = 10;
        ArrayList<String> chutes = new ArrayList<>();

        this.palavra.gerarPalavraSecreta();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Olá " + this.jogador.getNome() + ", bem-vindo ao jogo da Forca!");
        System.out.println(this.palavra.getPalavraComChute() + "\n");

        while (!this.palavra.palavraCompleta() && chutes.size() < numeroChutes) {
            System.out.print("Digite seu chute: ");
            String chute = scanner.nextLine();

            if (chutes.contains(chute)) {
                System.out.println("Você já chutou essa letra! Tente novamente.");
                continue;
            }

            chutes.add(chute);
            this.palavra.revelarLetra(chute);

            System.out.println("Palavra: " + this.palavra.getPalavraComChute());

            if (this.palavra.palavraCompleta()) {
                System.out.println("Parabéns, " + this.jogador.getNome() + "! Você venceu!");
                break;
            } else if (chutes.size() == numeroChutes) {
                System.out.println("Poxa, " + this.jogador.getNome() +
                        ", você perdeu! A palavra secreta era: " + this.palavra.getPalavraSecreta());
            }
        }

        scanner.close();
    }
}
