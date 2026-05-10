// import generated CORBA calculator files
import CalcModule.*;

// import CORBA classes
import org.omg.CORBA.*;

// import Portable Object Adapter classes
import org.omg.PortableServer.*; // is a CORBA package used to: create, manage, activate server objects.

// CalculatorImpl = server implementation class
// extends CalculatorPOA means this class implements CORBA methods
class CalculatorImpl extends CalculatorPOA {

    // add() method for addition
    public double add(double a, double b) {

        // print message when add method is called
        System.out.println("Add called");

        // return addition result
        return a + b;
    }

    // sub() method for subtraction
    public double sub(double a, double b) {

        // print message
        System.out.println("Sub called");

        // return subtraction result
        return a - b;
    }

    // mul() method for multiplication
    public double mul(double a, double b) {

        // print message
        System.out.println("Mul called");

        // return multiplication result
        return a * b;
    }

    // div() method for division
    public double div(double a, double b) {

        // print message
        System.out.println("Div called");

        // check division by zero
        if (b == 0)
            return 0;

        // return division result
        return a / b;
    }
}