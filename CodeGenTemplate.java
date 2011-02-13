import org.apache.bcel.generic.Type;
import org.apache.bcel.generic.ArrayType;
import org.apache.bcel.generic.ObjectType;

import org.apache.bcel.generic.ALOAD;
import org.apache.bcel.generic.AALOAD;
import org.apache.bcel.generic.AASTORE;
import org.apache.bcel.generic.ARRAYLENGTH;
import org.apache.bcel.generic.ASTORE;
import org.apache.bcel.generic.DUP;
import org.apache.bcel.generic.GOTO;
import org.apache.bcel.generic.IADD;
import org.apache.bcel.generic.IF_ICMPGE;
import org.apache.bcel.generic.IF_ICMPLT;
import org.apache.bcel.generic.IINC;
import org.apache.bcel.generic.ILOAD;
import org.apache.bcel.generic.ISTORE;
import org.apache.bcel.generic.LDC;
import org.apache.bcel.generic.NOP;
import org.apache.bcel.generic.POP;
import org.apache.bcel.generic.PUSH;

import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.LocalVariableGen;

import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionConstants;

import org.apache.bcel.Constants;

import java.io.IOException;

public class CodeGenTemplate
{
	public static void main(String args[])
	{
		ClassGen cg = new ClassGen("Test", "java.lang.Object", "<generated>", Constants.ACC_PUBLIC | Constants.ACC_SUPER, null);
		ConstantPoolGen cp = cg.getConstantPool();
		InstructionList il = new InstructionList();

		MethodGen mg = new MethodGen(Constants.ACC_STATIC | Constants.ACC_PUBLIC, Type.VOID, new Type[] { new ArrayType(Type.STRING, 1) }, new String[] { "args" }, "main", "Test", il, cp);

		InstructionFactory factory = new InstructionFactory(cg);
		LocalVariableGen lg = null;

// <code>
		// add from the ruby file output
// </code>


		il.append(InstructionConstants.RETURN);

		mg.setMaxStack();
		cg.addMethod(mg.getMethod());
		il.dispose();
		cg.addEmptyConstructor(Constants.ACC_PUBLIC);

		try {
			cg.getJavaClass().dump("Test.class");
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}

