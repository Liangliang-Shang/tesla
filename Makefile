BASEDIR=$(CURDIR)
PACKAGE=com/lshang/tesla
SRCDIR=$(BASEDIR)/src
BINDIR=$(BASEDIR)/bin
LIBDIR=$(BASEDIR)/lib

help:
	@echo 'Makefile for tesla, a demo of FIX Acceptor/Initiator                '
	@echo '                                                                    '
	@echo 'Usage:                                                              '
	@echo '   make src          copy $(SRCDIR)/*.java into $(SRCDIR)/$(PACKAGE)'
	@echo '   make class        compile tesla java source files                '
	@echo '   make jar          package class files into tesla.jar             '
	@echo '   make clean        clean class files                              '
	@echo '   make run          run tesla                                      '
	@echo '                                                                    '

source:
	cp $(SRCDIR)/*.java $(SRCDIR)/$(PACKAGE) 

class: source
	javac $(SRCDIR)/$(PACKAGE)/*.java 

jar: class
	cd  $(SRCDIR) && jar cvf tesla.jar com && cp tesla.jar $(LIBDIR)

acceptor: jar
	java com/lshang/tesla/FIXAcceptor

initiator: jar
	java com/lshang/tesla/FIXInitiator
