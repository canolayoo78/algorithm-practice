import sys

input = sys.stdin.readline


def solution():
    S = input().strip()
    grade = {
        "A+": 4.5,
        "A": 4.0,
        "B+": 3.5,
        "B": 3.0,
        "C+": 2.5,
        "C": 2.0,
        "D+": 1.5,
        "D": 1.0,
        "F": 0.0,
    }

    plus_flag = False
    total_degree = 0
    subjects = 0
    for s in S[::-1]:
        if s == "+":
            plus_flag = True
        else:
            degree = s
            if plus_flag:
                degree += "+"
            total_degree += grade[degree]
            subjects += 1
            plus_flag = False
    print(total_degree / subjects)


if __name__ == "__main__":
    solution()
