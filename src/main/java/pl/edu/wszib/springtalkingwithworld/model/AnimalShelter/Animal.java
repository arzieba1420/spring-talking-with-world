package pl.edu.wszib.springtalkingwithworld.model.AnimalShelter;




public class Animal {
    String name;
    int age;
    String id;
    AnimalType animalType;
    AnimalGender animalGender;
    boolean isReserved = false;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", animalType=" + animalType +
                ", animalGender=" + animalGender +
                ", isReserved=" + isReserved +
                '}';
    }
}
