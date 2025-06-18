import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Main {
    public static Persoana[] clienti;
    public static void main(String[] args){
        //citire din clienti.csv
        System.out.println("Citire clienti din fisier clienti.csv");
        citireClienti("clienti.csv");
        System.out.println("Clienti cititi:");
        for(Persoana client : clienti){
            System.out.println(client);
        }

    }
    public static void citireClienti(String numeFisier){
        try(BufferedReader in = new BufferedReader(new FileReader(numeFisier))){
            clienti = new Persoana[0];
            String linie;
            while((linie=in.readLine())!=null){
                String[] elemente = linie.split(",");
                Persoana client = new Persoana();
                client.setCnp(Long.parseLong(elemente[0].trim()));
                client.setNume(elemente[1].trim());
                Adresa adresa = new Adresa();
                adresa.setJudet(elemente[2].trim());
                adresa.setLocalitate(elemente[3].trim());
                adresa.setStrada(elemente[4].trim());
                adresa.setNumar(elemente[5].trim());
                adresa.setCod(Integer.parseInt(elemente[6].trim()));
                client.setAdresa(adresa);
                clienti= Arrays.copyOf(clienti, clienti.length+1);
                clienti[clienti.length-1] = client;
            }
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}
