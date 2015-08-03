.PHONY: all clean debug

CXX=g++
CPPFLAGS=-g $(shell pkg-config gtkmm-3.0 --cflags)
LDLIBS=$(shell pkg-config gtkmm-3.0 --libs) -lssl -lcrypto

SRCS=main.cpp myWindow.cpp hash.cpp
OBJS=$(subst .ccp,.o,$(SRCS))

all: hspg

clean:
	rm -f hspg
# need to have gdb installed
debug : hspg
	gdb hspg -ex run

hspg: $(OBJS)
	$(CXX) $(CPPFLAGS) -o hspg $(OBJS) $(LDLIBS)

main.o: main.cpp myWindow.cpp hash.cpp



# CC -- the c compiler to use
# CXX -- the c++ compiler to use
# LD -- the linker to use
# CFLAGS -- compilation flag for c source files
# CXXFLAGS -- compilation flags for c++ source files
# CPPFLAGS -- flags for the c-preprocessor (typically include file paths and symbols defined on the command line), used by c and c++
# LDFLAGS -- linker flags
# LDLIBS -- libraries to link

# CC=gcc
# CXX=g++
# RM=rm -f
# CPPFLAGS=-g $(shell root-config --cflags)
# LDFLAGS=-g $(shell root-config --ldflags)
# LDLIBS=$(shell root-config --libs)

# SRCS=tool.cc support.cc
# OBJS=$(subst .cc,.o,$(SRCS))

# all: tool

# tool: $(OBJS)
#     $(CXX) $(LDFLAGS) -o tool $(OBJS) $(LDLIBS) 

# tool.o: tool.cc support.hh

# support.o: support.hh support.cc

# clean:
#     $(RM) $(OBJS)

# dist-clean: clean
#     $(RM) tool
