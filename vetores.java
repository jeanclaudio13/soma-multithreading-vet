import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class vetores extends Thread {

    public static void main(String[] args) throws InterruptedException{
        int soma = 0;
        int qtd = 250;
        int inicio = 0;
        int qtdThreads = 8;
        int qtdValores = 100000;
        int[] a = new int[qtdValores];
        for (int i = 0; i < qtdValores; i++){
            a[i] = i;
        }

         //cria pool de threads para execução de tarefas
        ThreadPoolExecutor p = new ThreadPoolExecutor(5, 10, 1, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(10));
        List<Soma> listThread = new ArrayList<Soma>();

        for(int i = 0; i < qtdThreads; i++){
            listThread.add(new Soma(a,inicio));
            p.submit(listThread.get(i));
            inicio += qtd;
        }

        //força a execução e finalização das threads
        p.shutdown();

        //aguarda finalização das threads em execução
        p.awaitTermination(1, TimeUnit.DAYS);

        for(int i = 0; i < qtdThreads; i++){
            soma += listThread.get(i).soma;
        }

        System.out.println(soma);
    }

}

