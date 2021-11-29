def isodd(a):
    if a%2==1: #홀수이면
        return True
    else:
        return False

arr_odd=[] #홀수 저장 배열
sum=0
for i in range(7):
    num=int(input())
    if( isodd(num)): #홀수가 맞으면
        arr_odd.append(num) #배열에 저장
        sum=sum+num #합에 추가

arr_odd.sort() #배열 정렬

if(sum==0): #합이 0이면(홀수가 없으면)
        print("-1")
else:
    print(sum)
    print(arr_odd[0])
