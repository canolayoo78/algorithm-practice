def main():
    import io, os
    input = io.BufferedReader(io.FileIO(0), buffer_size=1 << 18).readline
    N = int(input())
    exist = bytearray(2000001)
    for _ in range(N):
        exist[int(input()) + 1000000] = True
    os.write(1, '\n'.join(str(i) for i, ei in enumerate(exist, -1000000) if ei).encode())

main()