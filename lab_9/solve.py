import angr
from angrutils import *
import claripy

def find_addr(state):
    out = str(state.posix.dumps(1))
    if "correct" in out:
        return True
    else:
        return False

def avoid_addr(state):
    out = str(state.posix.dumps(1))
    if "nonono" in out:
        return True
    else:
        return False

# Create CFG
proj = angr.Project("./give_me_password", load_options={'auto_load_libs':False})
main = proj.loader.main_object.get_symbol("main")
start_state = proj.factory.blank_state(addr=main.rebased_addr)
cfg = proj.analyses.CFGEmulated(fail_fast=True, starts=[main.rebased_addr], initial_state=start_state)
plot_cfg(cfg, "ais3_cfg", asminst=True, remove_imports=True, remove_path_terminator=True)

# Search password
flag_chars = [claripy.BVS('flag_%d' % i, 8) for i in range(12)]
flag = claripy.Concat(*flag_chars + [claripy.BVV(b'\n')])

argv = [proj.filename]
state = proj.factory.entry_state(args=argv, stdin=flag)
simgr = proj.factory.simulation_manager(state)

sm = simgr.explore(find=find_addr, avoid=avoid_addr)
found = sm.found
if (len(found) > 0):
    result = found[0].solver.eval(flag, cast_to=bytes).strip(b"\x00")
    print("==================")
    print("Password: ", end="")
    print(result)