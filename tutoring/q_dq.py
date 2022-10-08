
#----------------------------------------------------------------------
from collections import deque


MAX_QSIZE = 10                
class CircularQueue :
    def __init__( self ) :      
        self.front = 0         
        self.rear = 0         
        self.items = [None] * MAX_QSIZE   

    def isEmpty( self ) : return self.front == self.rear
    def isFull( self ) : return self.front == (self.rear+1)%MAX_QSIZE
    def clear( self ) : self.front = self.rear

    def enqueue( self, item ):
        if not self.isFull():                     
            self.rear = (self.rear+1)% MAX_QSIZE   
            self.items[self.rear] = item          

    def dequeue( self ):
        if not self.isEmpty():                     
            self.front = (self.front+1)% MAX_QSIZE   
            return self.items[self.front]           

    def peek( self ):
        if not self.isEmpty():
            return self.items[(self.front + 1) % MAX_QSIZE]

    def size( self ) :
       return (self.rear - self.front + MAX_QSIZE) % MAX_QSIZE

    def display( self ):
        out = []
        if self.front < self.rear :
            out = self.items[self.front+1:self.rear+1]
        else:
            out = self.items[self.front+1:MAX_QSIZE] \
                + self.items[0:self.rear+1]      
        print("[f=%s,r=%d] ==> "%(self.front, self.rear), out)


q = CircularQueue()                
for i in range(8): q.enqueue(i)      
q.display()                        
for i in range(5): q.dequeue();      
q.display()
for i in range(8,14): q.enqueue(i)   
q.display()


#======================================================================
# 5.2절
#======================================================================

class MyQueue():
    def __init__(self):
        self.front = []  # stack 1
        self.end = [] #stack 2


    def add(self, x):
        self.front.append(x);

    def remove(self):
        while len(self.front)>0:
            self.end.append(self.front.pop())

        temp = self.end.pop()
        while len(self.end)>0:
            self.front.append(self.end.pop())
        return temp
print("mytest")

qq = MyQueue()
qq.add(1)
qq.add(2)
qq.add(3)

print(qq.remove())
print(qq.remove())
print(qq.remove())




# q.add(0) # f_0
# q.add(1) # f_1

# #f_2
# f_n_2 = q.remove() # f_0
# f_n_1 = q.remove() # f_1

# f_n = f_n_2 + f_n_1 # f_2

# # f(n+1) = f(n) + f(N-1)
# q.add(f_n)
# q.add(f_n_1)

# def fib(n):
#     if n<=1 :
#         return n
    
#     q.add(0) # f_0
#     q.add(1) # f_1

#     ret =0
#     for i in range(3, n+1):
        
#         f_n_2 = q.remove() # f_0
#         f_n_1 = q.remove() # f_1

#         ret = f_n = f_n_2 + f_n_1 # f_2

#         # f(n+1) = f(n) + f(N-1)
#         q.add(f_n)
#         q.add(f_n_1)


#     return ret
    


    


#======================================================================
# 5.3절
#======================================================================





MAZE_SIZE = 6
def isValidPos(x, y) :      
    if x < 0 or y < 0 or x >= MAZE_SIZE or y >= MAZE_SIZE :
        return False      
    else :                 
        return map[y][x] == '0' or map[y][x] == 'x'




def BFS() :                
    que = CircularQueue()
    que.enqueue((0,1))
    print('BFS: ')         

    while not que.isEmpty(): 
        here = que.dequeue()
        print(here, end='->')
        x,y = here
        if (map[y][x] == 'x') : return True
        else :
            map[y][x] = '.'
            if isValidPos(x, y + 1) : que.enqueue((x, y + 1))   
            if isValidPos(x - 1, y) : que.enqueue((x - 1, y))   
            if isValidPos(x + 1, y) : que.enqueue((x + 1, y))   
            if isValidPos(x, y - 1) : que.enqueue((x, y - 1))   
    return False



map = [   [ '1', '1', '1', '1', '1', '1' ],
       [ 'e', '0', '1', '0', '0', '1' ],
       [ '1', '0', '0', '0', '1', '1' ],
       [ '1', '0', '1', '0', '1', '1' ],
       [ '1', '0', '1', '0', '0', 'x' ],
       [ '1', '1', '1', '1', '1', '1' ]]
# result = BFS()
# if result : print(' --> 미로탐색 성공')
# else : print(' --> 미로탐색 실패')


# 재귀함수를 사용할 때 가장 중요한 것
# 1. base case: 베이스 케이스가 없으면 무한루프랑 같다 
# 그래서 탈출조건을 만들어주어야 합니다.
# retrun (어떤 값) ==> base case에 대한 리턴이 됩니다
# return DFS(...)  ==> basecase가 아님

# 2. 방문표시: 방문한 곳을 다시 방문하면 무한루프에 빠지게됨
# 한 번 방문한 곳을 기록해주어야 함
# map[x][y]= '.'

# 3. 인접한 지역 탐색





MAZE_SIZE = 6
map = [   [ '1', '1', '1', '1', '1', '1' ],
       [ 'e', '0', '1', '0', '0', '1' ],
       [ '1', '0', '0', '0', '1', '1' ],
       [ '1', '0', '1', '0', '1', '1' ],
       [ '1', '0', '1', '0', '0', 'x' ],
       [ '1', '1', '1', '1', '1', '1' ]]

        
