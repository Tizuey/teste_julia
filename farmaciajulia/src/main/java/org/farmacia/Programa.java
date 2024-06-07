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
        Substancia substancia1 = new Substancia(Tipo.Alzheimer_Demencia, "Memantina");
        Substancia substancia2 = new Substancia(Tipo.Alzheimer_Demencia, "Donepezila");
        Substancia substancia3 = new Substancia(Tipo.Antidrepressivo, "Fluoxetina");
        Substancia substancia4 = new Substancia(Tipo.Antidrepressivo, "Sertralina");
        Substancia substancia5 = new Substancia(Tipo.Antipsicotico, "Risperidona");
        Substancia substancia6 = new Substancia(Tipo.Antipsicotico, "Quetiapina");
        Substancia substancia7 = new Substancia(Tipo.Parkinson, "Levodopa");
        Substancia substancia8 = new Substancia(Tipo.Parkinson, "Ropinirole");
        Substancia substancia9 = new Substancia(Tipo.Antinflamatorio_DorDeCabeca, "Ibuprofeno");
        Substancia substancia10 = new Substancia(Tipo.Antinflamatorio_DorDeCabeca, "Paracetamol");
        Substancia substancia11 = new Substancia(Tipo.Outros, "Loratadina");
        Substancia substancia12 = new Substancia(Tipo.Outros, "Metformina");
        Substancia substancia13 = new Substancia(Tipo.Vitamina, "Vitamina C");
        Substancia substancia14 = new Substancia(Tipo.Vitamina, "Vitamina D");

// Salvando substâncias
        SubstanciaRepository.save(substancia1);
        SubstanciaRepository.save(substancia2);
        SubstanciaRepository.save(substancia3);
        SubstanciaRepository.save(substancia4);
        SubstanciaRepository.save(substancia5);
        SubstanciaRepository.save(substancia6);
        SubstanciaRepository.save(substancia7);
        SubstanciaRepository.save(substancia8);
        SubstanciaRepository.save(substancia9);
        SubstanciaRepository.save(substancia10);
        SubstanciaRepository.save(substancia11);
        SubstanciaRepository.save(substancia12);
        SubstanciaRepository.save(substancia13);
        SubstanciaRepository.save(substancia14);

// Criando remédios
        Oral remedioOral1 = new Oral("Memantina ", LocalDate.of(2023, 12, 31), 50.0f, 100, 10.0f, substancia1, "Oral", "1 comprimido por dia");
        Oral remedioOral2 = new Oral("Fluoxetina ", LocalDate.of(2024, 12, 31), 55.0f, 100, 20.0f, substancia3, "Oral", "1 comprimido por dia");
        Oral remedioOral3 = new Oral("Risperidona ", LocalDate.of(2025, 12, 31), 60.0f, 100, 15.0f, substancia5, "Oral", "1 comprimido por dia");

        Injetavel remedioInjetavel1 = new Injetavel("Donepezila ", LocalDate.of(2023, 12, 31), 75.0f, 100, 15.0f, substancia2, "Intramuscular", "1ml por dia");
        Injetavel remedioInjetavel2 = new Injetavel("Sertralina ", LocalDate.of(2024, 12, 31), 80.0f, 100, 20.0f, substancia4, "Intramuscular", "1ml por dia");
        Injetavel remedioInjetavel3 = new Injetavel("Quetiapina ", LocalDate.of(2025, 12, 31), 85.0f, 100, 25.0f, substancia6, "Intramuscular", "1ml por dia");

        Topico remedioTopico1 = new Topico("Levodopa ", LocalDate.of(2023, 12, 31), 25.0f, 100, 5.0f, substancia7, "Aplicar na área afetada", "1 aplicação por dia");
        Topico remedioTopico2 = new Topico("Ropinirole ", LocalDate.of(2024, 12, 31), 30.0f, 100, 10.0f, substancia8, "Aplicar na área afetada", "1 aplicação por dia");
        Topico remedioTopico3 = new Topico("Ibuprofeno ", LocalDate.of(2025, 12, 31), 35.0f, 100, 15.0f, substancia9, "Aplicar na área afetada", "1 aplicação por dia");

// Salvando remédios
        RemedioRepository.save(remedioOral1);
        RemedioRepository.save(remedioOral2);
        RemedioRepository.save(remedioOral3);
        RemedioRepository.save(remedioInjetavel1);
        RemedioRepository.save(remedioInjetavel2);
        RemedioRepository.save(remedioInjetavel3);
        RemedioRepository.save(remedioTopico1);
        RemedioRepository.save(remedioTopico2);
        RemedioRepository.save(remedioTopico3);

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


        Menu.menuInicial();


    }
}