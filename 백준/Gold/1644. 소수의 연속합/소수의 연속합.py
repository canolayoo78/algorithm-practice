import sys 

input = sys.stdin.readline 

def solution(): 
    N = int(input())
    num = [i for i in range(N + 1)]
    
    def sieve_of_eratosthenes(N):
        is_prime = [True] * (N + 1)
        is_prime[0], is_prime[1] = False, False
        
        for i in range(2, int(N ** 0.5) + 1):
            if not is_prime[i]:
                continue
            for j in range(2 * i, N + 1, i):
                is_prime[j] = False
                
        prime_nums = [i for i in range(N+1) if is_prime[i]]
            
        return prime_nums
    
    prime_nums = sieve_of_eratosthenes(N)
    
    left, right, cur_sum, ans = 0, 0, 0, 0
    while True:
        if cur_sum == N:
            ans += 1
            
        if cur_sum >= N:
            cur_sum -= prime_nums[left]
            left += 1
        elif right == len(prime_nums):
            break
        else:
            cur_sum += prime_nums[right]
            right += 1
    print(ans)
    

if __name__ == "__main__":
    solution()