def isValidPos(map, x, y) :      
    if x < 0 or y < 0 or x >= MAZE_SIZE or y >= MAZE_SIZE :
        return False      
    else :                 
        return map[y][x] == '0' or map[y][x] == 'x'


def DFS(map, x,y):
    if map[y][x] == 'x':
        return True # 탐색을 완료했다! 도착지점을 발견했다

    # 방문표시
    map[y][x] = '.'

    # 인접한 지역 탐색
    if isValidPos(map,x, y + 1) : 
        ret = DFS(map, x, y+1) 
        if (ret == True):
            return True  # 탐색을 완료했어!

    if isValidPos(map,x - 1, y) : 
        ret = DFS(map, x-1, y)   
        if (ret == True):
            return True  # 탐색을 완료했어!
    if isValidPos(map,x + 1, y) : 
        ret = DFS(map, x+1, y)     
        if (ret == True):
            return True  # 탐색을 완료했어!
    if isValidPos(map,x, y - 1) : 
        ret = DFS(map, x, y-1)   
        if (ret == True):
            return True  # 탐색을 완료했어!

    
    # map[y][x] = '0'
    return False # 도착지점에 가지 못했다!



def DFS_stack(map):
    stk = [] # stack

    stk.append((0,1))

    while True:
        if len(stk)==0 :
            break
        x,y = here  = stk.pop()
        if(map[y][x] == 'x'):
            return True
        map[y][x] = '.'

        
        if isValidPos(map, x+1, y):
            stk.append((x+1,y))
            continue
        
        if isValidPos(map, x-1, y):
            stk.append((x-1,y))
            continue
        
        if isValidPos(map, x, y+1):
            stk.append((x,y+1))
            continue
        
        if isValidPos(map, x, y-1):
            stk.append((x,y-1))
            continue

    return False

    
print("탐색을 완료했어!~!"  if DFS_stack(map) else "못갔어 ㅠㅠ")
            


        



    
    





#----------------------------------------------------------------------
import queue             
Q = queue.Queue(maxsize=20)

for v in range(1, 10) : 
    Q.put(v) 
print("큐의 내용: ", end='')  
for _ in range(1, 10) : 
    print(Q.get(), end=' ')
print()


#======================================================================
# 5.5절
#======================================================================
class CircularDeque(CircularQueue) :             
    def __init__( self ) :                        
        super().__init__()   #부모클래스의 생성자를 호출                     

    def addRear( self, item ): self.enqueue(item )
    def deleteFront( self ): return self.dequeue()
    def getFront( self ): return self.peek()      
   
    def addFront( self, item ):                   
        if not self.isFull():
            self.items[self.front] = item        
            self.front = self.front - 1            
            if self.front < 0 : self.front = MAX_QSIZE - 1

    def deleteRear( self ):               
        if not self.isEmpty():
            item = self.items[self.rear];
            self.rear = self.rear - 1      
            if self.rear < 0 : self.rear = MAX_QSIZE - 1
            return item              

    def getRear( self ):          
        return self.items[self.rear]
        

dq = CircularDeque()              
for i in range(9):                 
   if i%2==0 : dq.addRear(i)      
   else : dq.addFront(i)          
dq.display()                    
for i in range(2): dq.deleteFront()   
for i in range(3): dq.deleteRear()   
dq.display()
for i in range(9,14): dq.addFront(i)
dq.display()


#======================================================================
# 5.6절
#======================================================================
class PriorityQueue :
    def __init__( self ):               
        self.items = []                  

    def isEmpty( self ):               
        return len( self.items ) == 0
    def size( self ): return len(self.items)
    def clear( self ): self.items = []      

    def enqueue( self, item ):            
        self.items.append( item )     


    def dequeue( self ):           
        self.items.sort()          
        return self.items.pop() 

    def peek( self ):  
        self.items.sort()          
        return self.items[-1]

q = PriorityQueue()
q.enqueue( 34 )
q.enqueue( 18 )
q.enqueue( 27 )
q.enqueue( 45 )
q.enqueue( 15 )

print("PQueue:", q.items)
while not q.isEmpty() :
    print("Max Priority = ", q.dequeue() )


#======================================================================
# 5.7절
#======================================================================

import math            
(ox,oy) = (5, 4)      
def dist(x,y) :          
    (dx, dy) = (ox-x, oy-y)
    return math.sqrt(dx*dx + dy*dy)   



    def findMaxIndex( self ):      
        if self.isEmpty(): return None
        else:
            highest = 0            
            for i in range(1, self.size()) :   
                if self.items[i][2] > self.items[highest][2] :
                    highest = i      
            return highest         



def MySmartSearch() :            
    q = PriorityQueue()            
    q.enqueue((0,1,-dist(0,1)))      
    print('PQueue: ')

    while not q.isEmpty(): 
        here = q.dequeue()
        print(here[0:2], end='->')   
        x,y,_ = here            
        if (map[y][x] == 'x') : return True
        else :
            map[y][x] = '.'
            if isValidPos(x, y - 1) : q.enqueue((x,y-1, -dist(x,y-1)))
            if isValidPos(x, y + 1) : q.enqueue((x,y+1, -dist(x,y+1)))
            if isValidPos(x - 1, y) : q.enqueue((x-1,y, -dist(x-1,y)))
            if isValidPos(x + 1, y) : q.enqueue((x+1,y, -dist(x+1,y)))
        print('우선순위큐: ', q.items)
    return False