# callgraph
# generate Lab_6.ll
clang -S -emit-llvm ./Lab_6.c
# 優化程式
opt -S -mem2reg Lab_6.ll
# generate callgraph base on Lab_6.ll, the output .dot file is ./callgraph.dot
opt -S -dot-callgraph Lab_6.ll

# control flow graph
# generate Lab_6.bc
clang -c -emit-llvm ./Lab_6.c -o Lab_6.bc
# generate control flow graph base on Lab_6.bc, the output .dot file is /tmp/cfg*.dot
opt --view-cfg Lab_6.bc

# generate .png from .dot
dot -Tpng *.dot -o *.png