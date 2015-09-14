.PHONY: all clean debug

CXX=g++
CPPFLAGS=-g $(shell pkg-config gtkmm-3.0 --cflags) $(shell pkg-config webkitgtk-3.0 --cflags)
LDLIBS=$(shell pkg-config gtkmm-3.0 --libs) $(shell pkg-config webkitgtk-3.0 --libs)

SRCS=main.cpp 
OBJS=$(subst .ccp,.o,$(SRCS))

all: webkit

clean:
	rm -f webkit
# need to have gdb installed
debug : webkit
	gdb webkit -ex run

webkit: $(OBJS)
	$(CXX) $(CPPFLAGS) -o webkit $(OBJS) $(LDLIBS)

main.o: main.cpp 


