public class Deneme {
    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();
        Cat cat1 = new Cat(true,3,"az",12,true);
        Cat cat2 = new Cat(true,6,"ac",13,true);
        Cat cat3 = new Cat(true,4,"ab",11,true);

        animalShelter.addAnimal(cat1);
        animalShelter.addAnimal(cat2);
        animalShelter.addAnimal(cat3);
        Animal animals = new Animal() {
            @Override
            public void treatAnimal() {

            }
        };

        animalShelter.sortAnimals();
        animalShelter.printAnimals();


    }
}
