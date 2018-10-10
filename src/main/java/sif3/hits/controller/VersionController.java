package sif3.hits.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import sif3.hits.config.HitsSpringContext;
import sif3.hits.dto.Version;

public class VersionController extends HttpServlet {
    private static final long serialVersionUID = 359029305711751426L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Version version = HitsSpringContext.getBean(Version.class);
        resp.setStatus(Response.Status.OK.getStatusCode());
        resp.getOutputStream().print("{ \"version\" : { \"server\" : \"" + version.getSifServer() + "\", \"datamodel\" : \"" + version.getSifDatamodel() + "\", \"infrastructure\" : \"" + version.getSifInfrastructure() + "\", \"framework\" : \"" + version.getSifFramework() + "\" } }");
        resp.getOutputStream().flush();
    }

}
