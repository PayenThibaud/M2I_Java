package org.example.untitled1.ws.jaxrs;

import br.com.jarch.util.BundleUtils;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("api")
public class RestApplication extends Application {

    public RestApplication() {
        BeanConfig conf = new BeanConfig();
        conf.setTitle(BundleUtils.messageBundle("label.siglaSistema"));
        conf.setDescription(BundleUtils.messageBundle("message.descricaoSistema"));
        conf.setVersion(BundleUtils.messageBundle("label.version"));
        conf.setHost("localhost:8080");
        conf.setBasePath("untitled1-ws/api");
        conf.setSchemes(new String[]{"http", "https"});
        conf.setResourcePackage("org.example.untitled1.ws");
        conf.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(
                //BaseContainerRequestFilterProvider.class, // Your RequestFilterProvider
                //BaseContainerResponseFilterProvider.class, // Your ResponseFilterProvider
                // Your classes managed
                ApiListingResource.class,
                SwaggerSerializers.class);
    }
}