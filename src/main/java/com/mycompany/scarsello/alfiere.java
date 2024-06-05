/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scarsello;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author fabri
 */
class alfiere {
    
    
    /**
 * Crea un nuovo file per registrare le mosse di una partita di scacchi.
 * Il nome del file è determinato in base al numero fornito.
 * Se il file con il nome specificato esiste già, il metodo tenta di creare un nuovo file con un nome incrementato.
 * 
 * @param nome Il numero da utilizzare nel nome del file.
 */
public void creafile(int nome) {
    /**
     * Crea il percorso del file concatenando "registromosse" con il numero fornito.
     */
    String percorso = "registromosse" + nome;

    /**
     * Crea un oggetto File utilizzando il percorso specificato.
     */
    File file = new File(percorso);

    try {
        /**
         * Prova a creare un nuovo file.
         */
        if (file.createNewFile()) {
            System.out.println("Il file è stato creato con successo: " + file.getName());
            /**
             * Inizializza una nuova istanza di Scacchiera utilizzando il percorso del file creato.
             */
            Scacchiera(percorso);
        } else {
            /**
             * Se il file esiste già, incrementa il nome e chiama ricorsivamente il metodo creafile.
             */
            nome++;
            creafile(nome);
        }
    } catch (IOException e) {
        /**
         * Se si verifica un'eccezione durante la creazione del file, incrementa il nome e chiama ricorsivamente il metodo creafile.
         */
        nome++;
        creafile(nome);
    }
}

