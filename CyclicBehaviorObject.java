public abstract class CyclicBehaviorObject {
    private static int IDIndex;
    private int ID;
    private boolean active;

    public CyclicBehaviorObject() {
        this.active = true;
        ID = IDIndex;
        IDIndex++;
    }

    public abstract void Update();

    public int getID() { return this.ID; }
    public boolean getActive() { return this.active; }

    public void setActive() { this.active = true; }
    public void setInactive() { this.active = false; }
}
