package Cors;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

public class CorsFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext RequestCtx, ContainerResponseContext res) throws IOException {

        res.getHeaders().add("Access-Control-Allow-Origin", "*" );
        res.getHeaders().add("Access-Control-Allow-Credentials", "true");
        res.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        res.getHeaders().add("Access-Control-Allow-Headers", "Origin, Accept, Content-Type, Authorization,x-access-token");

    }
}
