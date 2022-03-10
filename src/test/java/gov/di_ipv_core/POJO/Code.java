package gov.di_ipv_core.POJO;

public class Code {
    private String value;

    @Override
    public String toString() {
        return "Code{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Code(String value) {
        this.value = value;
    }
}
