package sif3.hits.dto;

import java.io.Serializable;

public class Version implements Serializable {
    private static final long serialVersionUID = 809275778065952364L;

    private String sifServer;
    private String sifDatamodel;
    
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

}
