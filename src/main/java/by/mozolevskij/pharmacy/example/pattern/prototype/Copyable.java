package by.mozolevskij.pharmacy.example.pattern.prototype;

public interface Copyable {
    Copyable copy();
}

class SomeObject implements Copyable {

    private Type type;
    public enum Type {
        ONE, TWO
    }

    @Override
    public SomeObject copy() {
        SomeObject someObject = new SomeObject();
        return someObject;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

class PrototypeTest {
    public static void main(String[] args) {
        SomeObject someObject = new SomeObject();
        SomeObject clone = someObject.copy();
        clone.setType(SomeObject.Type.ONE);
    }
}
