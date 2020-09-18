package com.spring.catfacts2.services;

import com.google.gson.Gson;
import com.spring.catfacts2.models.CatFacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class GetCatFactsService {

    // Denne metode læser og henter kun String text fra hjemmesiden
    public String getSingle() throws IOException {
        // Denne metode (API) peger på en specifik URL adresse på følgende hjemmeside for at "consume" dens indhold
        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        // Vi instantierer BufferedReader og InputStreamReader metoder for at læse fra 'catURL'
        BufferedReader catInput = new BufferedReader(new InputStreamReader(catURL.openStream()));
        // Vi distribuerer ("map") dataen til 'CatFact' klassen ift de ønskede og definerede parametre i denne; fra Json til det nye objekt 'data'
        CatFacts data = new Gson().fromJson(catInput, CatFacts.class);
        //Vi lukker / afslutter metoden BufferedReader, når vi har hentet det vi skulle (ligesom man lukker for vandhanen)
        catInput.close();
        // Vi returnerer 'data' med metoden toString
        return data.toString();
    }

    public String getTen() throws IOException {
        // Vi instantierer en ny ArrayList 'arrayCat'
        ArrayList <String> arrayCat = new ArrayList<>();
        // For loop for at hente data (text) 10 gange...
        for (int i = 0; i<10; i++){
            // og tilføje dem i ArrayList 'arrayCat'
            arrayCat.add(getSingle());
        }
        // Vi returnerer 'arrayCat' listen med metoden toString
        return arrayCat.toString();
    }
    // Denne metode læser og henter både String text og Date createdAt fra hjemmesiden og sorterer tekster efter dato
    public String getTenSortByDate() throws IOException {
        ArrayList<CatFacts> arrayCatSorted = new ArrayList<>();
        // For loop for at hente data (text + dato) 10 gange...
        for (int i=0; i<10; i++){
            // og tilføje dem i ArrayList 'arrayCatSorted'
            URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
            BufferedReader catInput = new BufferedReader(new InputStreamReader(catURL.openStream()));
            CatFacts data = new Gson().fromJson(catInput, CatFacts.class);
            arrayCatSorted.add(data);
            catInput.close();
        }
        // Collections metode skal sortere blandt dataen efter dato (se CatFacts class)
        Collections.sort(arrayCatSorted);
        return arrayCatSorted.toString();
    }

    public String getParamCF(char letter, int number) throws IOException {
        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        BufferedReader catInput = new BufferedReader(new InputStreamReader(catURL.openStream()));
        CatFacts data = new Gson().fromJson(catInput, CatFacts.class);
        //Lukker / afslutter BufferedReader
        catInput.close();
        int count = 0;

        for (int i = 0; i < data.getText().length(); i++) {
            if (data.getText().charAt(i) == letter) {
                count++;
            }
        }
        if (count == number) {
            return data.toString();
        }
        return "Nothing this time. Try your luck again!";
    }
}

