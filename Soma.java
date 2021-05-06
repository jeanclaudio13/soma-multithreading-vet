public class Soma extends Thread{
    private int qtd = 250;
    public int inicio;
    public int soma = 0;
    public int[] a;

    public Soma(int[] a, int inicio){
        this.a = a;
        this.inicio = inicio;
    }

    public void run(){
        for(int i = inicio; i < inicio + qtd;i++){
            soma += a[i];
        }
    }
}