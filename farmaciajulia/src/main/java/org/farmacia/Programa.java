package org.farmacia;
import org.farmacia.entities.*;

import org.farmacia.interface_menu.Menu;
import org.farmacia.repositories.RemedioRepository;
import org.farmacia.repositories.SubstanciaRepository;
import org.farmacia.services.RemedioService;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Programa {
    public static void main(String[] args) throws InterruptedException {

        // Criando substâncias para uso nos remédios
        Substancia substancia1 = new Substancia(Tipo.Alzheimer_Demencia, "01");
        Substancia substancia2 = new Substancia(Tipo.Antidrepressivo, "Substância 2");
        Substancia substancia3 = new Substancia(Tipo.Antipsicotico, "Substância 3");
        SubstanciaRepository.save(substancia1);
        SubstanciaRepository.save(substancia2);
        SubstanciaRepository.save(substancia3);

        // Criando remédios
        Oral remedioOral = new Oral("01", LocalDate.of(2023, 12, 31), 50.0f, 100, 10.0f, substancia1, "Oral", "500mg");
        Injetavel remedioInjetavel = new Injetavel("Remédio Injetável", LocalDate.of(2024, 12, 31), 75.0f, 100, 15.0f, substancia2, "Intravenoso", "1ml");
        Topico remedioTopico = new Topico("Remédio Tópico", LocalDate.of(2025, 12, 31), 25.0f, 100, 5.0f, substancia3, "Tópico", "Aplicar na área afetada");
        RemedioRepository.save(remedioOral);
        RemedioRepository.save(remedioInjetavel);
        RemedioRepository.save(remedioTopico);
/*
    //_________________________________________________________________________________________________________________________________________
        System.out.println("  _____                                             _             _   _           _    __                      ");
        Thread.sleep(500);
        System.out.println(" |  ___|   __ _   _ __   _ __ ___     __ _    ___  (_)   __ _    | | | |  _ __   (_)  / _|   __ _    ___   ___ ");
        Thread.sleep(500);
        System.out.println(" | |_     / _` | | '__| | '_ ` _ |   / _` |  / __| | |  / _` |   | | | | | '_ |  | | | |_   / _` |  / __| / __|");
        Thread.sleep(500);
        System.out.println(" |  _|   | (_| | | |    | | | | | | | (_| | | (__  | | | (_| |   | |_| | | | | | | | |  _| | (_| | | (__  |__ |");
        Thread.sleep(500);
        System.out.println(" |_|      |__,_| |_|    |_| |_| |_|  |__,_|  |___| |_|  |__,_|    |___/  |_| |_| |_| |_|    |__,_|  |___| |___/");
        Thread.sleep(500);
    //_________________________________________________________________________________________________________________________________________
        System.out.println(" ");
        System.out.println(" ");
        String texto = "SEJA BEM VINDO A NOSSA QUERIDA FARMÁCIA";
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(60);  // Atraso de 100 milissegundos entre cada caractere
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    //_________________________________________________________________________________________________________________________________________
        // Interface Interativa com Usuário -> Menu.java
        Thread.sleep(500);

*/
        Menu.menuInicial();


    }
}