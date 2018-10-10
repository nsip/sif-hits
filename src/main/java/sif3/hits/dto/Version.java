package sif3.hits.dto;

import java.io.Serializable;

public class Version implements Serializable {
    private static final long serialVersionUID = 809275778065952364L;

    private String sifServer;
    private String sifDatamodel;
    private String sifInfrastructure;
    private String sifFramework;

    public String getSifServer() {
        return sifServer;
    }

    public void setSifServer(String sifServer) {
        this.sifServer = sifServer;
    }

    public String getSifDatamodel() {
        return sifDatamodel;
    }

    public void setSifDatamodel(String sifDatamodel) {
        this.sifDatamodel = sifDatamodel;
    }

    public String getSifInfrastructure() {
        return sifInfrastructure;
    }

    public void setSifInfrastructure(String sifInfrastructure) {
        this.sifInfrastructure = sifInfrastructure;
    }

    public String getSifFramework() {
        return sifFramework;
    }

    public void setSifFramework(String sifFramework) {
        this.sifFramework = sifFramework;
    }

}
