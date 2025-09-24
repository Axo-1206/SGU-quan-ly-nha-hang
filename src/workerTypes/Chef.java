package workerTypes;

public class Chef extends base.Worker {
    
    public Chef(int id, String name, int age, String gender, String position, double salaries, String description) {
        super(id, name, age, gender,position, salaries, description);
    }

    @Override
    public void interact() {
        
    }

    @Override
    public void startWorking() {
        System.out.println("Chef: "+name+"Start working");
    }
    
    @Override
    public void stopWorking() {
        System.out.println("Chef: "+name+"Start working");
    }
}
