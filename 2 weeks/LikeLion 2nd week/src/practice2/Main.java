package practice2;

public class Main {
    public static void main(String[] args) {
        Driver unlicensed = new Driver("unlicensed", 0);
        Driver me = new Driver("me", 1);
        CarInterface car = new GoCart();    // 이 부분이 이해가 안 됨
        car.setDriver(unlicensed);  // 일단 GoCart에 setDriver로 가는 것 같음 x
//        car.getDriver   // 이게 안 되는 거 보니 위에 CarInterface car = new GoCart(); 이렇게 써주면 CarInterface에 있는 메소드만 가능한가봄
//        System.out.println(car); practice2.GoCart@41629346
        car.setDriver(me);
//        System.out.println(car); practice2.GoCart@41629346

        car = new SmallCar();
        car.setDriver(me);
//        System.out.println(car); practice2.SmallCar@6d311334
//        car.setDriver(unlicensed);
    }
}
