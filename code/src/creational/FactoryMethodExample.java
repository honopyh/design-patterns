package creational;

// 1. 제품(Product) 인터페이스 정의
interface Product {
    void use();
}

// 2. 구체적인 제품(Concrete Product) 클래스 구현
class ConcreteProductA implements Product {
    public void use() {
        System.out.println("ConcreteProductA를 사용합니다.");
    }
}

class ConcreteProductB implements Product {
    public void use() {
        System.out.println("ConcreteProductB를 사용합니다.");
    }
}

// 3. 팩토리(Factor) 클래스 정의
abstract class Creator {
    // 팩토리 메서드 (서브클래스에서 구현)
    abstract Product factoryMethod();

    // 제품을 사용하는 메서드
    public void someOperation() {
        Product product = factoryMethod(); // 팩토리 메서드 호출
        product.use();
    }
}

// 4. 구체적인 팩토리(Concrete Factory) 클래스 구현
class ConcreteCreatorA extends Creator {
    @Override
    Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// 5. 클라이언트 코드 (팩토리 사용 예제)
public class FactoryMethodExample {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        creatorA.someOperation(); // "ConcreteProductA를 사용합니다."

        Creator creatorB = new ConcreteCreatorB();
        creatorB.someOperation(); // "ConcreteProductB를 사용합니다."
    }
}
