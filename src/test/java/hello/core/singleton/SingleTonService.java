package hello.core.singleton;

// SingleTon Pattern 
public class SingleTonService {
    
    // 자기 자신을 내부에 static으로 가지고 있음(Class Lv)
    // jvm내 딱 한개만 생성됨
    private static final SingleTonService instance = new SingleTonService();
    
    public static SingleTonService getInstance(){
        return instance;
    }
    
    private SingleTonService() {
        // 외부에서 new로 생성하는것을 막음
        // 외부에서는 getInstanc()로 호출해야함
    }
    public void logic() {
        System.out.println("singleton 객체 로직");
    }
}
