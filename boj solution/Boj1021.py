
from collections import deque

def calc(dq:deque,  target:int):
    order =0
    size = len(dq)
    while dq[0] != target:
        order+=1
        dq.append(dq.popleft())

    dq.popleft()
    
    return min(order, size-order)

def main():
    N,M = map(int, input().split())
    targets = list (map(int, input().split()))

    dq = deque([i for i in range(1,N+1)])

    sum=0
    for target in targets:
        sum += calc(dq, target)

    print(sum)

    
main()


    
