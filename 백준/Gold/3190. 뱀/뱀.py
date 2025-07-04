import sys
from collections import deque

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    def is_in_board(head_x, head_y):
        return (
            1 <= head_x
            and head_x <= board_size
            and 1 <= head_y
            and head_y <= board_size
            and board[head_x][head_y] != -1
        )

    board_size = int(input())
    board = [[0] * (board_size + 1) for _ in range(board_size + 1)]
    num_apple = int(input())
    for _ in range(num_apple):
        x, y = map(int, input().split())
        board[x][y] = 1
    num_direction_change = int(input())
    direction_change_time = deque()
    direction_change_head = deque()
    for _ in range(num_direction_change):
        x, c = input().split()
        direction_change_time.append(int(x))
        direction_change_head.append(c)

    time = 1
    move = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    direction = 0
    head_x, head_y = 1, 1
    snake = deque([(1, 1)])
    board[head_x][head_y] = -1
    while True:
        move_x, move_y = move[direction]
        next_x, next_y = head_x + move_x, head_y + move_y
        if not is_in_board(next_x, next_y):
            return time
        snake.append((next_x, next_y))
        if board[next_x][next_y] != 1:
            tail_x, tail_y = snake.popleft()
            board[tail_x][tail_y] = 0
        board[next_x][next_y] = -1
        if direction_change_time and time == direction_change_time[0]:
            direction_change_time.popleft()
            changed_direction = direction_change_head.popleft()
            if changed_direction == "L":
                direction = (direction + 3) % 4
            else:
                direction = (direction + 1) % 4
        time += 1
        head_x, head_y = next_x, next_y


if __name__ == "__main__":
    print(solution())
