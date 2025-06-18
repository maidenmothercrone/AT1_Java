import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.lang.String.format;

public class Main {
    public static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    public static Persoana[] clienti;
    public static List<Depozit> depozite = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        //citire din clienti.csv
        System.out.println("Citire clienti din fisier clienti.csv");
        citireClienti("clienti.csv");
        System.out.println("Clienti cititi:");
        for(Persoana client : clienti){
            System.out.println(client);
        }

        //citire depozite din depozite.csv
        System.out.println("Citire depozite din fisierul depozite.csv");
        citireDepozite("depozite.csv");
        System.out.println("Depozite citite:");
        for (Depozit depozit : depozite){
            System.out.println(depozit);
        }

        //scriere in fisier pt depozite in euro
        scriereFisierText();

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

    public static void citireDepozite(String numeFisier){
        try(BufferedReader in = new BufferedReader(new FileReader(numeFisier))){
            String linie;
            while((linie = in.readLine()) !=null){
                Depozit depozit = new Depozit();
                String[] elemente = linie.split(",");
                long cnp = Long.parseLong(elemente[0].trim());
                Persoana titular = cautare(cnp);
                depozit.setTitular(titular);
                if(!elemente[1].trim().isEmpty()){
                    depozit.setImputernicit(cautare(Long.parseLong(elemente[1].trim())));
                }
                depozit.setDataDeschidere(format.parse(elemente[2].trim()));
                depozit.setMoneda(Moneda.valueOf(elemente[3].trim().toUpperCase()));
                depozit.setValoare(Double.parseDouble(elemente[4].trim()));
                depozit.setSucursala(elemente[5].trim());
                depozit.setTipDepozit(TipDepozit.valueOf(elemente[6].trim().toUpperCase()));
                depozit.setCodContract(Integer.parseInt(elemente[7].trim()));
                depozite.add(depozit);
            }
        }
        catch(Exception e){
            System.err.println(e);
        }

    }

    public static void scriereFisierText() throws FileNotFoundException {
        try(PrintWriter out = new PrintWriter("depozite_in_euro.txt")){
            out.println("Depozite in Euro:\n");
            out.println("------------------\n");
            for(Depozit depozit: depozite){
                if(String.valueOf(depozit.getMoneda()) == "EURO"){
                    out.println("Titular:");
                    out.println(depozit.getTitular());
                    out.println("Cod contract:");
                    out.println(depozit.getCodContract());
                    out.println("Valoare:");
                    out.println(depozit.getValoare());
                    out.println("\n");
                }
            }
        }
        catch(Exception e){
            System.err.println(e);
        }
    }

    private static Persoana cautare(long cnp){
        for(Persoana persoana:clienti){
            if(persoana.getCnp()==cnp){
                return persoana;
            }
        }
        return null;
    }
}
