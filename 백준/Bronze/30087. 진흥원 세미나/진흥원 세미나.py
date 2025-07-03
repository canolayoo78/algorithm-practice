import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    seminar_map = {
        "Algorithm": "204",
        "DataAnalysis": "207",
        "ArtificialIntelligence": "302",
        "CyberSecurity": "B101",
        "Network": "303",
        "Startup": "501",
        "TestStrategy": "105",
    }

    N = int(input())
    for _ in range(N):
        seminar = input().strip()
        write(seminar_map[seminar] + "\n")


if __name__ == "__main__":
    solution()