    /**
 * Scrive una mossa di gioco nella registrazione della partita di scacchi.
 * 
 * @param scacchiera La matrice rappresentante la configurazione attuale della scacchiera.
 * @param mossa Un array di caratteri che rappresenta la mossa da registrare.
 * @param nome Il nome del file di registrazione delle mosse.
 */
public void scrivifile(String[][] scacchiera, char[] mossa, String nome) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nome, true))) {
        /**
         * Scrive la mossa nel file di registrazione, includendo le coordinate di destinazione.
         */
        writer.write("" + mossa[4] + mossa[5] + "\n");
        
        /**
         * Richiama il metodo input per aggiornare il file con la nuova configurazione della scacchiera.
         */
        input(scacchiera, nome);
    } catch (IOException e) {
        /**
         * Gestisce eventuali eccezioni stampando la traccia dell'eccezione.
         */
        e.printStackTrace();
    }
}

    
    
    
    
    public void Scacchiera(String nome){
        Scanner scan=new Scanner(System.in);
        System.out.println("Benvenuto nella prima beta di scacchi, In questa versione potrai muovere solo il \n l'alfiere all'interno della scacchiera vuota, ecco per te un tutoria per iniziare partendo dalle basi:\n" +
"\n");      //qui chiedo all'utente di skippare o meno il tutoriL
        System.out.println("Desideri skippare il tutorial e l'introduzione? y/n");
            char scelta=scan.next().charAt(0);
        String[][] scacchiera = new String[8][8];                                    
                //inizializzazione della scacchiera con solo i pezzi di interesse
                scacchiera[2][0]="Bw";
                scacchiera[2][7]="Bb";
                scacchiera[7-2][0]="Bw";
                scacchiera[7-2][7]="Bb";
                
            if(scelta=='y'){
            System.out.println("Perfetto");
                System.out.println("");
                System.out.println("");
            System.out.println("  |----|----|----|----|----|----|----|----|");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " |");
            for (int j = 0; j < 8; j++) {
                if(scacchiera[j][8 - 1 - i]==null){
                System.out.print(" " + "  " + " |");     
                }else{
                System.out.print(" " + scacchiera[j][8 - 1 - i] + " |");
                }
            }
            System.out.println("\n  |----|----|----|----|----|----|----|----|");
        }
        System.out.println("    a    b    c    d    e    f    g    h");
        
                System.out.println("");
                 input(scacchiera, nome);
        }else if(scelta=='n'){
        System.out.println("Scopo del gioco: Lo scopo degli scacchi è quello di mettere il re avversario sotto scacco " +
                "in modo tale che non ci sia nessuna mossa legale per liberarlo.\n");

        // I pezzi e i loro movimenti
                System.out.println("I pezzi e i loro movimenti:");
                System.out.println("1. Re: Il re può muoversi in qualsiasi direzione (orizzontale, verticale o diagonale) " +
                "ma soltanto di una casella alla volta.");
                System.out.println("2. Regina: La regina può muoversi in qualsiasi direzione (orizzontale, verticale o " +
                "diagonale) per un numero illimitato di caselle.");
                System.out.println("3. Torre: La torre può muoversi in orizzontale o verticale per un numero illimitato di " +
                "caselle.");
                System.out.println("4. Alfiere: L'alfiere può muoversi in diagonale per un numero illimitato di caselle.");
                System.out.println("5. Cavallo: Il cavallo si muove in un movimento a \"L\": due caselle in una direzione e " +
                "una casella in direzione perpendicolare. Il movimento può essere eseguito sia in orizzontale che in " +
                "verticale.");
                System.out.println("6. Pedone: Il pedone può muoversi in avanti di una casella, ma al suo primo movimento " +
                "può avanzare di due caselle. Può catturare i pezzi avversari spostandosi diagonalmente in avanti. " +
                "Quando un pedone raggiunge l'ultima fila del tabellone avversario, può essere promosso in una " +
                "regina, torre, alfiere o cavallo.\n");

        // Scacco e scacco matto
                System.out.println("Scacco e scacco matto:");
                System.out.println("- Scacco: Uno scacco si verifica quando il re è minacciato da uno o più pezzi avversari. " +
                "Il giocatore deve muovere il re fuori dalla minaccia, bloccare la minaccia o catturare il pezzo " +
                "minacciante con uno dei propri pezzi.");
                System.out.println("- Scacco matto: Uno scacco matto si verifica quando il re è minacciato e non c'è nessuna " +
                "mossa legale che permetta al giocatore di liberare il proprio re. Questo significa che il re è sotto " +
                "scacco e non ci sono altre mosse possibili per evitare lo scacco. In tal caso, la partita termina e " +
                "il giocatore il cui re è sotto scacco matto perde la partita.\n");

        // Roccasta
                System.out.println("Roccasta: La roccata è una mossa speciale che coinvolge il re e una delle torri. Può " +
                "essere eseguita solo se il re e la torre coinvolta non si sono mai mossi prima, se non ci sono pezzi " +
                "tra il re e la torre, e se il re non è sotto scacco. Durante la roccata, il re si muove di due " +
                "caselle verso la torre coinvolta, e la torre si sposta alla casella immediatamente dopo il re.");
                System.out.println("");
                System.out.println("");
                System.out.println("");
        //inserie mossa
                System.out.println("Inserimento mossa:");
                System.out.println("");
                System.out.println();
                System.out.println("Passo 1: Guarda il Tavolo di Gioco");
                System.out.println("   a   b   c   d   e   f   g   h");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("8|   |   |   |   |   |   |   |   |8");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("7|   |   |   |   |   |   |   |   |7");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("6|   |   |   |   |   |   |   |   |6");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("5|   |   |   |   |   |   |   |   |5");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("4|   |   |   |   |   |   |   |   |4");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("3|   |   |   |   |   |   |   |   |3");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("2|   |   |   |   |   |   |   |   |2");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("1|   |   | x |   |   |   |   |   |1");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("   a   b   c   d   e   f   g   h");
                System.out.println();
                System.out.println("Passo 2: Seleziona la Pedina da Muovere");
                System.out.println("Inizia inserendo l'iniziale della pedina che vuoi muovere in maiuscolo, in questa beta potrai muovere solo l'alfiere\n");
                
                System.out.println("Nomenclatura dei pezzi degli scacchi:");
                System.out.println("K ------> Re (King)");
                System.out.println("Q ------> Regina (Queen)");
                System.out.println("R ------> Torre (Rook)");
                System.out.println("B ------> Alfiere (Bishop)");
                System.out.println("N ------> Cavallo (Knight)");
                System.out.println("P ------> Pedone (Pawn)\n\n\n");
                System.out.println("Inserisci la posizione della pedina che vuoi muovere, ad esempio 'c1'");
                System.out.println("la lettera corrisponde alla colonna, il numero alla riga ");

                System.out.println();
                System.out.println("Passo 3: Scegli la Destinazione");
                System.out.println("Ora, inserisci la posizione in cui vuoi spostare la pedina, ad esempio 'd2'");
                System.out.println("Come si muove l'alfiere?");
                System.out.println("L'alfiere si muuove solo in diagonale in qualsiasi direzione di quante posti desidera");
                System.out.println("un esempio di mossa valida:");
                System.out.println("-----------------------------");
                System.out.println("|                           |");
                System.out.println("|                           |");
                System.out.println("|                           |");
                System.out.println("|           Bc1 d2          |");
                System.out.println("|                           |");
                System.out.println("|                           |");
                System.out.println("|                           |");
                System.out.println("-----------------------------");

                System.out.println();
                System.out.println("Passo 4: Conferma la Mossa");
                System.out.println("La tua mossa è stata confermata!");
                System.out.println("");
                System.out.println("");
                System.out.println("   a   b   c   d   e   f   g   h");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("8|   |   |   |   |   |   |   |   |8");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("7|   |   |   |   |   |   |   |   |7");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("6|   |   |   |   |   |   |   |   |6");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("5|   |   |   |   |   |   |   |   |5");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("4|   |   |   |   |   |   |   |   |4");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("3|   |   |   |   |   |   |   |   |3");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("2|   |   |   | x |   |   |   |   |2");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("1|   |   |   |   |   |   |   |   |1");
                System.out.println(" +---+---+---+---+---+---+---+---+");
                System.out.println("   a   b   c   d   e   f   g   h");
                System.out.println();
                System.out.println("");
                System.out.println("");
                System.out.println("  |----|----|----|----|----|----|----|----|");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " |");
            for (int j = 0; j < 8; j++) {
                if(scacchiera[j][8 - 1 - i]==null){
                System.out.print(" " + "  " + " |");     
                }else{
                System.out.print(" " + scacchiera[j][8 - 1 - i] + " |");
                }
            }
            System.out.println("\n  |----|----|----|----|----|----|----|----|");
        }
        System.out.println("    a    b    c    d    e    f    g    h");
        
                System.out.println("");
                System.out.println("ora prova tu");
                System.out.println("");
                System.out.println("");
                
               
            
        
        
            
            input(scacchiera, nome);
        }else{
            System.out.println("scegli o y o n");
            Scacchiera(nome);
        }
            
                
    }
    public void mossa(char[] mossa, String[][] scacchiera, String nome) {
    // Calcola l'indice della riga iniziale della pedina
    int Ri = (int) mossa[1] - 97;
    System.out.println("\n riga iniziale " + Ri);

    // Calcola l'indice della colonna iniziale della pedina
    int Ci = mossa[2] - '0' - 1;
    System.out.println("\n colonna iniziale " + Ci);

    // Calcola l'indice della riga finale della pedina
    int Rf = (int) mossa[4] - 97;
    
    // Calcola l'indice della colonna finale della pedina
    int Cf = mossa[5] - '0' - 1;

    // Ottiene il tipo di pedina che si sta muovendo
    String pedina = scacchiera[Ri][Ci];
    System.out.println(pedina);

    // Rimuove la pedina dalla posizione iniziale
    scacchiera[Ri][Ci] = null;

    // Muove la pedina nella nuova posizione
    scacchiera[Rf][Cf] = pedina;

    // Visualizza la posizione della pedina mossa
    System.out.println("pedina mossa in " + mossa[4] + mossa[5]);

    // Visualizza la scacchiera dopo la mossa
    System.out.println("  |----|----|----|----|----|----|----|----|");
    for (int i = 0; i < 8; i++) {
        System.out.print((8 - i) + " |");
        for (int j = 0; j < 8; j++) {
            if (scacchiera[j][8 - 1 - i] == null) {
                System.out.print(" " + "  " + " |");
            } else {
                System.out.print(" " + scacchiera[j][8 - 1 - i] + " |");
            }
        }
        System.out.println("\n  |----|----|----|----|----|----|----|----|");
    }
    System.out.println("    a    b    c    d    e    f    g    h");

    // Scrive la mossa nel file di registrazione
    scrivifile(scacchiera, mossa, nome);
}

    
    
    
    
    
   public void input(String[][] scacchiera, String nome) {
    // Richiesta di inserire la mossa
    System.out.println("\n inserire la mossa:  ");
    Scanner scan = new Scanner(System.in);
    String mossa = scan.nextLine();
    char[] mossac = mossa.toCharArray();

    // Controllo della lunghezza della mossa
    if (mossac.length != 6) {
        System.out.println("hai inserito male la mossa, reinseriscila");
        // La mossa è più lunga di 6 caratteri, quindi richiede reinserimento
        input(scacchiera, nome);
    }

    // Controllo della lettera della riga iniziale
    if (controllol(mossac[1])) {
        System.out.println("hai inserito male la lettera, reinseriscila");
        // L'utente ha inserito una lettera non valida per la riga iniziale
        input(scacchiera, nome);
    }

    // Controllo del numero della colonna iniziale
    if (controllon(mossac[2])) {
        System.out.println("hai inserito male il numero, reinseriscila");
        // L'utente ha inserito un numero non valido per la colonna iniziale
        input(scacchiera, nome);
    }

    // Controllo della lettera della riga finale
    if (controllol(mossac[4])) {
        System.out.println("hai inserito male la lettera, reinseriscila");
        // L'utente ha inserito una lettera non valida per la riga finale
        input(scacchiera, nome);
    }

    // Controllo del numero della colonna finale
    if (controllon(mossac[5])) {
        System.out.println("hai inserito male la lettera, reinseriscila");
        // L'utente ha inserito un numero non valido per la colonna finale
        input(scacchiera, nome);
    }

    // Controllo se la posizione di partenza e di arrivo sono uguali
    if (mossac[1] == mossac[4] && mossac[2] == mossac[5]) {
        System.out.println("così la pedina non si muove, reinseriscila");
        // L'utente ha inserito la stessa posizione per la pedina di partenza e di arrivo
        input(scacchiera, nome);
    }

    // Controllo se la pedina scelta è un alfiere
    if (controllop(mossac[0])) {
        System.out.println("puoi muovere solo il bishop, reinseriscila");
        // L'utente ha scelto una pedina diversa dall'alfiere, che non è consentita
        input(scacchiera, nome);
    }

    // Controllo se la posizione scelta contiene una pedina
    if (controllopedina(mossac, scacchiera)) {
        System.out.println("qui non c'è nulla");
        // L'utente ha scelto una posizione senza pedina
        input(scacchiera, nome);
    }

    // Se tutti i controlli hanno avuto esito positivo, esegui la mossa dell'alfiere
    Alfiere(mossac, scacchiera, nome);
}

    
    
    
    
    public boolean controllol(char lettera){
    boolean risultato=false;
    int asci=(int) lettera; 
    if(!(asci>96 && asci<105)){
    risultato=true;    
    }
    return risultato;    
    }                             
    public boolean controllon(char numeroc){
    boolean risultato=false;   
    int numero=numeroc - '0';   
    if(!(numero>0 && numero<9)){
        risultato=true;
    }
    
    return risultato;
    }
    public boolean controllop(char pedina){
    boolean risultato=false;
    if(pedina!='B'){
        risultato=true;
    }
        
    return risultato;    
    }
    public boolean controllomovimento(char[] mossa){
    boolean risultato=false;
    int li=(int) mossa[1];                    //converto tramite codice ascii le lettere in numeri e faccio un cast dei numeri in int 
    int lf=(int) mossa[4];
    int ni=mossa[2]-'0';
    int nf=mossa[5]-'0';                        
    int n=Math.abs(ni-nf);                      //eseguo una sottrazione tra lettera iniziale e lettera finale
    int l=Math.abs(li-lf);                     //eseguo una sottrazione tra il numero iniziale e il numero finale
                                                //tramite gli if verificherò che la differenza tra coordinate sotto valore assoluto sia uguale
                                                //se fosse diverso vorrebbe dire che l'alfiere è stato mosso in modo errato
    if(n!=l){
        risultato=true;
    }
    return risultato;    
    }

    
    public boolean controllopedina(char[] mossa, String[][] scacchiera ){
        boolean risultato=false; 
        int ri=(int) mossa[1]-97;
         int co=mossa[2]-'0'-1;
         if(scacchiera[ri][co]==null){
         risultato=true;    
         }
        return risultato;
    }
    
    public void Alfiere(char[] mossac, String[][] scacchiera, String nome){
    if(controllomovimento(mossac)){
        System.out.println("l'alfiere non si muove così, reinseriscila");                //lutente ha mosso in modo errato lalfiere
        input(scacchiera, nome);
    }
   /* for(int c=0;c<4;c++){
        switch(c):
                case 0:
                    
                    
    }*/
                                                            //calcolo dell'algoritmo per prevedere tutte le mosse
        
    
    
    mossa(mossac, scacchiera, nome);
    }


}


