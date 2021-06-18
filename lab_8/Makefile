CC ?= gcc
C_FILES = $(wildcard *.c)
OBJS += $(C_FILES:.c=.o)
CFLAGS = -Wall -g
all: bmpgrayscale

%.o: %.c
	$(CC) $(CFLAGS) -c -o $@ $<
bmpgrayscale: $(OBJS)
	$(CC) $(CFLAGS) -o $@ $(OBJS)

check: bmpgrayscale
	$(RM) out.bmp
	./bmpgrayscale test.bmp out.bmp
clean:
	$(RM) bmpgrayscale *.o *.gch out.bmp >/dev/null 2>/dev/null || true

fuzz:
	export CC=~/AFLplusplus/afl-clang-fast
	export CXX=~/AFLplusplus/afl-clang-fast++
	export AFL_USE_ASAN=1
	LLVM_CONFIG=llvm-config-11 make
	~/AFLplusplus/afl-fuzz -i ~/st/st_lab8/testcase/ -o ~/st/st_lab8/out/ -b 1 -D -m none -- ~/st/st_lab8/Lab_8/bmpgrayscale @@ /dev/null