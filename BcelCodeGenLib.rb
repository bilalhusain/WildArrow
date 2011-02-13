# mode could be capture, target, branch, none
$mode = "none"

# this will represent ihLiteral in case of capture
$modeArg = ""

def setMode(mode, modeArg)
	$mode = mode
	$modeArg = modeArg
end


# TODO instruction will call a common method which acts based on mode
# Add spitIL(instruction, args)
# eg, spitIL("PUSH", "cp, \"0\"")

def NOP()
	if $mode == "target":
		puts $modeArg + ".setTarget("
	end
	puts "il.append(new NOP())"
	if $mode == "target":
		puts ")"
	end
	puts ";"
end

def POP()
	puts "il.append(new POP());"
end

def PUSH(val)
	if $mode == "capture":
		puts "InstructionHandle " + $modeArg + " = "
	end
	puts "il.append(new PUSH(cp, " + val + "));"
end

def ILOAD(name)
	puts "il.append(new ILOAD(" + name + "));"
end

def IF_ICMPGE(name)
	puts "IF_ICMPGE " + name + " = new IF_ICMPGE(null);";
	puts "il.append(" + name + ");"
end

def localVariable(name, type, val)
	puts "lg = mg.addLocalVariable(\"" + name + "\", Type." + type + ", null, null);"
	puts "int " + name + " = lg.getIndex();"
	PUSH(val)
	if type == "INT":
		puts "lg.setStart(il.append(new ISTORE(" + name + ")));"
	end
end

def print(str)
	puts "il.append(factory.createFieldAccess(\"java.lang.System\", \"out\", new ObjectType(\"java.io.PrintStream\"), Constants.GETSTATIC));";
	PUSH(str)
	puts "il.append(factory.createInvoke(\"java.io.PrintStream\", \"println\", Type.VOID, new Type[] { Type.STRING }, Constants.INVOKEVIRTUAL));"
end

