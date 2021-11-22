arr=[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
for i in range(10):
    arr[i]=int(input()) #입력받음
    arr[i]=arr[i]%42 #42로 나눈 나머지로 저장

count=1
arr.sort()
for i in range(9):
    if(arr[i] != arr[i+1]):
        count+=1
print(count)


##arr2 = [0 for i in range(0, 42)]
##for i in range(10):
##    for j in range(42):
##        if arr[i]==j:
##            arr2[j]+=1
##
##count=0
##for i in range(42):
##    if(arr2[i] != 0):
##        count+=1
##
##print(count)
