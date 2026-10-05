package jogodforca;
import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {
        String continuar = "";

        
        do {
           
            int tamanhoPalavra = Integer.parseInt(JOptionPane.showInputDialog("Jogador 1: Quantas letras sua palavra terá?"));
            
            String[] palavraSecreta = new String[tamanhoPalavra];
            String[] palavraDescoberta = new String[tamanhoPalavra];
            
           
            for (int i = 0; i < tamanhoPalavra; i++) {
                palavraDescoberta[i] = "_";
            }

            
            for (int contador = 0; contador < tamanhoPalavra; contador++) {
                palavraSecreta[contador] = JOptionPane.showInputDialog("Jogador 1: Informe a letra " + (contador + 1) + " da palavra secreta:");
            }

            int tentativasRestantes = 6;
            boolean ganhou = false;

        
            while (tentativasRestantes > 0 && !ganhou) {
                
               
                String exibicaoVisual = "";
                for (int i = 0; i < tamanhoPalavra; i++) {
                    exibicaoVisual += palavraDescoberta[i] + " ";
                }

               
                String palpite = JOptionPane.showInputDialog(null, 
                    "JOGADOR 2: Adivinhe a palavra!\n\n"
                    + "Palavra: " + exibicaoVisual + "\n"
                    + "Tentativas restantes: " + tentativasRestantes + "\n\n"
                    + "Digite uma letra:");

               
                boolean acertouLetra = false;
                for (int i = 0; i < tamanhoPalavra; i++) {
                    
                    if (palavraSecreta[i].equalsIgnoreCase(palpite)) {
                        palavraDescoberta[i] = palavraSecreta[i]; 
                        acertouLetra = true;
                    }
                }

               
                if (!acertouLetra) {
                    JOptionPane.showMessageDialog(null, "Errado! A letra '" + palpite + "' não está na palavra.");
                    tentativasRestantes--;
                } else {
                    JOptionPane.showMessageDialog(null, "Muito bem! Você acertou uma letra.");
                }

               
                boolean aindaTemTraco = false;
                for (int i = 0; i < tamanhoPalavra; i++) {
                    if (palavraDescoberta[i].equals("_")) {
                        aindaTemTraco = true;
                        break;
                    }
                }
                
                if (!aindaTemTraco) {
                    ganhou = true;
                }
            }

           
            String palavraCompleta = "";
            for (int i = 0; i < tamanhoPalavra; i++) {
                palavraCompleta += palavraSecreta[i];
            }

            if (ganhou) {
                JOptionPane.showMessageDialog(null, "Parabéns, Jogador 2! Você venceu!\nA palavra era: " + palavraCompleta);
            } else {
                JOptionPane.showMessageDialog(null, "Fim de jogo! Suas tentativas acabaram.\nA palavra correta era: " + palavraCompleta);
            }

            
            continuar = JOptionPane.showInputDialog("Jogar novamente?"
                    + "\nSim"
                    + "\nNão");

        } while (continuar != null && continuar.equalsIgnoreCase("Sim"));
        
        JOptionPane.showMessageDialog(null, "Obrigado por jogar!");
    }
}
