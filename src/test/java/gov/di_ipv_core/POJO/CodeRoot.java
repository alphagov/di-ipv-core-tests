package gov.di_ipv_core.POJO;

public class CodeRoot {

    private Code code;

    public CodeRoot() {
    }

    public CodeRoot(Code code) {
        this.code = code;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Root{" +
                "code=" + code +
                '}';
    }
}
