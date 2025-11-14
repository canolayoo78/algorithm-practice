T = int(input())
for test_case in range(1, T + 1):
    test_case, test_len = input().split()
    num_dict = {"ZRO" : 0, "ONE": 1, "TWO": 2, "THR": 3, "FOR": 4, "FIV": 5, "SIX": 6, "SVN": 7, "EGT": 8, "NIN": 9}

    def translate(s):
        return num_dict[s]
    
    num_list = list(input().split())
    num_list.sort(key = translate)
    
    ans = ' '.join(num_list)
                
    print(f"{test_case}\n{ans}")
