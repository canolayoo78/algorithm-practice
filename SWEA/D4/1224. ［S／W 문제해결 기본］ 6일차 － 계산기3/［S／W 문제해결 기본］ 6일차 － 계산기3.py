T = 10

for test_case in range(1, T + 1):
    _ = int(input())
    calc_f = input().strip()
    stack = []
    post_f = ""
    
    def precedence(op):
        if op in ('*', '/'):
            return 2
        if op in ('+', '-'):
            return 1
        return 0
    
    for c in calc_f:
        if c.isnumeric():
            post_f += c
        elif c == '(':
            stack.append(c)
        elif c == ')':
            while stack and stack[-1] != '(':
                post_f += stack.pop()
            stack.pop()
        else:
            while stack and precedence(stack[-1]) >= precedence(c):
                post_f += stack.pop()
            stack.append(c)
    while stack:
        post_f += stack.pop()
    
    for c in post_f:
        if c.isnumeric():
            stack.append(int(c))
        elif c == "+":
            b = stack.pop()
            a = stack.pop()
            stack.append(a + b)
        elif c == "*":
            b = stack.pop()
            a = stack.pop()
            stack.append(a * b)
        
    print(f"#{test_case} {stack[0]}")
