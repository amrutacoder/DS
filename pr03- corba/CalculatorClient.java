//Connects to server and remotely calls calculator methods.
// import generated CORBA calculator package files
// contains Calculator, CalculatorHelper, etc.
import CalcModule.*;

// import CORBA core classes
// used for ORB and remote object handling
import org.omg.CORBA.*;

// import CORBA Naming Service classes
// used to find server object by name
import org.omg.CosNaming.*; //omg = Object Management Group

// client class
class CalculatorClient {

    // main method = program execution starts here
    public static void main(String args[]) {

        try {

            // initialize ORB (Object Request Broker)
            // ORB acts as middleman between client and server
            ORB orb = ORB.init(args, null);

            // get reference of CORBA Name Service
            // NameService helps locate server object
            org.omg.CORBA.Object objRef =
                orb.resolve_initial_references("NameService");

            // convert generic object into NamingContextExt type
            // narrow() safely converts CORBA object reference
            NamingContextExt ncRef =
                NamingContextExtHelper.narrow(objRef);

            // find Calculator object registered with name "Calculator"
            // client gets remote calculator object reference
            Calculator calcObj =
                CalculatorHelper.narrow(
                    ncRef.resolve_str("Calculator"));

            // remotely call add() method from server
            System.out.println(
                "Addition: " + calcObj.add(10, 5));

            // remotely call subtraction method
            System.out.println(
                "Subtraction: " + calcObj.sub(10, 5));

            // remotely call multiplication method
            System.out.println(
                "Multiplication: " + calcObj.mul(10, 5));

            // remotely call division method
            System.out.println(
                "Division: " + calcObj.div(10, 5));

        } catch (Exception e) {

            // print error if exception occurs
            e.printStackTrace();
        }
    }
}
/*check java version if is it above 11+ then do the following steps...
1.CORBA was removed in Java 11+, so you must use JDK 8.
sudo apt update
sudo apt install openjdk-8-jdk -y
2 Switch system default to Java 8
sudo update-alternatives --config java 
java-8-openjdk-amd64   =type the number before this

Same for the compiler:
sudo update-alternatives --config javac
Pick java-8-openjdk-amd64 again.

Step 4: Verify ... if java is 1.8 then do this
java -version
javac -version
which idlj

after creating 4 files 
1. ls
 Generate Java Files from IDL 
2. Run idlj  = idlj -fall Calculator.idl    = This creates folder: CalcModule/
No output = success. Verify the folder was created: ls CalcModule
3. Compile - javac CalcModule/*.java *.java
4 Run (3 terminals needed)
Terminal 1 — Start ORB Daemon = cd ~/pr03_corba
orbd -ORBInitialPort 1050 -ORBInitialHost localhost
Terminal 2 — Start Server
cd ~/pr03_corba
java CalculatorServer -ORBInitialPort 1050 -ORBInitialHost localhost
Terminal 3 — Run Client
cd ~/pr03_corba
java CalculatorClient -ORBInitialPort 1050 -ORBInitialHost localhost 


idlj -fall Calculator.idl

👉 Converts IDL file into Java CORBA files.
👉 Generates helper, stub, and skeleton files automatically.

🔹 2. orbd -ORBInitialPort 1050 -ORBInitialHost localhost

👉 Starts CORBA ORB daemon service.
👉 Helps client find and connect to server object.

🔹 3. java CalculatorServer -ORBInitialPort 1050 -ORBInitialHost localhost

👉 Starts the CORBA server application.
👉 Server registers itself with ORBD and waits for client requests.

🔹 4. java CalculatorClient -ORBInitialPort 1050 -ORBInitialHost localhost

👉 Starts the CORBA client application.
👉 Client connects to server and gets result remotely.
*/