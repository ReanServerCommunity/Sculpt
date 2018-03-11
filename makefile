JAVA_HOME	= C:\jdk1.2
CLASSES		= MemoryStatus.class
OBJS		= WinMemory.obj
CFLAGS		= -nologo -Zi -DWIN32 -I$(JAVA_HOME)\include -I$(JAVA_HOME)\include\win32

.SUFFIXES: .java .class

# build java classes
.java.class:
	$(JAVA_HOME)\bin\javac $<

# generate jni stub headers
.class.h:
	$(JAVA_HOME)\bin\javah -jni $(<:.class=)

# build .c file
winmem.dll: $(OBJS)
	link -nologo -debug -dll -out:$@ $?

# C file dependency
WinMemory.c:

# clean all
clean:
	-del *.class *.dll *.obj *.pdb *.exp *.lib *.exp *.ilk
