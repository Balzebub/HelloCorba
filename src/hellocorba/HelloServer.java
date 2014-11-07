import HelloCorba.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;

/**
 * HelloServant ist die Implementierung des Hello-Interfaces. Jede Hello-Instanz
 * wird von einem HelloServant implementiert.
 */
class HelloServant extends HelloPOA {

    private ORB orb;

    public void setORB(ORB orb) {
        this.orb = orb;
    }

    @Override
    public String sayHello() {
        return "\nThis is not the CORBA-Project you're looking for!\n";
    }

    public void shutdown() {
        orb.shutdown(false);
    }
}

public class HelloServer {

    public static void main(String args[]) {
        try {
            // ORB erstellen und initialisieren
            ORB orb = ORB.init(args, null);

            // Referenz von RootPOA (Portable Object Adapter)
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            // POAManager wird aktiviert
            rootpoa.the_POAManager().activate();

            // Erstellen einer HelloServant-Instanz (implementierung des Hello-Objekts)
            HelloServant helloServant = new HelloServant();
            // Servant bei ORB "registrieren"
            helloServant.setORB(orb);

            // Objekt-Referenz vom Servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloServant);
            Hello href = HelloHelper.narrow(ref);

            // Aufruf des name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Vergabe eines Namens für die Objekt-Referenz
            String name = "Hello";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("HelloServer gestartet ...");

            // wartet auf Aufrufe
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("HelloServer beendet ...");

    }
}
