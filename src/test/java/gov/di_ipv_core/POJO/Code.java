package gov.di_ipv_core.POJO;

public class Code {

    public Code() {
    }

    private String value;

    public Code(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Code{" +
                "value='" + value + '\'' +
                '}';
    }
}
