/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellocorba;
import HelloCorba.Hello;
import HelloCorba.HelloHelper;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

/**
 *
 * @author Elveon
 */
public class HelloClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ORB orb = ORB.init(args, null);
            
            org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objref);
            
            NameComponent nc = new NameComponent("Hello", "");
            NameComponent path[] = {nc};
            
            Hello helloRef = HelloHelper.narrow(ncRef.resolve(path));
            
            String hello = helloRef.sayHello();
            System.out.println(hello);
            
        }catch (Exception e){
            
        }
    }
    
}
