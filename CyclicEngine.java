import java.util.ArrayList;

public class CyclicEngine implements Runnable{
    private ArrayList<CyclicBehaviorObject> register;
    private boolean RUN_FLAG = false;

    private CyclicEngine() { register = new ArrayList<CyclicBehaviorObject>(); }

    public static class CyclicEngineFactory {
    
        public static CyclicEngine build() {
            return new CyclicEngine();
        }

        public static void run(CyclicEngine CE) {
            Thread t = new Thread(CE, "CyclicEngine");
            t.start();
        }

    }

    public void run() {
        RUN_FLAG = true;
        while(true){
            while(RUN_FLAG){
                for(CyclicBehaviorObject instance : register){
                    if(!RUN_FLAG){ break; }
                    if(instance.getActive()){ instance.Update(); }
                }
            }
        }
    }

    public void registerInstance(CyclicBehaviorObject instance) { register.add(instance); }
    public void unregisterInstance(CyclicBehaviorObject instance) { register.remove(instance); }

    public void setActive() { RUN_FLAG = true; }
    public void setInactive() { RUN_FLAG = false; }
}