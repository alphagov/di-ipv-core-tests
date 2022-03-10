package gov.di_ipv_core.POJO;

public class CodeRoot {
    private Code code;

    @Override
    public String toString() {
        return "CodeRoot{" +
                "code=" + code +
                '}';
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public CodeRoot(Code code) {
        this.code = code;
    }
}
