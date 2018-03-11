import os
from shutil import copyfile
import subprocess
import sys

TEMP_CNF = "tmp.in"
TEMP_SOL = "tmp.out"
NULL = open(os.devnull, "wb")

def all_solutions(cnf_fname):
    """
    Given a file containing a set of constraints,
    generate all possible solutions.
    """
    # make a copy of original input file
    copyfile(cnf_fname, TEMP_CNF)

    while True:
        # run minisat to solve the constraint problem
        subprocess.call(["minisat", TEMP_CNF, TEMP_SOL], stdout=NULL,stderr=NULL)

        # look at the result
        with open(TEMP_SOL) as result:
            line = next(result)
            if line.startswith("SAT"):
                # Success - return solution
                line = next(result)
                solution = [int(i) for i in line.split()]
                yield solution
            else:
                # Failure - no more solutions possible
                break

        # disqualify found solution
        with open(TEMP_CNF, "a") as constraints:
            new_constraint = " ".join(str(-i) for i in sol)
            constraints.write("\n")
            constraints.write(new_constraint)

def main(cnf_fname):
    """
    Given a file containing a set of constraints,
    count the possible solutions.
    """
    count = sum(1 for i in all_solutions(cnf_fname))
    print("There are {} solutions.".format(count))

if __name__=="__main__":
    if len(sys.argv) == 2:
        main(sys.argv[1])
    else:
        print("Usage: {} cnf.in".format(sys.argv[0]))