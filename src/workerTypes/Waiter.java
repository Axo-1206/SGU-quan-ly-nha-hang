package workerTypes;

public class Waiter extends base.Worker {
    
    public Waiter(int id, String name, int age, String gender, String position, double salaries, String description) {
        super(id, name, age, gender,position, salaries, description);
    }

    @Override
    public void interact() {
        
    }

    @Override
    public void startWorking() {
        System.out.println("Waiter: "+name+"Start working");
    }
    
    @Override
    public void stopWorking() {
        System.out.println("Waiter: "+name+"Start working");
    }
}
