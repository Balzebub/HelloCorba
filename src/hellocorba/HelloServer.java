/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellocorba;
import HelloCorba._HelloImplBase;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

/**
 *
 * @author thronhac
 */
public class HelloServer {
    
    public static void main(String[] args) {
        try{
            ORB orb = ORB.init(args, null);
            
            HelloServant helloRef = new HelloServant();
            
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            
            NamingContext ncRef = NamingContextHelper.narrow(objRef);
            NameComponent nc = new NameComponent("Hello", "");
            NameComponent path[] = {nc};
            
            ncRef.rebind(path, helloRef);
            
            orb.connect(helloRef);
            
            java.lang.Object sync = new java.lang.Object();
            while(true){
            synchronized(sync) {
                sync.wait();
            }
            }
            
        }catch (Exception e){
            System.err.println("Fehler!" + e);
        }
    }
}

class HelloServant extends _HelloImplBase {
    public String sayHello(){
        return "\nHello Corba!\n";
    }
}
