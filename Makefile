export JVM="java"
export JC="javac"
export JAR="jar"
export SH="sh"
export RM="rm"
export FLAGS=""
export CD="cd"
export MKDIR="mkdir"
export CLASSPATH=""
export TEST_CLASSPATH=""

help:
	@echo "****************************************************"
	@echo "*****      \033[1;34mJava Makefile help\033[0;0m                  *****"
	@echo "****************************************************"
	@echo "    - Make sure all your .java source codes are placed inside the src/ directory"
	@echo ""
	@echo "    \033[32mcompile     :\033[0m    - compile all .java files in the build directory"
	@echo "    \033[32mjar         :\033[0m    - generate a .jar file for the application"
	@echo "    \033[32mrun         :\033[0m    - run the .jar file"
	@echo "    \033[32mtest-compile:\033[0m    - compile the test files"
	@echo "    \033[32mjunit       :\033[0m    - run all test files"
	@echo "\n"

build-structure:
	@echo "setting directory structure...";\
	for i in `find src -name *.java`; do\
		PKG_DIR=`echo "$$i" | sed "s/src\(.*\)\/.*\.java/build\1/"`;\
		[ -d $$PKG_DIR ] || $(MKDIR) -p $$PKG_DIR;\
	done

compile: build-structure
compile:
	@echo "compiling java files...";\
	CLASSPATH="";\
	for i in `find lib -name "*.jar"`; do\
		CLASSPATH="$$i:$$CLASSPATH";\
	done;\
	for i in `find src -depth -name *.java | tail`; do\
		PKG_DIR=`echo "$$i" | sed "s/\(src.*\)\/.*\.java/\1/"`;\
		CLASS_FILE=`echo "$$i" | sed "s/src\/\(.*\)\.java/.\/build\/\1\.class/"`;\
        if [ $$CLASS_FILE -ot $$i ]; then\
			echo "recompiling $$i...";\
			$(JC) -d build -cp "$$CLASSPATH:build/" $$PKG_DIR/*.java;\
			if [ $$? -ne 0 ]; then\
				exit 1;\
			fi;\
		fi;\
	done

jar: compile
jar:
	@MAIN=`grep -r "public static void main" src/* | grep -v .swp| sed "s/src\/\(.*\).java:.*/\1/"`;\
	echo "The main class of the jar file is: $$MAIN";\
	$(CD) build;\
	$(JAR) cvfe ../package.jar $$MAIN *;\
	$(CD) ..

run: jar
run:
	@echo "Running...";\
	echo "";\
	CLASSPATH="";\
	for i in `find lib -name "*.jar"`; do\
		CLASSPATH="$$i:$$CLASSPATH";\
	done;\
	$(JVM) -cp "$$CLASSPATH" -jar package.jar;\
	echo "";

init:
	-@$(MKDIR) src lib build test test/build test/src

junit: test-compile
	@echo "running jUnit tests...";\
	TEST_CLASSPATH="";\
	for i in `find test/lib -name "*.jar"`; do\
		TEST_CLASSPATH="$$i:$$TEST_CLASSPATH";\
	done;\
	TESTS=`find test/build -name *.class | sed "s/\//./g" | sed "s/\.class//" | sed "s/test\.build\.//"`;\
	$(JVM) -cp "$$TEST_CLASSPATH:test/build/:build/" org.junit.runner.JUnitCore $$TESTS

test-compile: compile test-build-structure
	@echo "compiling java files...";\
	TEST_CLASSPATH="";\
	for i in `find test/lib -name "*.jar"`; do\
		TEST_CLASSPATH="$$i:$$TEST_CLASSPATH";\
	done;\
	for i in `find test/src -depth -name *.java | tail`; do\
		PKG_DIR=`echo "$$i" | sed "s/\(test\/src.*\)\/.*\.java/\1/"`;\
		CLASS_FILE=`echo "$$i" | sed "s/test\/src\/\(.*\)\.java/test\/build\/\1\.class/"`;\
        if [ $$CLASS_FILE -ot $$i ]; then\
			echo "recompiling $$i...";\
			$(JC) -d test/build -cp "$$TEST_CLASSPATH:test/build/:build/" $$PKG_DIR/*.java;\
			if [ $$? -ne 0 ]; then\
				exit 1;\
			fi;\
		fi;\
	done

test-build-structure:
	@echo "setting directory structure...";\
	for i in `find test -name *.java`; do\
		PKG_DIR=`echo "$$i" | sed "s/test\/src\(.*\)\/.*\.java/test\/build\1/"`;\
		[ -d $$PKG_DIR ] || $(MKDIR) -p $$PKG_DIR;\
	done

clean:
	@echo "cleanning build files...";\
	$(RM) -rf build;\
	$(RM) -rf test/build;\
    $(MKDIR) build;\
    $(MKDIR) test/build;\
	$(RM) *.jar

.PHONY: build-structure compile clean run help init jar junit
