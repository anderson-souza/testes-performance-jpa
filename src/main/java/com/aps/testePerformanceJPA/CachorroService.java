package com.aps.testePerformanceJPA;

import com.aps.testePerformanceJPA.repository.CachorroRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Service
public class CachorroService {

    @Autowired
    CachorroRepository cachorroRepository;

    public void inserirCachorros() {

        Faker faker = new Faker(new Locale("pt-BR"));

        for (int i = 0; i <= 1000; i++) {
            Cachorro cachorro = new Cachorro();
            cachorro.setNome(faker.dog().name());
            cachorro.setIdade(new Random().nextInt(25));
            cachorroRepository.save(cachorro);
            System.out.println(cachorro);
        }
    }

    public void inserirCachorrosBatch() {

        Faker faker = new Faker(new Locale("pt-BR"));
        List<Cachorro> cachorroList = new ArrayList<>();

        for (int i = 0; i <= 20000; i++) {
            Cachorro cachorro = new Cachorro();
            cachorro.setNome(faker.dog().name());
            cachorro.setIdade(new Random().nextInt(25));
            cachorroList.add(cachorro);
            System.out.println(cachorro);
        }
        Iterable<Cachorro> cachorrosPersistidos = cachorroRepository.saveAll(cachorroList);
        System.out.println(cachorrosPersistidos.toString());
    }

    public List<Cachorro> buscarTodosCachorros() {
        List<Cachorro> dogs = new ArrayList<>();
        cachorroRepository.findAll().forEach(dogs::add);
        return dogs;
    }

}
