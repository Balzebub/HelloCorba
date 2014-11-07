import HelloCorba.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class HelloClient {

    static Hello hello;

    public static void main(String args[]) {
        try {
            // ORB erstellen und initialisieren
            ORB orb = ORB.init(args, null);
            
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Namensauflösung der Objektreferenz
            String name = "Hello";
            hello = HelloHelper.narrow(ncRef.resolve_str(name));

            // DEBUG System.out.println("Objekt vom Server erhalten" + hello);
            System.out.println(hello.sayHello());
            
            // beendet den Server
            // hello.shutdown();

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }

}
