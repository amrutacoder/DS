//Creates and registers calculator server object with CORBA Naming Service.
// import generated CORBA calculator files
import CalcModule.*;

// import CORBA core classes
import org.omg.CORBA.*;

// import Portable Object Adapter classes
// used for server object management
import org.omg.PortableServer.*;

// import Naming Service classes
// used to register server object name
import org.omg.CosNaming.*;

// server class
class CalculatorServer {

    // main method
    public static void main(String args[]) {

        try {

            // initialize ORB
            // ORB acts as communication broker
            ORB orb = ORB.init(args, null);

            // get reference of RootPOA
            // POA manages server objects
            POA rootpoa = POAHelper.narrow(

                // get RootPOA reference from ORB
                orb.resolve_initial_references("RootPOA"));

            // activate POA manager
            // allows server to receive client requests
            rootpoa.the_POAManager().activate();

            // create calculator implementation object
            CalculatorImpl calcImpl = new CalculatorImpl();

            // convert servant object into CORBA object reference
            org.omg.CORBA.Object ref =
                rootpoa.servant_to_reference(calcImpl);

            // narrow generic CORBA reference to Calculator type
            Calculator href =
                CalculatorHelper.narrow(ref);

            // get reference of CORBA Naming Service
            org.omg.CORBA.Object objRef =
                orb.resolve_initial_references("NameService");

            // convert object into NamingContextExt type
            NamingContextExt ncRef =
                NamingContextExtHelper.narrow(objRef);

            // create name path "Calculator"
            // server will register with this name
            NameComponent path[] =
                ncRef.to_name("Calculator");

            // bind/register server object with name service
            ncRef.rebind(path, href);

            // print message
            System.out.println(
                "Calculator Server ready...");

            // keep server running and waiting for requests
            orb.run();

        } catch (Exception e) {

            // print exception if error occurs
            e.printStackTrace();
        }
    }
}