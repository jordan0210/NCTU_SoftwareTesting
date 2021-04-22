	.text
	.file	"Lab_6.c"
	.globl	A                       # -- Begin function A
	.p2align	4, 0x90
	.type	A,@function
A:                                      # @A
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	popq	%rbp
	retq
.Lfunc_end0:
	.size	A, .Lfunc_end0-A
	.cfi_endproc
                                        # -- End function
	.globl	B                       # -- Begin function B
	.p2align	4, 0x90
	.type	B,@function
B:                                      # @B
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	popq	%rbp
	retq
.Lfunc_end1:
	.size	B, .Lfunc_end1-B
	.cfi_endproc
                                        # -- End function
	.globl	C                       # -- Begin function C
	.p2align	4, 0x90
	.type	C,@function
C:                                      # @C
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	popq	%rbp
	retq
.Lfunc_end2:
	.size	C, .Lfunc_end2-C
	.cfi_endproc
                                        # -- End function
	.globl	main                    # -- Begin function main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$32, %rsp
	movl	$0, -8(%rbp)
	movl	%edi, -12(%rbp)
	movq	%rsi, -24(%rbp)
	callq	A
	movl	$-1, -28(%rbp)
	cmpl	$1, -12(%rbp)
	jg	.LBB3_2
# %bb.1:
	movabsq	$.L.str, %rdi
	movb	$0, %al
	callq	printf
	movl	$-1, -8(%rbp)
	jmp	.LBB3_7
.LBB3_2:
	callq	B
	movl	$1, -4(%rbp)
.LBB3_3:                                # =>This Inner Loop Header: Depth=1
	movl	-4(%rbp), %eax
	cmpl	-12(%rbp), %eax
	jge	.LBB3_6
# %bb.4:                                #   in Loop: Header=BB3_3 Depth=1
	movabsq	$.L.str.1, %rdi
	movq	-24(%rbp), %rax
	movslq	-4(%rbp), %rcx
	movq	(%rax,%rcx,8), %rsi
	movb	$0, %al
	callq	printf
# %bb.5:                                #   in Loop: Header=BB3_3 Depth=1
	movl	-4(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -4(%rbp)
	jmp	.LBB3_3
.LBB3_6:
	callq	C
	movl	$0, -8(%rbp)
.LBB3_7:
	movl	-8(%rbp), %eax
	addq	$32, %rsp
	popq	%rbp
	retq
.Lfunc_end3:
	.size	main, .Lfunc_end3-main
	.cfi_endproc
                                        # -- End function
	.type	.L.str,@object          # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"no parameter !\n"
	.size	.L.str, 16

	.type	.L.str.1,@object        # @.str.1
.L.str.1:
	.asciz	"%s\n"
	.size	.L.str.1, 4


	.ident	"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"
	.section	".note.GNU-stack","",@progbits
