a=int(input())
b=int(input())
c=int(input())

##arr=[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
##calc=a*b*c
##
##while(calc!=0):
##    num=int(calc%10)
##    arr[ num ] += 1
##    calc=int(calc/10)
##
##for i in range(10):
##    print(arr[i])



r=list(str(a*b*c))
for i in range(10):
    print(r.count(str(i)))
