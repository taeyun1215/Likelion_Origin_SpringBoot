package practice2;

public abstract class AbstractCar implements CarInterface{  // alt + enter 눌러서 두번째 꺼
    protected int velocity = 0;

    @Override
    public void brake() {
        if(this.velocity < 0) this.velocity = 0;
    }
}
