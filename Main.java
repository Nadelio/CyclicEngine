public class Main {
    public static void main(String[] args) {
        // build engine
        CyclicEngine CE = CyclicEngine.CyclicEngineFactory.build();
        CE.setInactive(); // set inactive as precaution
        
        // build and register instances of updating objects
        CyclicBehaviorObject CBO = new CyclicBehaviorObject(){
            private int counter = 0;
            public void Update(){
                System.out.println(counter + " -> From CBO, ID: " + this.getID());
                counter++;
                if(counter == 10){
                    this.setInactive();
                }
            }
        };
        CyclicBehaviorObject CBO2 = new CyclicBehaviorObject() {
            private int counter = 0;
            public void Update(){
                System.out.println(counter + " -> From CBO, ID: " + this.getID());
                counter++;
                if(counter == 11){
                    this.setInactive();
                }
            }
        };
        
        // class that extends CyclicBehaviorObject can be registered
        UpdateExample UE = new UpdateExample();
        
        // register instances under engine
        CE.registerInstance(CBO);
        CE.registerInstance(CBO2);
        CE.registerInstance(UE);

        // activate and run engine
        CE.setActive();
        CyclicEngine.CyclicEngineFactory.run(CE); // do not run engine through CE.run(), will only run once, use this instead
    }
}