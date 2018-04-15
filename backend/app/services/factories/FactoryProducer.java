package services.factories;

public class FactoryProducer {
    public static AbstractFactory getFactory(String factoryType) {
        if (factoryType.equalsIgnoreCase("api"))
            return new ApiFactory();
        else if (factoryType.equalsIgnoreCase("user"))
            return new UserFactory();
        else
            return null;
    }
}
