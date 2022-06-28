package lesson6.l6_medium.task1;

public class Main {
    public static void main(String[] args) {
        Tree fir = new Tree("ель", true);
        Tree pine = new Tree("сосна", true);
        Flowers rose = new Flowers("роза");
        Grass fern = new Grass("папоротник");

        Plant[] arrPlants = {fir, pine, rose, fern};

        for (Plant entry : arrPlants) {
            if (entry instanceof Blooming && entry instanceof Smelling) {
                ((Blooming) entry).canBloom();
                ((Smelling) entry).canSmell();
            } else if (entry instanceof Blooming) {
                ((Blooming) entry).canBloom();
            } else if (entry instanceof Smelling) {
                ((Smelling) entry).canSmell();
            } else {
                //some things
            }
        }
    }
}
