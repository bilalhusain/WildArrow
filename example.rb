require 'BcelCodeGenLib'

localVariable("x", "INT", "3");
localVariable("y", "INT", "7");
ILOAD("x")
ILOAD("y")
IF_ICMPGE("ifcond")
print("\"ok\"")
setMode("target", "ifcond");
NOP();

