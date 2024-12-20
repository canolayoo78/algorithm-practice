import sys

input = sys.stdin.readline

N = int(input())


class Member:
    def __init__(self, age: str, name: str):
        self.age = int(age)
        self.name = name

    def __repr__(self):
        return f"{self.age} {self.name}"


members = []

for _ in range(N):
    age, name = input().split()
    members.append(Member(age, name))

sorted_members = sorted(members, key=lambda member: (member.age))

for i in range(N):
    print(sorted_members[i])
