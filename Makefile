BASEDIR=$(CURDIR)
PACKAGE=com/lshang/tesla
SRCDIR=$(BASEDIR)/src
BINDIR=$(BASEDIR)/bin
DATDIR=$(BASEDIR)/data
LIBDIR=$(BASEDIR)/lib
LOGDIR=$(BASEDIR)/log
TMPDIR=$(BASEDIR)/tmp

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

class: 
	javac -d $(TMPDIR)  $(SRCDIR)/*.java 

jar: class
	cd  $(TMPDIR) && jar cvf tesla.jar com && mv tesla.jar $(LIBDIR)

acceptor: jar
	java com/lshang/tesla/FIXAcceptor

initiator: jar
	java com/lshang/tesla/FIXInitiator

clean:
	cd $(DATDIR) && rm *
	cd $(LIBDIR) && rm tesla.jar
	cd $(LOGDIR) && rm *.log
