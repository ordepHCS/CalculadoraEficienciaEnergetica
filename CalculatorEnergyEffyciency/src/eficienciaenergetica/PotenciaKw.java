/*Grupo 5: Calculadora de Eficiencia Energetica :)
 * Pedro Henrique
 * Bianca Necy
 * Eduardo Victor
 * Carlos Gabriel
 * Carlos Henrique
 */
package eficienciaenergetica;

/*Classe do JDK para ler dados de entrada*/
import java.util.Scanner;
/*Classe do JDK (estou usando essa classe para capturar erros de entrada digitados pelo usúario)*/
import java.util.InputMismatchException;
/*Classe do JDK para formatar valores para duas casas decimais*/
import java.text.DecimalFormat;

/*Declaração de Classe, Var e seus tipos*/
public class PotenciaKw {
    /*Var do tipo "Double" porque estou trabalhando com valores decimais*/
	double potencia;
    double tempo;
    double consumo;
    
    /*Método Construtor*/
    public PotenciaKw(double potencia, double tempo) {
        this.potencia = potencia;
        this.tempo = tempo;
    }
    
    /*Método para calcular a energia consumida*/
    public double EnergiaConsumida() {
        /*Consiste em pegar a potencia em Kilowatts de um aparelho e multiplicar pelo tempo que o aparelho foi usado*/
    	return potencia * tempo;
    }
    
    /*Método para calcular a eficiência energértica*/
    public double EficienciaEnergetica() {
        return EnergiaConsumida() / (potencia * tempo);
    }
    
    /*Getters e Setters ou Método de Encapsulamento*/
    public double getPotencia() {
    	return potencia;
    }
    
    public void setPotencia(double potencia) {
    	this.potencia = potencia;
    }
    
    public double getConsumo() {
    	return consumo;
    }
    
    public void setConsumo(double consumo) {
    	this.consumo = consumo;
    }
    
    public double getTempo() {
    	return tempo;
    }
    
    public void setTempo(double tempo) {
    	this.tempo = tempo;
    }
    
    public double getEnergiaconsumida() {
    	return consumo;
    }
    
    public void setEnergiaconsumida(double Energiaconsumida) {
    	this.consumo = Energiaconsumida;
    }
    
    /*Método "main"*/
    public static void main(String[] args) {
        /*Objeto para ler a entrada do usúario*/
    	Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        
        /*Loop para o programa ser executado ate que seja interromopido*/
        while (true) {
            /*Bloco try - catch | Captura e lida com exceções que podem ocorrer durante a execução do código dentro do bloco "try"*/
        	try {
                System.out.println("Digite a potencia de um aparelho eletronico em WATTS");
                double potencia = scanner.nextDouble();
                
                /*Condição "if" para se caso a potencia receba um valor negativo ou 0*/
                if (potencia <= 0) {
                    throw new IllegalArgumentException("A potência deve ser um valor positivo");
                }

                System.out.println("Digite o tempo de uso deste aparelho em HORAS");
                double tempo = scanner.nextDouble();
                
                /*Condição "if" para se caso o tempo receba um valor negativo ou 0*/
                if(tempo <= 0) {
                    throw new IllegalArgumentException("O tempo de uso deve ser um valor positivo");
                }

                PotenciaKw potenciakw = new PotenciaKw(potencia, tempo);
                double consumo = potenciakw.EnergiaConsumida();
                System.out.println("A energia consumida pelo aparelho é: " + df.format(consumo) + "kWh (Kilowatt-Hora)");

                /*Ex: Amazonas Energia = R$ 0,83*/
                System.out.println("Digite o valor da tarifa em kWh (Kilowatt-Hora) da empresa que fornece energia na sua casa");
                double precoKwh = scanner.nextDouble();
                
                /*Condição "if" para se caso o valor da tarifa seja negativo ou 0*/
                if(precoKwh <= 0) {
                    throw new IllegalArgumentException("O preço por kWh deve ser um valor positivo");
                }
                double custoTotal = consumo * precoKwh;                
                System.out.println("O custo total de energia consumida em reais é: R$" + df.format(custoTotal));

                double eficienciaEnergetica = potenciakw.EficienciaEnergetica();
                System.out.println("A eficiencia energetica do aparelho é: " + eficienciaEnergetica);
                
                /*Pergunta ao usúario se ele deseja calcular novamente*/
                System.out.println("Deseja calcular novamente? (Sim/Nao)");
                String resposta = scanner.next();
                
                /*Condição "if" - se o usúario digitar "Sim" o programa reseta != "Sim" o programa termina*/
                if(!resposta.equalsIgnoreCase("Sim")) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada Inválida");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        /*Fecha o fluxo de entrada de dados*/
        scanner.close();
    }
}
