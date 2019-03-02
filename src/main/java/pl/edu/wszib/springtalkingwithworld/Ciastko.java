package pl.edu.wszib.springtalkingwithworld;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;



@Component
/*@Scope(SCOPE_PROTOTYPE)*/
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Ciastko {

    private boolean zjedzone = false;


    public boolean isZjedzone(){
        return zjedzone;
    }

    public void zjedz(){
        zjedzone=true;
    }
}
