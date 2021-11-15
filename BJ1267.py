def calc(t, sec, mon ):
    sum=0;
    while(t>=0):
        if(t>=sec):
            sum+=mon;
            t=t-sec;
        else:
            sum+=mon;
            break;
    return (sum)

n=int(input())
time=list(map(int, input().split()))
ys=0; ms=0;
for i in range (n):
    ys=ys+calc(time[i], 30, 10) #30초마다 10원
    ms=ms+calc(time[i], 60, 15) #60초마다 15원

if(ys<ms):
    print("Y", ys);
elif(ys>ms):
    print("M", ms);
else:
    print("Y M", ys);
