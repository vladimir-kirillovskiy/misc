.PHONY: all clean debug

CXX=g++
CPPFLAGS= -g
LDLIBS= -lssl -lcrypto

SRCS=main.cpp hash.cpp 
OBJS=$(subst .ccp,.o,$(SRCS))

all: hash

clean:
	rm -f hash
# need to have gdb installed
debug: hash
	gdb hash -ex run

hash: $(OBJS)
	# g++ `pkg-config gtkmm-3.0 --libs --cflags` -o gui gui.cpp
	$(CXX) $(CPPFLAGS) -o hash $(OBJS) $(LDLIBS)

hash.o: hash.cpp