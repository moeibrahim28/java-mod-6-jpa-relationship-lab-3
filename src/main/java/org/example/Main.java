package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        Owner owner3 = new Owner();
        Owner owner4 = new Owner();
        Owner owner5 = new Owner();

        owner1.setName("Moe");
        owner2.setName("Jay");
        owner3.setName("Thomas");
        owner4.setName("Paxton");
        owner5.setName("Oscar");

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();

        cat1.setName("Whiskers");
        cat2.setName("Peaches");
        cat3.setName("Snoopy");
        cat4.setName("Bob");
        cat5.setName("Kevin");
        cat6.setName("Stuart");

        CatOwner catOwner1 = new CatOwner();
        CatOwner catOwner2 = new CatOwner();
        CatOwner catOwner3 = new CatOwner();

        catOwner1.getOwnerList().add(owner1);
        catOwner1.getCatList().add(cat1);
        catOwner1.getCatList().add(cat2);
        catOwner2.getOwnerList().add(owner2);
        catOwner2.getOwnerList().add(owner3);
        catOwner2.getCatList().add(cat3);
        catOwner3.getOwnerList().add(owner4);
        catOwner3.getOwnerList().add(owner5);
        catOwner3.getCatList().add(cat4);
        catOwner3.getCatList().add(cat5);
        catOwner3.getCatList().add(cat6);


        transaction.begin();
        entityManager.persist(owner1);
        entityManager.persist(owner2);
        entityManager.persist(owner3);
        entityManager.persist(owner4);
        entityManager.persist(owner5);

        entityManager.persist(cat1);
        entityManager.persist(cat2);
        entityManager.persist(cat3);
        entityManager.persist(cat4);
        entityManager.persist(cat5);
        entityManager.persist(cat6);

        entityManager.persist(catOwner1);
        entityManager.persist(catOwner2);
        entityManager.persist(catOwner3);
        transaction.commit();

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}