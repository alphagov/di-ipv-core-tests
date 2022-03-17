package gov.di_ipv_core.POJO;

public class Gpg45Score{

    private Evidence evidence;

    public Gpg45Score() {
    }

    public Gpg45Score(Evidence evidence) {
        this.evidence = evidence;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    @Override
    public String toString() {
        return "Gpg45Score{" +
                "evidence=" + evidence +
                '}';
    }

}