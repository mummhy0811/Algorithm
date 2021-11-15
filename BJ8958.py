n=int(input())

for i in range(n):
    score=0
    total=0;
    test=list(input())
    for j in range(len(test)):
        if test[j]=='O':
            score=score+1
        else:
            score=0
        total=total+score
    print(total)
