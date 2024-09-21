public class UpdateExample extends CyclicBehaviorObject {

    public UpdateExample() {
        super();
    }

    private int counter = 0;

    @Override
    public void Update() {
        System.out.println("Update from CBO, ID: " + this.getID());
        counter++;
        if (counter == 10) {
            this.setInactive();
        }
    }
}
