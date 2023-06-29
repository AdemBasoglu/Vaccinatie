import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalShelterTest {

    AnimalShelter animalShelter;
    List<Animal> animals;

    @BeforeEach
    void setUp() {
        animalShelter = new AnimalShelter();
        Cat cat1 = new Cat(false, 3, "az", 12, true);
        Cat cat2 = new Cat(false, 6, "ac", 13, true);
        Cat cat3 = new Cat(false, 4, "ab", 11, true);
        animalShelter.addAnimal(cat1);
        animalShelter.addAnimal(cat2);
        animalShelter.addAnimal(cat3);
        animals = new ArrayList<>();

    }


    @Test//1
    @DisplayName("Sort Animal method working")
    void shouldBeSortAnimalMethodNameOfFirstIndexAz() {
        animalShelter.sortAnimals();
        assertEquals("az", animalShelter.getAnimals().get(0).getName());

    }

    @Test//2
    @DisplayName("Sort Animal By name method working")
    void shouldBeSortAnimalsByNameMethodsFirstIndexAb() {
        animalShelter.sortAnimalsByName();
        assertEquals("ab", animalShelter.getAnimals().get(0).getName());

    }

    @Test//3
    @DisplayName("Sort Animal By Age method working")
    void shouldBeSortAnimalsByAgeMethodsFirstIndexAge3() {
        animalShelter.sortAnimalsByAge();
        assertEquals(3, animalShelter.getAnimals().get(0).getAge());


    }


    @Test//4
    @DisplayName("Find Animal By Name method working")
    void shouldBeFindAnimalMethodNameAc() {
        assertEquals("ac", animalShelter.findAnimal("ac").get().getName());
    }

    @Test//5
    @DisplayName("Find Animal By Number method working")
    void shouldBeFindAnimalMethodWithAnimalNumberNameAb() {

        assertEquals("ab", animalShelter.findAnimal(2).get().getName());

    }

    @Test//6
    @DisplayName("Treat Animal  method correct working")
    void shouldBeTreatAnimalMethodPassed() {
        Cat cat = new Cat();
        cat.treatAnimal();
        assertFalse(cat.isHasLongNails());
        assertTrue(cat.isClean());

    }

    @Test//7
    @DisplayName("Treat Animal  method by number correct working")
    void shouldBeTreatAnimalMethodNegatieveScenario() {
        animalShelter.treatAnimal(0);
        assertTrue(animalShelter.getAnimals().get(0).isClean());
    }


    @Test//8
    @DisplayName("Treat All Animal Method working")
    void shouldBeAllAnimalsTreat() {
        Cat cat1 = new Cat(false, 3, "az", 12, true);
        Cat cat2 = new Cat(false, 6, "ac", 13, true);
        Cat cat3 = new Cat(false, 4, "ab", 11, true);
        animalShelter.addAnimal(cat1);
        animalShelter.addAnimal(cat2);
        animalShelter.addAnimal(cat3);

        animalShelter.treatAllAnimals();//should be all animals clean and has not long nails

        assertFalse(cat1.isHasLongNails());
        assertFalse(cat2.isHasLongNails());
        assertFalse(cat3.isHasLongNails());
        assertTrue(cat1.isClean());
        assertTrue(cat2.isClean());
        assertTrue(cat3.isClean());
    }

    @Test//9
    @DisplayName("Find Oldest Animal method correct working")
    void shouldBeFindOldestAnimalResultAge6() {

        assertEquals(6, animalShelter.findOldestAnimal().get().getAge());


    }

    @Test//10
    @DisplayName("Find Oldest Animal method not correct working")
    void shouldBeNotFindOldestAnimalResultAge3() {

        assertNotEquals(3, animalShelter.findOldestAnimal().get().getAge());


    }

    @Test//11
    @DisplayName("Count Animal method correct working")
    void shouldBeCountAnimal3() {
        assertEquals(3, animalShelter.countAnimals());


    }

    @Test//12
    @DisplayName("Add new Animal method correct working")
    void shouldBeAddAnimalMethodExpectedCount4() {

        Dog dog = new Dog(true, 1, "Black", 12, false);
        animalShelter.addAnimal(dog);

        assertEquals(4, animalShelter.countAnimals());

    }

    @Test//13
    @DisplayName("Add new Animal method correct working")
    void shouldBeAddAnimalMethodExpectedCountNummers() {
        assertNotEquals(6, animalShelter.countAnimals());
    }
    @Test//14
    @ParameterizedTest
    @DisplayName("Find Animal By Number method working")
    @ValueSource(ints = {0, 1, 2})
    void shouldBeFindAnimalMethodAnimalNummer(int number) {
        assertEquals(number, animalShelter.findAnimal(number).get().getAnimalNumber());
    }

    @Test//15
    @DisplayName("Treat Animal By Name method correct working")
    void shouldBeTreatAnimalByNameMethodPassed() {
        Cat cat1 = new Cat(false, 3, "az", 12, true);
        Cat cat2 = new Cat(false, 6, "ac", 13, true);
        Cat cat3 = new Cat(false, 4, "ab", 11, true);
       animalShelter.treatAnimal("az");
       animalShelter.treatAnimal("ac");


        assertTrue(animalShelter.getAnimals().get(0).isClean());
        assertTrue(animalShelter.getAnimals().get(1).isClean());


    }

}