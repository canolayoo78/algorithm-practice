import sys

input = sys.stdin.readlines

members = input()[1:]
members.sort(key=lambda member: int(member.split()[0]))

print("".join(members))
